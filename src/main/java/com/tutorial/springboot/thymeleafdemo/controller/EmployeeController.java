package com.tutorial.springboot.thymeleafdemo.controller;

import com.tutorial.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //load employee data
    private List<Employee> employees;

    @PostConstruct
    private void loadData(){
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Leslie", "Andrews", "leslie@gmail.com"));
        employees.add(new Employee(2, "Emma", "Baumgarten", "emma@gmail.com"));
        employees.add(new Employee(3, "Awani", "Gupta", "awani@gmail.com"));
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", employees);
        return "list-employees";
    }

}
