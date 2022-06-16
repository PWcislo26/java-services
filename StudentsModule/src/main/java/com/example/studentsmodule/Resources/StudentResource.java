package com.example.studentsmodule.Resources;

import com.example.studentsmodule.Entities.Student;
import com.example.studentsmodule.Repository.StudentRepo;
import com.example.studentsmodule.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController("/")
public class StudentResource {

    final
    StudentService studentService;

    final
    StudentRepo studentRepo;

    public StudentResource(StudentService studentService, StudentRepo studentRepo) {
        this.studentService = studentService;
        this.studentRepo = studentRepo;
    }

    @GetMapping("/students")
    public ResponseEntity<List> getStudents(@RequestParam(name = "firstName", required = false) String firstName,
                                            @RequestParam(name = "lastName", required = false) String lastName){
        if(firstName != null && lastName != null){
            return new ResponseEntity(studentRepo.findAllByFirstNameAndLastName(firstName, lastName), HttpStatus.OK);
        }
        if(firstName != null){
            return new ResponseEntity(studentRepo.findAllByFirstName(firstName), HttpStatus.OK);
        }
        if(lastName != null){
            return new ResponseEntity(studentRepo.findAllByLastName(lastName), HttpStatus.OK);
        }

        return new ResponseEntity(studentRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentsByName(@PathVariable Long id){
        Optional<Student> studentById = studentRepo.findById(id);
        if(studentById.isPresent()){
            return new ResponseEntity<>(studentById.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public ResponseEntity createStudent(@RequestBody Student student){
        studentRepo.saveAndFlush(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        studentRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/students/{id}/applications")
    public ResponseEntity<List> getStudentApplications(@PathVariable Long id){
        Optional<Student> studentById = studentRepo.findById(id);
        if(studentById.isPresent()){
            return new ResponseEntity<>(studentById.get().getApplications(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/students/{id}/applications/{applicationId}")
    public ResponseEntity<List> getStudentApplication(@PathVariable Long id, @PathVariable Long applicationId){
        Optional<Student> studentById = studentRepo.findById(id);
        if(studentById.isPresent()){
            return new ResponseEntity<List>(studentById.get().getApplications().stream().filter(application ->
                    Objects.equals(application.getId(), applicationId)).collect(Collectors.toList()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}