package build.dream.common.utils;

import org.springframework.data.redis.core.StringRedisTemplate;

public class QueueUtils {
    private static StringRedisTemplate stringRedisTemplate;

    private static StringRedisTemplate obtainStringRedisTemplate() {
        if (stringRedisTemplate == null) {
            stringRedisTemplate = ApplicationHandler.getBean(StringRedisTemplate.class);
        }
        return stringRedisTemplate;
    }

    public static void convertAndSend(String channel, String message) {
        obtainStringRedisTemplate().convertAndSend(channel, message);
    }
}
