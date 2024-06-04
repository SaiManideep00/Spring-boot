package com.example.Springbootdemo;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class Student {
    private int rollno;
    private String name;
    private int age;
}
