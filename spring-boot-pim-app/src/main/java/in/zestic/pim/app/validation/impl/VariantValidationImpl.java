package in.zestic.pim.app.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import in.zestic.pim.api.product.Image;
import in.zestic.pim.api.product.Variant;
import in.zestic.pim.app.validation.ImageValidation;
import in.zestic.pim.app.validation.VariantValidation;

public class VariantValidationImpl implements ConstraintValidator<VariantValidation, Variant> {

  @Override
  public boolean isValid(Variant variant, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
