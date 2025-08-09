package com.erc.HospitalDemo.dto;

public class DoctorRegistrationDTO {

    private Long doctorId;
    private String name;
    private String speciality;
    private Integer age;
    private String gender;
    private Integer numberOfPatientsAttended;

    // Getters and Setters
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getNumberOfPatientsAttended() {
        return numberOfPatientsAttended;
    }

    public void setNumberOfPatientsAttended(Integer numberOfPatientsAttended) {
        this.numberOfPatientsAttended = numberOfPatientsAttended;
    }
}
