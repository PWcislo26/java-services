package com.example.servicesmodule.Requests;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String pesel;
}
