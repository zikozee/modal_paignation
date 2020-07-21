package com.zikozee.modal_paignation.controller;

import com.zikozee.modal_paignation.model.Employee;
import com.zikozee.modal_paignation.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

//    public EmployeeController(EmployeeService service) {
//        this.service = service;
//    }

    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") Long page ){
        model.addAttribute("data", service.findAll(PageRequest.of(page.intValue(), 4)));
        model.addAttribute("currentPage", page);
        return "index";
    }

    @PostMapping("/save")
    public String save(Employee employee){
        service.save(employee);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        service.delete(id);

        return "redirect:/";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Employee findOne(Long id){
       return service.findOne(id);
    }
}
