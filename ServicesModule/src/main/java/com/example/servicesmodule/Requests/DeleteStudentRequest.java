package com.example.servicesmodule.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
@AllArgsConstructor
public class DeleteStudentRequest {
    private Long id;
}
