package com.altera.capstone.bookingvaccine.domain.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name = "users")
// implements UserDetails
public class UserDao {

    private static final long serialVersionUID = 7623636514318420512L;

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
    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email")
    private String email;
    @Column(name = "no_handphone")
    private String noHandphone;
    @Column(name = "roles")
    private String roles;

//    @Column(nullable = true, length = 64)
//    private String photos;

    @Column(name = "image_name")
    private String imageName;
    @Column(name = "image_type")
    private String imageType;
    @Column(name = "img_profile", unique = false, nullable = true, length = 100000)
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

    public UserDao(String imageName, String imageType, byte[] imageProfile) {
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userMapped")
    private List<FamilyDao> familyDaoList;
}
