package com.zikozee.modal_paignation.repository;

import com.zikozee.modal_paignation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
