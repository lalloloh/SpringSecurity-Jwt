package br.com.laironoliveira.spring_security_jwt.domain.exception;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message) {
        super(message);
    }
    
}
