package com.udacity.jdnd.course3.critter.dto;

import com.udacity.jdnd.course3.critter.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
@Data
public class CustomerDTO {
    private long id;
    private String name;
    private String phoneNumber;
    private String notes;
    private List<Long> petList;

    public CustomerEntity convertToCustomerEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setNotes(dto.getNotes());
        List<PetEntity> petEntities = dto.getPetList().stream()
                .map(petId -> {
                    PetEntity petEntity = new PetEntity();
                    petEntity.setId(petId);
                    return petEntity;
                })
                .collect(Collectors.toList());
        entity.setPetList(petEntities);
        return entity;
    }
}
