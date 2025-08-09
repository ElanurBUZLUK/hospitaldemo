package com.erc.HospitalDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EBPHONENUMBER")
public class Phonenumber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_phonenumberid")
    @SequenceGenerator(name = "sequence_generator_phonenumberid", sequenceName = "PHONENUMBER_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "PHONE_NUMBER_ID")
    private Long phoneNumberId;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "TYPE")
    private String type;

    @OneToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    // Getters and Setters
    public Long getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(Long phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}