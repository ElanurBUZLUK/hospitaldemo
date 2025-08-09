package com.erc.HospitalDemo.mapper;

import com.erc.HospitalDemo.dto.PhonenumberDTO;
import com.erc.HospitalDemo.entity.Phonenumber;

public class PhonenumberMapper {

    public static PhonenumberDTO toDto(Phonenumber phonenumber) {
        if (phonenumber == null) return null;

        PhonenumberDTO dto = new PhonenumberDTO();
        dto.setPhoneNumberId(phonenumber.getPhoneNumberId());
        dto.setPhoneNumber(phonenumber.getPhoneNumber());
        dto.setType(phonenumber.getType());

        return dto;
    }

    public static Phonenumber toEntity(PhonenumberDTO dto) {
        if (dto == null) return null;

        Phonenumber phonenumber = new Phonenumber();
        phonenumber.setPhoneNumberId(dto.getPhoneNumberId());
        phonenumber.setPhoneNumber(dto.getPhoneNumber());
        phonenumber.setType(dto.getType());

        return phonenumber;
    }
}