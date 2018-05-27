package priv.shen.wechat.remind.backend.dto;

import lombok.Data;

@Data
public class SecureRemindIdView {
    private Long clockId;
    private String openid;
}
