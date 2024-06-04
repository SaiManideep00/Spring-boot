package com.example.Springbootdemo.service;


import com.example.Springbootdemo.entity.Department;
import com.example.Springbootdemo.error.DepartmentNotFoundException;
import com.example.Springbootdemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department dept) {
        return departmentRepository.save(dept);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent())
            throw new DepartmentNotFoundException("Department Not Found");
        else
            return department.get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "Deleted Successfully";
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department dept) {
        Department deptDB=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(dept.getDepartmentName()) && !"".equalsIgnoreCase(dept.getDepartmentName()))
        {
            deptDB.setDepartmentName(dept.getDepartmentName());
        }
        if(Objects.nonNull(dept.getDepartmentAddress()) && !"".equalsIgnoreCase(dept.getDepartmentAddress()))
        {
            deptDB.setDepartmentAddress(dept.getDepartmentAddress());
        }
        if(Objects.nonNull(dept.getDepartmentCode()) && !"".equalsIgnoreCase(dept.getDepartmentCode()))
        {
            deptDB.setDepartmentCode(dept.getDepartmentCode());
        }
        return  departmentRepository.save(deptDB);
    }

    @Override
    public Department getDepartmentByName(String deptName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(deptName);
    }
}
