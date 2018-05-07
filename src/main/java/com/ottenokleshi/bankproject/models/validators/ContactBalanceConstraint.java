package com.ottenokleshi.bankproject.models.validators;

import javax.validation.*;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactBalanceValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactBalanceConstraint {
    String message() default "Invalid balance";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}