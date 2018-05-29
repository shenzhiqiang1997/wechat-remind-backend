package priv.shen.wechat.remind.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import priv.shen.wechat.remind.backend.constant.Constant;
import priv.shen.wechat.remind.backend.constant.RequestURL;
import priv.shen.wechat.remind.backend.repository.FormidRepository;
import priv.shen.wechat.remind.backend.repository.RemindRepository;

@Service
public class TemplateMessageService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private FormidRepository formidRepository;
    @Autowired
    private RemindRepository remindRepository;

    public void sendRemind(){
        String accessToken = redisTemplate.opsForValue().get(Constant.ACCESS_TOKEN.getValue());

        String templateMessageUrl = RequestURL.TEMPLATE_MESSAGE_URL+accessToken;
    }
}
