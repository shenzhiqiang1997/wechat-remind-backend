package priv.shen.wechat.remind.backend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Formid {
    @Id
    private String formid;
    private String openid;
    private Date date;
}
