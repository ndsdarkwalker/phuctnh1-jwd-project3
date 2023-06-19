package com.udacity.jdnd.course3.critter.converter;

import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.entities.EmployeeRequestEntity;

public class EmployeeRequestConverter {
    public EmployeeEntity convert(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setSkills(employeeDTO.getSkills());
        employeeEntity.setDaysAvailable(employeeDTO.getDaysAvailable());
        return employeeEntity;
    }

    public EmployeeRequestDTO convert(EmployeeRequestEntity employeeRequestEntity) {
        EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO();
        employeeRequestDTO.setSkills(employeeRequestEntity.getSkills());
        employeeRequestDTO.setDate(employeeRequestEntity.getDate());
        return employeeRequestDTO;
    }
}

