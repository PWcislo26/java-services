package com.example.servicesmodule.Requests;

import lombok.Getter;

@Getter
public class CancelApplicationRequest {
    private Long id;
    private String status = "Cancelled";

    public CancelApplicationRequest(Long id){
        this.id = id;
    }
}
