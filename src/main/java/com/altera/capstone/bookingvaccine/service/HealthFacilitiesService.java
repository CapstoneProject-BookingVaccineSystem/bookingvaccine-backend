package com.altera.capstone.bookingvaccine.service;

import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.dao.*;
import com.altera.capstone.bookingvaccine.domain.dto.FamilyDto;
import com.altera.capstone.bookingvaccine.domain.dto.FamilyDtoResponse;
import com.altera.capstone.bookingvaccine.domain.dto.HealthFacilitiesDtoResponse;
import com.altera.capstone.bookingvaccine.domain.dto.HealthFaciltiesDto;
import com.altera.capstone.bookingvaccine.repository.AreaRepository;
import com.altera.capstone.bookingvaccine.repository.CategoryFacilitiesRepository;
import com.altera.capstone.bookingvaccine.repository.HealthFacilitesRepository;
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

@Slf4j
@Service
public class HealthFacilitiesService {
  @Autowired
  private HealthFacilitesRepository healthFacilitesRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CategoryFacilitiesRepository categoryFacilitiesRepository;

  @Autowired
  private AreaRepository areaRepository;

  @Autowired
  private ModelMapper mapper;

  public ResponseEntity<Object> getAllHealthFacility(){
    log.info("Executing get All Health Facility");
    try {
      List<HealthFacilitiesDao> daoList = healthFacilitesRepository.findAll();
      List<HealthFacilitiesDtoResponse> list = new ArrayList<>();
      for(HealthFacilitiesDao dao : daoList) {
        list.add(HealthFacilitiesDtoResponse.builder()
                .id_health_facilities(dao.getId_health_facilities())
                .healthFacilitiesName(dao.getHealthFacilitiesName())
                .addressHealthFacilities(dao.getAddressHealthFacilities())
                .linkLocation(dao.getLinkLocation())
                .phoneFacilities(dao.getPhoneFacilities())
                // from HealthFacilityDtoResponse
                .area(AreaDao.builder()
                        .id_area(dao.getAreaMapped().getId_area())
                        .areaName(dao.getAreaMapped().getAreaName())
                        .build())
                .categoryFacilities(CategoryFacilitiesDao.builder()
                        .id_category_facilities(dao.getCategoryMapped().getId_category_facilities())
                        .categoryFacilitiesName(dao.getCategoryMapped().getCategoryFacilitiesName())
                        .build())
                .user(UserDao.builder()
                        .id_user(dao.getUserMapped().getId_user())
                        .firstName(dao.getUserMapped().getFirstName())
                        .lastName(dao.getUserMapped().getLastName())
                        .build())
                .build());
      }
      return ResponseUtil.build(AppConstant.Message.SUCCESS, list, HttpStatus.OK);
    }catch (Exception e){
      log.error("Happened error when get all health facility. Error: {}", e.getMessage());
      log.trace("Get error when get all health facility. ", e);
      throw e;
    }
  }

  public ResponseEntity<Object> addHealthFacility(HealthFaciltiesDto request) {
    log.info("Executing add health facility with request: {}", request);
    try{
      log.info("Get area by id: {}", request.getIdArea());
      Optional<AreaDao> areaDaoOptional = areaRepository.findById(request.getIdArea());
      if (areaDaoOptional.isEmpty()) {
        log.info("Area [{}] not found", request.getIdArea());
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      log.info("Get category facility by id: {}", request.getIdCategoryFacilities());
      Optional<CategoryFacilitiesDao> categoryFacilitiesDaoOptional = categoryFacilitiesRepository.findById(request.getIdCategoryFacilities());
      if (categoryFacilitiesDaoOptional.isEmpty()) {
        log.info("Category Facility [{}] not found", request.getIdCategoryFacilities());
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }

      log.info("Get user by id: {}", request.getIdUser());
      Optional<UserDao> userDaoOptional = userRepository.findById(request.getIdUser());
      if (userDaoOptional.isEmpty()) {
        log.info("User [{}] not found", request.getIdUser());
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }

      HealthFacilitiesDao healthFacilitiesDao = mapper.map(request, HealthFacilitiesDao.class);
      healthFacilitiesDao.setAreaMapped(areaDaoOptional.get());
      healthFacilitiesDao.setCategoryMapped(categoryFacilitiesDaoOptional.get());
      healthFacilitiesDao.setUserMapped(userDaoOptional.get());
      healthFacilitiesDao = healthFacilitesRepository.save(healthFacilitiesDao);
      log.info("Executing add health facility success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, mapper.map(healthFacilitiesDao, HealthFaciltiesDto.class), HttpStatus.OK);

    } catch (Exception e) {
      log.error("Happened error when add Health Facility. Error: {}", e.getMessage());
      log.trace("Get error when add Health Facility. ", e);
      throw e;   }
  }

  public ResponseEntity<Object> updateHealthFacility(Long id, HealthFaciltiesDto request){
    log.info("Executing update health facility with request: {}", request);
    try {
      log.info("GET health facility by id: {}", request);
      Optional<HealthFacilitiesDao>healthFacilitiesDaoOptional= healthFacilitesRepository.findById(id);
      if(healthFacilitiesDaoOptional.isEmpty()) {
        log.info("health facility {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      log.info("GET Area by id: {}", request);
      Optional<AreaDao> areaDaoOptional = areaRepository.findById(id);
      if(areaDaoOptional.isEmpty()) {
        log.info("Area {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      log.info("GET Category Facility by id: {}", request);
      Optional<CategoryFacilitiesDao> categoryFacilitiesDaoOptional = categoryFacilitiesRepository.findById(id);
      if(categoryFacilitiesDaoOptional.isEmpty()) {
        log.info("Category Facility {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      log.info("GET user by id: {}", request);
      Optional<UserDao> userDaoOptional = userRepository.findById(id);
      if(userDaoOptional.isEmpty()) {
        log.info("User {} not found", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      if(userDaoOptional.get().getRoles() == "USER") {
        log.info("user {} not assigned as ADMIN", id);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      healthFacilitiesDaoOptional.ifPresent(res -> {
        res.setHealthFacilitiesName(request.getHealthFacilitiesName());
        res.setAddressHealthFacilities(request.getAddressHealthFacilities());
        res.setPhoneFacilities(request.getPhoneFacilities());
        res.setLinkLocation(request.getLinkLocation());
        res.setCategoryMapped(categoryFacilitiesDaoOptional.get());
        res.setAreaMapped(areaDaoOptional.get());
        res.setUserMapped(userDaoOptional.get());
        healthFacilitesRepository.save(res);
      });
      log.info("Executing update health facility success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, mapper.map(healthFacilitiesDaoOptional, HealthFaciltiesDto.class), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when update family. Error: {}", e.getMessage());
      log.trace("Get error when update family. ", e);
      throw e;
    }
  }

  public ResponseEntity<Object> deleteHealthFacility(Long id_health_facilities) {
    log.info("Executing delete health facility id: {}", id_health_facilities);
    try{
      Optional<HealthFacilitiesDao> healthFacilitiesDaoOptional = healthFacilitesRepository.findById(id_health_facilities);
      if(healthFacilitiesDaoOptional.isEmpty()) {
        log.info("health facility {} not found", id_health_facilities);
        return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
      }
      healthFacilitesRepository.deleteById(id_health_facilities);
      log.info("Executing delete health facility success");
      return ResponseUtil.build(AppConstant.Message.SUCCESS, null, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Happened error when delete health facility. Error: {}", e.getMessage());
      log.trace("Get error when delete health facility. ", e);
      throw e;
    }
  }
}
