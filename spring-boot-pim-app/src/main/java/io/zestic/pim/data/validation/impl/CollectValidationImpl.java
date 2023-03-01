package io.zestic.pim.data.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import io.zestic.pim.api.catalog.Collect;
import io.zestic.pim.data.validation.CollectValidation;

public class CollectValidationImpl implements ConstraintValidator<CollectValidation, Collect> {

  @Override
  public boolean isValid(Collect collect, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
