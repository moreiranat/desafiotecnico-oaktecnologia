package com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.dto.ErrorDTO;

@RestControllerAdvice
public class ValidationErrorHandler {
	
	@Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<ErrorDTO> dtos = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorDTO error = new ErrorDTO(e.getField(), message);
            dtos.add(error);
        });

        return ResponseEntity.status(exception.getStatusCode()).body(dtos);
    }

}
