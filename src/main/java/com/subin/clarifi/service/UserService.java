package com.subin.clarifi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subin.clarifi.DTO.UserRegistrationRequestDTO;
import com.subin.clarifi.DTO.UserRegistrationRespondDTO;
import com.subin.clarifi.entity.User;
import com.subin.clarifi.repository.UserRepository;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    public UserRegistrationRespondDTO register(UserRegistrationRequestDTO userRegistrationRequestDTO){

        if(userRepository.existsByEmail(userRegistrationRequestDTO.getEmail()))
            throw new RuntimeException("Email already exist");

        User user = new User();
        user.setUsername(userRegistrationRequestDTO.getUsername());
        user.setEmail(userRegistrationRequestDTO.getEmail());
        user.setDob(userRegistrationRequestDTO.getDob());
        user.setPassword(userRegistrationRequestDTO.getPassword());


        User savedUser = userRepository.save(user);

        UserRegistrationRespondDTO userRegistrationRespondDTO = new UserRegistrationRespondDTO();

        userRegistrationRespondDTO.setUsername(user.getUsername());
        userRegistrationRespondDTO.setEmail(user.getEmail());
        userRegistrationRespondDTO.setDob(user.getDob());

        return userRegistrationRespondDTO;
    }

        public UserRegistrationRespondDTO findByUsername(String username){

            User user = userRepository.findByUsername(username).orElseThrow();
            UserRegistrationRespondDTO userRegistrationRespondDTO = new UserRegistrationRespondDTO();

            userRegistrationRespondDTO.setUsername(user.getUsername());
            userRegistrationRespondDTO.setEmail(user.getEmail());
            userRegistrationRespondDTO.setDob(user.getDob());
            
            return userRegistrationRespondDTO;
    }
     
}
