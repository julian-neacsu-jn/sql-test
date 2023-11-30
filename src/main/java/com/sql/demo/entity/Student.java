package com.sql.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int age;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String address;
}
