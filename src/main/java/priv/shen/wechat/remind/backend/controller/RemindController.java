package priv.shen.wechat.remind.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.shen.wechat.remind.backend.entity.Remind;
import priv.shen.wechat.remind.backend.service.RemindService;

@RestController
@RequestMapping("/remind")
public class RemindController {
    @Autowired
    private RemindService remindService;


}
