package build.dream.common.constraints;

import javax.validation.Payload;

public @interface VerifyJsonSchema {
    String value();

    String message() default "{javax.validation.constraints.VerifyJsonSchema.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
