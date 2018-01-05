package build.dream.common.utils;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QueueUtils {
    private static StringRedisTemplate stringRedisTemplate;

    private static StringRedisTemplate obtainStringRedisTemplate() {
        if (stringRedisTemplate == null) {
            stringRedisTemplate = ApplicationHandler.getBean(StringRedisTemplate.class);
        }
        return stringRedisTemplate;
    }

    public static ListOperations<String, String> obtainListOperations() {
        return obtainStringRedisTemplate().opsForList();
    }

    public static void convertAndSend(String channel, String message) {
        obtainStringRedisTemplate().convertAndSend(channel, message);
    }

    public static List<String> lrange(String key, long start, long end) {
        return obtainListOperations().range(key, start, end);
    }

    public static void ltrim(String key, long start, long end) {
        obtainListOperations().trim(key, start, end);
    }

    public static Long llen(String key) {
        return obtainListOperations().size(key);
    }

    public static Long lpush(String key, String value) {
        return obtainListOperations().leftPush(key, value);
    }

    public static Long lpush(String key, String... values) {
        return obtainListOperations().leftPushAll(key, values);
    }

    public static Long lpush(String key, Collection<String> values) {
        return obtainListOperations().leftPushAll(key, values);
    }

    public static Long lpush(String key, String pivot, String value) {
        return obtainListOperations().leftPush(key, pivot, value);
    }

    public static Long lpushx(String key, String value) {
        return obtainListOperations().leftPushIfPresent(key, value);
    }

    public static Long rpush(String key, String value) {
        return obtainListOperations().rightPush(key, value);
    }

    public static Long rpush(String key, String... values) {
        return obtainListOperations().rightPushAll(key, values);
    }

    public static Long rpush(String key, Collection<String> values) {
        return obtainListOperations().rightPushAll(key, values);
    }

    public static Long rpush(String key, String pivot, String value) {
        return obtainListOperations().rightPush(key, pivot, value);
    }

    public static Long rpushx(String key, String value) {
        return obtainListOperations().rightPushIfPresent(key, value);
    }

    public static void lset(String key, long index, String value) {
        obtainListOperations().set(key, index, value);
    }

    public static Long lrem(String key, long count, String value) {
        return obtainListOperations().remove(key, count, value);
    }

    public static String lindex(String key, long index) {
        return obtainListOperations().index(key, index);
    }

    public static String lpop(String key) {
        return obtainListOperations().leftPop(key);
    }

    public static String lpop(String key, long timeout, TimeUnit timeUnit) {
        return obtainListOperations().leftPop(key, timeout, timeUnit);
    }

    public static String rpop(String key) {
        return obtainListOperations().rightPop(key);
    }

    public static String rpop(String key, long timeout, TimeUnit timeUnit) {
        return obtainListOperations().rightPop(key, timeout, timeUnit);
    }

    public static String rpoplpush(String sourceKey, String destinationKey) {
        return obtainListOperations().rightPopAndLeftPush(sourceKey, destinationKey);
    }

    public static String rpoplpush(String sourceKey, String destinationKey, long timeout, TimeUnit timeUnit) {
        return obtainListOperations().rightPopAndLeftPush(sourceKey, destinationKey, timeout, timeUnit);
    }
}
