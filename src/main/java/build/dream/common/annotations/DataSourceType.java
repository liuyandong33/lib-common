package build.dream.common.annotations;

import build.dream.common.constants.Constants;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceType {
    int type() default Constants.DATA_SOURCE_TYPE_WRITE;
}
