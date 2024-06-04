package com.example.Springbootdemo.service;

import com.example.Springbootdemo.entity.Department;
import com.example.Springbootdemo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department=Department.builder().departmentName("EM").departmentCode("CV").departmentAddress("NH").build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("EM")).thenReturn(department);
    }
    @Test
    @DisplayName("Test for valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldBeCalled(){
        String departmentName="EM";
        Department found=departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}