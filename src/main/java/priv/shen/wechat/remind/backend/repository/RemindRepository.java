package priv.shen.wechat.remind.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.shen.wechat.remind.backend.entity.Remind;

public interface RemindRepository extends JpaRepository<Remind,Long> {
}
