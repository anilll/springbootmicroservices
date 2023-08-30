package com.anilthapa.departmentservice.service;

import com.anilthapa.departmentservice.model.Department;
import com.anilthapa.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department addDepartment(Department department){
        return repository.addDepartment(department);
    }

    public Department findById(Long id){
        return repository.findById(id);
    }

    public List<Department> findAll(){
        return repository.findAll();
    }


}
