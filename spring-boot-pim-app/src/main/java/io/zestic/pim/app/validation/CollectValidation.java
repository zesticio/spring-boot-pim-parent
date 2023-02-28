package io.zestic.pim.app.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import io.zestic.pim.app.validation.impl.ProductValidationImpl;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductValidationImpl.class)
public @interface CollectValidation {

  String message() default "Invalid client object";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
