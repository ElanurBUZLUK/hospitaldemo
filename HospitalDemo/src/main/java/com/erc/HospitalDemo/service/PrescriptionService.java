package com.erc.HospitalDemo.service;

import com.erc.HospitalDemo.dto.PrescriptionDTO;
import com.erc.HospitalDemo.entity.Prescription;
import com.erc.HospitalDemo.mapper.PrescriptionMapper;
import com.erc.HospitalDemo.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<PrescriptionDTO> getAllPrescriptions() {
        return prescriptionRepository.findAll().stream()
                .map(PrescriptionMapper::toDto)
                .collect(Collectors.toList());
    }

    public PrescriptionDTO getPrescriptionById(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found with ID: " + id));
        return PrescriptionMapper.toDto(prescription);
    }

    public PrescriptionDTO savePrescription(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = PrescriptionMapper.toEntity(prescriptionDTO);
        Prescription savedPrescription = prescriptionRepository.save(prescription);
        return PrescriptionMapper.toDto(savedPrescription);
    }

    public PrescriptionDTO updatePrescription(Long id, PrescriptionDTO prescriptionDTO) {
        Prescription existingPrescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found with ID: " + id));

        existingPrescription.setDetails(prescriptionDTO.getDetails());

        Prescription updatedPrescription = prescriptionRepository.save(existingPrescription);
        return PrescriptionMapper.toDto(updatedPrescription);
    }

    public boolean deletePrescription(Long id) {
        if (prescriptionRepository.existsById(id)) {
            prescriptionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}