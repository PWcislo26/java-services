package com.example.studentsmodule.Resources;

import com.example.studentsmodule.Entities.Application;
import com.example.studentsmodule.Entities.Student;
import com.example.studentsmodule.Repository.ApplicationRepo;
import com.example.studentsmodule.Repository.StudentRepo;
import com.example.studentsmodule.Services.StudentService;
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

    final
    ApplicationRepo applicationRepo;

    public StudentResource(StudentService studentService, StudentRepo studentRepo, ApplicationRepo applicationRepo) {
        this.studentService = studentService;
        this.studentRepo = studentRepo;
        this.applicationRepo = applicationRepo;
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

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        Optional<Student> studentById = studentRepo.findById(id);
        if(studentById.isPresent()){
            studentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


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

    @PostMapping("/students/{id}/applications")
    public ResponseEntity createApplication(@RequestBody Application application){
        applicationRepo.saveAndFlush(application);
        return new ResponseEntity<>(HttpStatus.OK);
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

    @PutMapping("/students/{id}/applications/{applicationId}")
    public ResponseEntity cancelApplication(@PathVariable Long id, @PathVariable Long applicationId,
                                            @RequestBody Application applicationDetails ){
        Optional<Student> studentById = studentRepo.findById(id);
        Optional<Application> applicationById = applicationRepo.findById(applicationId);
        if(studentById.isPresent() && applicationById.isPresent()){
            Application application = applicationById.get();
            application.setStatus(applicationDetails.getStatus());
            applicationRepo.save(application);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
