package build.dream.common.constraints;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ItemLengthValidator.class})
public @interface ItemLength {
    String message() default "{javax.validation.constraints.ItemLength.message}";

    Class<?>[] groups() default {};

    int min() default 0;

    int max() default Integer.MAX_VALUE;
}
