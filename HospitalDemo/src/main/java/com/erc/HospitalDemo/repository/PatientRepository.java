package com.erc.HospitalDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erc.HospitalDemo.entity.Patient;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDoctor_DoctorId(Long doctorId);
}