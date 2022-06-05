package com.altera.capstone.bookingvaccine.repository;

import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {
//    nik_username as username
    UserDao getDistinctTopByUsername(String username);

//    Optional<UserDao> findByName(String namePhoto);
}
