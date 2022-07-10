package com.example.spring.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {

    @Test
    void ver() {
        System.out.println("in ver");
        assertEquals("abc","abc");
    }

    @Test
    void root() {
        System.out.println("in root");
    }

    @Test
    void greet() {
        System.out.println("in greet");
    }
}