package priv.shen.wechat.remind.backend.schedule;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import priv.shen.wechat.remind.backend.service.TemplateMessageService;
import priv.shen.wechat.remind.backend.template.RemindTemplateMessage;

@Setter
public class RemindTemplateMessageJob extends QuartzJobBean {
    private TemplateMessageService templateMessageService;
    private RemindTemplateMessage remindTemplateMessage;
    private String receiverOpenid;
    private String senderOpenid;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if (senderOpenid==null)
            templateMessageService.sendRemind(receiverOpenid,remindTemplateMessage);
        else
            templateMessageService.sendRemind(receiverOpenid,senderOpenid,remindTemplateMessage);
    }
}
