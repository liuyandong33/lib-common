package build.dream.common.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SQLType {
    String value() default "";
    String length() default "";
    boolean notNull() default false;
    boolean autoIncrement() default false;
    boolean unique() default false;
    boolean primaryKey() default false;
    String defaultValue() default "";
    String onUpdate() default "";
    String comment() default "";
}
