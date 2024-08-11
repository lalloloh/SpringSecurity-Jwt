package br.com.laironoliveira.spring_security_jwt.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.laironoliveira.spring_security_jwt.domain.service.AuthenticationService;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class AuthenticationController {
    
    private AuthenticationService authenticationService;

    @PostMapping("authenticate")
    public String authenticate() {
        return authenticationService.authenticate();
    }
    
}
