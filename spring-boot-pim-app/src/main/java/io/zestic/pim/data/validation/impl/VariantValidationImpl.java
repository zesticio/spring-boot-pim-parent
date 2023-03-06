package io.zestic.pim.data.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import io.zestic.pim.api.product.VariantModel;
import io.zestic.pim.data.validation.VariantValidation;

public class VariantValidationImpl implements ConstraintValidator<VariantValidation, VariantModel> {

  @Override
  public boolean isValid(VariantModel variant, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
