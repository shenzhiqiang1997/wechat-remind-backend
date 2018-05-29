package priv.shen.wechat.remind.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OpenidJson {
    /**
     * openid : OPENID
     * session_key : SESSIONKEY
     * unionid : UNIONID
     */

    private String openid;
    private String session_key;
    private String unionid;
}
