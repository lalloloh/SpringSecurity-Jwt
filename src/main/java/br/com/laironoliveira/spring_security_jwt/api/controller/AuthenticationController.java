package br.com.laironoliveira.spring_security_jwt.api.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.laironoliveira.spring_security_jwt.domain.service.AuthenticationService;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("authenticate")
public class AuthenticationController {
    
    private AuthenticationService authenticationService;

    @PostMapping()
    public String authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }
    
}
