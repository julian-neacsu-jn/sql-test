package com.sql.demo.service;

import com.sql.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee getEmployeeById(Integer id);

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    List<Employee> getEmployeesByFirstName(String firstName);

    List<Employee> getEmployeesByLastName(String lastName);

    Employee getEmployeeByEmail (String email);

    List<Employee> getEmployeesByLastNameAndFirstName(String lastName, String firstName);
}
