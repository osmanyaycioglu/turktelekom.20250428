package org.example.spring.cloud.msorder.input.error;

import java.util.stream.Collectors;

import org.example.spring.cloud.msorder.input.models.ErrorResto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResto handleExp(final IllegalArgumentException exp) {
        return ErrorResto.builder()
                         .withErrorDescParam(exp.getMessage())
                         .withErrorCodeParam(1001)
                         .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResto handleExp(final MethodArgumentNotValidException exp) {
        return ErrorResto.builder()
                         .withErrorDescParam("Validation error")
                         .withErrorCodeParam(1002)
                         .withSubErrorsParam(exp.getAllErrors()
                                                .stream()
                                                .map(e -> ErrorResto.builder()
                                                                    .withErrorDescParam(e.toString())
                                                                    .withErrorCodeParam(1003)
                                                                    .build())
                                                .collect(Collectors.toList()))
                         .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResto handleExp(final Exception exp) {
        return ErrorResto.builder()
                         .withErrorDescParam(exp.getMessage())
                         .withErrorCodeParam(5000)
                         .build();
    }

}
