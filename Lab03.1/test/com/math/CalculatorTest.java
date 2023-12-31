/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
    // fixture: this is the business object or objects under test
    private Calculator calc;


    @BeforeClass
    public static void initializeTestRun() {
        System.out.println("BeforeClass initializeTestRun()");
    }

    @AfterClass
    public static void finalizeTestRun() {
        System.out.println("AfterClass finalizeTestRun()");
    }

    @Before
    public void setUp() {
        System.out.println("setUp()");
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void testAdd() {
        System.out.println("Tests add()");
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        System.out.println("Tests divide()");
        assertEquals(2.5, calc.divide(5, 2), .001);
    }

    @Test
    public void testIsEven() {
        System.out.println("Tests isEven()");
        assertTrue(calc.isEven(10));
        assertFalse(calc.isEven(11));
    }
}