package build.dream.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;
import java.util.Set;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(Application.class, args);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchema jsonSchema = JsonSchemaFactory.getInstance().getSchema("{\"type\":\"object\",\"properties\": {\"name\": {\"type\":\"string\",\"minLength\": 2,\"maxLength\": 3}},\"required\":[\"name\"]}");
        Set<ValidationMessage> aa =  jsonSchema.validate(objectMapper.readTree("{\"name\": \"啊\"}"), objectMapper.readTree("{\"name\": \"啊\"}"), "aaa");
        int a = 100;
    }
}
