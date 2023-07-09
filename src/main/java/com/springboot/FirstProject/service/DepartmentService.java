package com.springboot.FirstProject.service;

import com.springboot.FirstProject.entity.Department;
import com.springboot.FirstProject.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

   public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId);

   public Department updateDepartmentById(Long departmentId, Department department);
}
