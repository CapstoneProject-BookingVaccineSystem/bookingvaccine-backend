package com.altera.capstone.bookingvaccine.controller;

import com.altera.capstone.bookingvaccine.domain.dto.BookingDto;
import com.altera.capstone.bookingvaccine.domain.dto.SessionDto;
import com.altera.capstone.bookingvaccine.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/v1/booking", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Booking", value = "Booking" )
public class BookingController {
  @Autowired
  private BookingService bookingService;

  // GET All and pagination
  @ApiOperation(value = "Get all booking",  response = BookingDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success get list booking"),

  })
  @GetMapping(value = "")
  public ResponseEntity<Object> getAll() {
    return bookingService.getAllBooking();
  }

  // GET By Id
  @ApiOperation(value = "Get Booking by id",  response = BookingDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success get Booking by id"),

  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id){
    return bookingService.getBookingById(id);
  }

  // POST
  @ApiOperation(value = "Add Booking",  response = BookingDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success add booking"),

  })
  @PostMapping(value = "")
  public ResponseEntity<Object> addBooking(@RequestBody BookingDto request) {
    try{
      return bookingService.addBooking(request);
    } catch (Exception e) {
      throw e;
    }
  }

  // PUT
  @ApiOperation(value = "Update booking",  response = BookingDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success Update booking"),

  })
  @PutMapping(value = "/{id}")
  public ResponseEntity<Object> updateBooking(@PathVariable(value = "id") Long id, @RequestBody BookingDto request) {
    return bookingService.updateBooking(id, request);
  }

  // DELETE
  @ApiOperation(value = "Delete booking",  response = BookingDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Success delete booking"),

  })
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Object> deleteBooking(@PathVariable(value = "id") Long id) {
    return bookingService.deleteBooking(id);
  }
}
