package build.dream.common.utils;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;
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
     *
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        obtainValueOperations().set(key, value);
    }

    /**
     * SETEX
     *
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    public static void setex(String key, String value, long timeout, TimeUnit unit) {
        obtainValueOperations().set(key, value, timeout, unit);
    }

    /**
     * SETNX
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean setnx(String key, String value) {
        return obtainValueOperations().setIfAbsent(key, value);
    }

    /**
     * MSET
     *
     * @param map
     */
    public static void mset(Map<String, String> map) {
        obtainValueOperations().multiSet(map);
    }

    /**
     * MSETNX
     *
     * @param map
     * @return
     */
    public static Boolean msetnx(Map<String, String> map) {
        return obtainValueOperations().multiSetIfAbsent(map);
    }

    /**
     * GET
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        return obtainValueOperations().get(key);
    }

    /**
     * GETSET
     *
     * @param key
     * @param value
     * @return
     */
    public static String getset(String key, String value) {
        return obtainValueOperations().getAndSet(key, value);
    }

    /**
     * mget
     *
     * @param keys
     * @return
     */
    public static List<String> mget(Collection<String> keys) {
        return obtainValueOperations().multiGet(keys);
    }

    /**
     * INCR
     *
     * @param key
     * @return
     */
    public static Long incr(String key) {
        return obtainValueOperations().increment(key, 1);
    }

    /**
     * INCRBY
     *
     * @param key
     * @param delta
     * @return
     */
    public static Long incrby(String key, long delta) {
        return obtainValueOperations().increment(key, delta);
    }

    /**
     * INCRBYFLOAT
     *
     * @param key
     * @param delta
     * @return
     */
    public static Double incrbyfloat(String key, double delta) {
        return obtainValueOperations().increment(key, delta);
    }

    /**
     * APPEND
     *
     * @param key
     * @param value
     * @return
     */
    public static Integer append(String key, String value) {
        return obtainValueOperations().append(key, value);
    }

    /**
     * GETRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static String getrange(String key, long start, long end) {
        return obtainValueOperations().get(key, start, end);
    }

    /**
     * SETRANGE
     *
     * @return
     */
    public static void setrange(String key, String value, long offset) {
        obtainValueOperations().set(key, value, offset);
    }

    /**
     * STRLEN
     *
     * @param key
     * @return
     */
    public static Long strlen(String key) {
        return obtainValueOperations().size(key);
    }

    /**
     * SETBIT
     *
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public static Boolean setbit(String key, long offset, boolean value) {
        return obtainValueOperations().setBit(key, offset, value);
    }

    /**
     * GETBIT
     *
     * @param key
     * @param offset
     * @return
     */
    public static Boolean getbit(String key, long offset) {
        return obtainValueOperations().getBit(key, offset);
    }

    public static void delete(String... keys) {
        for (String key : keys) {
            obtainStringRedisTemplate().delete(key);
        }
    }

    /**
     * HEXISTS
     *
     * @param key
     * @param field
     * @return
     */
    public static Boolean hexists(String key, String field) {
        return obtainHashOperations().hasKey(key, field);
    }

    /**
     * HGET
     *
     * @param key
     * @param field
     * @return
     */
    public static String hget(String key, String field) {
        return obtainHashOperations().get(key, field);
    }

    /**
     * HGETALL
     *
     * @return
     */
    public static Map<String, String> hgetall(String key) {
        return obtainHashOperations().entries(key);
    }

    public static List<String> multiGet(String key, Collection<String> hashKeys) {
        return obtainHashOperations().multiGet(key, hashKeys);
    }

    /**
     * HINCRBY
     * @param key
     * @param field
     * @param increment
     * @return
     */
    public static Long hincrBy(String key, String field, long increment) {
        return obtainHashOperations().increment(key, field, increment);
    }

    /**
     * HINCRBYFLOAT
     * @param key
     * @param field
     * @param increment
     * @return
     */
    public static Double hincrByFloat(String key, String field, double increment) {
        return obtainHashOperations().increment(key, field, increment);
    }

    /**
     * 	HKEYS
     * @param key
     * @return
     */
    public static Set<String> hkeys(String key) {
        return obtainHashOperations().keys(key);
    }

    /**
     * HLEN
     * @param key
     * @return
     */
    public static Long hlen(String key) {
        return obtainHashOperations().size(key);
    }

    /**
     * HMGET
     * @param key
     * @param fields
     */
    public static void hmget(String key, String... fields) {
        List<String> hashKeys = new ArrayList<>();
        for (String field : fields) {
            hashKeys.add(field);
        }
        obtainHashOperations().multiGet(key, hashKeys);
    }

    /**
     * HMSET
     * @param key
     * @param map
     */
    public static void hmset(String key, Map<String, String> map) {
        obtainHashOperations().putAll(key, map);
    }

    /**
     * HSET
     * @param key
     * @param field
     * @param value
     */
    public static void hset(String key, String field, String value) {
        obtainHashOperations().put(key, field, value);
    }

    /**
     * HSETNX
     * @param key
     * @param field
     * @param value
     */
    public static void hsetnx(String key, String field, String value) {
        obtainHashOperations().putIfAbsent(key, field, value);
    }

    /**
     * HVALS
     * @param key
     * @return
     */
    public static List<String> hvals(String key) {
        return obtainHashOperations().values(key);
    }

    public static Boolean expire(String key, long timeout, TimeUnit unit) {
        return obtainStringRedisTemplate().expire(key, timeout, unit);
    }

    public static Boolean expireAt(String key, final Date date) {
        return obtainStringRedisTemplate().expireAt(key, date);
    }
}
