package build.dream.common.annotations;

import build.dream.common.models.BasicModel;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JsonSchema {
    String value() default "";
}
