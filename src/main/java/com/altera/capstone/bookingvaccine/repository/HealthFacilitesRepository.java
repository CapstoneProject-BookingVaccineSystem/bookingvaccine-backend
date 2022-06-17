package com.altera.capstone.bookingvaccine.repository;

import com.altera.capstone.bookingvaccine.domain.dao.FamilyDao;
import com.altera.capstone.bookingvaccine.domain.dao.HealthFacilitiesDao;
import com.altera.capstone.bookingvaccine.domain.dao.SessionDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface HealthFacilitesRepository extends JpaRepository<HealthFacilitiesDao, Long> {
//  List<HealthFacilitiesDao> findFacilityByName(String healthFacilitiesName);
//
//  @Query(value = "SELECT b FROM HealthFacilitiesDao b WHERE upper(b.healthFacilitiesName) LIKE UPPER(CONCAT('%', :healthFacilitiesName, '%') ) ")
//  List<HealthFacilitiesDao> findAllByName(@Param("healthFacilitiesName") String healthFacilitiesName);

  @Query(value = "SELECT * FROM health_facilities f WHERE f.id_user = :id_user", nativeQuery = true)
  List<HealthFacilitiesDao> findFacilityByUserId(@PathVariable("id_user")Long id_user);
}
