package io.zestic.pim.data.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import io.zestic.pim.api.product.Product;
import io.zestic.pim.data.validation.ProductValidation;

public class ProductValidationImpl implements ConstraintValidator<ProductValidation, Product> {

  @Override
  public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
