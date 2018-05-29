package priv.shen.wechat.remind.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.shen.wechat.remind.backend.domain.Remind;

import java.util.List;

public interface RemindRepository extends JpaRepository<Remind,Long> {
    List<Remind> findAllBySelfRemindAndReceiverId(Integer selfRemind,String receiverId);
    List<Remind> findAllBySelfRemindAndSenderId(Integer selfRemind,String senderId);
    void deleteByIdAndSenderIdEquals(Long remindId, String senderId);
    void deleteByIdAndReceiverIdEquals(Long remindId, String receiverId);
    Remind findByIdAndSenderIdEquals(Long remindId, String senderId);
    Remind findByIdAndReceiverIdEquals(Long remindId, String receiverId);
}
