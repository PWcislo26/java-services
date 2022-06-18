package com.example.servicesmodule.Resources;

import com.example.servicesmodule.Entities.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetApplicationsResource {

    private final RestTemplate restTemplate;

    @GetMapping("/{id}/my-applications")
    public ResponseEntity<List> getApplications(@PathVariable Long id){
        return restTemplate.getForEntity("http://localhost:8081/students/{id}/applications", List.class, id);
    }

    @GetMapping("{id}/my-applications/{applicationId}")
    public Object getApplication(@PathVariable Long id, @PathVariable Long applicationId){
        Object application = restTemplate.getForObject("http://localhost:8081/students/{id}/applications/{applicationId}",
                Object.class,id,applicationId);
        return application;
    }

}
