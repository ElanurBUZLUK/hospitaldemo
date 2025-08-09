package com.erc.HospitalDemo.controller;

import com.erc.HospitalDemo.dto.CityDTO;
import com.erc.HospitalDemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    @Autowired
    private CityService cityService;

    // Tüm şehirleri getirir
    @GetMapping
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<CityDTO> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    // Şehir ID'sine göre belirli bir şehir getirir
    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable Long id) {
        CityDTO city = cityService.getCityById(id);
        return city != null ? ResponseEntity.ok(city) : ResponseEntity.notFound().build();
    }

    // Yeni bir şehir kaydı oluşturur
    @PostMapping
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO cityDTO) {
        CityDTO createdCity = cityService.saveCity(cityDTO);
        return ResponseEntity.status(201).body(createdCity);
    }

    // Şehir ID'sine göre mevcut bir şehri günceller
    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> updateCity(@PathVariable Long id, @RequestBody CityDTO cityDetails) {
        CityDTO updatedCity = cityService.updateCity(id, cityDetails);
        return updatedCity != null ? ResponseEntity.ok(updatedCity) : ResponseEntity.notFound().build();
    }

    // Şehir ID'sine göre bir şehri siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        boolean deleted = cityService.deleteCity(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}