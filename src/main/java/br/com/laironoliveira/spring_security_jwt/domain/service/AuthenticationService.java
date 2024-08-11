package br.com.laironoliveira.spring_security_jwt.domain.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    
    public String authenticate(Authentication authentication){
        return jwtService.generateToken(authentication);
    }
}
