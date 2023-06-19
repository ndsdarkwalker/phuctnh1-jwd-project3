package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IEmployeeService {
    List<EmployeeEntity> findAll();

    EmployeeEntity findById(Long id);

    EmployeeEntity add(EmployeeDTO dto);

    List<EmployeeEntity> findByAvailability(Set<EmployeeSkill> skills, LocalDate date);
}
