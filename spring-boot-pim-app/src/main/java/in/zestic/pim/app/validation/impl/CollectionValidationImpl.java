package in.zestic.pim.app.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import in.zestic.pim.api.catalog.Collection;
import in.zestic.pim.api.product.Image;
import in.zestic.pim.app.validation.CollectionValidation;
import in.zestic.pim.app.validation.ImageValidation;

public class CollectionValidationImpl implements ConstraintValidator<CollectionValidation, Collection> {

  @Override
  public boolean isValid(Collection collection, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
