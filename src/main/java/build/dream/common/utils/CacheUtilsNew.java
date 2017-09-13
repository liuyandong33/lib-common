package build.dream.common.utils;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyandong on 2017/6/16.
 */
public class CacheUtilsNew {
    private static StringRedisTemplate stringRedisTemplate = null;

    public static ValueOperations<String, String> getValueOperations() {
        if (stringRedisTemplate == null) {
            stringRedisTemplate = ApplicationHandler.getBean(StringRedisTemplate.class);
        }
        return stringRedisTemplate.opsForValue();
    }

    public static HashOperations<String, String, String> getHashOperations() {
        if (stringRedisTemplate == null) {
            stringRedisTemplate = ApplicationHandler.getBean(StringRedisTemplate.class);
        }

        return stringRedisTemplate.opsForHash();
    }

    /**
     * SET
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        getValueOperations().set(key, value);
    }

    /**
     * SETEX
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    public static void set(String key, String value, long timeout, TimeUnit unit) {
        getValueOperations().set(key, value, timeout, unit);
    }

    /**
     * SETNX
     * @param key
     * @param value
     * @return
     */
    public static Boolean setIfAbsent(String key, String value) {
        return getValueOperations().setIfAbsent(key, value);
    }

    /**
     * MSET
     * @param map
     */
    public static void multiSet(Map<String, String> map) {
        getValueOperations().multiSet(map);
    }

    /**
     * MSET
     * @param map
     * @return
     */
    public static Boolean multiSetIfAbsent(Map<String, String> map) {
        return getValueOperations().multiSetIfAbsent(map);
    }

    /**
     * GET
     * @param key
     * @return
     */
    public static String get(String key) {
        return getValueOperations().get(key);
    }

    /**
     * GETSET
     * @param key
     * @param value
     * @return
     */
    public static String getAndSet(String key, String value) {
        return getValueOperations().getAndSet(key, value);
    }

    /**
     * MGET
     * @param keys
     * @return
     */
    public static List<String> multiGet(Collection<String> keys) {
        return getValueOperations().multiGet(keys);
    }

    /**
     * INCR
     * @param key
     * @param delta
     * @return
     */
    public static Long increment(String key, long delta) {
        return getValueOperations().increment(key, delta);
    }

    /**
     * INCRBYFLOAT
     * @param key
     * @param delta
     * @return
     */
    public static Double increment(String key, double delta) {
        return getValueOperations().increment(key, delta);
    }

    /**
     * APPEND
     * @param key
     * @param value
     * @return
     */
    public static Integer append(String key, String value) {
        return getValueOperations().append(key, value);
    }

    /**
     * GETRANGE
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static String get(String key, long start, long end) {
        return getValueOperations().get(key, start, end);
    }

    /**
     * SETRANGE
     * @return
     */
    public static void set(String key, String value, long offset) {
        getValueOperations().set(key, value, offset);
    }

    /**
     * STRLEN
     * @param key
     * @return
     */
    public static Long size(String key) {
        return getValueOperations().size(key);
    }

    /**
     * SETBIT
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public static Boolean setBit(String key, long offset, boolean value) {
        return getValueOperations().setBit(key, offset, value);
    }

    /**
     * GETBIT
     * @param key
     * @param offset
     * @return
     */
    public static Boolean getBit(String key, long offset) {
        return getValueOperations().getBit(key, offset);
    }

    public static Long delete(String key, String... hashKeys) {
        return getHashOperations().delete(key, hashKeys);
    }

    public static Boolean hasKey(String key, String hashKey) {
        return getHashOperations().hasKey(key, hashKey);
    }

    public static String get(String key, String hashKey) {
        return getHashOperations().get(key, hashKey);
    }

    public static List<String> multiGet(String key, Collection<String> hashKeys) {
        return getHashOperations().multiGet(key, hashKeys);
    }

    public static Long increment(String key, String hashKey, long delta) {
        return getHashOperations().increment(key, hashKey, delta);
    }

    public static Double increment(String key, String hashKey, double delta) {
        return getHashOperations().increment(key, hashKey, delta);
    }

    public static Set<String> keys(String key) {
        return getHashOperations().keys(key);
    }
}
