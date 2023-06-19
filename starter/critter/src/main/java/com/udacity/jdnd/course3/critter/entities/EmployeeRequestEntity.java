package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class EmployeeRequestEntity {
    @ElementCollection
    private Set<EmployeeSkill> skills;
    @Column
    private LocalDate date;
}
