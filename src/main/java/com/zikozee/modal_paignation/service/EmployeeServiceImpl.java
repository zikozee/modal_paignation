package com.zikozee.modal_paignation.service;

import com.zikozee.modal_paignation.model.Employee;
import com.zikozee.modal_paignation.model.EmployeeDTO;
import com.zikozee.modal_paignation.model.SomeDTO;
import com.zikozee.modal_paignation.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Transactional
    @Override
    public List<SomeDTO> findAllbyEmailContain(String email) {
        return repository.findByEmailContaining(email)
                .map(employee -> SomeDTO.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .build())
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<SomeDTO> findAllbyLastNameContain(String lastName) {
        Specification<Employee> specs = (entity, cq, cb) -> cb.like(cb.lower(entity.get("lastName")),"%" + lastName.toLowerCase() +"%");

        return repository.stream(specs, Employee.class)
                .map(employee -> SomeDTO.builder()
                .lastName(employee.getLastName())
                .firstName(employee.getFirstName())
                .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<String> getAllString() {

        Supplier<Stream<?>> supplier = () -> repository.findAllByLastNameContains("e");

        return supplier.get()
                .filter(data -> data instanceof Employee)
                .map(data -> {
                    Employee employee = (Employee)data;
                    return employee.getFirstName() + " " + employee.getLastName() + " " + employee.getEmail();
                })
                .collect(Collectors.toList());
    }

    private Employee buildEmployee(EmployeeDTO employeeDTO){
        return  Employee.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .build();
    }

}
