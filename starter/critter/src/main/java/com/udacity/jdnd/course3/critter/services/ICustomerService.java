package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;

import java.util.List;

public interface ICustomerService {
    List<CustomerEntity> findAll();

    CustomerEntity findById(Long id);

    CustomerEntity add(CustomerDTO dto);

    CustomerEntity findByPet(PetEntity petEntity);

    CustomerEntity findByPetId(Long petId);
}
