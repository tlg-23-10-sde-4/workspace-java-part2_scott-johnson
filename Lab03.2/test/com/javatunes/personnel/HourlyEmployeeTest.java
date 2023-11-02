package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee emp;
    private HourlyEmployee emp2;



    @Before
    public void setUp() {
        emp = new HourlyEmployee("Amilia", Date.valueOf("2020-06-02"), 25.0, 30.0);
        emp2 = new HourlyEmployee("Amilia", Date.valueOf("2020-06-02"), 25.0, 30.0);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameRate_sameHours() {
        emp2.setName("Anna");
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameRate_sameHours() {
        emp2.setHireDate(Date.valueOf("1999-09-09"));
        assertNotEquals(emp, emp2);

    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentRate_sameHours() {
        emp2.setRate(15.0);
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_sameRate_differentHours() {
        emp2.setHours(45.0);
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_AllPropertiesSame() {
        assertEquals(emp, emp2);
    }

    @Test
    public void testPay() {
        assertEquals(750, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(187.5, emp.payTaxes(), .001);
    }
}