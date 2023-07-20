package io.zestic.pim.app.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import io.zestic.pim.api.product.ProductModel;
import io.zestic.pim.app.validation.ProductValidation;

public class ProductValidationImpl implements ConstraintValidator<ProductValidation, ProductModel> {

  @Override
  public boolean isValid(ProductModel product, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
