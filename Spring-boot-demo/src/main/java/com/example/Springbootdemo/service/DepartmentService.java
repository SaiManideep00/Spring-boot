package com.example.Springbootdemo.service;


import com.example.Springbootdemo.entity.Department;
import com.example.Springbootdemo.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    public  Department saveDepartment(Department dept);

    public  List<Department> getDepartments();

   public  Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public String deleteDepartmentById(Long departmentId);

   public Department updateDepartmentById(Long departmentId,Department dept );

   public Department getDepartmentByName(String deptName);
}
