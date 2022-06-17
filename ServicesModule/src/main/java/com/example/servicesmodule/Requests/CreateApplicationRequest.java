package com.example.servicesmodule.Requests;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateApplicationRequest {
    private Long studentId;
    private String type;
    private String description;
}
