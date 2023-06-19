package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
//    List<EmployeeEntity> findByIds(Long id);

    List<EmployeeEntity> findBySkillsAndAvailabilityDate(Set<EmployeeSkill> skill, LocalDate date);
}
