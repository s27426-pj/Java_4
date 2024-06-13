package zj1.example.zad1.Validation;

import jakarta.validation.*;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CarTypeValidation.class)
public @interface ValidateCarClass {

    public String message() default "Invalid Car Class";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
