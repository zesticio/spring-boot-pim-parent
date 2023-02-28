package io.zestic.pim.app.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import io.zestic.pim.api.product.Image;
import io.zestic.pim.app.validation.ImageValidation;

public class ImageValidationImpl implements ConstraintValidator<ImageValidation, Image> {

  @Override
  public boolean isValid(Image image, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
