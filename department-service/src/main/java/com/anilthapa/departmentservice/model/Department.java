package com.anilthapa.departmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
}
