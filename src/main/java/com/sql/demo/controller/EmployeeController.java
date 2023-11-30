package com.sql.demo.controller;

import com.sql.demo.entity.Employee;
import com.sql.demo.service.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping(path = "/getEmployee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(employeeDAO.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/saveEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeDAO.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAllEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeDAO.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(path = "/getEmployeesByFirstName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployeesByFirstName(@RequestParam String firstName){
        return new ResponseEntity<>(employeeDAO.getEmployeesByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping(path = "/getEmployeesByLastName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployeesByLastName(@RequestParam String lastName){
        return new ResponseEntity<>(employeeDAO.getEmployeesByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping(path = "/getEmployeeByEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Employee> getEmployeeById(@RequestParam String email){
        return new ResponseEntity<>(employeeDAO.getEmployeeByEmail(email), HttpStatus.OK);
    }

    @GetMapping(path = "/getEmployeesByLastNameAndFirstName", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Employee>> getEmployeesByLastNameAbdFirstName(@RequestParam String lastName, @RequestParam String firstName){
        return new ResponseEntity<>(employeeDAO.getEmployeesByLastNameAndFirstName(lastName, firstName), HttpStatus.OK);
    }

    @GetMapping(path = "/greetings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGreetings() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
