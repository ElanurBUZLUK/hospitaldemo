package com.erc.HospitalDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EBPRESCRIPTION")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_prescriptionid")
    @SequenceGenerator(name = "sequence_generator_prescriptionid", sequenceName = "PRESCRIPTION_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "PRESCRIPTION_ID")
    private Long prescriptionId;

    @Column(name = "DETAILS", nullable = false)
    private String details;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}