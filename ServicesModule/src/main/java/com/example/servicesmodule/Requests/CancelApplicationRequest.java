package com.example.servicesmodule.Requests;

import lombok.Getter;

@Getter
public class CancelApplicationRequest {
    private Long id;
    private Long studentId;
    private String status = "Cancelled";

    public CancelApplicationRequest(Long id, Long studentId){
        this.id = id;
        this.studentId =  studentId;
    }
}
