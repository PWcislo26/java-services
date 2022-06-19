package com.example.studentsmodule.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Applications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicationId")
    Long id;
    @Column(name = "studentId")
    Long studentId;
    @Column
    String type;
    @Column
    String description;
    @Column
    String status = "sent";
    @Column
    LocalDate date = LocalDate.now();

    public Application(Long studentId, String type, String description){
        this.studentId = studentId;
        this.type = type;
        this.description = description;
    }
}
