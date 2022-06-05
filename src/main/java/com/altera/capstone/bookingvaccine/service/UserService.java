package com.altera.capstone.bookingvaccine.service;

import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
import com.altera.capstone.bookingvaccine.domain.payload.UsernamePassword;
import com.altera.capstone.bookingvaccine.repository.UserRepository;
import com.altera.capstone.bookingvaccine.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Log4j2
@Service
@RequiredArgsConstructor

public class UserService {

  private final UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDao user = userRepository.getDistinctTopByUsername(username);
//        if(user == null)
//            throw new UsernameNotFoundException("Username not found");
//
//        return user;
//    }

  public UserDao register(UsernamePassword req){
    UserDao user = new UserDao();
    if(req.getRoles() == null){
      req.setRoles("USER");
    }
    user.setUsername(req.getUsername());
//        user.setPassword(passwordEncoder.encode(req.getPassword()));
    user.setPassword((req.getPassword()));
    user.setFirstName(req.getFirstName());
    user.setLastName(req.getLastName());
    user.setBirthDate(req.getBirthDate());
    user.setGender(req.getGender());
    user.setEmail(req.getEmail());
    user.setNoHandphone(req.getNoHandphone());
    user.setRoles(req.getRoles());
    return userRepository.save(user);
  }

  public UserDao store(MultipartFile file)throws IOException{
    String imageData = StringUtils.cleanPath(file.getOriginalFilename());
    UserDao fileDB = new UserDao(imageData, file.getContentType(), file.getBytes());
    return userRepository.save(fileDB);
  }

//  public UserDao getFileByIdUser(Long id){
//    return userRepository.findById(id).get();
//  }

  public ResponseEntity<Object> getUserById(Long id_user) {
    log.info("Executing get category by id: {} ", id_user);
    try {
      Optional<UserDao> userDao = userRepository.findById(id_user);
      if(userDao.isEmpty()) {
        log.info("user id: {} not found", id_user);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      log.info("Executing get user by id success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, userDao, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when get user by id. Error: {}", e.getMessage());
      log.trace("Get error when get user by id. ", e);
      throw e;
    }
  }

  public Stream<UserDao> getAllFileByUserDao() {
    return userRepository.findAll().stream();
  }

}
