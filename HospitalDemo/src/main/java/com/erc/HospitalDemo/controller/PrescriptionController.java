package com.erc.HospitalDemo.controller;

import com.erc.HospitalDemo.dto.PrescriptionDTO;
import com.erc.HospitalDemo.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
@CrossOrigin(origins = "http://localhost:4200")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // Tüm reçeteleri getirir
    @GetMapping
    public ResponseEntity<List<PrescriptionDTO>> getAllPrescriptions() {
        List<PrescriptionDTO> prescriptions = prescriptionService.getAllPrescriptions();
        return ResponseEntity.ok(prescriptions);
    }

    // Reçete ID'sine göre belirli bir reçeteyi getirir
    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> getPrescriptionById(@PathVariable Long id) {
        PrescriptionDTO prescription = prescriptionService.getPrescriptionById(id);
        return prescription != null ? ResponseEntity.ok(prescription) : ResponseEntity.notFound().build();
    }

    // Yeni bir reçete kaydı oluşturur
    @PostMapping
    public ResponseEntity<PrescriptionDTO> createPrescription(@RequestBody PrescriptionDTO prescriptionDTO) {
        PrescriptionDTO createdPrescription = prescriptionService.savePrescription(prescriptionDTO);
        return ResponseEntity.status(201).body(createdPrescription);
    }

    // Reçete ID'sine göre mevcut bir reçeteyi günceller
    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> updatePrescription(@PathVariable Long id, @RequestBody PrescriptionDTO prescriptionDTO) {
        PrescriptionDTO updatedPrescription = prescriptionService.updatePrescription(id, prescriptionDTO);
        return updatedPrescription != null ? ResponseEntity.ok(updatedPrescription) : ResponseEntity.notFound().build();
    }

    // Reçete ID'sine göre bir reçeteyi siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        boolean deleted = prescriptionService.deletePrescription(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}