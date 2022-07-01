package com.example.spring.controller;

import com.example.spring.dto.MyDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/ver")
    public String ver(){
        return "1.1.1.1";
    }

    @GetMapping("/")
    public String root(){
        return "This is root";
    }

    @GetMapping("/greet")
    public String greet(){
        System.out.println("First Page");
        MyDto dto = new MyDto();
        dto.setName("Justin");
        return "Hello " + dto.getName();
    }
}
