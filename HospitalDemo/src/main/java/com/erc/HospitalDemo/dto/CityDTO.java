package com.erc.HospitalDemo.dto;

import java.util.List;

public class CityDTO {
    private Long cityId;
    private String cityName;
    private List<DistrictDTO> districts;

    // Getters and Setters
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<DistrictDTO> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictDTO> districts) {
        this.districts = districts;
    }
}