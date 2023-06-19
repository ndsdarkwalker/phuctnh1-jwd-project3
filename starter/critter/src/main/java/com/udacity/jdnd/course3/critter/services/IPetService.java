package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entities.PetEntity;

import java.util.List;

public interface IPetService {
    PetEntity findById(Long id);

    List<PetEntity> findByOwnerId(Long ownerId);

    PetEntity add(PetDTO dto);

    List<PetEntity> findAll();
}
