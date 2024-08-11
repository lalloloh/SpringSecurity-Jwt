package br.com.laironoliveira.spring_security_jwt.domain.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    public String authenticate(){
        return "token";
    }
}
