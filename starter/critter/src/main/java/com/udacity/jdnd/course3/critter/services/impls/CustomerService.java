package com.udacity.jdnd.course3.critter.services.impls;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PetRepository petRepository;

    @Override
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity findById(Long id) {
        Optional<CustomerEntity> optionalEntity = customerRepository.findById(id);
        return optionalEntity.orElse(null);
    }

    @Override
    public CustomerEntity findByPet(PetEntity petEntity) {
        List<CustomerEntity> customers = customerRepository.findAll();
        for (CustomerEntity customer : customers) {
            List<PetEntity> pets = customer.getPetList();
            if (pets.contains(petEntity)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public CustomerEntity add(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        List<PetEntity> petList = new ArrayList<>();
        List<Long> petId = dto.getPetList();
        if (!CollectionUtils.isEmpty(petId)) {
            petId.forEach(e -> {
                Optional<PetEntity> petEntity = petRepository.findById(e);
                petEntity.ifPresent(petList::add);
            });
        }
        entity.setName(dto.getName());
        entity.setNotes(dto.getNotes());
        entity.setPetList(petList);
        entity.setPhoneNumber(dto.getPhoneNumber());
        return customerRepository.save(entity);
    }
}
