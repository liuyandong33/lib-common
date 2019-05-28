package build.dream.common.annotations;

import build.dream.common.orm.IdGenerator;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Id {
    /**
     * 主键生成策略
     *
     * @return
     */
    GenerationStrategy strategy() default GenerationStrategy.AUTO_INCREMENT;

    /**
     * ID 生成器 Class
     *
     * @return
     */
    Class<? extends IdGenerator> idGeneratorClass() default IdGenerator.class;
}
