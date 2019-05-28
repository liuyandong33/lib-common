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
    GenerationStrategy strategy();

    /**
     * ID 生成器 Class
     *
     * @return
     */
    Class<? extends IdGenerator> idGeneratorClass() default IdGenerator.class;
}
