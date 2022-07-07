package com.altera.capstone.bookingvaccine.controller;

import com.altera.capstone.bookingvaccine.config.security.AuthService;
import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.payload.Login;
import com.altera.capstone.bookingvaccine.domain.payload.TokenResponse;
import com.altera.capstone.bookingvaccine.domain.payload.UsernamePassword;
import com.altera.capstone.bookingvaccine.service.UserService;
import com.altera.capstone.bookingvaccine.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/v1/auth")
@RequiredArgsConstructor
@Api(tags = "Auth", value = "Auth")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    // Register
    @ApiOperation(value = "Register user", response = UsernamePassword.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success register user"),

    })
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsernamePassword req) {
        authService.register(req);
        return ResponseUtil.build(AppConstant.Message.SUCCESS, req, HttpStatus.OK);
    }

    // Login
    @ApiOperation(value = "Login user", response = Login.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success login user"),

    })
    @PostMapping("/login")
    public ResponseEntity<?> token(@RequestBody UsernamePassword req) {
        TokenResponse token = authService.generateToken(req);
        return ResponseUtil.build(AppConstant.Message.SUCCESS, token, HttpStatus.OK);
    }
}