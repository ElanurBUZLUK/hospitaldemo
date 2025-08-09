package com.erc.HospitalDemo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EBPATIENT")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_patientid")
    @SequenceGenerator(name = "sequence_generator_patientid", sequenceName = "PATIENT_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "PATIENT_ID")
    private Long patientId;

    @Column(name = "NAME")
    private String patientName;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @ManyToOne
    @JoinColumn(name = "DISTRICT_ID")
    private District district;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phonenumber> phoneNumbers = new ArrayList<>();

    @Column(name = "DATE_OF_VISIT")
    private String dateOfVisit;

    @Column(name = "PRESCRIPTION")
    private String prescription;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    // Getter ve Setter metotları
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Phonenumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phonenumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
