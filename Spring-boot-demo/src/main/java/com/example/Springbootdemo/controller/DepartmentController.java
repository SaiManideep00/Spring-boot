package com.example.Springbootdemo.controller;

import com.example.Springbootdemo.entity.Department;
import com.example.Springbootdemo.error.DepartmentNotFoundException;
import com.example.Springbootdemo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.DefaultPersistenceDelegate;
import java.util.List;
@RestController
public class DepartmentController {
    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService departmentService;
@PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department dept)
{
    return departmentService.saveDepartment(dept);
}

@GetMapping("/departments")
    public List<Department> getDepartments()
{
    return  departmentService.getDepartments();
}

@GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
    return departmentService.getDepartmentById(departmentId);
}

@DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
{
    return departmentService.deleteDepartmentById(departmentId);
}

@PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department dept){
    return departmentService.updateDepartmentById( departmentId,dept );
}

@GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String deptName)
{
    return  departmentService.getDepartmentByName(deptName);
}
}
