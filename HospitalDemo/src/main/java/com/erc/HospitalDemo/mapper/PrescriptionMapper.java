package com.erc.HospitalDemo.mapper;

import com.erc.HospitalDemo.dto.PrescriptionDTO;
import com.erc.HospitalDemo.entity.Prescription;

public class PrescriptionMapper {

    public static PrescriptionDTO toDto(Prescription prescription) {
        PrescriptionDTO dto = new PrescriptionDTO();
        dto.setPrescriptionId(prescription.getPrescriptionId());
        dto.setDetails(prescription.getDetails());
        return dto;
    }

    public static Prescription toEntity(PrescriptionDTO dto) {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId(dto.getPrescriptionId());
        prescription.setDetails(dto.getDetails());
        return prescription;
    }
}