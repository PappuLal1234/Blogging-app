package com.blog.controller;

import com.blog.entity.AuthenticationToken;
import com.blog.entity.User;
import com.blog.entity.dto.SignUpOutput;
import com.blog.entity.dto.SignInInput;

import com.blog.service.AuthenticationService;
import com.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private  UserService userService;
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }
    @PostMapping("/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInPatient(signInInput);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

//    @PutMapping("/{userId}")
//    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user) {
//        User existingUser = userService.getUserById(userId);
//        if (existingUser != null) {
//            user.setUserId(userId);
//            User updatedUser = userService.updateUser(user);
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
@PutMapping ("/{email}/token/{token}")
public  ResponseEntity<User> updateUser1(@PathVariable String email,@PathVariable String token, @RequestBody User user)
{
    AuthenticationToken authenticationToken=
new AuthenticationToken();
    if(authenticationService.authenticate(email,token)) {
            User updatedUser = userService.updateUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

}
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        User existingUser = userService.getUserById(userId);
        if (existingUser != null) {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
