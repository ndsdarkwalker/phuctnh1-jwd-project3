package com.udacity.jdnd.course3.critter.converter;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entities.PetEntity;

public class PetConverter {
    public PetEntity convert(PetDTO petDTO) {
        PetEntity petEntity = new PetEntity();
        petEntity.setId(petDTO.getId());
        petEntity.setType(petDTO.getType());
        petEntity.setName(petDTO.getName());
        petEntity.setOwnerId(petDTO.getOwnerId());
        petEntity.setBirthDate(petDTO.getBirthDate());
        petEntity.setNotes(petDTO.getNotes());
        return petEntity;
    }

    public PetDTO convert(PetEntity petEntity) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(petEntity.getId());
        petDTO.setType(petEntity.getType());
        petDTO.setName(petEntity.getName());
        petDTO.setOwnerId(petEntity.getOwnerId());
        petDTO.setBirthDate(petEntity.getBirthDate());
        petDTO.setNotes(petEntity.getNotes());
        return petDTO;
    }
}

