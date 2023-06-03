package br.com.arcelino.webfluxcourse.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TrimTextFieldValidator implements ConstraintValidator<TrimTextField, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || value.trim().equals(value);
    }

}
