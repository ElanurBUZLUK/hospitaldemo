package com.erc.HospitalDemo.mapper;

import com.erc.HospitalDemo.dto.DistrictDTO;
import com.erc.HospitalDemo.entity.District;

public class DistrictMapper {

    public static DistrictDTO toDto(District district) { // Metod adı toDto olarak güncellendi
        if (district == null) return null;

        DistrictDTO dto = new DistrictDTO();
        dto.setDistrictId(district.getDistrictId());
        dto.setDistrictName(district.getDistrictName());
        dto.setCityId(district.getCity().getCityId());
        
        return dto;
    }

    public static District toEntity(DistrictDTO dto) {
        if (dto == null) return null;

        District district = new District();
        district.setDistrictId(dto.getDistrictId());
        district.setDistrictName(dto.getDistrictName());
        // City should be set in the service layer if needed
        
        return district;
    }
}