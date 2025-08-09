package com.erc.HospitalDemo.controller;

import com.erc.HospitalDemo.dto.DoctorDTO;
import com.erc.HospitalDemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Tüm doktorları getirir
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<DoctorDTO> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    // Doktor ID'sine göre belirli bir doktoru getirir
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
        DoctorDTO doctor = doctorService.getDoctorById(id);
        return doctor != null ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

    // Yeni bir doktor kaydı oluşturur
    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        DoctorDTO createdDoctor = doctorService.saveDoctor(doctorDTO);
        return ResponseEntity.status(201).body(createdDoctor);
    }

    // Doktor ID'sine göre mevcut bir doktoru günceller
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) {
        DoctorDTO updatedDoctor = doctorService.updateDoctor(id, doctorDTO);
        return updatedDoctor != null ? ResponseEntity.ok(updatedDoctor) : ResponseEntity.notFound().build();
    }

    // Doktor ID'sine göre bir doktoru siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        boolean deleted = doctorService.deleteDoctor(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}