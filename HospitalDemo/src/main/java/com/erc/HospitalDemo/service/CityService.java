package com.erc.HospitalDemo.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erc.HospitalDemo.dto.CityDTO;
import com.erc.HospitalDemo.entity.City;
import com.erc.HospitalDemo.mapper.CityMapper;
import com.erc.HospitalDemo.repository.CityRepository;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    // Tüm şehirleri DTO listesi olarak döndürür
    public List<CityDTO> getAllCities() {
        return cityRepository.findAll().stream()
                .map(CityMapper::toDto) // Metod adı toDto olarak düzenlendi
                .collect(Collectors.toList());
    }

    // Şehir ID'sine göre belirli bir şehir getirir
    public CityDTO getCityById(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        return city != null ? CityMapper.toDto(city) : null;
    }

    // Yeni bir şehir kaydı oluşturur
    public CityDTO saveCity(CityDTO cityDTO) {
        City city = CityMapper.toEntity(cityDTO);
        City savedCity = cityRepository.save(city);
        return CityMapper.toDto(savedCity);
    }

    // Şehir ID'sine göre mevcut bir şehri günceller
    public CityDTO updateCity(Long id, CityDTO cityDetails) {
        City existingCity = cityRepository.findById(id).orElse(null);
        if (existingCity != null) {
            existingCity.setCityName(cityDetails.getCityName());
            City updatedCity = cityRepository.save(existingCity);
            return CityMapper.toDto(updatedCity);
        }
        return null;
    }

    // Şehir ID'sine göre bir şehri siler
    public boolean deleteCity(Long id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}