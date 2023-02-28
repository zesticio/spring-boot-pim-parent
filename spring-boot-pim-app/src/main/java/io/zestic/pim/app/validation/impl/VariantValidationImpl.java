package io.zestic.pim.app.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import io.zestic.pim.api.product.Variant;
import io.zestic.pim.app.validation.VariantValidation;

public class VariantValidationImpl implements ConstraintValidator<VariantValidation, Variant> {

  @Override
  public boolean isValid(Variant variant, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
