package com.csse.restapi.dto;

import com.csse.restapi.entities.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignRole implements Serializable {
    private Long user_id;
    private Long role_id;
}