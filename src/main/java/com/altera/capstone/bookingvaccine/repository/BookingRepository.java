package com.altera.capstone.bookingvaccine.repository;

import com.altera.capstone.bookingvaccine.domain.dao.BookingDao;
import com.altera.capstone.bookingvaccine.domain.dao.SessionDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingDao, Long> {
  // searching with LIKE
  @Query("SELECT b FROM BookingDao b WHERE b.healthFacilitiesDaoMapped.healthFacilitiesName " +
          "LIKE %?1% OR s.vaccineMapped.vaccineName LIKE %?2%")
  List<BookingDao> findNameByLike(String health_facility_name, String vaccine_name);
}
