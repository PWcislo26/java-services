package com.example.studentsmodule.Entities;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Students")
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long id;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name= "lastName", nullable = false)
    private String lastName;
    @Column(name = "pesel", length = 11)
    private String pesel;

    @Nullable
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    List<Application> applications;

    public Student(String firstName, String lastName, String pesel){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.applications = new ArrayList<>();
    }
}
