package com.erc.HospitalDemo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.erc.HospitalDemo.entity.Phonenumber;

@Repository
public interface PhonenumberRepository extends JpaRepository<Phonenumber, Long> {
    
    @Query("SELECT p FROM Phonenumber p WHERE p.patient.patientId = :patientId")
    List<Phonenumber> findByPatientId(@Param("patientId") Long patientId);
}