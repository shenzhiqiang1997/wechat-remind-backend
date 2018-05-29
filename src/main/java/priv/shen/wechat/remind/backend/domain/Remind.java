package priv.shen.wechat.remind.backend.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class Remind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "remind_id")
    private Long id;
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
