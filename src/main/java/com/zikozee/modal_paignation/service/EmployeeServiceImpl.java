package com.zikozee.modal_paignation.service;

import com.zikozee.modal_paignation.model.Employee;
import com.zikozee.modal_paignation.model.EmployeeDTO;
import com.zikozee.modal_paignation.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
    public void save(EmployeeDTO employeeDTO) {
       Employee employee = buildEmployee(employeeDTO);
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

    @Override
    public List<Employee> findEmployeeByLastNameAndEmail(String lastName, String emailContains) {
        return repository.findEmployeeByLastNameAndEmail(lastName, emailContains);
    }

    @Override
    public List<Employee> sorted(String lastName, String email) {


        Specification<Employee> initialSPec =(entity, cq, cb) -> cb.like(cb.lower(entity.get("email")),"%" + email.toLowerCase() +"%");

        Specification<Employee> finalSpec = initialSPec.and((entity, cq, cb) -> cb.like(cb.lower(entity.get("lastName")),"%" + lastName.toLowerCase() +"%"));

        return repository.stream(finalSpec, Employee.class).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<Employee> findByEmailContaining(String email) {
        return repository.findByEmailContaining(email).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<Employee> findAllbyLastname(String lastName) {
        return repository.findAllbyLastname(lastName).collect(Collectors.toList());
    }

    private Employee buildEmployee(EmployeeDTO employeeDTO){
        return  Employee.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .build();
    }

}
