package com.springboot.FirstProject.controller;

import com.springboot.FirstProject.entity.Department;
import com.springboot.FirstProject.error.DepartmentNotFoundException;
import com.springboot.FirstProject.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department)
    {
        LOGGER.info("Inside saveDepartment of Department Controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartment()
    {
        return departmentService.fetchDepartment();
    }

    @GetMapping("/department/{id}")
    public Department fetchDepartmentById (@PathVariable("id") Long departmentId) throws DepartmentNotFoundException
    {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!!";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @Valid @RequestBody Department department)
    {
        return departmentService.updateDepartmentById(departmentId,department);
    }
}
