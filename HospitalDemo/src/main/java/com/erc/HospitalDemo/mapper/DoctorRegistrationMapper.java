package com.erc.HospitalDemo.mapper;

import com.erc.HospitalDemo.dto.DoctorRegistrationDTO;
import com.erc.HospitalDemo.entity.DoctorRegistration;

public class DoctorRegistrationMapper {

    public static DoctorRegistrationDTO toDto(DoctorRegistration doctor) {
        DoctorRegistrationDTO dto = new DoctorRegistrationDTO();
        dto.setDoctorId(doctor.getDoctorId());
        dto.setName(doctor.getName());
        dto.setSpeciality(doctor.getSpeciality());
        dto.setAge(doctor.getAge());
        dto.setGender(doctor.getGender());
        dto.setNumberOfPatientsAttended(doctor.getNumberOfPatientsAttended());
        return dto;
    }

    public static DoctorRegistration toEntity(DoctorRegistrationDTO dto) {
        DoctorRegistration doctor = new DoctorRegistration();
        doctor.setDoctorId(dto.getDoctorId());
        doctor.setName(dto.getName());
        doctor.setSpeciality(dto.getSpeciality());
        doctor.setAge(dto.getAge());
        doctor.setGender(dto.getGender());
        doctor.setNumberOfPatientsAttended(dto.getNumberOfPatientsAttended());
        return doctor;
    }
}
