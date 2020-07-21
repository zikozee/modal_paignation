package com.zikozee.modal_paignation.repository;

import com.zikozee.modal_paignation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query(value = "SELECT * FROM employee WHERE last_name like %?1% AND email like %?2%", nativeQuery = true)
    @Query(value = "select * from employee  where last_name like %?1%  and email like %?2%", nativeQuery =true)
    List<Employee> findEmployeeByLastNameContainsAndEmailContains(@Param("lastName") String lastName, @Param("email") String emailContains);
}
