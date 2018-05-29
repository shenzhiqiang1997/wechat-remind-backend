package priv.shen.wechat.remind.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import priv.shen.wechat.remind.backend.constant.Constant;
import priv.shen.wechat.remind.backend.constant.RequestURL;
import priv.shen.wechat.remind.backend.domain.Formid;
import priv.shen.wechat.remind.backend.repository.FormidRepository;
import priv.shen.wechat.remind.backend.template.RemindTemplateMessage;

@Service
public class TemplateMessageService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private FormidRepository formidRepository;

    @Transactional
    public void sendRemind(String receiverOpenid, RemindTemplateMessage remindTemplateMessage){
        String accessToken = redisTemplate.opsForValue().get(Constant.ACCESS_TOKEN.getValue());

        String templateMessageUrl = RequestURL.TEMPLATE_MESSAGE_URL.getPath()+accessToken;

        Formid formid = formidRepository.findTop1ByOpenidOrderByDate(receiverOpenid);
        formidRepository.deleteById(formid.getFormid());
        remindTemplateMessage.setForm_id(formid.getFormid());

        restTemplate.postForObject(templateMessageUrl,remindTemplateMessage,String.class);
    }

    @Transactional
    public void sendRemind(String receiverOpenid,String senderOpenid,RemindTemplateMessage remindTemplateMessage){
        String accessToken = redisTemplate.opsForValue().get(Constant.ACCESS_TOKEN.getValue());
        System.out.println(accessToken);
        String templateMessageUrl = RequestURL.TEMPLATE_MESSAGE_URL.getPath()+accessToken;
        Formid formid = formidRepository.findTop1ByOpenidOrderByDate(receiverOpenid);
        formidRepository.deleteById(formid.getFormid());
        remindTemplateMessage.setForm_id(formid.getFormid());

        restTemplate.postForObject(templateMessageUrl,remindTemplateMessage,String.class);

        formid = formidRepository.findTop1ByOpenidOrderByDate(senderOpenid);
        formidRepository.deleteById(formid.getFormid());
        remindTemplateMessage.setForm_id(formid.getFormid());

        restTemplate.postForObject(templateMessageUrl,remindTemplateMessage,String.class);
    }
}
