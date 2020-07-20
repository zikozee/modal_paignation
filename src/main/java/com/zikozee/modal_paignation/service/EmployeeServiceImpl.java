package com.zikozee.modal_paignation.service;

import com.zikozee.modal_paignation.model.Employee;
import com.zikozee.modal_paignation.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable){
        return  repository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Employee findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
