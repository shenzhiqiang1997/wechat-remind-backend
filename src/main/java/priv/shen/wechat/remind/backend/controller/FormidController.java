package priv.shen.wechat.remind.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.shen.wechat.remind.backend.dto.FormidView;
import priv.shen.wechat.remind.backend.result.MessageResult;
import priv.shen.wechat.remind.backend.result.Result;
import priv.shen.wechat.remind.backend.service.FormidService;

@RestController
@RequestMapping("/formid")
public class FormidController {
    @Autowired
    private FormidService formidService;

    @PostMapping("/save")
    public MessageResult save(@RequestBody FormidView formidView){
        return formidService.saveFormid(formidView);
    }
}
