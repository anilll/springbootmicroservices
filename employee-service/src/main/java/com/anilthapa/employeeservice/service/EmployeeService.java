package com.anilthapa.employeeservice.service;

import com.anilthapa.employeeservice.model.Employee;
import com.anilthapa.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee){
        return repository.addEmployee(employee);
    }

    public Employee findById(Long id){
        return repository.findById(id);
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public List<Employee> findByDepartmentId(Long departmentId){
        return repository.findByDepartmentId(departmentId);
    }
}
