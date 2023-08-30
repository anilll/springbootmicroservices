package com.anilthapa.employeeservice.controller;

import com.anilthapa.employeeservice.model.Employee;
import com.anilthapa.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Employee> findAll(){
        return service.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable("departmentId") Long departmentId){
        return service.findByDepartmentId(departmentId);
    }
}
