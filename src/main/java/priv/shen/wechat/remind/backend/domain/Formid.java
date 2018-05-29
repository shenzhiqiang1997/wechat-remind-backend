package priv.shen.wechat.remind.backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Formid {
    private String formid;
    private String openid;
    private Date date;
}
