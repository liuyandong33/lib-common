package build.dream.common.server;

import build.dream.common.constants.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class HttpCondition implements Condition {
    private Environment environment;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        environment = context.getEnvironment();
        if (containsProperty(Constants.SERVER_SSL_PROTOCOL)
                && containsProperty(Constants.SERVER_SSL_KEY_STORE)
                && containsProperty(Constants.SERVER_SSL_KEY_STORE_PASSWORD)
                && containsProperty(Constants.SERVER_SSL_KEY_STORE_TYPE)
                && containsProperty(Constants.SERVER_SSL_KEY_ALIAS)
                && containsProperty(Constants.SERVER_HTTP_PORT)) {
            return true;
        }
        return false;
    }

    private boolean containsProperty(String key) {
        return StringUtils.isNotBlank(environment.getProperty(key));
    }
}
