package com.zikozee.modal_paignation.service;

import com.zikozee.modal_paignation.model.Employee;
import com.zikozee.modal_paignation.model.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);
    void save(EmployeeDTO employeeDTO);
    Employee findOne(Long id);
    void delete(Long id);

    List<Employee> findEmployeeByLastNameAndEmail(String lastName, String emailContains);

    List<Employee> sorted(String lastName, String email);

    List<Employee> findByEmailContaining(String email);

    List<Employee> findAllbyLastname(String lastName);

}
