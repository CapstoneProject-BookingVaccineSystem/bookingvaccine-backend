package com.altera.capstone.bookingvaccine.service;

import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.dao.FamilyDao;
import com.altera.capstone.bookingvaccine.domain.dao.HealthFacilitiesDao;
import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
import com.altera.capstone.bookingvaccine.domain.dto.FamilyDto;
import com.altera.capstone.bookingvaccine.domain.dto.FamilyDtoResponse;
import com.altera.capstone.bookingvaccine.domain.dto.UserDto;
import com.altera.capstone.bookingvaccine.domain.dto.UserDtoResponse;
import com.altera.capstone.bookingvaccine.domain.payload.UsernamePassword;
import com.altera.capstone.bookingvaccine.repository.FamilyRepository;
import com.altera.capstone.bookingvaccine.repository.HealthFacilitesRepository;
import com.altera.capstone.bookingvaccine.repository.UserRepository;
import com.altera.capstone.bookingvaccine.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Log4j2
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FamilyRepository familyRepository;

  @Autowired
  private HealthFacilitesRepository healthFacilitesRepository;

  @Autowired
  private ModelMapper mapper;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDao user = userRepository.getDistinctTopByUsername(username);
//        if(user == null)
//            throw new UsernameNotFoundException("Username not found");
//
//        return user;
//    }

//  public UserDao register(UsernamePassword req){
//    UserDao user = new UserDao();
//    if(req.getRoles() == null){
//      req.setRoles("USER");
//    }
//    user.setUsername(req.getUsername());
////        user.setPassword(passwordEncoder.encode(req.getPassword()));
//    user.setPassword((req.getPassword()));
//    user.setFirstName(req.getFirstName());
//    user.setLastName(req.getLastName());
//    user.setBirthDate(req.getBirthDate());
//    user.setGender(req.getGender());
//    user.setEmail(req.getEmail());
//    user.setNoHandphone(req.getNoHandphone());
//    user.setRoles(req.getRoles());
//    return userRepository.save(user);
//  }

  public ResponseEntity<Object> addUser(UserDto request) {
    log.info("Executing add user with request: {}", request);
    try{
//      log.info("Get family by id: {}", request.getId_family());
//      Optional<FamilyDao> familyDao = familyRepository.findById(request.getId_family());
//      if (familyDao.isEmpty()) {
//        log.info("Family [{}] not found", request.getId_family());
//        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
//      }

//      log.info("Get health facility by id: {}", request.getId_health_facilities());
//      Optional<HealthFacilitiesDao> healthFacilitiesDao = healthFacilitesRepository.findById(request.getId_health_facilities());
//      if (healthFacilitiesDao.isEmpty()) {
//        log.info("Health Facility [{}] not found", request.getId_health_facilities());
//        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
//      }
      UserDao userDao = mapper.map(request, UserDao.class);
//      userDao.setFamilyDaoList((List<FamilyDao>) familyDao.get());
//      userDao.setHealthFacilitiesDaoList(healthFacilitiesDao.get());
      userDao = userRepository.save(userDao);
      log.info("Executing add user success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, mapper.map(userDao, UserDto.class), HttpStatus.OK);

    } catch (Exception e) {
      log.error("Happened error when add user. Error: {}", e.getMessage());
      log.trace("Get error when add user. ", e);
      throw e;   }
  }

//  public UserDao store(MultipartFile file)throws IOException{
//    String imageData = StringUtils.cleanPath(file.getOriginalFilename());
//    UserDao fileDB = new UserDao(imageData, file.getContentType(), file.getBytes());
//    return userRepository.save(fileDB);
//  }

//  public UserDao getFileByIdUser(Long id){
//    return userRepository.findById(id).get();
//  }

  public ResponseEntity<Object> getUserById(Long id_user) {
    log.info("Executing get user by id: {} ", id_user);
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

  public ResponseEntity<Object> getAllUser() {
    log.info("Executing get All User");
    try {
      List<UserDao> daoList = userRepository.findAll();
      List<UserDtoResponse> list = new ArrayList<>();
      for(UserDao dao : daoList) {
        list.add(UserDtoResponse.builder()
                .id_user(dao.getId_user())
                .username(dao.getUsername())
                .firstName(dao.getFirstName())
                .lastName(dao.getLastName())
                .gender(dao.getGender())
                .email(dao.getEmail())
                .birthDate(dao.getBirthDate())
                .noPhone(dao.getNoPhone())
                .roles(dao.getRoles())
//                .user(UserDao.builder()
//                        .id_user(dao.getUserMapped().getId_user())
//                        .username(dao.getUserMapped().getUsername())
//                        .firstName(dao.getUserMapped().getFirstName())
//                        .lastName(dao.getUserMapped().getLastName())
//                        .build())
                .build());
      }
      return ResponseUtil.build(AppConstant.Message.SUCCESS, list, HttpStatus.OK);
    }catch (Exception e){
      log.error("Happened error when get all User. Error: {}", e.getMessage());
      log.trace("Get error when get all user. ", e);
      throw e;
    }
  }

  public ResponseEntity<Object> updateUser(Long id_user, UserDto request){
    log.info("Executing update user with request: {}", request);
    try {
      Optional<UserDao>userDaoOptional= userRepository.findById(id_user);
      if(userDaoOptional.isEmpty()) {
        log.info("User {} not found", id_user);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      userDaoOptional.ifPresent(res -> {
        res.setUsername(request.getUsername());
        res.setPassword(request.getPassword());
        res.setFirstName(request.getFirstName());
        res.setLastName(request.getLastName());
        res.setBirthDate(request.getBirthDate());
        res.setEmail(request.getEmail());
        res.setNoPhone(request.getNoPhone());
        userRepository.save(res);
      });
      log.info("Executing update user success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, mapper.map(userDaoOptional, UserDto.class), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when update user. Error: {}", e.getMessage());
      log.trace("Get error when update user. ", e);
      throw e;
    }
  }

  public ResponseEntity<Object> deleteUser(Long id_user) {
    log.info("Executing delete user id: {}", id_user);
    try{
      Optional<UserDao> userDaoOptional =userRepository.findById(id_user);
      if(userDaoOptional.isEmpty()) {
        log.info("User {} not found", id_user);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      userRepository.deleteById(id_user);
      log.info("Executing delete user success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, null, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when delete user. Error: {}", e.getMessage());
      log.trace("Get error when delete user. ", e);
      throw e;
    }
  }

//  public Stream<UserDao> getAllFileByUserDao() {
//    return userRepository.findAll().stream();
//  }

}
