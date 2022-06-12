package com.altera.capstone.bookingvaccine.domain.dto;

import com.altera.capstone.bookingvaccine.domain.dao.AreaDao;
import com.altera.capstone.bookingvaccine.domain.dao.HealthFacilitiesDao;
import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
import com.altera.capstone.bookingvaccine.domain.dao.VaccineDao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SessionDtoResponse {

  private Long id_session;

  private Integer stock;

  @DateTimeFormat(pattern = "HH:mm:ss")
  @JsonFormat(pattern = "HH:mm:ss")
  private LocalTime startTime;

  @DateTimeFormat(pattern = "HH:mm:ss")
  @JsonFormat(pattern = "HH:mm:ss")
  private LocalTime endTime;

//  private Integer lastStock;

//  private AreaDao areaDao;

  private VaccineDao vaccineDao;

  private HealthFacilitiesDao healthFacilitiesDao;
}
