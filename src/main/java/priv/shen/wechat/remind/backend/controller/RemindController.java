package priv.shen.wechat.remind.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.shen.wechat.remind.backend.dto.*;
import priv.shen.wechat.remind.backend.result.*;
import priv.shen.wechat.remind.backend.service.RemindService;

import java.util.List;

@RestController
@RequestMapping("/remind")
public class RemindController {
    @Autowired
    private RemindService remindService;

    @PostMapping("/send")
    public ClockResult send(@RequestBody RemindView remindView) throws Exception {
        return remindService.sendRemind(remindView);
    }

    @PostMapping("/agree")
    public MessageResult agree(@RequestBody AgreeView agreeView) throws Exception {
        return remindService.agreeRemind(agreeView);
    }

    @PostMapping("/list/self")
    public ClockListResult listForSelf(@RequestBody OpenidView openidView){
        return remindService.listForSelf(openidView);
    }

    @PostMapping("/list/friend")
    public ClockListResult listForFriend(@RequestBody OpenidView openidView){
        return remindService.listForFriend(openidView);
    }

    @PostMapping("/delete")
    public MessageResult delete(@RequestBody SecureRemindIdView secureRemindIdView){
        return remindService.delete(secureRemindIdView);
    }

    @PostMapping("/detail")
    public RemindDetailResult detail(@RequestBody SecureRemindIdView secureRemindIdView){
        return remindService.getDetail(secureRemindIdView);
    }
}
