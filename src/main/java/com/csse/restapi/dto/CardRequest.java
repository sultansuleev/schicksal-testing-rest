package com.csse.restapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class CardRequest implements Serializable {
    private Long id;
    private String question;
    private String correctAns;
    private String firstAns;
    private String secondAns;
    private String thirdAns;
    private String fourthAns;
    private String jwtToken;

    CardRequest(String question, String correctAns, String firstAns, String secondAns, String thirdAns, String fourthAns, String jwtToken){
        this.question = question;
        this.correctAns = correctAns;
        this.firstAns = firstAns;
        this.secondAns = secondAns;
        this.thirdAns = thirdAns;
        this.fourthAns = fourthAns;
        this.jwtToken = jwtToken;
    }

    CardRequest(Long id, String question, String correctAns, String firstAns, String secondAns, String thirdAns, String fourthAns) {
        this.id = id;
        this.question = question;
        this.correctAns = correctAns;
        this.firstAns = firstAns;
        this.secondAns = secondAns;
        this.thirdAns = thirdAns;
        this.fourthAns = fourthAns;
        this.jwtToken = jwtToken;
    }
}