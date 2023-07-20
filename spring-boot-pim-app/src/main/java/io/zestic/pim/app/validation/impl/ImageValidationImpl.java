package io.zestic.pim.app.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import io.zestic.pim.api.product.ImageModel;
import io.zestic.pim.app.validation.ImageValidation;

public class ImageValidationImpl implements ConstraintValidator<ImageValidation, ImageModel> {

  @Override
  public boolean isValid(ImageModel image, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
