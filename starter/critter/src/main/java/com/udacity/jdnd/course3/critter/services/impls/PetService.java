package com.udacity.jdnd.course3.critter.services.impls;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetService implements IPetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<PetEntity> findAll() {
        return petRepository.findAll();
    }

    @Override
    public PetEntity findById(Long id) {
        Optional<PetEntity> optionalEntity = petRepository.findById(id);
        return optionalEntity.orElse(null);
    }

    @Override
    public PetEntity add(PetDTO dto) {
        PetEntity entity = new PetEntity();
        CustomerEntity customer = customerRepository.getOne(dto.getOwnerId());
        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setType(dto.getType());
        entity.setNotes(dto.getNotes());
        entity.setOwnerId(customer.getId());
        return petRepository.save(entity);
    }

    @Override
    public List<PetEntity> findByOwnerId(Long ownerId) {
        return petRepository.findByOwner(ownerId);
    }
}
