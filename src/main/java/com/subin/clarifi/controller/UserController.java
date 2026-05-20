package com.subin.clarifi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subin.clarifi.DTO.UserRegistrationRequestDTO;
import com.subin.clarifi.DTO.UserRegistrationRespondDTO;
import com.subin.clarifi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController{

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationRespondDTO> registration(@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO){
        
        UserRegistrationRespondDTO registeredUser = userService.register(userRegistrationRequestDTO);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @GetMapping("/login/{username}")
    public ResponseEntity<UserRegistrationRespondDTO> loadUserByEmail(@PathVariable String username){

        UserRegistrationRespondDTO respondUser = userService.findByUsername(username);
        return new ResponseEntity<UserRegistrationRespondDTO>(respondUser, HttpStatus.OK);
    }

}
