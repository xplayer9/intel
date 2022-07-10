package com.example.spring.controller;

import com.example.spring.dto.MyDto;
import com.example.spring.dto.StockDTO;
import com.example.spring.repository.DbRep;
import com.example.spring.service.CsvDataService;
import com.example.spring.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
    @Autowired
    DbRep rep;
    @Autowired
    MyService ser;

    @Autowired
    CsvDataService csvService;

    @GetMapping("/ver")
    public String ver(){
        return "1.1.1.1 " + ser.getAnswer();
    }

    @GetMapping("/")
    public String root(){
        return "This is root";
    }

    @GetMapping("/greet")
    public String greet(){
        System.out.println("First Page");
        StringBuilder sb = new StringBuilder();
        MyDto me = new MyDto();
        me.setName("Justin");
        sb.append("Hello ").append(me.getName()).append("<br>");
        for(StockDTO s:rep.findAll())
            sb.append(s.getStock()).append("<br>");
        return sb.toString();
    }


    @GetMapping("/covid")
    public String covid() {
        return csvService.getData();
    }

    public int addNumber(int a, int b){
        long ans = (long)a+b;
        if(ans>Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            throw new ArithmeticException("Number over range");
        return (int)ans;
    }
}
