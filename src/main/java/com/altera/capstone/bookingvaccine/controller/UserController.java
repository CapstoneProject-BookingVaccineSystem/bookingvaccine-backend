package com.altera.capstone.bookingvaccine.controller;

import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.common.ResponseMessage;
import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
import com.altera.capstone.bookingvaccine.domain.dto.FamilyDto;
import com.altera.capstone.bookingvaccine.domain.dto.UserDto;
import com.altera.capstone.bookingvaccine.domain.payload.UsernamePassword;
import com.altera.capstone.bookingvaccine.repository.UserRepository;
import com.altera.capstone.bookingvaccine.service.UserService;
import com.altera.capstone.bookingvaccine.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

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

  // POST
  @ApiOperation(value = "Register user",  response = UsernamePassword.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success register user"),

  })
  @PostMapping("")
  public ResponseEntity<?> register(@RequestBody UserDto req) {
    userService.addUser(req);
    return ResponseUtil.build(AppConstant.Message.SUCCESS, req, HttpStatus.OK);
  }

  // - Get All
  @ApiOperation(value = "Get all user",  response = UserDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success get list user"),
  })
  @GetMapping(value = "")
  public ResponseEntity<Object> getAll() {
    return userService.getAllUser();
  }

  // GET By ID
  @ApiOperation(value = "GET User by id",  response = UserDao.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success get user by id"),
  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id){
    return userService.getUserById(id);
  }

  // PUT User By Id
  @ApiOperation(value = "Update user",  response = UserDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success update user"),
  })
  @PutMapping(value = "/{id}")
  public ResponseEntity<Object> updateBook(@PathVariable(value = "id") Long id, @RequestBody UserDto request) {
    return userService.updateUser(id, request);
  }

  // DELETE User By Id
  @ApiOperation(value = "Delete user",  response = UserDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success delete user"),
  })
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id) {
    return userService.deleteUser(id);
  }
//  @ApiOperation(value = "upload photo user",  response = UsernamePassword.class)
//  @ApiResponses(value = {
//          @ApiResponse(code = 200, message = "Success upload photo user"),
//
//  })
//  @PostMapping("/upload")
//  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){
//    String message = "";
//    try {
//      userService.store(file);
//      message = "Uploaded The File Successfully: "+ file.getOriginalFilename();
//      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//    } catch (Exception e){
//      message = "Could Not Upload the File : "+ file.getOriginalFilename() + "!";
//      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//    }
//  }

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
