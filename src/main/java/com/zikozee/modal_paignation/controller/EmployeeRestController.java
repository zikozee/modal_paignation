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
        return service.findEmployeeByLastNameContainsAndEmailContains(lastName, email);
    }
}
