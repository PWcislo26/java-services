package com.example.servicesmodule.Resources;

import com.example.servicesmodule.Entities.Application;
import com.example.servicesmodule.Requests.CreateApplicationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class CreateApplicationResource {

    private final RestTemplate restTemplate;

    @PostMapping("/{id}/my-applications/create")
    public ResponseEntity createApplication(@PathVariable Long id, @RequestBody CreateApplicationRequest createApplicationRequest){
        Application application = new Application(id, createApplicationRequest.getType()
                , createApplicationRequest.getDescription());
        restTemplate.postForEntity("http://localhost:8081/students/{id}/applications", application,
                ResponseEntity.class, id);
        return new ResponseEntity("Application created", HttpStatus.OK);
    }
}
