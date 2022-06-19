package com.example.servicesmodule.Entities;

import lombok.*;

import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Application {
    private Long id;
    private Long studentId;
    private String type;
    private String description;
    private String status;
    private LocalDate date;

    public Application(Long studentId, String type, String description){
        this.studentId = studentId;
        this.type = type;
        this.description = description;
        this.status = "Sent";
        this.date = LocalDate.now();
    }

    public Application(String status){
        this.status = status;
    }
}
