package build.dream.common.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {InListValidator.class})
public @interface InList {
    String[] value();

    String message() default "{javax.validation.constraints.InList.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
