package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
public class ScheduleEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "schedules_employees", joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<EmployeeEntity> employees;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "schedules_pets",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private List<PetEntity> pets;

    @Column
    private LocalDate date;

    @ElementCollection
    private Set<EmployeeSkill> activities;

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
