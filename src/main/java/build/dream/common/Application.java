package build.dream.common;

import build.dream.common.erp.catering.domains.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        Class<?> domainClass = GoodsUnit.class;
        String simpleName = domainClass.getSimpleName();
        StringBuilder code = new StringBuilder("public static class Builder {private final " + simpleName + " instance = new " + simpleName + "();");
        while (domainClass != Object.class) {
            Field[] fields = domainClass.getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                code.append("public Builder " + name + "(" + field.getType().getSimpleName() + " " + name + ") { instance.set" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(" + name + ");return this;}");
            }
            domainClass = domainClass.getSuperclass();
        }
        code.append("}");

        System.out.println(code.toString());
        System.out.println("public static Builder builder() {return new Builder();}");
    }
}
