package com.example.servicesmodule.Resources;

import com.example.servicesmodule.Entities.Application;
import com.example.servicesmodule.Requests.CancelApplicationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class CancelApplicationResource {

    private final RestTemplate restTemplate;


    @PutMapping("/{id}/my-applications/{applicationId}/cancel")
    public ResponseEntity cancelApplication(@PathVariable Long id, @PathVariable Long applicationId){
        Application application = new Application("Cancelled");
        String url = String.format("http://localhost:8081/students/%x/applications/%x",
                id, applicationId);
        restTemplate.put(url, application);
        return new ResponseEntity(HttpStatus.OK);
    }
}
