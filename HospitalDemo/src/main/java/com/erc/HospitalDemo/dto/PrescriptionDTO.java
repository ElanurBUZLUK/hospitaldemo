package com.erc.HospitalDemo.dto;

public class PrescriptionDTO {

    private Long prescriptionId;
    private String details;

    // Getters ve Setters
    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}