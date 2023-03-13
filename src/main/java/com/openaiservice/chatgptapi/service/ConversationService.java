package com.openaiservice.chatgptapi.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.openaiservice.chatgptapi.config.ChatGptConfig;
import com.openaiservice.chatgptapi.dao.ConversationRepository;
import com.openaiservice.chatgptapi.entities.Conversation;
import com.openaiservice.chatgptapi.entities.request.PromptRequest;
import com.openaiservice.chatgptapi.entities.request.chatgptRequest;
import com.openaiservice.chatgptapi.entities.response.chatgptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ConversationService {

    private static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ConversationRepository conversationRepository;

    public List<Conversation> getHistory(){
        return conversationRepository.findAll();
    }

    public String getResponse(PromptRequest promptRequest){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        headers.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + promptRequest.getKeyapi());

        HttpEntity<chatgptRequest> requestEntity = new HttpEntity<>(new chatgptRequest(
                ChatGptConfig.MODEL,
                promptRequest.getQuestion(),
                ChatGptConfig.TEMPERATURE,
                ChatGptConfig.MAX_TOKEN,
                ChatGptConfig.TOP_P), headers);

        ResponseEntity<chatgptResponse> responseEntity = restTemplate.postForEntity(
                ChatGptConfig.URL,
                requestEntity,
                chatgptResponse.class);


        System.out.println(responseEntity.getBody().getChoices().get(0).getText());

        String question = promptRequest.getQuestion();
        String response = responseEntity.getBody().getChoices().get(0).getText();

        // add to database the message
        conversationRepository.save(new Conversation(question,response));

        return response;
    }
}
