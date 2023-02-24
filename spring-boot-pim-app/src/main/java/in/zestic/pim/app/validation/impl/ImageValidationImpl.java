package in.zestic.pim.app.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import in.zestic.pim.api.product.Image;
import in.zestic.pim.app.validation.ImageValidation;

public class ImageValidationImpl implements ConstraintValidator<ImageValidation, Image> {

  @Override
  public boolean isValid(Image image, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
