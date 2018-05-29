package priv.shen.wechat.remind.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.shen.wechat.remind.backend.dto.FormidView;
import priv.shen.wechat.remind.backend.result.MessageResult;
import priv.shen.wechat.remind.backend.service.FormidService;

@Api(value = "formid相关接口")
@RestController
@RequestMapping("/formid")
public class FormidController {
    @Autowired
    private FormidService formidService;

    @ApiOperation(value = "保存formid")
    @PostMapping("/save")
    public MessageResult save(@RequestBody FormidView formidView){
        return formidService.saveFormid(formidView);
    }
}
