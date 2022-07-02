package com.altera.capstone.bookingvaccine.domain.dao;

import com.altera.capstone.bookingvaccine.domain.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET is_deleted = true WHERE id_user = ?")
@Where(clause = "is_deleted = false")
// implements UserDetails
public class UserDao extends BaseEntity{

  private static final long serialVersionUID = -1266576651734156259L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_user;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "birthDate")
  private LocalDate birthDate;

  @Column(name = "gender")
  private String gender;

  @Column(name = "email")
  private String email;

  @Column(name = "noPhone")
  private String noPhone;

  @Column(name = "address")
  private String address;

  @Column(name = "roles")
  private String roles;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userMapped")
  private List<FamilyDao> familyDaoList;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userMapped")
  private List<BookingDao> bookingDaoList;

}
