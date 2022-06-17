package com.altera.capstone.bookingvaccine.repository;

import org.springframework.stereotype.Repository;

import com.altera.capstone.bookingvaccine.domain.dao.NewsVaccineDao;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NewsVaccineRepository extends JpaRepository<NewsVaccineDao, Long> {

}
