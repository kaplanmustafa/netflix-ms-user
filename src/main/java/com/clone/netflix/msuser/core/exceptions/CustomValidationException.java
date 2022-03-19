package com.clone.netflix.msuser.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomValidationException extends RuntimeException {

    private Map<String, String> validationErrors;

    @Override
    public String toString() {
        return "CustomValidationException{" +
                "validationErrors=" + validationErrors +
                '}';
    }
}
