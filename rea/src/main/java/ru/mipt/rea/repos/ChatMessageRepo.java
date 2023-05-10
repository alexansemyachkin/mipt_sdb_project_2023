package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.chat.ChatMessage;
import ru.mipt.rea.models.chat.MessageStatus;

import java.util.List;

@Repository
public interface ChatMessageRepo extends CrudRepository<ChatMessage, Integer> {

    List<ChatMessage> findByChatId(String chatId);
    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

}