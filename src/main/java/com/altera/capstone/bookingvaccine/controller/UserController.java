package com.altera.capstone.bookingvaccine.controller;

import com.altera.capstone.bookingvaccine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ResponseEntity<?> getLogin(Principal principal){
        return ResponseEntity.ok(principal.getName()+" Berhasil Login");
    }
}
