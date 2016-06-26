package com.ttech.controller;

import com.ttech.model.Employee;
import com.ttech.model.Status;
import com.ttech.persistance.EmployeeDataEngine;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by T on 19/06/2016.
 */
@RestController
public class EmployeeController {

    EmployeeDataEngine employeeDataEngine = EmployeeDataEngine.getEmployeeDataEngineInstance();

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees(){

        return employeeDataEngine.getAllEmployees();
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@PathVariable int id) {

        return employeeDataEngine.getEmployeeById(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Status> addEmployee(@RequestBody Employee employee ) {

        employeeDataEngine.addEmployee(employee);

        Status status = new Status();
        //:TODO - Validate that employee has been successfully added
        status.setStatusCode(200);
        status.setMessage("Successfully added new employee");

        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }


}
