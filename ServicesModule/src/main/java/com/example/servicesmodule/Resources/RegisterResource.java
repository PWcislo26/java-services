package com.example.servicesmodule.Resources;

import com.example.servicesmodule.Entities.Student;
import com.example.servicesmodule.Requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class RegisterResource {

    private final RestTemplate restTemplate;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest registerRequest){
        ResponseEntity<Student[]> forEntity = restTemplate.getForEntity("http://localhost:8081/students",
                Student[].class);
        for (Student student : forEntity.getBody()){
            if(student.getFirstName().equals(registerRequest.getFirstName())
                    && student.getLastName().equals(registerRequest.getLastName())
                    && student.getPesel().equals(registerRequest.getPesel())){
                throw new RuntimeException();
            }
        }
        Student student = new Student(registerRequest.getFirstName(), registerRequest.getLastName(), registerRequest.getPesel());
        restTemplate.postForEntity("http://localhost:8081/students", student, ResponseEntity.class);
        return new ResponseEntity(HttpStatus.OK);
    }

}
