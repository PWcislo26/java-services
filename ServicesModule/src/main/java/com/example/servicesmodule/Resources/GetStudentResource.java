package com.example.servicesmodule.Resources;

import com.example.servicesmodule.Entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class GetStudentResource {

    private final RestTemplate restTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return restTemplate.getForEntity("http://localhost:8081/students/{id}", Student.class, id );
    }
}
