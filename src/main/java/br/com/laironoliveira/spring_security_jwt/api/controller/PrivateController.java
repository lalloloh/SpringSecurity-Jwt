package br.com.laironoliveira.spring_security_jwt.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("private")
public class PrivateController {
    
    @GetMapping()
    public String getMessage() {
        return "Mensagem provida pela rota privada!";
    }
    
}
