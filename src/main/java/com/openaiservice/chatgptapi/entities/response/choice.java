package com.openaiservice.chatgptapi.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class choice implements Serializable {
    private Integer index;
    private String text;
    @JsonProperty("finish_reason")
    private String finishReason;
}
