package com.altera.capstone.bookingvaccine.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.altera.capstone.bookingvaccine.constant.AppConstant;
import com.altera.capstone.bookingvaccine.domain.dao.SessionDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.altera.capstone.bookingvaccine.domain.dao.NewsVaccineDao;
import com.altera.capstone.bookingvaccine.domain.dto.NewsVaccineDto;
import com.altera.capstone.bookingvaccine.domain.dto.NewsVaccineDtoRespone;
import com.altera.capstone.bookingvaccine.repository.NewsVaccineRepository;
import com.altera.capstone.bookingvaccine.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NewsVaccineService {

    @Autowired
    private NewsVaccineRepository newsVaccineRepository;

    @Autowired
    private ModelMapper mapper;

    // GET ALL DATA NEW BY DESC (for Mobile App)
    public List<NewsVaccineDao> getAllNewByDesc(){
        log.info("Executing get all news vaccine By Desc");
        try {
            return (List<NewsVaccineDao>) newsVaccineRepository.findAll(Sort.by(Sort.Order.desc("createdAt")));
        } catch (Exception e) {
            log.error("Happened error when get all news vaccine. Error: {}", e.getMessage());
            log.trace("Get error when get all news vaccine. ", e);
            throw e;
        }
    }

    // GET ALL DATA ById
    public ResponseEntity<Object> getNewsVaccineById(Long id) {
        log.info("Executing get news vaccine by id: {} ", id);
        try {
            Optional<NewsVaccineDao> newsVaccineDao = newsVaccineRepository.findById(id);
            if (newsVaccineDao.isEmpty()) {
                log.info("news vaccine id: {} not found", id);
                return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
            }
            log.info("Executing get news vaccine by id success");
            return ResponseUtil.build(AppConstant.Message.SUCCESS, newsVaccineDao, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Happened error when get news vaccine by id. Error: {}", e.getMessage());
            log.trace("Get error when get news vaccine by id. ", e);
            throw e;
        }
    }

    // GET ALL DATA NEWS for ADMIN
    public ResponseEntity<Object> getAllNewsVaccine(int page, int size) {
        log.info("Executing get all news vaccine");
        try {
            Pageable paging = PageRequest.of(page, size, Sort.by(Sort.Order.desc("createdAt")));
            Page<NewsVaccineDao> pageResult = newsVaccineRepository.findAll(paging);
            return ResponseUtil.build(AppConstant.Message.SUCCESS, pageResult, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Happened error when get all news vaccine. Error: {}", e.getMessage());
            log.trace("Get error when get all news vaccine. ", e);
            throw e;
        }

    }

    public ResponseEntity<Object> getNewsByLike(String search){
        try {
            log.info("Execute get data news");
            List<NewsVaccineDao> newsVaccineDaoList = newsVaccineRepository.findTitleNewsByLike(search);
            return ResponseUtil.build(AppConstant.Message.SUCCESS, newsVaccineDaoList, HttpStatus.OK);
        } catch (Exception e){
            log.error("Happened error when get news by like. Error: {}", e.getMessage());
            log.trace("Get error when get news by like. ", e);
            throw e;
        }
    }

    public ResponseEntity<Object> addNewsVaccine(NewsVaccineDto request) {
        log.info("Executing add news vaccine with request: {}", request);
        try {
            log.info("Executing add news vaccine success");
            NewsVaccineDao newsVaccineDao = mapper.map(request, NewsVaccineDao.class);
            newsVaccineDao = newsVaccineRepository.save(newsVaccineDao);
            return ResponseUtil.build(AppConstant.Message.SUCCESS,
                    mapper.map(newsVaccineDao, NewsVaccineDto.class), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Happened error when add news vaccine. Error: {}", e.getMessage());
            log.trace("Get error when add news vaccine. ", e);
            throw e;
        }
    }

    public ResponseEntity<Object> updateNewsVaccine(Long id, NewsVaccineDto request) {
        log.info("Executing update news vaccine with request: {}", request);
        try {
            Optional<NewsVaccineDao> newsVaccineDao = newsVaccineRepository.findById(id);
            if (newsVaccineDao.isEmpty()) {
                log.info("news vaccine {} not found", id);
                return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
            }
            newsVaccineDao.ifPresent(res -> {
                res.setTitleNewsVaccine(request.getTitleNewsVaccine());
                res.setAuthorNewsVaccine(request.getAuthorNewsVaccine());
                res.setContentNewsVaccine(request.getContentNewsVaccine());
                res.setImageNewsVaccine(request.getImageNewsVaccine());
                // res.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
                newsVaccineRepository.save(res);
            });
            log.info("Executing update news vaccine success");
            return ResponseUtil.build(AppConstant.Message.SUCCESS,
                    mapper.map(newsVaccineDao, NewsVaccineDto.class), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Happened error when update news vaccine. Error: {}", e.getMessage());
            log.trace("Get error when update news vaccine. ", e);
            throw e;
        }
    }

    public ResponseEntity<Object> deleteNewsVaccine(Long id) {
        log.info("Executing delete news vaccine id: {}", id);
        try {
            Optional<NewsVaccineDao> newsVaccineDao = newsVaccineRepository.findById(id);
            if (newsVaccineDao.isEmpty()) {
                log.info("news vaccine {} not found", id);
                return ResponseUtil.build(AppConstant.Message.NOT_FOUND, null, HttpStatus.BAD_REQUEST);
            }
            newsVaccineRepository.deleteById(id);
            log.info("Executing delete news vaccine success");
            return ResponseUtil.build(AppConstant.Message.SUCCESS, null, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Happened error when delete news vaccine. Error: {}", e.getMessage());
            log.trace("Get error when delete news vaccine. ", e);
            throw e;
        }
    }
}
