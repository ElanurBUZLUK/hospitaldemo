package com.erc.HospitalDemo.controller;

import com.erc.HospitalDemo.dto.PatientDTO;
import com.erc.HospitalDemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Tüm hastaları getirir
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    // Doktor ID'sine göre hastaları getirir
    @GetMapping("/byDoctor/{doctorId}")
    public ResponseEntity<List<PatientDTO>> getPatientsByDoctor(@PathVariable Long doctorId) {
        List<PatientDTO> patients = patientService.getPatientsByDoctor(doctorId);
        return ResponseEntity.ok(patients);
    }

    // Hasta ID'sine göre belirli bir hasta getirir
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        PatientDTO patient = patientService.getPatientById(id);
        return patient != null ? ResponseEntity.ok(patient) : ResponseEntity.notFound().build();
    }

    // Yeni bir hasta kaydı oluşturur
    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO createdPatient = patientService.savePatient(patientDTO);
        return ResponseEntity.status(201).body(createdPatient);
    }

    // Hasta ID'sine göre mevcut bir hastayı günceller
    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDetails) {
        PatientDTO updatedPatient = patientService.updatePatient(id, patientDetails);
        return updatedPatient != null ? ResponseEntity.ok(updatedPatient) : ResponseEntity.notFound().build();
    }

    // Hasta ID'sine göre bir hastayı siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        boolean deleted = patientService.deletePatient(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}