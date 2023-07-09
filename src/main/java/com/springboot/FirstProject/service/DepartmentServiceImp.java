package com.springboot.FirstProject.service;

import com.springboot.FirstProject.entity.Department;
import com.springboot.FirstProject.error.DepartmentNotFoundException;
import com.springboot.FirstProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);

        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department depDb = departmentRepository.findById(departmentId).get();

        if(!(department.getDepartmentName() == null) && !(department.getDepartmentName() == ""))
        {
            depDb.setDepartmentName(department.getDepartmentName());
        }

        if(!(department.getDepartmentAddress() == null) && !(department.getDepartmentAddress() == ""))
        {
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(!(department.getDepartmentCode() == null) && !(department.getDepartmentCode() == ""))
        {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDb);
    }

}
