package com.erc.HospitalDemo.mapper;

import com.erc.HospitalDemo.dto.DoctorDTO;
import com.erc.HospitalDemo.entity.Doctor;

public class DoctorMapper {

    public static DoctorDTO toDto(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setDoctorId(doctor.getDoctorId());
        dto.setName(doctor.getName());
        dto.setSpecialty(doctor.getSpecialty());
        return dto;
    }

    public static Doctor toEntity(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(dto.getDoctorId());
        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
        return doctor;
    }
}