package br.com.laironoliveira.spring_security_jwt.domain.exception;

public class UnauthorizedException extends RuntimeException {
    
    public UnauthorizedException(String message) {
        super(message);
    }
}
