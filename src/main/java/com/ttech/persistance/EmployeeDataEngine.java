package com.ttech.persistance;

import com.ttech.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by T on 19/06/2016.
 */
public class EmployeeDataEngine {

    private EmployeeDataEngine(){};

    private static EmployeeDataEngine employeeDataEngine = null;

    public static EmployeeDataEngine getEmployeeDataEngineInstance() {

        if(employeeDataEngine == null) {
            return new EmployeeDataEngine();
        }
        else {
            return employeeDataEngine;
        }
    }

    private static ConcurrentHashMap<Integer, Employee> employeeHashMap = new ConcurrentHashMap<>();

    /**
     *
     * @return employeeList
     */
    public List<Employee> getAllEmployees() {

        ArrayList employeeList = new ArrayList();
        employeeHashMap.forEach((k, v) -> employeeList.add(v));
        return employeeList;
    }

    /**
     *
     * @param id
     * @return employee
     */
    public Employee getEmployeeById(Integer id) {
        return employeeHashMap.get(id);
    }

    /**
     *
     * @param employee
     */
    public synchronized void addEmployee(Employee employee) {

        final int key = employeeHashMap.size() + 1;
        employee.setEmpId(key);
        employeeHashMap.put(key, employee);

    }

    public void removeAllEmployees() {

        employeeHashMap.clear();
    }
}
