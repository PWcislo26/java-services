package com.example.servicesmodule.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String pesel;
}
