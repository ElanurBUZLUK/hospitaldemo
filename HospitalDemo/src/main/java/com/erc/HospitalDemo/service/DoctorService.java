package com.erc.HospitalDemo.service;

import com.erc.HospitalDemo.dto.DoctorDTO;
import com.erc.HospitalDemo.entity.Doctor;
import com.erc.HospitalDemo.mapper.DoctorMapper;
import com.erc.HospitalDemo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(DoctorMapper::toDto)
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
        return DoctorMapper.toDto(doctor);
    }

    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = DoctorMapper.toEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return DoctorMapper.toDto(savedDoctor);
    }

    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
        
        existingDoctor.setName(doctorDTO.getName());
        existingDoctor.setSpecialty(doctorDTO.getSpecialty()); // Burada düzeltme yapıldı
        
        Doctor updatedDoctor = doctorRepository.save(existingDoctor);
        return DoctorMapper.toDto(updatedDoctor);
    }

    public boolean deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}