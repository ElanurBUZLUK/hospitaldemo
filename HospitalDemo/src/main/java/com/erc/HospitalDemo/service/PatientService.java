package com.erc.HospitalDemo.service;

import com.erc.HospitalDemo.dto.PatientDTO;
import com.erc.HospitalDemo.entity.Patient;
import com.erc.HospitalDemo.entity.Doctor;
import com.erc.HospitalDemo.mapper.CityMapper;
import com.erc.HospitalDemo.mapper.DistrictMapper;
import com.erc.HospitalDemo.mapper.PatientMapper;
import com.erc.HospitalDemo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toDto)
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        return patient != null ? PatientMapper.toDto(patient) : null;
    }

    public List<PatientDTO> getPatientsByDoctor(Long doctorId) {
        List<Patient> patients = patientRepository.findByDoctor_DoctorId(doctorId);
        return patients.stream()
                .map(PatientMapper::toDto)
                .collect(Collectors.toList());
    }

    public PatientDTO savePatient(PatientDTO patientDTO) {
        Patient patient = PatientMapper.toEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.toDto(savedPatient);
    }

    public PatientDTO updatePatient(Long id, PatientDTO patientDetails) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setPatientName(patientDetails.getPatientName());
            existingPatient.setDateOfVisit(patientDetails.getDateOfVisit());
            existingPatient.setPrescription(patientDetails.getPrescription());

            // Doctor ID'den Doctor nesnesi oluşturma
            if (patientDetails.getDoctorId() != null) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(patientDetails.getDoctorId());
                existingPatient.setDoctor(doctor);
            }

            // DTO nesnelerini entity nesnelerine dönüştürmek için mapper kullanın
            existingPatient.setCity(CityMapper.toEntity(patientDetails.getCity()));
            existingPatient.setDistrict(DistrictMapper.toEntity(patientDetails.getDistrict()));

            Patient updatedPatient = patientRepository.save(existingPatient);
            return PatientMapper.toDto(updatedPatient);
        }
        return null;
    }

    public boolean deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
