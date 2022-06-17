package com.example.servicesmodule.Entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private List<Application> applications;

    public Student(String firstName, String lastName, String pesel){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.applications = new ArrayList<>();
    }
}
