package com.erc.HospitalDemo.mapper;

import com.erc.HospitalDemo.dto.CityDTO;
import com.erc.HospitalDemo.entity.City;
import java.util.stream.Collectors;

public class CityMapper {

    public static CityDTO toDto(City city) { // Metod adı toDto olarak güncellendi
        if (city == null) return null;

        CityDTO dto = new CityDTO();
        dto.setCityId(city.getCityId());
        dto.setCityName(city.getCityName());
        dto.setDistricts(city.getDistricts().stream()
                .map(DistrictMapper::toDto) // Uyumlu olması için toDto olarak güncellendi
                .collect(Collectors.toList()));

        return dto;
    }

    public static City toEntity(CityDTO dto) {
        if (dto == null) return null;

        City city = new City();
        city.setCityId(dto.getCityId());
        city.setCityName(dto.getCityName());
        
        return city;
    }
}