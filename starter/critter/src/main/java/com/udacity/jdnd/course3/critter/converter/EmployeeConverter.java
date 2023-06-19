package com.udacity.jdnd.course3.critter.converter;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeConverter {
    public EmployeeEntity convert(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setSkills(employeeDTO.getSkills());
        employeeEntity.setDaysAvailable(employeeDTO.getDaysAvailable());
        return employeeEntity;
    }

    public EmployeeDTO convert(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setName(employeeEntity.getName());
        employeeDTO.setSkills(employeeEntity.getSkills());
        employeeDTO.setDaysAvailable(employeeEntity.getDaysAvailable());
        return employeeDTO;
    }
}

