package com.example.webbe.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DobValidator.class)
public @interface DobConstraint {

    String message() default "Ngày sinh không hợp lệ dobstraint";

    int min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
