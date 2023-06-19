package com.udacity.jdnd.course3.critter.services.impls;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;
import com.udacity.jdnd.course3.critter.entities.ScheduleEntity;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.repositories.ScheduleRepository;
import com.udacity.jdnd.course3.critter.services.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService implements IScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PetRepository petRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ScheduleEntity> findByCustomer(Long id) {
        return null;
    }

    @Override
    public List<ScheduleEntity> findByPet(Long id) {
        return null;
    }

    @Override
    public List<ScheduleEntity> findByEmployee(Long id) {
        return null;
    }

    @Override
    public ScheduleEntity add(ScheduleDTO dto) {
        ScheduleEntity entity = new ScheduleEntity();
        List<PetEntity> listPet = petRepository.findAllById(dto.getPetIds());
        List<EmployeeEntity> listEmployee = employeeRepository.findAllById(dto.getEmployeeIds());
        entity.setDate(dto.getDate());
        entity.setEmployees(listEmployee);
        entity.setPets(listPet);
        entity.setActivities(dto.getActivities());
        return scheduleRepository.save(entity);
    }

    @Override
    public List<ScheduleEntity> findAll() {
        return scheduleRepository.findAll();
    }
}