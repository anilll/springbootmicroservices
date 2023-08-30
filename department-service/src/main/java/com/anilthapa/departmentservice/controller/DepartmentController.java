package com.anilthapa.departmentservice.controller;

import com.anilthapa.departmentservice.client.FeignServiceClient;
import com.anilthapa.departmentservice.model.Department;
import com.anilthapa.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Autowired
    FeignServiceClient feignServiceClient;

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return service.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Department> findAll(){
        return service.findAll();
    }

    @GetMapping("/WithEmployees")
    public List<Department> findByDepartmentIdWithEmployee(){
        List<Department> departments = service.findAll();
        departments.forEach(
                        department -> department.setEmployees(feignServiceClient.findByDepartmentId(department.getId())));
                return departments;
        }

    }
