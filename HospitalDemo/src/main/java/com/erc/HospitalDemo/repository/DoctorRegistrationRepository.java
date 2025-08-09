package com.erc.HospitalDemo.repository;

import com.erc.HospitalDemo.entity.DoctorRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRegistrationRepository extends JpaRepository<DoctorRegistration, Long> {
}
