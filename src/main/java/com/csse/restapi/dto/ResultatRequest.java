package com.csse.restapi.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ResultatRequest implements Serializable {
    private Long id;
    private Long user_id;
    private Integer result;

    ResultatRequest(Long user_id, Integer result){
        this.user_id = user_id;
        this.result = result;
    }

    ResultatRequest(Long id, Long user_id, Integer result) {
        this.id = id;
        this.user_id = user_id;
        this.result = result;
    }
}