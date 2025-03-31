package org.example.annotation.custom1;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValid implements ConstraintValidator<PhoneValidation, String> {
    private static final String PHONE_REGEX = "^\\+?[0-9]{10}$";

    @Override
    public void initialize(PhoneValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && Pattern.matches(PHONE_REGEX, s);
    }
}
