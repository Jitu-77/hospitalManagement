package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Patient> findByNameContaining(String name);

//    JPQL QUERIES
    @Query("Select p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("Select p FROM Patient p where p.birthDate >:birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

//    @Query("Select p.bloodGroup ,Count(p) FROM Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();
    @Query("Select new com.example.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup,"+" Count(p)) FROM Patient p group by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

//    NATIVE QUERY
    @Query(value = "select * from patient", nativeQuery = true)
//    List<Patient> findAllPatients();
    Page<Patient> findAllPatients(Pageable pageable);
}
