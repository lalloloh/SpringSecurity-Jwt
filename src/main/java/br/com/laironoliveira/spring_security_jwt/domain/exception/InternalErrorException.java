package br.com.laironoliveira.spring_security_jwt.domain.exception;

public class InternalErrorException extends RuntimeException {
    
    public InternalErrorException(String message) {
        super(message);
    }
}
