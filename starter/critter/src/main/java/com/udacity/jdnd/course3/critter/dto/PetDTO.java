package com.udacity.jdnd.course3.critter.dto;

import com.udacity.jdnd.course3.critter.entities.PetEntity;
import com.udacity.jdnd.course3.critter.enums.PetType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PetDTO {
    private long id;
    private PetType type;
    private String name;
    private long ownerId;
    private LocalDate birthDate;
    private String notes;

    public PetEntity convertToPetEntity(PetDTO dto) {
        PetEntity entity = new PetEntity();
        entity.setId(dto.getId());
        entity.setType(dto.getType());
        entity.setName(dto.getName());
        entity.setOwnerId(dto.getOwnerId());
        entity.setBirthDate(dto.getBirthDate());
        entity.setNotes(dto.getNotes());
        return entity;
    }

    public PetDTO convertToPetDTO(PetEntity entity) {
        PetDTO dto = new PetDTO();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setName(entity.getName());
        dto.setOwnerId(entity.getOwnerId());
        dto.setBirthDate(entity.getBirthDate());
        dto.setNotes(entity.getNotes());
        return dto;
    }
}
