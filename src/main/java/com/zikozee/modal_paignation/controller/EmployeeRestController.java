package com.zikozee.modal_paignation.controller;

import com.zikozee.modal_paignation.model.Employee;
import com.zikozee.modal_paignation.model.SomeDTO;
import com.zikozee.modal_paignation.service.EmployeeDeleteService;
import com.zikozee.modal_paignation.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class EmployeeRestController {

    private final EmployeeService service;
    private final EmployeeDeleteService deleteService;
    private final Environment env;

    @GetMapping("/employeeCustom")
    @ResponseBody//optional, since RestController already contains @ResponseBody
    public List<Employee> employeeCustom(@RequestParam(defaultValue = "") String lastName, @RequestParam(defaultValue = "") String email){
        log.info(env.getProperty("JAVA_HOME"));
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

    @GetMapping("/emailContain")
    @ResponseBody//optional, since RestController already contains @ResponseBody
    public List<SomeDTO> findAllbyEmailContain(@RequestParam(defaultValue = "") String email){
        return service.findAllbyEmailContain(email);
    }

    @GetMapping("/lastNameContain")
    @ResponseBody//optional, since RestController already contains @ResponseBody
    public List<SomeDTO> findAllbylastmeContain(@RequestParam(defaultValue = "") String lastName){
        return service.findAllbyLastNameContain(lastName);
    }


    @DeleteMapping("/deleteByTemplate")
    public SomeDTO delete(String firstName, String lastName){
        return deleteService.deleteByTemplate(firstName, lastName);
    }

    @GetMapping("/listString")
    public List<String> getString(){
        return service.getAllString();
    }

}
