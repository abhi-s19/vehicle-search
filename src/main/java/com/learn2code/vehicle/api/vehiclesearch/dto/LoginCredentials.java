package com.learn2code.vehicle.api.vehiclesearch.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginCredentials {

    private String username;
    private String password;
}
