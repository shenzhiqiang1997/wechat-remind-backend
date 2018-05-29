package priv.shen.wechat.remind.backend.template;

import lombok.Data;

@Data
public class RemindTemplateMessage {
    private String touser;
    private String template_id;
    private String page;
    private String form_id;
    private RemindTemplateData data;
}
