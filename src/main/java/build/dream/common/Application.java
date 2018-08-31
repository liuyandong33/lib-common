package build.dream.common;

import build.dream.common.constants.Constants;
import build.dream.common.erp.catering.domains.Coupon;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        Class<?> domainClass = Coupon.class;
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
        code.append("public " + simpleName + " build() {return instance;}");
        code.append("}");

        System.out.println(code.toString());
        System.out.println("public static Builder builder() {return new Builder();}");

        BigDecimal sunQuality = BigDecimal.valueOf(Double.valueOf(1.9891)).multiply(Constants.BIG_DECIMAL_TEN.pow(30));
        System.out.println("太阳质量为：" + sunQuality + "kg");

        BigDecimal earthQuality = BigDecimal.valueOf(Double.valueOf(5.965)).multiply(Constants.BIG_DECIMAL_TEN.pow(24));
        System.out.println("地球质量为：" + earthQuality + "kg");

        System.out.println("太阳的质量为地球质量的" + sunQuality.divide(earthQuality, 10, BigDecimal.ROUND_DOWN) + "倍");

        BigDecimal sunRadius = BigDecimal.valueOf(6.955).multiply(BigDecimal.TEN.pow(8));
        System.out.println("太阳的半径为：" + sunRadius + "m");

        BigDecimal sunVolume = Constants.BIG_DECIMAL_FOUR.multiply(Constants.BIG_DECIMAL_PI).multiply(sunRadius.pow(3)).divide(Constants.BIG_DECIMAL_THREE, 10, BigDecimal.ROUND_DOWN);
        System.out.println("太阳的体积为：" + sunVolume + "m³");

        BigDecimal earthRadius = BigDecimal.valueOf(6371000);
        System.out.println("地球的半径为：" + earthRadius + "m");
        BigDecimal earthVolume = Constants.BIG_DECIMAL_FOUR.multiply(Constants.BIG_DECIMAL_PI).multiply(earthRadius.pow(3)).divide(Constants.BIG_DECIMAL_THREE, 10, BigDecimal.ROUND_DOWN);
        System.out.println("地球的体积为：" + earthVolume + "m³");

        System.out.println("太阳的体积是地球体积的:" + sunVolume.divide(earthVolume, 10, BigDecimal.ROUND_DOWN) + "倍");

        BigDecimal moonQuality = BigDecimal.valueOf(Double.valueOf(7.349)).multiply(Constants.BIG_DECIMAL_TEN.pow(22));
        System.out.println("月球的质量为：" + moonQuality + "kg");

        System.out.println("地球的质量是月球质量的：" + earthQuality.divide(moonQuality, 10, BigDecimal.ROUND_DOWN) + "倍");

        // 冒泡排序法
        int array[] = {4, 1, 2, 5, 6, 9, 8, 66};
        int length = array.length;
        for (int index = 0; index < length - 1; index++) {
            for (int i = 0; i < length - 1 - index; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        for (int index = 0; index < length; index++) {
            System.out.println(array[index]);
        }
    }
}
