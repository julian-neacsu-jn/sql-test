package com.sql.demo.entity;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Table(name="employee")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer employeeId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name="salary")
    private Double salary;


}