package io.zestic.pim.data.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import io.zestic.pim.api.catalog.CollectModel;
import io.zestic.pim.data.validation.CollectValidation;

public class CollectValidationImpl implements ConstraintValidator<CollectValidation, CollectModel> {

  @Override
  public boolean isValid(CollectModel collect, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
