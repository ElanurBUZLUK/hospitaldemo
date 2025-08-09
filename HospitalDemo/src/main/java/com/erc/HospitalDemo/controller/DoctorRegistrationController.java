package com.erc.HospitalDemo.controller;

import com.erc.HospitalDemo.dto.DoctorRegistrationDTO;
import com.erc.HospitalDemo.service.DoctorRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRegistrationController {

    @Autowired
    private DoctorRegistrationService service;

    @PostMapping("/register")
    public DoctorRegistrationDTO registerDoctor(@RequestBody DoctorRegistrationDTO doctorDTO) {
        return service.saveDoctor(doctorDTO);
    }

    @GetMapping
    public List<DoctorRegistrationDTO> getAllDoctors() {
        return service.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorRegistrationDTO getDoctorById(@PathVariable Long id) {
        return service.getDoctorById(id);
    }
}
