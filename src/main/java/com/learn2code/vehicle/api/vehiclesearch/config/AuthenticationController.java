package com.learn2code.vehicle.api.vehiclesearch.config;

import com.learn2code.vehicle.api.vehiclesearch.dto.LoginCredentials;
import com.learn2code.vehicle.api.vehiclesearch.security.JwtUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired
    private JwtUtill jwtUtill;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping
    public ResponseEntity<Object> generateJwt(@RequestBody LoginCredentials credentials){

        String username = credentials.getUsername();
        String password = credentials.getPassword();
        Map<String,Object> respMap = new HashMap<>();

        if(username!=null && !username.isEmpty() && password!=null && !password.isEmpty()){

            UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
            String jwtToken = jwtUtill.generateToken(userDetails);
            respMap.put("status","success");
            respMap.put("jwt",jwtToken);
            return new ResponseEntity<>(respMap, HttpStatus.OK);
        }
        throw new UsernameNotFoundException("Please enter valid credentials");
    }
}
