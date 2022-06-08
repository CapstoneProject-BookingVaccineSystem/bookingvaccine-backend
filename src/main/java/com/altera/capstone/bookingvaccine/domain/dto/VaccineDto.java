package com.altera.capstone.bookingvaccine.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VaccineDto {

  private static final long serialVersionUID = -6735953605516155759L;

  private Long id;

  @ApiModelProperty(notes = "Vaccine Name", example = "Sinovac")
  private String vaccineName;

  @ApiModelProperty(notes = "Stock Vaccine", example = "100")
  private String stockVaccine;

}
