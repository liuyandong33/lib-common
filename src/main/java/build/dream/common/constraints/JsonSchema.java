package build.dream.common.constraints;

import javax.validation.Payload;

public @interface JsonSchema {
    String value();

    String message() default "{javax.validation.constraints.JsonSchema.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
