package priv.shen.wechat.remind.backend.template;

import lombok.Data;
import priv.shen.wechat.remind.backend.constant.Constant;

@Data
public class RemindTemplateMessage {
    private String touser;
    private String template_id = Constant.TEMPLATE_ID.getValue();
    private String page;
    private String form_id;
    private RemindTemplateData data;
}
