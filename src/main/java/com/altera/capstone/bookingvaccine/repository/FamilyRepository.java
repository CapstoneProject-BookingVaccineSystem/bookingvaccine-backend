package com.altera.capstone.bookingvaccine.repository;

import com.altera.capstone.bookingvaccine.domain.dao.FamilyDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyDao, Long> {
  List<FamilyDao> findFamilyDaoByFullName(String fullName);

  @Query(value = "SELECT b FROM FamilyDao b WHERE upper(b.fullName) LIKE UPPER(CONCAT('%', :fullName, '%') ) ")
  List<FamilyDao> findAllByFullName(@Param("fullName") String fullName);

//  FamilyDao findByFullName(String fullName);
}
