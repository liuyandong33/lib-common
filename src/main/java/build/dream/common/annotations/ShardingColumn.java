package build.dream.common.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ShardingColumn {
    String fieldName();

    String columnName();
}
