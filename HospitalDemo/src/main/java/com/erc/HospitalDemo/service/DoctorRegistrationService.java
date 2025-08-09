package com.erc.HospitalDemo.service;

import com.erc.HospitalDemo.dto.DoctorRegistrationDTO;
import com.erc.HospitalDemo.entity.DoctorRegistration;
import com.erc.HospitalDemo.mapper.DoctorRegistrationMapper;
import com.erc.HospitalDemo.repository.DoctorRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorRegistrationService {

    @Autowired
    private DoctorRegistrationRepository repository;

    public DoctorRegistrationDTO saveDoctor(DoctorRegistrationDTO doctorDTO) {
        DoctorRegistration doctor = DoctorRegistrationMapper.toEntity(doctorDTO);
        DoctorRegistration savedDoctor = repository.save(doctor);
        return DoctorRegistrationMapper.toDto(savedDoctor);
    }

    public List<DoctorRegistrationDTO> getAllDoctors() {
        return repository.findAll().stream()
                .map(DoctorRegistrationMapper::toDto)
                .collect(Collectors.toList());
    }

    public DoctorRegistrationDTO getDoctorById(Long doctorId) {
        return repository.findById(doctorId)
                .map(DoctorRegistrationMapper::toDto)
                .orElse(null);
    }
}
