package com.altera.capstone.bookingvaccine.controller;

import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
import com.altera.capstone.bookingvaccine.domain.payload.UsernamePassword;
import com.altera.capstone.bookingvaccine.repository.UserRepository;
import com.altera.capstone.bookingvaccine.service.UserService;
import com.altera.capstone.bookingvaccine.util.ImageUtility;
import com.altera.capstone.bookingvaccine.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Controller
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

//    @GetMapping("/login")
//    public ResponseEntity<?> getLogin(Principal principal){
//        return ResponseEntity.ok(principal.getName()+" Berhasil Login");
//    }

        @ApiOperation(value = "Register user",  response = UsernamePassword.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success register user"),

    })
    @PostMapping("/create")
    public ResponseEntity<?> register(@RequestBody UsernamePassword req) {
//        validasi length nik
//        authService.validateUsernameAsNIK(req);
//        validasi role
//        authService.validateInputRole(req);
//        save
        userService.register(req);
        return ResponseUtil.build(AppConstant.Message.SUCCESS, req, HttpStatus.OK);
    }

//    @PostMapping("/upload/image")
//    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file)
//            throws IOException {
//
//        userRepository.save(UserDao.builder()
//                .name(file.getOriginalFilename())
//                .typeImg(file.getContentType())
//                .imageProfile(ImageUtility.compressImage(file.getBytes())).build());
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ImageUploadResponse("Image uploaded successfully: " +
//                        file.getOriginalFilename()));
//    }

//    @GetMapping(path = {"/get/image/info/{name}"})
//    public UserDao getImageDetails(@PathVariable("name") String namePhoto) throws IOException {
//
//        final Optional<UserDao> dbImage = userRepository.findByName(namePhoto);
//
//        return UserDao.builder()
//                .name(dbImage.get().getName())
//                .typeImg(dbImage.get().getTypeImg())
//                .imageProfile(ImageUtility.decompressImage(dbImage.get().getImageProfile())).build();
//    }

//    @GetMapping(path = {"/get/image/{name}"})
//    public ResponseEntity<byte[]> getImage(@PathVariable("name") String namePhoto) throws IOException {
//
//        final Optional<UserDao> dbImage = userRepository.findByName(namePhoto);
//
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.valueOf(dbImage.get().getTypeImg()))
//                .body(ImageUtility.decompressImage(dbImage.get().getImageProfile()));
//    }
}
