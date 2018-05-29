package priv.shen.wechat.remind.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.shen.wechat.remind.backend.domain.Formid;

public interface FormidRepository extends JpaRepository<Formid,String> {
    Formid findTopByOpenidOrderByDate(String openid);
}
