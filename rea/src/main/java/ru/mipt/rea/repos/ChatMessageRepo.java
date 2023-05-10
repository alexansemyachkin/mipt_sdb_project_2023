package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.chat.ChatMessage;

import java.util.List;

@Repository
public interface ChatMessageRepo extends CrudRepository<ChatMessage, Integer> {

    List<ChatMessage> findByChatId(int chatId);

}