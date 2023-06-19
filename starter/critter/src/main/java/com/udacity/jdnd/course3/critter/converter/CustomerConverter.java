package com.udacity.jdnd.course3.critter.converter;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerConverter {

    public CustomerEntity convert(CustomerDTO dto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(dto.getId());
        customerEntity.setName(dto.getName());
        customerEntity.setPhoneNumber(dto.getPhoneNumber());
        customerEntity.setNotes(dto.getNotes());
        // Convert the list of pet IDs to PetEntity objects and set them in the customerEntity
        List<PetEntity> petEntities = new ArrayList<>();
        for (Long petId : dto.getPetList()) {
            PetEntity petEntity = new PetEntity();
            petEntity.setId(petId);
            petEntities.add(petEntity);
        }
        customerEntity.setPetList(petEntities);
        return customerEntity;
    }

    public CustomerDTO convert(CustomerEntity entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setNotes(entity.getNotes());
        List<Long> petIds = entity.getPetList().stream()
                .map(PetEntity::getId)
                .collect(Collectors.toList());
        dto.setPetList(petIds);
        return dto;
    }
}

