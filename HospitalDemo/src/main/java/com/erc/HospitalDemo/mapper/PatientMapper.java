package com.erc.HospitalDemo.mapper;

import com.erc.HospitalDemo.dto.PatientDTO;
import com.erc.HospitalDemo.entity.Patient;
import com.erc.HospitalDemo.entity.Doctor;
import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientDTO toDto(Patient patient) {
        if (patient == null) return null;

        PatientDTO dto = new PatientDTO();
        dto.setPatientId(patient.getPatientId());
        dto.setPatientName(patient.getPatientName());
        dto.setDateOfVisit(patient.getDateOfVisit());
        dto.setPrescription(patient.getPrescription());

        // Doctor nesnesinin ID'sini alarak DTO'ya atama
        if (patient.getDoctor() != null) {
            dto.setDoctorId(patient.getDoctor().getDoctorId());
        }

        dto.setCity(CityMapper.toDto(patient.getCity()));
        dto.setDistrict(DistrictMapper.toDto(patient.getDistrict()));
        dto.setPhoneNumbers(patient.getPhoneNumbers().stream()
                .map(PhonenumberMapper::toDto)
                .collect(Collectors.toList()));

        return dto;
    }

    public static Patient toEntity(PatientDTO dto) {
        if (dto == null) return null;

        Patient patient = new Patient();
        patient.setPatientId(dto.getPatientId());
        patient.setPatientName(dto.getPatientName());
        patient.setDateOfVisit(dto.getDateOfVisit());
        patient.setPrescription(dto.getPrescription());

        // Doctor ID'den Doctor nesnesi oluşturma
        if (dto.getDoctorId() != null) {
            Doctor doctor = new Doctor();
            doctor.setDoctorId(dto.getDoctorId());
            patient.setDoctor(doctor);
        }

        patient.setCity(CityMapper.toEntity(dto.getCity()));
        patient.setDistrict(DistrictMapper.toEntity(dto.getDistrict()));
        patient.setPhoneNumbers(dto.getPhoneNumbers().stream()
                .map(PhonenumberMapper::toEntity)
                .collect(Collectors.toList()));

        return patient;
    }
}
