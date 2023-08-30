package com.anilthapa.employeeservice.repository;

import com.anilthapa.employeeservice.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class EmployeeRepository {

    List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee){
        log.info("addEmployee method inside repository layer {}",employee);
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll(){
        return employees;
    }

    public List<Employee> findByDepartmentId(Long departmentId){
        return employees.stream()
                .filter(employee -> employee.departmentId().equals(departmentId))
                .toList();
    }
}
