package br.com.laironoliveira.spring_security_jwt.api.exception.handler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.laironoliveira.spring_security_jwt.domain.exception.BusinessException;
import br.com.laironoliveira.spring_security_jwt.domain.exception.EntityNotFoundException;
import br.com.laironoliveira.spring_security_jwt.domain.exception.InternalErrorException;
import br.com.laironoliveira.spring_security_jwt.domain.exception.UnauthorizedException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {

        List<ApiException.Field> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(fieldError -> new ApiException.Field(fieldError.getField(), fieldError.getDefaultMessage()))
				.collect(Collectors.toList());

        ApiException exception = new ApiException(status.value(), OffsetDateTime.now(), "Falha na validação", errors);

        return handleExceptionInternal(ex, exception, headers, status, request);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleHandlerMethodValidationException(@NonNull HandlerMethodValidationException ex,
            @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        
        List<ApiException.Field> errors = ex.getAllErrors()
            .stream()
            .filter(error -> error instanceof FieldError)
            .map(error -> new ApiException.Field(((FieldError) error).getField(), error.getDefaultMessage()))
            .collect(Collectors.toList());
        
        ApiException exception = new ApiException(status.value(), OffsetDateTime.now(), "Falha na validação", errors);

        return new ResponseEntity<>(exception, new HttpHeaders(), status);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiException exception = new ApiException(status.value(), OffsetDateTime.now(), ex.getMessage(), null);
        return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiException exception = new ApiException(status.value(), OffsetDateTime.now(), ex.getMessage(), null);
        return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException ex, WebRequest request){
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ApiException exception = new ApiException(status.value(), OffsetDateTime.now(), ex.getMessage(), null);
        return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(InternalErrorException.class)
    protected ResponseEntity<Object> handleInternalErrorException(InternalErrorException ex, WebRequest request){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiException exception = new ApiException(status.value(), OffsetDateTime.now(), ex.getMessage(), null);
        return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
    }
}
