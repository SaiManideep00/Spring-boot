package com.example.Springbootdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String helloWorld()
    {

        System.out.println("Hello World");
        //return 1;
        return "Hello World";
    }

}
