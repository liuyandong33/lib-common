package build.dream.common.annotations;

import build.dream.common.orm.IdGenerator;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GeneratedValue {
    /**
     * 主键生成策略
     *
     * @return
     */
    GenerationType strategy();

    String sql() default "";

    Class<? extends IdGenerator> idGenerator() default IdGenerator.class;
}
