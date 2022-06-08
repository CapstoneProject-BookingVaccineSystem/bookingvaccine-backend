package com.altera.capstone.bookingvaccine.repository;

import com.altera.capstone.bookingvaccine.domain.dao.FamilyDao;
import com.altera.capstone.bookingvaccine.domain.dao.HealthFacilitiesDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthFacilitesRepository extends JpaRepository<HealthFacilitiesDao, Long> {
//  List<HealthFacilitiesDao> findFacilityByName(String healthFacilitiesName);
//
//  @Query(value = "SELECT b FROM HealthFacilitiesDao b WHERE upper(b.healthFacilitiesName) LIKE UPPER(CONCAT('%', :healthFacilitiesName, '%') ) ")
//  List<HealthFacilitiesDao> findAllByName(@Param("healthFacilitiesName") String healthFacilitiesName);
}
