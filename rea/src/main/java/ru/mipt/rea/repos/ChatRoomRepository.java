package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import ru.mipt.rea.models.chat.ChatRoom;

import java.util.Optional;

public interface ChatRoomRepository extends CrudRepository<ChatRoom, Integer> {

    ChatRoom findBySenderIdAndRecipientId(int senderId, int recipientId);
}
