package com.csse.restapi.services;

import com.csse.restapi.entities.Roles;
import com.csse.restapi.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void deleteUser(Users user);
    Boolean existsByEmail(String email);
    Users createUser(Users user);
    Users getUser(Long id);
    String getPasswordByEmail(String email);
    Users getByEmail(String email);
    List<Users> getAll();
    Roles getRole(Long id);
    Users AdmSaveUserInfo(Users item);
}