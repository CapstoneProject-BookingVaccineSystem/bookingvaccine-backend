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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name = "users")
//@SQLDelete(sql = "UPDATE users SET is_deleted = true WHERE id_user = ?")
//@Where(clause = "is_deleted = false")
// implements UserDetails
public class UserDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_user;

  @Column(name = "username", nullable = true, unique = true)
  private String username;

  @Column(name = "password", nullable = true)
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

  @Column(name = "roles")
  private String roles;

//    @Column(nullable = true, length = 64)
//    private String photos;

  @Column(name = "image_name")
  private String imageName;
  @Column(name = "image_type")
  private String imageType;
  @Column(name = "image_profile", unique = false, nullable = true, length = 100000)
  @Lob
  private byte[] imageProfile;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//        list.add(new SimpleGrantedAuthority(roles));
//        return list;
//    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return this.active;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.active;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.active;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.active;
//    }

//  public UserDao(String imageName, String imageType, byte[] imageProfile) {
//  }

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userMapped")
  private List<FamilyDao> familyDaoList;

//  @JsonIgnore
//  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userMapped")
//  private HealthFacilitiesDao healthFacilitiesDaoList;
}
