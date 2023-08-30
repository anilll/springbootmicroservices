package com.anilthapa.departmentservice.repository;

import com.anilthapa.departmentservice.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class DepartmentRepository {

    List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department){
        log.info("Inside addDepartment method in repository layer {}",department);
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        log.info("Inside findById method in repository layer {}",id);
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll(){
        log.info("Inside findAll method in repository layer");
        return departments;
    }

}
