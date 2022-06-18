package com.example.servicesmodule.Resources;

import com.example.servicesmodule.Entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class DeleteStudentResource {

    private final RestTemplate restTemplate;

    @DeleteMapping("/{id}/delete-account")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        restTemplate.delete("http://localhost:8081/students/{id}", id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
