package priv.shen.wechat.remind.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.shen.wechat.remind.backend.domain.Remind;
import priv.shen.wechat.remind.backend.dto.*;
import priv.shen.wechat.remind.backend.exception.GlobalException;
import priv.shen.wechat.remind.backend.repository.RemindRepository;
import priv.shen.wechat.remind.backend.result.Flag;
import priv.shen.wechat.remind.backend.result.Message;
import priv.shen.wechat.remind.backend.result.Result;

import java.util.List;
import java.util.Optional;

@Service
public class RemindService {
    @Autowired
    private RemindRepository remindRepository;

    public Result<Long> sendRemind(RemindView remindView){
        Remind remind = new Remind();
        remind.setSenderId(remindView.getOpenid());
        if (remindView.getSelfClock() == 1){
            remind.setReceiverId(remindView.getOpenid());
        }else {
            remind.setState(0);
        }
        remind.setTime(remindView.getTime());
        remind.setTitle(remindView.getTitle());
        remind.setContent(remindView.getContent());
        remind.setName(remindView.getName());

        remind = remindRepository.saveAndFlush(remind);
        return new Result<>(Flag.SUCCESS.getCode(),remind.getRemindId());
    }

    public Result<String> agreeRemind(AgreeView agreeView) {
        Optional<Remind> remindOptional = remindRepository.findById(agreeView.getClockId());
        if (!remindOptional.isPresent())
            throw new GlobalException(Message.AGREE_FAILURE.getContent());

        Remind remind = remindOptional.get();
        if (agreeView.getCheck() ==1 )
            remind.setState(1);
        else
            remind.setState(0);

        remind.setReceiverId(agreeView.getReceiverOpenId());

        return new Result<>(Flag.SUCCESS.getCode(),Message.AGREE_SUCCESS.getContent());
    }

    public Result<List<Remind>> listForSelf(OpenidView openidView) {
        List<Remind> remindList = remindRepository.findAllBySelfRemindAndReceiverId(1,openidView.getOpenid());
        return new Result<>(Flag.SUCCESS.getCode(),remindList);
    }

    public Result<List<Remind>> listForFriend(OpenidView openidView) {
        List<Remind> remindList = remindRepository.findAllBySelfRemindAndSenderId(0, openidView.getOpenid());
        return new Result<>(Flag.SUCCESS.getCode(),remindList);
    }

    public Result<String> delete(SecureRemindIdView receiverView) {
        remindRepository.deleteByRemindIdAndReceiverIdEquals(receiverView.getClockId(),receiverView.getOpenid());
        remindRepository.deleteByRemindIdAndSenderIdEquals(receiverView.getClockId(),receiverView.getOpenid());
        return new Result<>(Flag.SUCCESS.getCode(),Message.DELETE_SUCCESS.getContent());
    }


    public Result<RemindDetail> getDetail(SecureRemindIdView secureRemindIdView) {
        Remind remind = remindRepository.findByRemindIdAndReceiverIdEquals(secureRemindIdView.getClockId(),secureRemindIdView.getOpenid());
        if (remind == null){
            remind = remindRepository.findByRemindIdAndSenderIdEquals(secureRemindIdView.getClockId(),secureRemindIdView.getOpenid());
        }

        if (remind == null){
            throw new GlobalException(Message.DETAIL_FAILURE.getContent());
        }

        RemindDetail remindDetail = new RemindDetail(remind.getTitle(),remind.getContent(),remind.getName());

        return new Result<>(Flag.SUCCESS.getCode(),remindDetail);
    }
}
