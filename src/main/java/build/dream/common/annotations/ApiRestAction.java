package build.dream.common.annotations;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRestAction {
    Class<? extends BasicModel> modelClass() default BasicModel.class;

    Class<?> serviceClass() default Object.class;

    String serviceMethodName() default "";

    String error() default "";

    boolean zipped() default false;

    boolean signed() default false;

    String datePattern() default Constants.DEFAULT_DATE_PATTERN;
}
