package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.chat.ChatRoom;

@Repository
public interface ChatRoomRepo extends CrudRepository<ChatRoom, Integer> {

    ChatRoom findBySenderIdAndRecipientId(int senderId, int recipientId);
}
