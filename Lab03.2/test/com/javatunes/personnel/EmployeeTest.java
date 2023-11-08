package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;


    @Before
    public void setUp() {
        //emp1 = new DummyEmployee("Mary", Date.valueOf("2000-02-02"));
        //emp2 = new DummyEmployee("Mary", Date.valueOf("2000-02-02"));
        emp1 = getEmployee();
        emp2 = getEmployee();

    }

    private Employee getEmployee() {
        return new Employee("Mary", Date.valueOf("2000-02-02")) {
            public double pay() {
                return 0;
            }

            public double payTaxes() {
                return 0;
            }
        };
    }
        @Test
        public void equals_shouldReturnFalse_differentName_sameHireDate () {
            emp2.setName("Joey");
            assertNotEquals(emp1, emp2);
        }

        @Test
        public void equals_shouldReturnFalse_sameName_differentHireDate () {
            emp2.setHireDate(Date.valueOf("1999-09-09"));
            assertNotEquals(emp1, emp2);
        }

        @Test
        public void equals_shouldReturnTrue_allPropertiesSame () {
            assertEquals(emp1, emp2);
        }

        //NAMES MEMBER LEVEL INNER CLASSES
        private class DummyEmployee extends Employee {
            public DummyEmployee(String name, Date hireDate) {
                super(name, hireDate);
            }

            // done on one line becuase we dont need these 2 methods to change. but are required
            public double pay() {
                return 0;
            }

            public double payTaxes() {
                return 0;
            }
        }
    }