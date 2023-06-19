package com.udacity.jdnd.course3.critter.dto;

import com.udacity.jdnd.course3.critter.entities.EmployeeRequestEntity;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class EmployeeRequestDTO {
    private Set<EmployeeSkill> skills;
    private LocalDate date;

    public EmployeeRequestEntity convertToEmployeeRequestEntity(EmployeeRequestDTO dto) {
        EmployeeRequestEntity entity = new EmployeeRequestEntity();
        entity.setSkills(dto.getSkills());
        entity.setDate(dto.getDate());
        return entity;
    }

    public EmployeeRequestDTO convertToEmployeeRequestDTO(EmployeeRequestEntity entity) {
        EmployeeRequestDTO dto = new EmployeeRequestDTO();
        dto.setSkills(entity.getSkills());
        dto.setDate(entity.getDate());
        return dto;
    }
}
