package com.example.studentsmodule.Services;

import com.example.studentsmodule.Entities.Student;
import com.example.studentsmodule.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StudentService {
    final
    StudentRepo studentRepo;


    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents(){return studentRepo.findAll();}

    @PostConstruct
    private void postConstruct(){
        Student student = new Student("Piotr", "Wcislo", "98030602530");
        Student student1 = new Student("Anna", "Gorska", "99050503210");
        Student student2 =  new Student("Piotr", "Nowak", "98");
        studentRepo.save(student);
        studentRepo.save(student1);
        studentRepo.save(student2);
    }
}
