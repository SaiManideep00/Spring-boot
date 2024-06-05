package com.example.Springbootdemo.controller;

import com.example.Springbootdemo.entity.Department;
import com.example.Springbootdemo.error.DepartmentNotFoundException;
import com.example.Springbootdemo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp()
    {
        department=Department.builder()
                .departmentId(1L)
                .departmentAddress("WH")
                .departmentName("CEM")
                .departmentCode("5t-0").build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment=Department.builder()
                .departmentAddress("WH")
                .departmentName("CEM")
                .departmentCode("5t-0").build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"CEM\",\n" +
                        "    \"departmentAddress\":\"WH\",\n" +
                        "    \"departmentCode\":\"5t-0\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}