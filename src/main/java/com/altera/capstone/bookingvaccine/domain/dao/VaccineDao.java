package com.altera.capstone.bookingvaccine.domain.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name = "vaccine")
public class VaccineDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_vaccine;

  @Column(name = "vaccine_name", nullable = false)
  private String vaccineName;

//  @Column(name = "stock_vaccine", nullable = false)
//  private String stockVaccine;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vaccineMapped")
  private List<SessionDao> sessionDaoList;
}
