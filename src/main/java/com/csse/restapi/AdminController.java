package com.csse.restapi;

import com.csse.restapi.dto.AssignRole;
import com.csse.restapi.dto.CardRequest;
import com.csse.restapi.dto.ResultatRequest;
import com.csse.restapi.entities.*;
import com.csse.restapi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CardService cardService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<Users> users = userService.getAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Set<Roles> roles = new HashSet<>();
        roles.add(roleService.getRoleByName("ROLE_USER"));
        user.setRoles(roles);
        String password = user.getPassword();
        user.setQuote("Write a Quote...");
        user.setPassword(passwordEncoder.encode(password));
        userService.createUser(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody Users user) {
        userService.deleteUser(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/assignRole")
    public ResponseEntity<?> assignRole(@RequestBody AssignRole item) {
        System.out.println(item);
        Users user = userService.getUser(item.getUser_id());
        Set<Roles> roles = user.getRoles();
        Roles addedRole = userService.getRole(item.getRole_id());

        if (roles.contains(addedRole)) {
            roles.remove(addedRole);
        } else {
            roles.add(addedRole);

            user.setRoles(roles);
        }

        userService.AdmSaveUserInfo(user);

        return ResponseEntity.ok(item);
    }

    @GetMapping("/tests")
    public ResponseEntity<?> getTests() {
        List<Card> cards = cardService.getAll();

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/generateTest")
    public ResponseEntity<?> generateTest() {
        List<Card> cards = new ArrayList<>();
        Random rand = new Random();
        List<Card> givenList = cardService.getAll();
        List<Integer> doneGen = new ArrayList<>();

        int numberOfElements = 4;

        while (cards.size() != 4) {
            for (int i = 0; i < numberOfElements; i++) {
                int randomIndex = rand.nextInt(givenList.size());
                if (!doneGen.contains(randomIndex)) {
                    doneGen.add(randomIndex);
                    cards.add(givenList.get(randomIndex));
                }
            }
        }

        System.out.println(
                cards
        );
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @PostMapping("/addQuiz")
    public ResponseEntity<?>  addItem(@RequestBody CardRequest cardRequest){
        System.out.println(cardRequest);

        Card card = new Card();
        card.setQuestion(cardRequest.getQuestion());
        card.setCorrectAns(cardRequest.getCorrectAns());
        card.setFirstAns(cardRequest.getFirstAns());
        card.setSecondAns(cardRequest.getSecondAns());
        card.setThirdAns(cardRequest.getThirdAns());
        card.setFourthAns(cardRequest.getFourthAns());
        cardService.createCard(card);

        return  ResponseEntity.ok(card);
    }

    @DeleteMapping("/deleteCard")
    public ResponseEntity<?> deleteCard(@RequestBody Card card) {
        cardService.deleteCard(card);
        return ResponseEntity.ok(card);
    }

    @GetMapping("/ratings")
    public ResponseEntity<?> getRatings() {
        List<Rating> cards = cardService.getRatings();

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @PostMapping("/addResultat")
    public ResponseEntity<?> addResultat(@RequestBody ResultatRequest restRequest){
        System.out.println(restRequest);

        Rating card = new Rating();
        card.setUser_id(restRequest.getUser_id());
        card.setResult(restRequest.getResult());
        cardService.createRating(card);

        return  ResponseEntity.ok(card);
    }
}
