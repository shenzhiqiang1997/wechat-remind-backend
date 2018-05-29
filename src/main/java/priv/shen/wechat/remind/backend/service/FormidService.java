package priv.shen.wechat.remind.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.shen.wechat.remind.backend.domain.Formid;
import priv.shen.wechat.remind.backend.dto.FormidView;
import priv.shen.wechat.remind.backend.repository.FormidRepository;
import priv.shen.wechat.remind.backend.result.Flag;
import priv.shen.wechat.remind.backend.result.Message;
import priv.shen.wechat.remind.backend.result.MessageResult;

import java.util.Date;

@Service
public class FormidService {
    @Autowired
    private FormidRepository formidRepository;
    public MessageResult saveFormid(FormidView formidView) {
        Formid formid = new Formid();
        formid.setFormid(formidView.getFormid());
        formid.setOpenid(formidView.getOpenid());
        formid.setDate(new Date());
        formidRepository.save(formid);

        return new MessageResult(Flag.SUCCESS.getCode(), Message.SAVE_SUCCESS.getContent());
    }
}
