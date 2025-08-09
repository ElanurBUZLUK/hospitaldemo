package com.erc.HospitalDemo.service;

import com.erc.HospitalDemo.dto.PhonenumberDTO;
import com.erc.HospitalDemo.entity.Phonenumber;
import com.erc.HospitalDemo.mapper.PhonenumberMapper;
import com.erc.HospitalDemo.repository.PhonenumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhonenumberService {

    @Autowired
    private PhonenumberRepository phonenumberRepository;

    /**
     * Telefon numarasını ID'ye göre getirir.
     * @param id Telefon numarası ID'si
     * @return PhonenumberDTO veya null
     */
    @Transactional(readOnly = true)
    public PhonenumberDTO getPhoneNumberById(Long id) {
        Optional<Phonenumber> phonenumber = phonenumberRepository.findById(id);
        return phonenumber.map(PhonenumberMapper::toDto).orElse(null);
    }

    /**
     * Yeni bir telefon numarası kaydeder.
     * @param phonenumberDTO Kaydedilecek telefon numarası bilgilerini içeren DTO.
     * @return Kaydedilen telefon numarası bilgilerini içeren DTO.
     */
    @Transactional
    public PhonenumberDTO savePhoneNumber(PhonenumberDTO phonenumberDTO) {
        Phonenumber phonenumber = PhonenumberMapper.toEntity(phonenumberDTO);
        Phonenumber savedPhonenumber = phonenumberRepository.save(phonenumber);
        return PhonenumberMapper.toDto(savedPhonenumber);
    }

    /**
     * Telefon numarasını günceller.
     * @param id Güncellenecek telefon numarasının ID'si
     * @param phonenumberDTO Güncelleme bilgilerini içeren DTO
     * @return Güncellenmiş telefon numarası bilgilerini içeren DTO veya null
     */
    @Transactional
    public PhonenumberDTO updatePhoneNumber(Long id, PhonenumberDTO phonenumberDTO) {
        Optional<Phonenumber> existingPhonenumber = phonenumberRepository.findById(id);
        if (existingPhonenumber.isPresent()) {
            Phonenumber phonenumber = existingPhonenumber.get();
            phonenumber.setPhoneNumber(phonenumberDTO.getPhoneNumber());
            phonenumber.setType(phonenumberDTO.getType());
            Phonenumber updatedPhonenumber = phonenumberRepository.save(phonenumber);
            return PhonenumberMapper.toDto(updatedPhonenumber);
        }
        return null;
    }

    /**
     * Telefon numarasını ID'ye göre siler.
     * @param id Silinecek telefon numarasının ID'si
     * @return Silme işlemi başarılıysa true, aksi takdirde false
     */
    @Transactional
    public boolean deletePhoneNumber(Long id) {
        if (phonenumberRepository.existsById(id)) {
            phonenumberRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Belirli bir hasta ID'sine göre telefon numaralarını getirir.
     * @param patientId Hastanın ID'si.
     * @return Telefon numaralarını içeren DTO listesi.
     */
    @Transactional(readOnly = true)
    public List<PhonenumberDTO> getPhoneNumbersByPatientId(Long patientId) {
        List<Phonenumber> phonenumbers = phonenumberRepository.findByPatientId(patientId);
        return phonenumbers.stream()
                           .map(PhonenumberMapper::toDto)
                           .collect(Collectors.toList());
    }

    /**
     * Tüm telefon numaralarını getirir.
     * @return Tüm telefon numaralarını içeren DTO listesi.
     */
    @Transactional(readOnly = true)
    public List<PhonenumberDTO> getAllPhoneNumbers() {
        List<Phonenumber> phonenumbers = phonenumberRepository.findAll();
        return phonenumbers.stream()
                           .map(PhonenumberMapper::toDto)
                           .collect(Collectors.toList());
    }
}