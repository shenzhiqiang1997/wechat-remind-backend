package priv.shen.wechat.remind.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import priv.shen.wechat.remind.backend.util.AccessTokenUtil;

@SpringBootApplication
public class WechatRemindBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatRemindBackendApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public AccessTokenUtil accessTokenUtil(){
        return new AccessTokenUtil();
    }
}
