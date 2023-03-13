package com.openaiservice.chatgptapi.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromptRequest implements Serializable {
    private String keyapi;
    private String question;
}
