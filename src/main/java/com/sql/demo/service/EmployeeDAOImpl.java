package com.sql.demo.service;

import com.sql.demo.entity.Employee;
import com.sql.demo.repository.EmployeeRepositoryJPA;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EmployeeRepositoryJPA employeeRepositoryJPA;

    @Autowired
    public EmployeeDAOImpl (EmployeeRepositoryJPA employeeRepositoryJPA){
        this.employeeRepositoryJPA = employeeRepositoryJPA;
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Integer id) {
        return employeeRepositoryJPA.getEmployeeById(id);
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepositoryJPA. save(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepositoryJPA.getAllEmployees();
    }

    @Override
    @Transactional
    public List<Employee> getEmployeesByFirstName(String firstName) {
        return employeeRepositoryJPA.getEmployeeByName(firstName);
    }

    @Override
    @Transactional
    public List<Employee> getEmployeesByLastName(String lastName) {
        return employeeRepositoryJPA.getEmployeesByLastName(lastName);
    }

    @Override
    @Transactional
    public Employee getEmployeeByEmail(String email) {
        return employeeRepositoryJPA.getEmployeeByEmail(email);
    }

    @Override
    @Transactional
    public List<Employee> getEmployeesByLastNameAndFirstName(String lastName, String firstName) {
        return employeeRepositoryJPA.getEmployeeByLastNameAndFirstName(lastName, firstName);
    }

}
