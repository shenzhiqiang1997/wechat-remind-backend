package priv.shen.wechat.remind.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String title;
    private Integer selfRemind;
    private Integer state;
}
