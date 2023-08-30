package com.anilthapa.departmentservice.client;

import com.anilthapa.departmentservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="feign", url = "http://localhost:8060")
public interface FeignServiceClient {

    @GetMapping("/employees/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable("departmentId") Long departmentId);
}
