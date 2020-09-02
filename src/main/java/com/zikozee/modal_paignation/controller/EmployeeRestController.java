package com.zikozee.modal_paignation.controller;

import com.zikozee.modal_paignation.model.Employee;
import com.zikozee.modal_paignation.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeRestController {

    private final EmployeeService service;

    @GetMapping("/employeeCustom")
    @ResponseBody//optional, since RestController already contains @ResponseBody
    public List<Employee> employeeCustom(@RequestParam(defaultValue = "") String lastName, @RequestParam(defaultValue = "") String email){
        return service.findEmployeeByLastNameAndEmail(lastName, email);
    }


    @GetMapping("/sorted")
    public List<Employee> sorted(@RequestParam(defaultValue = "") String lastName, @RequestParam(defaultValue = "") String email){
        return service.sorted(lastName, email);
    }

    @GetMapping("/email")
    public List<Employee> findByEmailContaining(@RequestParam(defaultValue = "") String email){
        return service.findByEmailContaining(email);
    }


    @GetMapping("/lastName")
    @ResponseBody//optional, since RestController already contains @ResponseBody
    public List<Employee> findAllbyLastname(@RequestParam(defaultValue = "") String lastName){
        return service.findAllbyLastname(lastName);
    }


}
