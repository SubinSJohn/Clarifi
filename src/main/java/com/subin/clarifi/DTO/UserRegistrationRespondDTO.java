package com.subin.clarifi.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRespondDTO{
    
    private String username;

    private String email;

    private LocalDate dob;
}
