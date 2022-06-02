package com.altera.capstone.bookingvaccine.domain.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class UsernamePassword {
    private String username;    // nik_as_username as username
    private String password;
//    private String firstName;
//    private String lastName;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDate birthDate;
//    private String gender;
//    private String email;
//    private String noHandphone;
//    private String roles;
}
