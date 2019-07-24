package build.dream.common.redis;

import build.dream.common.constants.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CommonRedisCondition implements Condition {
    private Environment environment;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        environment = context.getEnvironment();

        if (containsProperty(Constants.COMMON_REDIS_HOST) && containsProperty(Constants.COMMON_REDIS_PORT) && containsProperty(Constants.COMMON_REDIS_PASSWORD)) {
            return true;
        }

        return false;
    }

    private boolean containsProperty(String key) {
        return StringUtils.isNotBlank(environment.getProperty(key));
    }
}
