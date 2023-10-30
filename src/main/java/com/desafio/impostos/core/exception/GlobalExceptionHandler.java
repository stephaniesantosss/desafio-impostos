package com.desafio.impostos.core.exception;

import com.desafio.impostos.core.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var errorMessage = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(
                e -> errorMessage.put(e.getField(), e.getDefaultMessage()));

        return new ResponseEntity<>(new ErrorResponse(
                BAD_REQUEST.value(),
                BAD_REQUEST.name(),
                errorMessage.toString()), BAD_REQUEST);
    }
}
