package com.altera.capstone.bookingvaccine.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SessionDto {

  private Long id_session;

  @ApiModelProperty(notes = "input existing stock", example = "100")
  private Integer stock;

  @ApiModelProperty(notes = "start on session", example = "08.00")
  private String startTime;

  @ApiModelProperty(notes = "session ended", example = "10.00")
  private String endTime;

//  @ApiModelProperty(notes = "remaining vaccine stock", example = "50")
//  private Integer lastStock;

//  private Long idUser;

  private Long idVaccine;

  private Long idHealthFacilities;
}
