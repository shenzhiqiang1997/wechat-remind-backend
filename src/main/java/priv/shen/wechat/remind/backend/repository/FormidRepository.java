package priv.shen.wechat.remind.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.shen.wechat.remind.backend.domain.Formid;

import java.util.Date;

public interface FormidRepository extends JpaRepository<Formid,String> {
    Formid findTop1ByOpenidOrderByDate(String openid);
    void deleteAllByDateBefore(Date date);
}
