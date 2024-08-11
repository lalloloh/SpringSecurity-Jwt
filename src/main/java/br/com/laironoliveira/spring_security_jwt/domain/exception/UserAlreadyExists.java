package br.com.laironoliveira.spring_security_jwt.domain.exception;

public class UserAlreadyExists extends BusinessException {

    public UserAlreadyExists(String message) {
        super(message);
    }
    
}
