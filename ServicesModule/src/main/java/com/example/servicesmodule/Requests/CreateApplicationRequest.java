package com.example.servicesmodule.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateApplicationRequest {
    private String type;
    private String description;
}
