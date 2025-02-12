package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

    @Query("SELECT p FROM PetEntity p WHERE p.customer.id = :customerId")
    PetEntity findPetByCustomer(@Param("customerId") Long customerId);

    @Query("SELECT p FROM PetEntity p WHERE p.customer.id = :ownerId")
    List<PetEntity> findByOwner(@Param("ownerId") Long ownerId);
}
