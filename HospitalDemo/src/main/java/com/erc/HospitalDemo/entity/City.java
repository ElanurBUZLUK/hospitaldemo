package com.erc.HospitalDemo.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "EBCITY")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_cityid")
    @SequenceGenerator(name = "sequence_generator_cityid", sequenceName = "CITY_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "CITYID", nullable = false)
    private Long cityId;

    @Column(name = "NAME", nullable = false)
    private String cityName;

    @OneToMany(mappedBy = "city")
    private Set<District> districts;

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

    public Set<District> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }
}