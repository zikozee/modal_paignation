package com.zikozee.modal_paignation.service;

import com.zikozee.modal_paignation.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);
    void save(Employee employee);
    Employee findOne(Long id);
    void delete(Long id);

    List<Employee> findEmployeeByLastNameContainsAndEmailContains(String lastName, String emailContains);

}
