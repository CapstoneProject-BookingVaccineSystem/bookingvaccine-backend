package com.altera.capstone.bookingvaccine.service;

import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.dao.*;
import com.altera.capstone.bookingvaccine.domain.dto.SessionDto;
import com.altera.capstone.bookingvaccine.domain.dto.SessionDtoResponse;
import com.altera.capstone.bookingvaccine.repository.*;
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

@Slf4j
@Service
public class SessionService {
  @Autowired
  private SessionRepository sessionRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private VaccineRepository vaccineRepository;

  @Autowired
  private AreaRepository areaRepository;

  @Autowired
  private HealthFacilitesRepository healthFacilitesRepository;

  @Autowired
  private ModelMapper mapper;

  public ResponseEntity<Object> getAllSession() {
    log.info("Executing get all session.");
    try{
      List<SessionDao> daoList = sessionRepository.findAll();
      List<SessionDtoResponse> list = new ArrayList<>();
      for(SessionDao dao : daoList){
        list.add(mapper.map(dao, SessionDtoResponse.class));
      }
      return ResponseUtil.build(AppConstant.Message.SUCCESS, list, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when get all session. Error: {}", e.getMessage());
      log.trace("Get error when get all session. ", e);
      throw e;
    }
  }

  public ResponseEntity<Object> getSessionByAreaId(Long id) {
    log.info("Executing get session by area id: {} ", id);
    try {
      List<SessionDao> sessionDao = sessionRepository.getSessionByAreaId(id);
      if(sessionDao.isEmpty()) {
        log.info("Area id: {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      log.info("Executing get session by Area id success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, sessionDao, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when get session by Area id. Error: {}", e.getMessage());
      log.trace("Get error when get session by Area id. ", e);
      throw e;
    }
  }

  public ResponseEntity<Object> getSessionById(Long id) {
    log.info("Executing get session by id: {} ", id);
    try {
      Optional<SessionDao> sessionDao = sessionRepository.findById(id);
      if(sessionDao.isEmpty()) {
        log.info("session id: {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      log.info("Executing get session by id success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, sessionDao, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when get session by id. Error: {}", e.getMessage());
      log.trace("Get error when get session by id. ", e);
      throw e;
    }
  }

  public ResponseEntity<Object> addSession(SessionDto request) {
    log.info("Executing add session with request: {}", request);
    try{

      log.info("Get area by id: {}", request.getIdArea());
      Optional<AreaDao> areaDaoOptional = areaRepository.findById(request.getIdArea());
      if (areaDaoOptional.isEmpty()) {
        log.info("area [{}] not found", request.getIdArea());
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }

      log.info("Get health facility by id: {}", request.getIdHealthFacilities());
      Optional<HealthFacilitiesDao> healthFacilitiesDaoOptional = healthFacilitesRepository.findById(request.getIdHealthFacilities());
      if (healthFacilitiesDaoOptional.isEmpty()) {
        log.info("health facility [{}] not found", request.getIdHealthFacilities());
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }

      log.info("Get vaccine by id: {}", request.getIdVaccine());
      Optional<VaccineDao> vaccineDaoOptional = vaccineRepository.findById(request.getIdVaccine());
      if (vaccineDaoOptional.isEmpty()) {
        log.info("vaccine [{}] not found", request.getIdVaccine());
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }

      SessionDao sessionDao = SessionDao.builder()
              .areaMapped(areaDaoOptional.get())
              .vaccineMapped(vaccineDaoOptional.get())
              .healthFacilitiesDaoMapped(healthFacilitiesDaoOptional.get())
              .stock(request.getStock())
              .startTime(request.getStartTime())
              .endTime(request.getEndTime())
//              .lastStock(request.getLastStock())
              .build();
      sessionDao = sessionRepository.save(sessionDao);
      log.info("Executing add session success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, mapper.map(sessionDao, SessionDto.class), HttpStatus.OK);

    } catch (Exception e) {
      log.error("Happened error when add session. Error: {}", e.getMessage());
      log.trace("Get error when add session. ", e);
      throw e;
    }
  }

//  public ResponseEntity<Object> searchSessionByTitle() {}
//  public ResponseEntity<Object> getSessionByTitle() {}
//  public ResponseEntity<Object> getSessionByCategoryName() {}

  public ResponseEntity<Object> updateSession(Long id, SessionDto request) {
    log.info("Executing update session with request: {}", request);
    try {
      Optional<SessionDao> sessionDaoOptional = sessionRepository.findById(id);
      if(sessionDaoOptional.isEmpty()) {
        log.info("session {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      Optional<VaccineDao> vaccineDaoOptional = vaccineRepository.findById(id);
      if(vaccineDaoOptional.isEmpty()) {
        log.info("vaccine {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      Optional<AreaDao> areaDaoOptional = areaRepository.findById(id);
      if(areaDaoOptional.isEmpty()) {
        log.info("area {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      sessionDaoOptional.ifPresent(res -> {
        res.setVaccineMapped(vaccineDaoOptional.get()); //updated vaccine
        res.setAreaMapped(areaDaoOptional.get());
        res.setStartTime(request.getStartTime());
        res.setEndTime(request.getEndTime());
        res.setStock(request.getStock());
//        res.setLastStock(request.getLastStock());
        sessionRepository.save(res);
      });
      log.info("Executing update session success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, mapper.map(sessionDaoOptional, SessionDto.class), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when update session. Error: {}", e.getMessage());
      log.trace("Get error when update session. ", e);
      throw e;
    }
  }
  public ResponseEntity<Object> deleteSession(Long id) {
    log.info("Executing delete session id: {}", id);
    try{
      Optional<SessionDao> sessionDaoOptional = sessionRepository.findById(id);
      if(sessionDaoOptional.isEmpty()) {
        log.info("session {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      sessionRepository.deleteById(id);
      log.info("Executing delete session success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, null, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when delete session. Error: {}", e.getMessage());
      log.trace("Get error when delete session. ", e);
      throw e;
    }
  }
}
