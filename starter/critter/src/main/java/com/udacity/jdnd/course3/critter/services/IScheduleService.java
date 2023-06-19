package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entities.ScheduleEntity;

import java.util.List;

public interface IScheduleService {
    List<ScheduleEntity> findByCustomer(Long id);

    List<ScheduleEntity> findByPets(Long id);

    List<ScheduleEntity> findByEmployees(Long id);

    ScheduleEntity add(ScheduleDTO dto);

    List<ScheduleEntity> findAll();
}
