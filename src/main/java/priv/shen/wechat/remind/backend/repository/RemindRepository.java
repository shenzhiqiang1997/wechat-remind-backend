package priv.shen.wechat.remind.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.shen.wechat.remind.backend.domain.Remind;

import java.util.List;

public interface RemindRepository extends JpaRepository<Remind,Long> {
    List<Remind> findAllBySelfRemindAndReceiverId(Integer selfRemind,String receiverId);
    List<Remind> findAllBySelfRemindAndSenderId(Integer selfRemind,String senderId);
    void deleteByRemindIdAndSenderIdEquals(Long remindId,String senderId);
    void deleteByRemindIdAndReceiverIdEquals(Long remindId,String receiverId);
    Remind findByRemindIdAndSenderIdEquals(Long remindId,String senderId);
    Remind findByRemindIdAndReceiverIdEquals(Long remindId,String receiverId);
}
