package com.ttech.persistance;

import com.ttech.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by T on 22/06/2016.
 */
public class EmployeeDataEngineTest {

    private EmployeeDataEngine employeeDataEngine = EmployeeDataEngine.getEmployeeDataEngineInstance();
    private Employee employeeOne;
    private Employee employeeTwo;

    @Before
    public void setUp(){

        employeeOne = new Employee();
        employeeOne.setEmpId(1);
        employeeOne.setName("Tester 1");
        employeeOne.setEmploymentType("Permanent");

        employeeTwo = new Employee();
        employeeTwo.setEmpId(2);
        employeeTwo.setName("Tester 2");
        employeeTwo.setEmploymentType("Contract");

    }

    @After
    public void tearDown(){

        employeeDataEngine.removeAllEmployees();
    }

    @Test
    public void testShouldGetAllEmployees() {

        employeeDataEngine.addEmployee(employeeOne);
        employeeDataEngine.addEmployee(employeeTwo);

        assertThat("Should retrieve 2 Employees", employeeDataEngine.getAllEmployees().size()  , is(equalTo(2)));

    }

    @Test
    public void testShouldGetEmployeeById() {

        employeeDataEngine.addEmployee(employeeOne);
        employeeDataEngine.addEmployee(employeeTwo);

        assertThat("Should find Employee 1", employeeDataEngine.getEmployeeById(1).getEmpId()  , is(equalTo(1)));

    }

}



