package priv.shen.wechat.remind.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Remind {
    @Id
    @GeneratedValue
    private Long remindId;
    private String senderId;
    private String receiverId;
    private String senderName;
    private Date time;
    private String title;
    private Integer selfRemind;
    private Integer state;
}
