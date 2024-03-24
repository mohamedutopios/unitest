package org.example;

import org.junit.jupiter.api.*;

public class MonTest {


    @BeforeAll
    static void initAll(){
        System.out.println("beforeAll");
    }


    @BeforeEach
    void init(){
        System.out.println("beforeEach");
    }


    @AfterEach
    void tearDown(){
        System.out.println("AfterEach");
    }


    @AfterAll
    static void tearDownAll(){
        System.out.println("AfterAll");
    }


    @Test
    @DisplayName("premier test")
    void simpleTest(){
        System.out.println("Simple test 1");
        Assertions.assertTrue(true);
    }


    @Test
    @DisplayName("Second test")
    void simpleTest2(){

        System.out.println("Simple test 2 ");
        Assertions.assertTrue(true,"toujours true");
    }


}
