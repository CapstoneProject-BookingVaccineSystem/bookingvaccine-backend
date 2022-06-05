package com.altera.capstone.bookingvaccine.domain.dao;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name = "category_facilities")
public class CategoryFacilitiesDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_category_facilities;

  @Column(name = "category_facilities_name", nullable = false)
  private String categoryFacilitiesName;
}
