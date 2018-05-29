package priv.shen.wechat.remind.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class Remind {
    @Id
    @GeneratedValue
    private Long remindId;
    private String senderId;
    private String receiverId;
    private String name;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date time;
    private String title;
    private String content;
    private Integer selfRemind;
    private Integer state;
}
