package com.subin.clarifi.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequestDTO{
    
    private String username;
    
    private String password;
    
    private String email;
    
    private LocalDate dob;
}
