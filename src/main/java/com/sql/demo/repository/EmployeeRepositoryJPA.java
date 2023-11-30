package com.sql.demo.repository;

import com.sql.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeRepositoryJPA extends JpaRepository<Employee, Integer> {

    @Procedure("[dbo].[spEmployee_All]")
    List<Employee> getAllEmployees();

    @Procedure("[dbo].[spEmployee_getEmployeeByFirstName]")
    List<Employee> getEmployeeByName(String firstName);

    @Procedure("[dbo].[spEmployee_getEmployeesByLastName]")
    List<Employee> getEmployeesByLastName(String lastName);

    @Procedure("[dbo].[spEmployee_getEmployeeById]")
    Employee getEmployeeById(Integer id);

    @Procedure("[dbo].[spEmployee_getEmployeeByEmail]")
    Employee getEmployeeByEmail(String email);

    @Procedure("[dbo].[spEmpluee_saveEmployee]")
    Employee saveEmployee(Employee employee);

    @Procedure("[dbo].[spEmployee_getByLastNameAndFirstName]")
    List<Employee> getEmployeeByLastNameAndFirstName(String lastName, String firstName);

}
