package com.altera.capstone.bookingvaccine.controller;

import com.altera.capstone.bookingvaccine.config.security.AuthService;
import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.payload.TokenResponse;
import com.altera.capstone.bookingvaccine.domain.payload.UsernamePassword;
import com.altera.capstone.bookingvaccine.service.UserService;
import com.altera.capstone.bookingvaccine.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsernamePassword req) {
//        validasi length nik
        authService.validateUsernameAsNIK(req);
//        save
        authService.register(req);
        return ResponseUtil.build(AppConstant.Message.SUCCESS, req, HttpStatus.OK);
    }

    @PostMapping("/token" )
    public ResponseEntity<?> token(@RequestBody UsernamePassword req) {
        TokenResponse token = authService.generateToken(req);
        return ResponseUtil.build(AppConstant.Message.SUCCESS, token, HttpStatus.OK);

        /*jika ingin print message not found*/
//        try {
//            TokenResponse token = authService.generateToken(req);
//            return ResponseUtil.build(AppConstant.Message.SUCCESS, token, HttpStatus.OK);
//        } catch (Exception e){
//            return ResponseUtil.build(AppConstant.Message.NOT_FOUND, req.getUsername(),HttpStatus.NOT_FOUND);
//        }
    }
}
