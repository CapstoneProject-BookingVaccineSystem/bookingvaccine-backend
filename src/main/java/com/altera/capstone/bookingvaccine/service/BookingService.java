package com.altera.capstone.bookingvaccine.service;

import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.dao.*;
import com.altera.capstone.bookingvaccine.domain.dto.BookingDto;
import com.altera.capstone.bookingvaccine.domain.dto.BookingDtoResponse;
import com.altera.capstone.bookingvaccine.domain.dto.SessionDto;
import com.altera.capstone.bookingvaccine.domain.dto.SessionDtoResponse;
import com.altera.capstone.bookingvaccine.repository.BookingRepository;
import com.altera.capstone.bookingvaccine.repository.FamilyRepository;
import com.altera.capstone.bookingvaccine.repository.SessionRepository;
import com.altera.capstone.bookingvaccine.repository.UserRepository;
import com.altera.capstone.bookingvaccine.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FamilyRepository familyRepository;

  @Autowired
  private SessionRepository sessionRepository;

  @Autowired
  private ModelMapper mapper;

  public ResponseEntity<Object> getAllBooking() {
    log.info("Executing get all booking.");
    try{
      List<BookingDao> daoList = bookingRepository.findAll();
      List<BookingDtoResponse> list = new ArrayList<>();
      for(BookingDao dao : daoList){
        list.add(mapper.map(dao, BookingDtoResponse.class));
      }
      return ResponseUtil.build(AppConstant.Message.SUCCESS, list, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when get all booking. Error: {}", e.getMessage());
      log.trace("Get error when get all booking. ", e);
      throw e;
    }
  }

  public ResponseEntity<Object> getBookingById(Long id) {
    log.info("Executing get booking by id: {} ", id);
    try {
      Optional<BookingDao> bookingDao = bookingRepository.findById(id);
      if(bookingDao.isEmpty()) {
        log.info("booking id: {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      log.info("Executing get booking by id success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, bookingDao, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when get booking by id. Error: {}", e.getMessage());
      log.trace("Get error when get booking by id. ", e);
      throw e;
    }
  }

  public ResponseEntity<Object> addBooking(BookingDto request) {
    log.info("Executing add booking with request: {}", request);
    try{

      log.info("Get user by id: {}", request.getIdUser());
      Optional<UserDao> userDaoOptional = userRepository.findById(request.getIdUser());
      if (userDaoOptional.isEmpty()) {
        log.info("User [{}] not found", request.getIdUser());
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }

      log.info("Get family by id: {}", request.getIdFamily());
      Optional<FamilyDao> familyDaoOptional = familyRepository.findById(request.getIdFamily());
      if (familyDaoOptional.isEmpty()) {
        log.info("vaccine [{}] not found", request.getIdFamily());
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }

      log.info("Get Session by id: {}", request.getIdSession());
      Optional<SessionDao> sessionDaoOptional = sessionRepository.findById(request.getIdFamily());
      if(sessionDaoOptional.isEmpty()){
        log.info("session [{}] not found", request.getIdSession());
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }

      BookingDao bookingDao = BookingDao.builder()
              .userMapped(userDaoOptional.get())
              .familyMapped(familyDaoOptional.get())
              .sessionMapped(sessionDaoOptional.get())
              .build();
      bookingDao = bookingRepository.save(bookingDao);
      log.info("Executing add booking success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, mapper.map(bookingDao, BookingDto.class), HttpStatus.OK);

    } catch (Exception e) {
      log.error("Happened error when add booking. Error: {}", e.getMessage());
      log.trace("Get error when add booking. ", e);
      throw e;
    }
  }
}
