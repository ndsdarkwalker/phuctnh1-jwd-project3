package com.udacity.jdnd.course3.critter.dto;

import com.udacity.jdnd.course3.critter.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;
import com.udacity.jdnd.course3.critter.entities.ScheduleEntity;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ScheduleDTO {
    private long id;
    private List<Long> employeeIds;
    private List<Long> petIds;
    private LocalDate date;
    private Set<EmployeeSkill> activities;

    public ScheduleEntity convertToScheduleEntity(ScheduleDTO dto) {
        ScheduleEntity entity = new ScheduleEntity();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        List<EmployeeEntity> employeeEntities = dto.getEmployeeIds().stream()
                .map(employeeId -> {
                    EmployeeEntity employeeEntity = new EmployeeEntity();
                    employeeEntity.setId(employeeId);
                    return employeeEntity;
                })
                .collect(Collectors.toList());
        entity.setEmployees(employeeEntities);
        List<PetEntity> petEntities = dto.getPetIds().stream()
                .map(petId -> {
                    PetEntity petEntity = new PetEntity();
                    petEntity.setId(petId);
                    return petEntity;
                })
                .collect(Collectors.toList());
        entity.setPets(petEntities);
        entity.setActivities(dto.getActivities());
        return entity;
    }

    public ScheduleDTO convertToScheduleDTO(ScheduleEntity entity) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        List<Long> employeeIds = entity.getEmployees().stream()
                .map(EmployeeEntity::getId)
                .collect(Collectors.toList());
        dto.setEmployeeIds(employeeIds);
        List<Long> petIds = entity.getPets().stream()
                .map(PetEntity::getId)
                .collect(Collectors.toList());
        dto.setPetIds(petIds);
        dto.setActivities(entity.getActivities());
        return dto;
    }
}
