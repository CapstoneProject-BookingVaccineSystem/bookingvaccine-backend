package com.altera.capstone.bookingvaccine.domain.dto;

import com.altera.capstone.bookingvaccine.domain.dao.AreaDao;
import com.altera.capstone.bookingvaccine.domain.dao.CategoryFacilitiesDao;
import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class HealthFacilitiesDtoResponse {
  private Long id_health_facilities;

  private String healthFacilitiesName;

  private String addressHealthFacilities;

  private String linkLocation;

  private String phoneFacilities;

  private UserDao user;

  private AreaDao area;

  private CategoryFacilitiesDao categoryFacilities;
}
