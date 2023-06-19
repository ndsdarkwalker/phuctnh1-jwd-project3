package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entities.ScheduleEntity;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface IScheduleService {
    List<ScheduleEntity> findByCustomer(Long id);

    List<ScheduleEntity> findByPet(Long id);

    List<ScheduleEntity> findByEmployee(Long id);

    ScheduleEntity add(ScheduleDTO dto);

    List<ScheduleEntity> findAll();
}
