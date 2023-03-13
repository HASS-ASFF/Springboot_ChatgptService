package com.openaiservice.chatgptapi.entities.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class chatgptResponse implements Serializable {
    private String id;
    private String object;
    private String model;
    private LocalDate created;
    private List<choice> choices;
}
