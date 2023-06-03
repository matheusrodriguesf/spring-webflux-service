package br.com.arcelino.webfluxcourse.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = { TrimTextFieldValidator.class })
@Target(ElementType.FIELD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface TrimTextField {

    String message() default "O Campo não pode conter espaços em branco no início ou no fim";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
