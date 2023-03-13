package com.openaiservice.chatgptapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Conversation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    @Column(length = 4000)
    private String response;

    public Conversation(String question, String response){
        this.question = question;
        this.response = response;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
