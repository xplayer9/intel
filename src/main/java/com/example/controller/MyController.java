package com.example.controller;

import com.example.dto.MyDto;
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
        return "Hello Spring" + dto.getName();
    }
}
