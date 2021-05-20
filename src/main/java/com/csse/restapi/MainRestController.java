package com.csse.restapi;

import com.csse.restapi.dto.CardRequest;
import com.csse.restapi.dto.JwtRequest;
import com.csse.restapi.dto.MessageResponse;
import com.csse.restapi.entities.Card;
import com.csse.restapi.entities.Users;
import com.csse.restapi.jwt.JwtTokenGenerator;
import com.csse.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class MainRestController {
    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    private UserService userService;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PutMapping("/changeName")
    public ResponseEntity<?> changeName(@RequestBody Users user) {
        Users existedUser = userService.getByEmail(user.getEmail());
        System.out.println(user);
        existedUser.setFullName(user.getFullName());
        userService.createUser(existedUser);

        return ResponseEntity.ok(existedUser);
    }

    @PutMapping("/changeQuote")
    public ResponseEntity<?> changeQuote(@RequestBody Users user) {
        Users existedUser = userService.getByEmail(user.getEmail());
        System.out.println(user);
        existedUser.setQuote(user.getQuote());
        userService.createUser(existedUser);

        return ResponseEntity.ok(existedUser);
    }

    @PutMapping("/changePass")
    public ResponseEntity<?> changePassword(@RequestBody JwtRequest request) {
        Users existedUser = userService.getByEmail(request.getEmail());

        if (passwordEncoder.matches(request.getPassword(), existedUser.getPassword())) {
            existedUser.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userService.createUser(existedUser);
            return ResponseEntity.ok(existedUser);
        }

        return ResponseEntity.badRequest().body(new MessageResponse("Old password does not match!"));
    }
}
