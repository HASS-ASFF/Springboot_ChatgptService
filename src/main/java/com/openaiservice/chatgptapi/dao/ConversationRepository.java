package com.openaiservice.chatgptapi.dao;

import com.openaiservice.chatgptapi.entities.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation,Long> {

}
