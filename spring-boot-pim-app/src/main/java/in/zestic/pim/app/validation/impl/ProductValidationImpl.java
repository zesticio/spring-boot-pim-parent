package in.zestic.pim.app.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import in.zestic.pim.api.product.Product;
import in.zestic.pim.app.validation.ProductValidation;

public class ProductValidationImpl implements ConstraintValidator<ProductValidation, Product> {

  @Override
  public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
