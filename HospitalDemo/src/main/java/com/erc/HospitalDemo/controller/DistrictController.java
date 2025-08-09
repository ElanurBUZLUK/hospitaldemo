package com.erc.HospitalDemo.controller;

import com.erc.HospitalDemo.dto.DistrictDTO;
import com.erc.HospitalDemo.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
@CrossOrigin(origins = "http://localhost:4200")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    // Tüm ilçeleri getirir
    @GetMapping
    public ResponseEntity<List<DistrictDTO>> getAllDistricts() {
        List<DistrictDTO> districts = districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }

    // İlçe ID'sine göre belirli bir ilçe getirir
    @GetMapping("/{id}")
    public ResponseEntity<DistrictDTO> getDistrictById(@PathVariable Long id) {
        DistrictDTO district = districtService.getDistrictById(id);
        return district != null ? ResponseEntity.ok(district) : ResponseEntity.notFound().build();
    }

    // Şehir ID'sine göre ilçeleri getirir
    @GetMapping("/byCity/{cityId}")
    public ResponseEntity<List<DistrictDTO>> getDistrictsByCityId(@PathVariable Long cityId) {
        List<DistrictDTO> districts = districtService.getDistrictsByCityId(cityId);
        return ResponseEntity.ok(districts);
    }

    // Hastanın ID'sine göre ilçeyi getirir
    @GetMapping("/byPatient/{patientId}")
    public ResponseEntity<DistrictDTO> getDistrictByPatientId(@PathVariable Long patientId) {
        DistrictDTO district = districtService.getDistrictByPatientId(patientId);
        return district != null ? ResponseEntity.ok(district) : ResponseEntity.notFound().build();
    }

    // Yeni bir ilçe kaydı oluşturur
    @PostMapping
    public ResponseEntity<DistrictDTO> createDistrict(@RequestBody DistrictDTO districtDTO) {
        DistrictDTO createdDistrict = districtService.saveDistrict(districtDTO);
        return ResponseEntity.status(201).body(createdDistrict);
    }

    // İlçe ID'sine göre mevcut bir ilçeyi günceller
    @PutMapping("/{id}")
    public ResponseEntity<DistrictDTO> updateDistrict(@PathVariable Long id, @RequestBody DistrictDTO districtDetails) {
        DistrictDTO updatedDistrict = districtService.updateDistrict(id, districtDetails);
        return updatedDistrict != null ? ResponseEntity.ok(updatedDistrict) : ResponseEntity.notFound().build();
    }

    // İlçe ID'sine göre bir ilçeyi siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
        boolean deleted = districtService.deleteDistrict(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}