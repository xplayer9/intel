package com.example.spring.controller;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyNumberTest {

    MyController con = null;
    TestInfo info;
    TestReporter repo;

    @BeforeAll
    void init(TestInfo info, TestReporter repo){
        this.info = info;
        this.repo = repo;
        con = new MyController();
    }

    @AfterAll
    void cleanup(){
        System.out.println("Clean Everything");
    }

    @Nested
    class MyTestTrueFalse{
        @Test
        void test_false() {
            assertFalse(2<1);
        }
        @Test
        void test_true() {
            assertTrue(1==1);
        }
    }

    @Test
    @DisplayName("simple test")
    @Disabled
    void test_simple() {
        assumeTrue(true);
        assertEquals(1,1);
    }

    //test can be selected by Tag
    @Test
    @Tag("testAll")
    void test_all() {
        assertAll(
                ()->assertEquals(1,1),
                ()->assertEquals(2,con.addNumber(1,1)),
                ()->assertEquals(8,con.addNumber(2,6)),
                ()->assertEquals(10,10)
        );
    }

    @Test
    @DisplayName("assertThrows test")
    void test_assertThrows() {
        assertThrows(ArithmeticException.class, () -> {
            con.addNumber(Integer.MAX_VALUE,1000);
        });
        //check message if necessary
        //assertEquals("Number over range", exception.getMessage());
    }

    @RepeatedTest(3)
    @DisplayName("assertEqual test")
    void test_assertEqual() {
        repo.publishEntry("Repoter in test_assertEqual");
        //use lambda to improve a little bit
        assertEquals(2, con.addNumber(1,1), ()->"Message if failed");
        int[] arry1 = {1,2,3};
        int[] arry2 = {1,2,3};
        assertArrayEquals(arry1, arry2);
        Iterable<Integer> it1 = new ArrayList<>(List.of(1,2,3));
        Iterable<Integer> it2 = new LinkedList<>(List.of(1,2,3));
        assertIterableEquals(it1, it2);
    }
}