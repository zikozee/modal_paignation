package com.zikozee.modal_paignation.service;

import com.zikozee.modal_paignation.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);
    Employee save(Employee employee);
    Employee findOne(Long id);
    void delete(Long id);

}
