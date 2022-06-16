package com.altera.capstone.bookingvaccine.repository;

import com.altera.capstone.bookingvaccine.domain.dao.FamilyDao;
import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
import com.altera.capstone.bookingvaccine.domain.dto.UserDtoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {
//    nik_username as username
//    UserDao getDistinctTopByUsername(String username);

//    Optional<UserDao> findByName(String namePhoto);

//    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//            + "FROM Department d RIGHT JOIN d.employees e")
//    List<DeptEmpDto> fetchEmpDeptDataRightJoin();

//    @Query("SELECT new com.altera.capstone.bookingvaccine.domain.dto.UserDtoResponse (u.id_user, u.username, u.first_name, u.last_name, f.id_family, f.nik, f.full_name) FROM users u RIGHT JOIN u.familyMapped f")
//    List<UserDtoResponse> findFamilyByUserId(@Param("id_user") Long id_user);


//    @Query( value = "SELECT u.id_user, u.created_at, u.created_by, u.is_deleted, u.updated_at,u.first_name, u.last_name, u.username, u.birth_date, u.gender, u.email, u.no_phone, u.image_profile, u.roles, u.password, \n" +
//            "f.id_family, f.nik, f.full_name, f.user_id\n" +
//            "\tFROM family f RIGHT JOIN users u ON f.id_family = u.id_user", nativeQuery = true)
//    List<FamilyDao> findFamilyByUserId(@Param("id_user") Long id_user);

//    SELECT u.id_user, u.first_name, u.last_name, u.username,
//    f.id_family, f.nik, f.full_name, f.user_id
//    FROM public.users u RIGHT JOIN public.family f ON u.id_user = f.id_family;
}
