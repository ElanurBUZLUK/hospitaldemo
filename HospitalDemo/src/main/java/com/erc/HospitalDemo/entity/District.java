package com.erc.HospitalDemo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "EBDISTRICT")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_districtid")
    @SequenceGenerator(name = "sequence_generator_districtid", sequenceName = "DISTRICT_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "DISTRICTID", nullable = false)
    private Long districtId;

    @Column(name = "NAME", nullable = false)
    private String districtName;

    @ManyToOne
    @JoinColumn(name = "CITYID", nullable = false)
    private City city;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Patient> patients;

    // Getters and Setters
    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}