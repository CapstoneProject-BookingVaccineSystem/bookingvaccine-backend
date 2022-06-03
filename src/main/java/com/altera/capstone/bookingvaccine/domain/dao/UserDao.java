package com.altera.capstone.bookingvaccine.domain.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "users")
// implements UserDetails
public class UserDao {

//    private static final long serialVersionUID = 7623636514318420512L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nik_as_username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false, unique = true)
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


//    @Column(columnDefinition = "boolean default true")
//    private boolean active = true;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//        list.add(new SimpleGrantedAuthority(roles));
//        return list;
//    }
//
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

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
