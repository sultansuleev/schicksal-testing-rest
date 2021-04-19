package com.csse.restapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 123456789L;
    private String email;
    private String password;
    private String fullName;
    private String university;
    private String location;
    private String quote;
    private String newPassword;

    JwtRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    public JwtRequest(String email, String fullName, String newPassword) {
        this.email = email;
        this.fullName = fullName;
        this.newPassword = newPassword;
    }

    public JwtRequest(String email, String fullName, String newPassword, String quote) {
        this.email = email;
        this.fullName = fullName;
        this.newPassword = newPassword;
        this.quote = quote;
    }
}