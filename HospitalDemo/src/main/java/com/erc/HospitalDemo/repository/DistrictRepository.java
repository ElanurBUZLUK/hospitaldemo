package com.erc.HospitalDemo.repository;

import com.erc.HospitalDemo.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    // Şehir ID'sine göre ilçeleri bulur
    List<District> findByCity_CityId(Long cityId);

    // Hasta ID'sine göre bir ilçe bulur
    Optional<District> findByPatients_PatientId(Long patientId);
}

