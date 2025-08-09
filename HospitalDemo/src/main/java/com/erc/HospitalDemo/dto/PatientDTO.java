package com.erc.HospitalDemo.dto;

import java.util.List;

public class PatientDTO {
    private Long patientId;
    private String patientName;
    private String dateOfVisit;
    private String prescription;
    private Long doctorId;
    private CityDTO city;
    private DistrictDTO district;
    private List<PhonenumberDTO> phoneNumbers;

    // Getters and Setters
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public DistrictDTO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictDTO district) {
        this.district = district;
    }

    public List<PhonenumberDTO> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhonenumberDTO> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}