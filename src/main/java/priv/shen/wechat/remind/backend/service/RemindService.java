package priv.shen.wechat.remind.backend.service;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.shen.wechat.remind.backend.constant.Constant;
import priv.shen.wechat.remind.backend.domain.Remind;
import priv.shen.wechat.remind.backend.dto.*;
import priv.shen.wechat.remind.backend.exception.GlobalException;
import priv.shen.wechat.remind.backend.repository.RemindRepository;
import priv.shen.wechat.remind.backend.result.*;
import priv.shen.wechat.remind.backend.schedule.RemindTemplateMessageJob;
import priv.shen.wechat.remind.backend.template.RemindTemplateData;
import priv.shen.wechat.remind.backend.template.RemindTemplateMessage;
import priv.shen.wechat.remind.backend.template.TemplateDataElement;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class RemindService {
    @Autowired
    private RemindRepository remindRepository;
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private SimpleDateFormat sdf;
    @Autowired
    private TemplateMessageService templateMessageService;

    @Transactional
    public ClockResult sendRemind(RemindView remindView) throws Exception {
        Remind remind = new Remind();
        remind.setSenderId(remindView.getOpenid());
        remind.setTime(remindView.getTime());
        remind.setTitle(remindView.getTitle());
        remind.setContent(remindView.getContent());
        remind.setName(remindView.getName());
        remind.setSelfRemind(remindView.getSelf_clock());

        if (remindView.getSelf_clock() == 1){
            remind.setReceiverId(remindView.getOpenid());
            startSendRemindJob(remindView.getOpenid(),null,remind);
        }else {
            remind.setState(0);
        }

        remind = remindRepository.saveAndFlush(remind);
        return new ClockResult(Flag.SUCCESS.getCode(),remind.getId());
    }

    @Transactional
    public MessageResult agreeRemind(AgreeView agreeView) throws Exception {
        Optional<Remind> remindOptional = remindRepository.findById(agreeView.getClockId());
        if (!remindOptional.isPresent())
            throw new GlobalException(Message.AGREE_FAILURE.getContent());

        Remind remind = remindOptional.get();
        if (agreeView.getCheck() == 1 ){
            remind.setState(1);
            startSendRemindJob(agreeView.getReceiverOpenId(),remind.getSenderId(),remind);
        }
        else
            remind.setState(0);

        remind.setReceiverId(agreeView.getReceiverOpenId());

        return new MessageResult(Flag.SUCCESS.getCode(),Message.AGREE_SUCCESS.getContent());
    }

    public ClockListResult listForSelf(OpenidView openidView) {
        List<Remind> remindList = remindRepository.findAllBySelfRemindAndReceiverId(1,openidView.getOpenid());
        return new ClockListResult(Flag.SUCCESS.getCode(),remindList);
    }

    public ClockListResult listForFriend(OpenidView openidView) {
        List<Remind> remindList = remindRepository.findAllBySelfRemindAndSenderId(0, openidView.getOpenid());
        return new ClockListResult(Flag.SUCCESS.getCode(),remindList);
    }

    @Transactional
    public MessageResult delete(SecureRemindIdView receiverView) {
        remindRepository.deleteByIdAndReceiverIdEquals(receiverView.getClockId(),receiverView.getOpenid());
        remindRepository.deleteByIdAndSenderIdEquals(receiverView.getClockId(),receiverView.getOpenid());
        return new MessageResult(Flag.SUCCESS.getCode(),Message.DELETE_SUCCESS.getContent());
    }


    public RemindDetailResult getDetail(SecureRemindIdView secureRemindIdView) {
        Remind remind = remindRepository.findByIdAndReceiverIdEquals(secureRemindIdView.getClockId(),secureRemindIdView.getOpenid());
        if (remind == null){
            remind = remindRepository.findByIdAndSenderIdEquals(secureRemindIdView.getClockId(),secureRemindIdView.getOpenid());
        }

        if (remind == null){
            throw new GlobalException(Message.DETAIL_FAILURE.getContent());
        }

        RemindDetailResult remindDetailResult = new RemindDetailResult(remind.getTitle(),remind.getContent(),remind.getName());

        return remindDetailResult;
    }

    private void startSendRemindJob(String receiverOpenid,String senderOpenid,Remind remind) throws Exception{
        RemindTemplateMessage remindTemplateMessage = new RemindTemplateMessage();
        remindTemplateMessage.setTouser(receiverOpenid);
        RemindTemplateData remindTemplateData = new RemindTemplateData();
        remindTemplateData.setKeyword1(new TemplateDataElement(remind.getTitle()));
        remindTemplateData.setKeyword2(new TemplateDataElement(sdf.format(remind.getTime())));
        remindTemplateData.setKeyword3(new TemplateDataElement(remind.getContent()));
        remindTemplateMessage.setData(remindTemplateData);

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(Constant.RECEIVER_OPENID.getValue(),receiverOpenid);
        jobDataMap.put(Constant.SENDER_OPENID.getValue(),senderOpenid);
        jobDataMap.put(Constant.REMIND_TEMPLATE_MESSAGE.getValue(),remindTemplateMessage);
        jobDataMap.put(Constant.TEMPLATE_MESSAGE_SERVICE.getValue(),templateMessageService);

        JobDetail jobDetail = JobBuilder
                .newJob(RemindTemplateMessageJob.class)
                .usingJobData(jobDataMap)
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .startAt(remind.getTime())
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
    }
}
