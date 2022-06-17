package com.example.servicesmodule.Resources;

import com.example.servicesmodule.Entities.Application;
import com.example.servicesmodule.Requests.CancelApplicationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class CancelApplicationResource {

    private final RestTemplate restTemplate;


    @PutMapping("/my-applications/cancel")
    public ResponseEntity cancelApplication(@RequestBody CancelApplicationRequest cancelApplicationRequest){
        Application application = new Application(cancelApplicationRequest.getId(),
                cancelApplicationRequest.getStudentId(), cancelApplicationRequest.getStatus());
        String url = String.format("http://localhost:8081/students/%x/applications/%x",
                cancelApplicationRequest.getStudentId(), cancelApplicationRequest.getId());
        restTemplate.put(url, application);
        return new ResponseEntity(HttpStatus.OK);
    }
}
