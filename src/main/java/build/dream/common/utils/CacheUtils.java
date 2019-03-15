package build.dream.common.utils;

import org.springframework.data.redis.core.*;

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

    public static ListOperations<String, String> obtainListOperations() {
        return obtainStringRedisTemplate().opsForList();
    }

    public static SetOperations<String, String> obtainSetOperations() {
        return obtainStringRedisTemplate().opsForSet();
    }

    /**
     * KEYS
     *
     * @param pattern
     * @return
     */
    public static Set<String> keys(String pattern) {
        return obtainStringRedisTemplate().keys(pattern);
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

    public static Boolean exists(String key) {
        return obtainStringRedisTemplate().hasKey(key);
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
    public static Map<String, String> hgetAll(String key) {
        return obtainHashOperations().entries(key);
    }

    /**
     * HINCRBY
     *
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
     *
     * @param key
     * @param field
     * @param increment
     * @return
     */
    public static Double hincrByFloat(String key, String field, double increment) {
        return obtainHashOperations().increment(key, field, increment);
    }

    /**
     * HKEYS
     *
     * @param key
     * @return
     */
    public static Set<String> hkeys(String key) {
        return obtainHashOperations().keys(key);
    }

    /**
     * HLEN
     *
     * @param key
     * @return
     */
    public static Long hlen(String key) {
        return obtainHashOperations().size(key);
    }

    /**
     * HMGET
     *
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
     *
     * @param key
     * @param map
     */
    public static void hmset(String key, Map<String, String> map) {
        obtainHashOperations().putAll(key, map);
    }

    /**
     * HSET
     *
     * @param key
     * @param field
     * @param value
     */
    public static void hset(String key, String field, String value) {
        obtainHashOperations().put(key, field, value);
    }

    /**
     * HSETNX
     *
     * @param key
     * @param field
     * @param value
     */
    public static void hsetnx(String key, String field, String value) {
        obtainHashOperations().putIfAbsent(key, field, value);
    }

    /**
     * HVALS
     *
     * @param key
     * @return
     */
    public static List<String> hvals(String key) {
        return obtainHashOperations().values(key);
    }

    public static Boolean expire(String key, long timeout, TimeUnit unit) {
        return obtainStringRedisTemplate().expire(key, timeout, unit);
    }

    public static Boolean expireAt(String key, Date date) {
        return obtainStringRedisTemplate().expireAt(key, date);
    }

    public static Long hdel(String key, String... fields) {
        return obtainHashOperations().delete(key, fields);
    }

    public static Long ttl(String key) {
        return obtainStringRedisTemplate().getExpire(key);
    }

    public static Long ttl(String key, TimeUnit timeUnit) {
        return obtainStringRedisTemplate().getExpire(key, timeUnit);
    }

    /**
     * LRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static List<String> lrange(String key, long start, long end) {
        return obtainListOperations().range(key, start, end);
    }

    /**
     * LTRIM
     *
     * @param key
     * @param start
     * @param end
     */
    public static void ltrim(String key, long start, long end) {
        obtainListOperations().trim(key, start, end);
    }

    /**
     * LLEN
     *
     * @param key
     * @return
     */
    public static Long llen(String key) {
        return obtainListOperations().size(key);
    }

    /**
     * LPUSH
     *
     * @param key
     * @param value
     * @return
     */
    public static Long lpush(String key, String value) {
        return obtainListOperations().leftPush(key, value);
    }

    /**
     * LPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long leftPushAll(String key, String... values) {
        return obtainListOperations().leftPushAll(key, values);
    }

    /**
     * LPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long lpushx(String key, String value) {
        return obtainListOperations().leftPushIfPresent(key, value);
    }

    /**
     * LPUSH
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public static Long lpush(String key, String pivot, String value) {
        return obtainListOperations().leftPush(key, pivot, value);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param value
     * @return
     */
    public static Long rpush(String key, String value) {
        return obtainListOperations().rightPush(key, value);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long rpush(String key, String... values) {
        return obtainListOperations().rightPushAll(key, values);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long rpush(String key, Collection<String> values) {
        return obtainListOperations().rightPushAll(key, values);
    }

    /**
     * RPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long rpushx(String key, String value) {
        return obtainListOperations().rightPushIfPresent(key, value);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public static Long rightPush(String key, String pivot, String value) {
        return obtainListOperations().rightPush(key, pivot, value);
    }

    /**
     * LSET
     *
     * @param key
     * @param index
     * @param value
     */
    public static void lset(String key, long index, String value) {
        obtainListOperations().set(key, index, value);
    }

    /**
     * LREM
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    public static Long lrem(String key, long count, Object value) {
        return obtainListOperations().remove(key, count, value);
    }

    /**
     * LINDEX
     *
     * @param key
     * @param index
     * @return
     */
    public static String lindex(String key, long index) {
        return obtainListOperations().index(key, index);
    }

    /**
     * LPOP
     *
     * @param key
     * @return
     */
    public static String lpop(String key) {
        return obtainListOperations().leftPop(key);
    }

    /**
     * BLPOP
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public static String blpop(String key, long timeout, TimeUnit unit) {
        return obtainListOperations().leftPop(key, timeout, unit);
    }

    /**
     * RPOP
     *
     * @param key
     * @return
     */
    public static String rpop(String key) {
        return obtainListOperations().rightPop(key);
    }

    /**
     * BRPOP
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public static String brpop(String key, long timeout, TimeUnit unit) {
        return obtainListOperations().rightPop(key, timeout, unit);
    }

    /**
     * RPOPLPUSH
     *
     * @param sourceKey
     * @param destinationKey
     * @return
     */
    public static String rpoplpush(String sourceKey, String destinationKey) {
        return obtainListOperations().rightPopAndLeftPush(sourceKey, destinationKey);
    }

    /**
     * BRPOPLPUSH
     *
     * @param sourceKey
     * @param destinationKey
     * @param timeout
     * @param unit
     * @return
     */
    public static String brpoplpush(String sourceKey, String destinationKey, long timeout, TimeUnit unit) {
        return obtainListOperations().rightPopAndLeftPush(sourceKey, destinationKey, timeout, unit);
    }

    /**
     * SADD
     *
     * @param key
     * @param values
     * @return
     */
    public static Long sadd(String key, String... values) {
        return obtainSetOperations().add(key, values);
    }

    /**
     * SREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long srem(String key, Object... values) {
        return obtainSetOperations().remove(key, values);
    }

    /**
     * SPOP
     *
     * @param key
     * @return
     */
    public static String spop(String key) {
        return obtainSetOperations().pop(key);
    }

    /**
     * SPOP
     *
     * @param key
     * @param count
     * @return
     */
    public static List<String> spop(String key, long count) {
        return obtainSetOperations().pop(key, count);
    }

    /**
     * SMOVE
     *
     * @param key
     * @param value
     * @param destKey
     * @return
     */
    public static Boolean smove(String key, String value, String destKey) {
        return obtainSetOperations().move(key, value, destKey);
    }

    /**
     * SCARD
     *
     * @param key
     * @return
     */
    public static Long scard(String key) {
        return obtainSetOperations().size(key);
    }

    /**
     * SISMEMBER
     *
     * @param key
     * @param object
     * @return
     */
    public static Boolean sismember(String key, Object object) {
        return obtainSetOperations().isMember(key, object);
    }

    /**
     * SINTER
     *
     * @param key
     * @param otherKey
     * @return
     */
    public static Set<String> sinter(String key, String otherKey) {
        return obtainSetOperations().intersect(key, otherKey);
    }

    /**
     * SINTER
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public static Set<String> sinter(String key, Collection<String> otherKeys) {
        return obtainSetOperations().intersect(key, otherKeys);
    }

    /**
     * SINTERSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long sinterstore(String key, String otherKey, String destKey) {
        return obtainSetOperations().intersectAndStore(key, otherKey, destKey);
    }

    /**
     * SINTERSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long sinterstore(String key, Collection<String> otherKeys, String destKey) {
        return obtainSetOperations().intersectAndStore(key, otherKeys, destKey);
    }

    /**
     * SUNION
     *
     * @param key
     * @param otherKey
     * @return
     */
    public static Set<String> sunion(String key, String otherKey) {
        return obtainSetOperations().union(key, otherKey);
    }

    /**
     * SUNION
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public static Set<String> sunion(String key, Collection<String> otherKeys) {
        return obtainSetOperations().union(key, otherKeys);
    }

    /**
     * SUNIONSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long sunionstore(String key, String otherKey, String destKey) {
        return obtainSetOperations().unionAndStore(key, otherKey, destKey);
    }

    /**
     * SUNIONSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long sunionstore(String key, Collection<String> otherKeys, String destKey) {
        return obtainSetOperations().unionAndStore(key, otherKeys, destKey);
    }

    /**
     * SDIFF
     *
     * @param key
     * @param otherKey
     * @return
     */
    public static Set<String> sdiff(String key, String otherKey) {
        return obtainSetOperations().difference(key, otherKey);
    }

    /**
     * SDIFF
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public static Set<String> SDIFF(String key, Collection<String> otherKeys) {
        return obtainSetOperations().difference(key, otherKeys);
    }

    /**
     * SDIFFSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long sdiffstore(String key, String otherKey, String destKey) {
        return obtainSetOperations().differenceAndStore(key, otherKey, destKey);
    }

    /**
     * SDIFFSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long sdiffstore(String key, Collection<String> otherKeys, String destKey) {
        return obtainSetOperations().differenceAndStore(key, otherKeys, destKey);
    }

    /**
     * SMEMBERS
     *
     * @param key
     * @return
     */
    public static Set<String> smembers(String key) {
        return obtainSetOperations().members(key);
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @return
     */
    public static String srandmember(String key) {
        return obtainSetOperations().randomMember(key);
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @param count
     * @return
     */
    public static List<String> srandmember(String key, long count) {
        return obtainSetOperations().randomMembers(key, count);
    }
}
