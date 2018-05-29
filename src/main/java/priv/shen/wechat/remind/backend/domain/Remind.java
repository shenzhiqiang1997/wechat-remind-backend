package priv.shen.wechat.remind.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonFormat(pattern = "id")
    private Long remindId;
    @JsonIgnore
    private String senderId;
    @JsonIgnore
    private String receiverId;
    private String name;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date time;
    private String title;
    @JsonIgnore
    private String content;
    @JsonIgnore
    private Integer selfRemind;
    private Integer state;
}
