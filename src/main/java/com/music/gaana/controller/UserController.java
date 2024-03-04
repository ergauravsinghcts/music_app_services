package com.music.gaana.controller;

/*
 * create controller using the methods available in UserService
 */

import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.music.gaana.exceptions.UserAlreadyExistException;
import com.music.gaana.model.User;
import com.music.gaana.service.UserService;

import java.util.Date;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    // use jwt signing key from application.properties
    @Value("${jwt.signing.key}")
    private String jwtSigningKey;
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws UserAlreadyExistException {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> validateUser(@RequestBody User user) {
        User user1 = userService.validateUser(user.getEmailId(), user.getPassword());
        if (user1 == null) {
            return new ResponseEntity<String>("User is invalid", HttpStatus.NOT_FOUND);
        }
        String token = getToken(user.getEmailId());
        return new ResponseEntity<String>("User logged in successfully !! Token:" + token, HttpStatus.OK);
    }

    // create method gettoken to generate token based on emailId
    private String getToken(String emailId) {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject(emailId)
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, jwtSigningKey)
                .compact();
    }

}
