package com.erc.HospitalDemo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EBDOCTOR")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_doctorid")
    @SequenceGenerator(name = "sequence_generator_doctorid", sequenceName = "DOCTOR_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "DOCTOR_ID")
    private Long doctorId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SPECIALTY")
    private String specialty;

    // OneToMany ilişkisi ile Patient sınıfına bağlanıyor
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Patient> patients = new ArrayList<>();

    // Getter ve Setter metotları
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
