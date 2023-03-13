package com.openaiservice.chatgptapi.web.controller;


import com.openaiservice.chatgptapi.entities.Conversation;
import com.openaiservice.chatgptapi.entities.request.PromptRequest;
import com.openaiservice.chatgptapi.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @PostMapping("/api/prompts")
    public String AskChatgptApi(@RequestBody PromptRequest promptRequest){
        return conversationService.getResponse(promptRequest);
    }

    @GetMapping("/api/conversations")
    public List<Conversation>  StoredConversation(){
        return conversationService.getHistory();
    }
}
