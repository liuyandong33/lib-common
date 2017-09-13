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
public class CacheUtils {
    private static StringRedisTemplate stringRedisTemplate = null;

    public static StringRedisTemplate obtainStringRedisTemplate() {
        if (stringRedisTemplate == null) {
            stringRedisTemplate = ApplicationHandler.getBean(StringRedisTemplate.class);
        }
        return stringRedisTemplate;
    }

    public static ValueOperations<String, String> obtainValueOperations() {
        return obtainStringRedisTemplate().opsForValue();
    }

    public static HashOperations<String, String, String> obtainHashOperations() {
        return obtainStringRedisTemplate().opsForHash();
    }

    /**
     * SET
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        obtainValueOperations().set(key, value);
    }

    /**
     * SETEX
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    public static void set(String key, String value, long timeout, TimeUnit unit) {
        obtainValueOperations().set(key, value, timeout, unit);
    }

    /**
     * SETNX
     * @param key
     * @param value
     * @return
     */
    public static Boolean setIfAbsent(String key, String value) {
        return obtainValueOperations().setIfAbsent(key, value);
    }

    /**
     * MSET
     * @param map
     */
    public static void multiSet(Map<String, String> map) {
        obtainValueOperations().multiSet(map);
    }

    /**
     * MSET
     * @param map
     * @return
     */
    public static Boolean multiSetIfAbsent(Map<String, String> map) {
        return obtainValueOperations().multiSetIfAbsent(map);
    }

    /**
     * GET
     * @param key
     * @return
     */
    public static String get(String key) {
        return obtainValueOperations().get(key);
    }

    /**
     * GETSET
     * @param key
     * @param value
     * @return
     */
    public static String getAndSet(String key, String value) {
        return obtainValueOperations().getAndSet(key, value);
    }

    /**
     * MGET
     * @param keys
     * @return
     */
    public static List<String> multiGet(Collection<String> keys) {
        return obtainValueOperations().multiGet(keys);
    }

    /**
     * INCR
     * @param key
     * @param delta
     * @return
     */
    public static Long increment(String key, long delta) {
        return obtainValueOperations().increment(key, delta);
    }

    /**
     * INCRBYFLOAT
     * @param key
     * @param delta
     * @return
     */
    public static Double increment(String key, double delta) {
        return obtainValueOperations().increment(key, delta);
    }

    /**
     * APPEND
     * @param key
     * @param value
     * @return
     */
    public static Integer append(String key, String value) {
        return obtainValueOperations().append(key, value);
    }

    /**
     * GETRANGE
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static String get(String key, long start, long end) {
        return obtainValueOperations().get(key, start, end);
    }

    /**
     * SETRANGE
     * @return
     */
    public static void set(String key, String value, long offset) {
        obtainValueOperations().set(key, value, offset);
    }

    /**
     * STRLEN
     * @param key
     * @return
     */
    public static Long size(String key) {
        return obtainValueOperations().size(key);
    }

    /**
     * SETBIT
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public static Boolean setBit(String key, long offset, boolean value) {
        return obtainValueOperations().setBit(key, offset, value);
    }

    /**
     * GETBIT
     * @param key
     * @param offset
     * @return
     */
    public static Boolean getBit(String key, long offset) {
        return obtainValueOperations().getBit(key, offset);
    }

    public static void delete(String... keys) {
        for (String key : keys) {
            obtainStringRedisTemplate().delete(key);
        }
    }

    public static Boolean hasKey(String key, String hashKey) {
        return obtainHashOperations().hasKey(key, hashKey);
    }

    /**
     * HGET
     * @param key
     * @param hashKey
     * @return
     */
    public static String get(String key, String hashKey) {
        return obtainHashOperations().get(key, hashKey);
    }

    public static List<String> multiGet(String key, Collection<String> hashKeys) {
        return obtainHashOperations().multiGet(key, hashKeys);
    }

    public static Long increment(String key, String hashKey, long delta) {
        return obtainHashOperations().increment(key, hashKey, delta);
    }

    public static Double increment(String key, String hashKey, double delta) {
        return obtainHashOperations().increment(key, hashKey, delta);
    }

    public static Set<String> keys(String key) {
        return obtainHashOperations().keys(key);
    }

    public static void putAll(String key, Map<String, String> map) {
        obtainHashOperations().putAll(key, map);
    }

    public static void put(String key, String hashKey, String value) {
        obtainHashOperations().put(key, hashKey, value);
    }

    public static void putIfAbsent(String key, String hashKey, String value) {
        obtainHashOperations().put(key, hashKey, value);
    }

    public static List<String> values(String key) {
        return obtainHashOperations().values(key);
    }

    public static Map<String, String> entries(String key) {
        return obtainHashOperations().entries(key);
    }

    public static void expire(String key, long timeout, TimeUnit unit) {
        obtainStringRedisTemplate().expire(key, timeout, unit);
    }
}
