package priv.shen.wechat.remind.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.shen.wechat.remind.backend.repository.RemindRepository;

@Service
public class RemindService {
    @Autowired
    private RemindRepository remindRepository;
}
