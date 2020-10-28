package com.zikozee.modal_paignation.repository;

import com.zikozee.modal_paignation.model.Employee;
import com.zikozee.modal_paignation.model.SomeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface EmployeeRepository extends JpaRepository<Employee, Long>,
        JpaSpecificationExecutor<Employee>, StreamableJpaSpecificationRepository<Employee>  {

//NATIVE QUERY
    @Query(value = "select * from Employee  where last_name like %?1%  and email like %?2%", nativeQuery =true)
    List<Employee> findEmployeeByLastNameAndEmail(String lastName,String emailContains);

    Stream<Employee> findByEmailContaining(String email);

    @Query(value = "select * from Employee  where last_name like %?1%", nativeQuery =true)
    Stream<Employee> findAllbyLastname(String lastName);

    Stream<SomeDTO> findAllByEmailContains(String email);

    Stream<?> findAllByLastNameContains(String name);
}
