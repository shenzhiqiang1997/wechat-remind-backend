package priv.shen.wechat.remind.backend.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import priv.shen.wechat.remind.backend.domain.Remind;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClockListResult {
    private Integer flag;
    private List<Remind> clockList;
}
