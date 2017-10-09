package build.dream.common;

import build.dream.common.listeners.BasicHttpSessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.SessionEventHttpSessionListenerAdapter;

import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public SessionEventHttpSessionListenerAdapter sessionEventHttpSessionListenerAdapter() {
        List<HttpSessionListener> listeners = new ArrayList<HttpSessionListener>();
        listeners.add(new BasicHttpSessionListener());
        SessionEventHttpSessionListenerAdapter sessionEventHttpSessionListenerAdapter = new SessionEventHttpSessionListenerAdapter(listeners);
        return sessionEventHttpSessionListenerAdapter;
    }
}
