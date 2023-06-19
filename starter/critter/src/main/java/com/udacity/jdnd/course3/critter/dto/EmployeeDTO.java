package com.udacity.jdnd.course3.critter.dto;

import com.udacity.jdnd.course3.critter.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import lombok.Data;

import java.time.DayOfWeek;
import java.util.Set;

@Data
public class EmployeeDTO {
    private long id;
    private String name;
    private Set<EmployeeSkill> skills;
    private Set<DayOfWeek> daysAvailable;

    public EmployeeEntity convertToEmployeeEntity(EmployeeDTO dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSkills(dto.getSkills());
        entity.setDaysAvailable(dto.getDaysAvailable());
        return entity;
    }

    public EmployeeDTO convertToEmployeeDTO(EmployeeEntity entity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSkills(entity.getSkills());
        dto.setDaysAvailable(entity.getDaysAvailable());
        return dto;
    }
}
