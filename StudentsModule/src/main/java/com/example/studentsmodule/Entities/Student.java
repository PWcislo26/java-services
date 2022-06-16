package com.example.studentsmodule.Entities;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "student")
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name= "lastName")
    private String lastName;
    @Column(name = "pesel")
    private String pesel;

    @Nullable
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    List<Application> applications;

    public Student(String firstName, String lastName, String pesel){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }
}
