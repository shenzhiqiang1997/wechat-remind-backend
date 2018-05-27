package priv.shen.wechat.remind.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.shen.wechat.remind.backend.domain.Remind;
import priv.shen.wechat.remind.backend.dto.*;
import priv.shen.wechat.remind.backend.result.Result;
import priv.shen.wechat.remind.backend.service.RemindService;

import java.util.List;

@RestController
@RequestMapping("/remind")
public class RemindController {
    @Autowired
    private RemindService remindService;

    @PostMapping("/send")
    public Result<Long> send(@RequestBody RemindView remindView){
        return remindService.sendRemind(remindView);
    }

    @PostMapping("/agree")
    public Result<String> agree(@RequestBody AgreeView agreeView){
        return remindService.agreeRemind(agreeView);
    }

    @PostMapping("/list/self")
    public Result<List<Remind>> listForSelf(@RequestBody OpenidView openidView){
        return remindService.listForSelf(openidView);
    }

    @PostMapping("/list/friend")
    public Result<List<Remind>> listForFriend(@RequestBody OpenidView openidView){
        return remindService.listForFriend(openidView);
    }

    @PostMapping("/delete")
    public Result<String> delete(@RequestBody SecureRemindIdView secureRemindIdView){
        return remindService.delete(secureRemindIdView);
    }

    @PostMapping("/detail")
    public Result<RemindDetail> detail(@RequestBody SecureRemindIdView secureRemindIdView){
        return remindService.getDetail(secureRemindIdView);
    }
}
