package com.erc.HospitalDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.erc.HospitalDemo.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    // JpaRepository zaten findById metodunu sağladığı için ekstra bir tanımlamaya gerek yoktur
}
