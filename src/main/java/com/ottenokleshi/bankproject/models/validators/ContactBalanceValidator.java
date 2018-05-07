package com.ottenokleshi.bankproject.models.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ContactBalanceValidator implements
        ConstraintValidator<ContactBalanceConstraint, Integer> {

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer >= 0;
    }
}
