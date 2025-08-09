package com.erc.HospitalDemo.service;

import com.erc.HospitalDemo.dto.DistrictDTO;
import com.erc.HospitalDemo.entity.District;
import com.erc.HospitalDemo.mapper.DistrictMapper;
import com.erc.HospitalDemo.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Transactional
    public DistrictDTO saveDistrict(DistrictDTO districtDto) {
        District district = DistrictMapper.toEntity(districtDto);
        District savedDistrict = districtRepository.save(district);
        return DistrictMapper.toDto(savedDistrict);
    }

    @Transactional(readOnly = true)
    public List<DistrictDTO> getAllDistricts() {
        return districtRepository.findAll().stream()
                .map(DistrictMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DistrictDTO getDistrictById(Long id) {
        Optional<District> district = districtRepository.findById(id);
        return district.map(DistrictMapper::toDto).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<DistrictDTO> getDistrictsByCityId(Long cityId) {
        return districtRepository.findByCity_CityId(cityId).stream()
                .map(DistrictMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DistrictDTO getDistrictByPatientId(Long patientId) {
        Optional<District> district = districtRepository.findByPatients_PatientId(patientId);
        return district.map(DistrictMapper::toDto).orElse(null);
    }

    @Transactional
    public DistrictDTO updateDistrict(Long id, DistrictDTO districtDetails) {
        District existingDistrict = districtRepository.findById(id).orElse(null);
        if (existingDistrict != null) {
            existingDistrict.setDistrictName(districtDetails.getDistrictName());
            District updatedDistrict = districtRepository.save(existingDistrict);
            return DistrictMapper.toDto(updatedDistrict);
        }
        return null;
    }

    @Transactional
    public boolean deleteDistrict(Long id) {
        if (districtRepository.existsById(id)) {
            districtRepository.deleteById(id);
            return true;
        }
        return false;
    }
}