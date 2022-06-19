package com.altera.capstone.bookingvaccine.controller;

import com.altera.capstone.bookingvaccine.domain.dao.NewsVaccineDao;
import com.altera.capstone.bookingvaccine.domain.dto.SessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altera.capstone.bookingvaccine.domain.dto.NewsVaccineDto;
import com.altera.capstone.bookingvaccine.service.NewsVaccineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/v1/news", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "NewsVaccine", value = "NewsVaccine")
public class NewsVaccineController {

    @Autowired
    private NewsVaccineService newsVaccineService;

    // GET ALL
    @ApiOperation(value = "Get all news vaccine", response = NewsVaccineDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success get list news vaccine"),
    })
    @GetMapping(value = "/{page}/{size}")
    public ResponseEntity<Object> getAllNews(@PathVariable (value = "page")int page,
                                             @PathVariable(value = "size") int size) {
        return newsVaccineService.getAllNewsVaccine(page, size);
    }

    // GET ALL News Data By Desc
    @ApiOperation(value = "Get all news vaccine By Desc", response = NewsVaccineDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success get list news vaccine By Desc"),
    })
    @GetMapping(value = "/desc")
    public Iterable<NewsVaccineDao> getAllByDesc() {
        return newsVaccineService.getAllNewByDesc();
    }

    // GET By Like
    @ApiOperation(value = "Get By LIKE News Vaccine",  response = SessionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success get By LIKE News Vaccine"),

    })
    @GetMapping("/search/{search}")
    public ResponseEntity<Object> getSearch(@PathVariable(value = "search") String search){
        return newsVaccineService.getNewsByLike(search);
    }

    @ApiOperation(value = "Get news vaccine by id", response = NewsVaccineDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success get news vaccine by id"),
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getNewsById(@PathVariable Long id) {
        return newsVaccineService.getNewsVaccineById(id);
    }

    @ApiOperation(value = "Add new news vaccine", response = NewsVaccineDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success add new news vaccine"),
    })
    @PostMapping(value = "")
    public ResponseEntity<Object> addNews(@RequestBody NewsVaccineDto request) {
        return newsVaccineService.addNewsVaccine(request);
    }

    // PUT
    @ApiOperation(value = "Update news vaccine", response = NewsVaccineDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success update news vaccine"),
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateNews(@PathVariable(value = "id") Long id,
            @RequestBody NewsVaccineDto request) {
        return newsVaccineService.updateNewsVaccine(id, request);
    }

    // DELETE
    @ApiOperation(value = "Delete news vaccine", response = NewsVaccineDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success delete news vaccine"),
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteNews(@PathVariable(value = "id") Long id) {
        return newsVaccineService.deleteNewsVaccine(id);
    }

}
