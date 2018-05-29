package priv.shen.wechat.remind.backend.dto;

import lombok.Data;

@Data
public class AccessTokenJson {
    private String access_token;
    private Integer expires_in;
}
