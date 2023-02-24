package in.zestic.pim.app.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import in.zestic.pim.api.catalog.Collect;
import in.zestic.pim.api.product.Image;
import in.zestic.pim.app.validation.CollectValidation;
import in.zestic.pim.app.validation.ImageValidation;

public class CollectValidationImpl implements ConstraintValidator<CollectValidation, Collect> {

  @Override
  public boolean isValid(Collect collect, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
