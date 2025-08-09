package com.erc.HospitalDemo.controller;

import com.erc.HospitalDemo.dto.PhonenumberDTO;
import com.erc.HospitalDemo.service.PhonenumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phoneNumbers")
@CrossOrigin(origins = "http://localhost:4200")
public class PhonenumberController {

    @Autowired
    private PhonenumberService phonenumberService;

    // Tüm telefon numaralarını getirir
    @GetMapping
    public ResponseEntity<List<PhonenumberDTO>> getAllPhoneNumbers() {
        List<PhonenumberDTO> phoneNumbers = phonenumberService.getAllPhoneNumbers();
        return ResponseEntity.ok(phoneNumbers);
    }

    // Belirli bir telefon numarasını ID'ye göre getirir
    @GetMapping("/{id}")
    public ResponseEntity<PhonenumberDTO> getPhoneNumberById(@PathVariable Long id) {
        PhonenumberDTO phoneNumber = phonenumberService.getPhoneNumberById(id);
        return phoneNumber != null ? ResponseEntity.ok(phoneNumber) : ResponseEntity.notFound().build();
    }

    // Belirli bir hasta ID'sine göre telefon numaralarını getirir
    @GetMapping("/byPatient/{patientId}")
    public ResponseEntity<List<PhonenumberDTO>> getPhoneNumbersByPatientId(@PathVariable Long patientId) {
        List<PhonenumberDTO> phoneNumbers = phonenumberService.getPhoneNumbersByPatientId(patientId);
        return ResponseEntity.ok(phoneNumbers);
    }

    // Yeni bir telefon numarası ekler
    @PostMapping
    public ResponseEntity<PhonenumberDTO> createPhoneNumber(@RequestBody PhonenumberDTO phonenumberDTO) {
        PhonenumberDTO createdPhoneNumber = phonenumberService.savePhoneNumber(phonenumberDTO);
        return ResponseEntity.status(201).body(createdPhoneNumber);
    }

    // Telefon numarasını günceller
    @PutMapping("/{id}")
    public ResponseEntity<PhonenumberDTO> updatePhoneNumber(@PathVariable Long id, @RequestBody PhonenumberDTO phonenumberDTO) {
        PhonenumberDTO updatedPhoneNumber = phonenumberService.updatePhoneNumber(id, phonenumberDTO);
        return updatedPhoneNumber != null ? ResponseEntity.ok(updatedPhoneNumber) : ResponseEntity.notFound().build();
    }

    // Telefon numarasını siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoneNumber(@PathVariable Long id) {
        boolean deleted = phonenumberService.deletePhoneNumber(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}