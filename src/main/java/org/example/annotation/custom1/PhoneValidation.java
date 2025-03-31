package org.example.annotation.custom1;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValid.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneValidation {
    String message() default "Invalid phone number";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
