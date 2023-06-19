package com.udacity.jdnd.course3.critter.controllers;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.entities.PetEntity;
import com.udacity.jdnd.course3.critter.services.impls.CustomerService;
import com.udacity.jdnd.course3.critter.services.impls.EmployeeService;
import com.udacity.jdnd.course3.critter.services.impls.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PetService petService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO dto) {
        CustomerEntity savedDto = customerService.add(dto);
        return savedDto.convertToCustomerDTO(savedDto);
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> entities = customerService.findAll();
        List<CustomerDTO> dtos = new ArrayList<>();
        for (CustomerEntity entity : entities) {
            dtos.add(entity.convertToCustomerDTO(entity));
        }
        return dtos;
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId) {
//        PetEntity petEntity = petService.findById(petId);
//        CustomerEntity customerEntity = customerService.findByPet(petEntity);
//        if (customerEntity != null) {
//            return customerEntity.convertToCustomerDTO(customerEntity);
//        }
//        return new CustomerDTO();
        CustomerEntity customerEntity = customerService.findByPetId(petId);
        return customerEntity.convertToCustomerDTO(customerEntity);
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity savedEntity = employeeService.add(employeeDTO);
        return savedEntity.convertToEmployeeDTO(savedEntity);
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        EmployeeEntity entity = employeeService.findById(employeeId);
        return entity.convertToEmployeeDTO(entity);
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        EmployeeEntity entity = employeeService.findById(employeeId);
        EmployeeDTO dto = entity.convertToEmployeeDTO(entity);
        dto.setDaysAvailable(daysAvailable);
        employeeService.add(dto);
    }
}
