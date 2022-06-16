package com.example.studentsmodule.Services;

import com.example.studentsmodule.Entities.Application;
import com.example.studentsmodule.Entities.Student;
import com.example.studentsmodule.Repository.ApplicationRepo;
import com.example.studentsmodule.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    final
    StudentRepo studentRepo;

    final
    ApplicationRepo applicationRepo;


    public StudentService(StudentRepo studentRepo, ApplicationRepo applicationRepo) {
        this.studentRepo = studentRepo;
        this.applicationRepo = applicationRepo;
    }

    public List<Student> getAllStudents(){return studentRepo.findAll();}

    @PostConstruct
    private void postConstruct(){
        Student student = new Student("Piotr", "Wcislo", "98030602530");
        Student student1 = new Student("Anna", "Gorska", "99050503210");
        Student student2 =  new Student("Piotr", "Nowak", "98");
        studentRepo.save(student);
        Application application = new Application(1L, "Scholarship", "XYZ");
        applicationRepo.save(application);
        studentRepo.save(student1);
        studentRepo.save(student2);
    }
}
