package build.dream.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application extends ClassLoader {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
