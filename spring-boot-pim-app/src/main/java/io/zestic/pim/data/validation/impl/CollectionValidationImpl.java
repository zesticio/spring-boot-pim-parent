package io.zestic.pim.data.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import io.zestic.pim.api.catalog.CollectionModel;
import io.zestic.pim.data.validation.CollectionValidation;

public class CollectionValidationImpl implements ConstraintValidator<CollectionValidation, CollectionModel> {

  @Override
  public boolean isValid(CollectionModel collection, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
