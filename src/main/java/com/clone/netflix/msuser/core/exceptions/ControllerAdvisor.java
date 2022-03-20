package com.clone.netflix.msuser.core.exceptions;

import com.clone.netflix.msuser.core.results.error.ErrorDataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ControllerAdvisor {

    private static final String VERIFICATION_FAILED_MESSAGE = "Verification Failed!";

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<>(validationErrors, VERIFICATION_FAILED_MESSAGE);
        log.error("TID: " + errorDataResult.getTid() + " Ex: " + exceptions.getLocalizedMessage());

        return errorDataResult;
    }

    @ExceptionHandler(value = CustomValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleCustomValidationException(CustomValidationException exceptions) {
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<>(exceptions.getValidationErrors(), VERIFICATION_FAILED_MESSAGE);
        log.error("TID: " + errorDataResult.getTid() + " Ex: " + exceptions.getValidationErrors());

        return errorDataResult;
    }
}
