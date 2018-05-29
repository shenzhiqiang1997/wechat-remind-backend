package priv.shen.wechat.remind.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.shen.wechat.remind.backend.dto.*;
import priv.shen.wechat.remind.backend.result.*;
import priv.shen.wechat.remind.backend.service.RemindService;

@Api(value = "备忘相关接口")
@RestController
@RequestMapping("/remind")
public class RemindController {
    @Autowired
    private RemindService remindService;

    @ApiOperation(value = "发送备忘申请",response = ClockResult.class)
    @PostMapping("/send")
    public ClockResult send(@RequestBody RemindView remindView) throws Exception {
        return remindService.sendRemind(remindView);
    }

    @ApiOperation(value = "同意好友的备忘申请")
    @PostMapping("/agree")
    public MessageResult agree(@RequestBody AgreeView agreeView) throws Exception {
        return remindService.agreeRemind(agreeView);
    }

    @ApiOperation(value = "查看我的备忘列表",response = ClockListResult.class)
    @PostMapping("/list/self")
    public ClockListResult listForSelf(@RequestBody OpenidView openidView){
        return remindService.listForSelf(openidView);
    }

    @ApiOperation(value = "查看给朋友的备忘列表",response = ClockListResult.class)
    @PostMapping("/list/friend")
    public ClockListResult listForFriend(@RequestBody OpenidView openidView){
        return remindService.listForFriend(openidView);
    }

    @ApiOperation(value = "删除闹钟")
    @PostMapping("/delete")
    public MessageResult delete(@RequestBody SecureRemindIdView secureRemindIdView){
        return remindService.delete(secureRemindIdView);
    }

    @ApiOperation(value = "查看备忘详细内容",response = RemindDetailResult.class)
    @PostMapping("/detail")
    public RemindDetailResult detail(@RequestBody SecureRemindIdView secureRemindIdView){
        return remindService.getDetail(secureRemindIdView);
    }
}
