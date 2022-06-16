package com.example.studentsmodule.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long studentId;
    String type;
    String description;
    String status;

    public Application(Long studentId, String type, String description){
        this.studentId = studentId;
        this.type = type;
        this.description = description;
        this.status = "Sent";
    }
}
