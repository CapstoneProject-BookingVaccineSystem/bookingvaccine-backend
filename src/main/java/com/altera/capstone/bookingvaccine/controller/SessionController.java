package com.altera.capstone.bookingvaccine.controller;

import com.altera.capstone.bookingvaccine.domain.dto.SessionDto;
import com.altera.capstone.bookingvaccine.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/v1/session", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Session", value = "Session" )
public class SessionController {
  @Autowired
  private SessionService sessionService;

  // GET
  @ApiOperation(value = "Get all session",  response = SessionDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success get list session"),

  })
  @GetMapping(value = "")
  public ResponseEntity<Object> getAll() {
    return sessionService.getAllSession();
  }

  // GET By Id
  @ApiOperation(value = "Get session by id",  response = SessionDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success get session by id"),

  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id){
    return sessionService.getSessionById(id);
  }

  // POST
  @ApiOperation(value = "Add session",  response = SessionDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success add session"),

  })
  @PostMapping(value = "")
  public ResponseEntity<Object> addSession(@RequestBody SessionDto request) {
    try{
      return sessionService.addSession(request);
    } catch (Exception e) {
      throw e;
    }
  }

  // PUT
  @ApiOperation(value = "Update session",  response = SessionDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success Update session"),

  })
  @PutMapping(value = "/{id}")
  public ResponseEntity<Object> updateSession(@PathVariable(value = "id") Long id, @RequestBody SessionDto request) {
    return sessionService.updateSession(id, request);
  }

  @ApiOperation(value = "Delete session",  response = SessionDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success delete session"),

  })
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Object> deleteSession(@PathVariable(value = "id") Long id) {
    return sessionService.deleteSession(id);
  }
}
