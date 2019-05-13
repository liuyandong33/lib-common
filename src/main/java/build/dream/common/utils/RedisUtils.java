package build.dream.common.utils;

import org.springframework.data.redis.connection.RedisListCommands;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RedisUtils {
    public static ValueOperations<String, String> obtainValueOperations(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    public static HashOperations<String, String, String> obtainHashOperations(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    public static ListOperations<String, String> obtainListOperations(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.opsForList();
    }

    public static SetOperations<String, String> obtainSetOperations(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    public static ZSetOperations<String, String> obtainZSetOperations(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.opsForZSet();
    }

    /**
     * KEYS
     *
     * @param pattern
     * @return
     */
    public static Set<String> keys(RedisTemplate<String, String> redisTemplate, String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * SET
     *
     * @param key
     * @param value
     */
    public static void set(RedisTemplate<String, String> redisTemplate, String key, String value) {
        obtainValueOperations(redisTemplate).set(key, value);
    }

    /**
     * SETEX
     *
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    public static void setex(RedisTemplate<String, String> redisTemplate, String key, String value, long timeout, TimeUnit unit) {
        obtainValueOperations(redisTemplate).set(key, value, timeout, unit);
    }

    /**
     * SETNX
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean setnx(RedisTemplate<String, String> redisTemplate, String key, String value) {
        return obtainValueOperations(redisTemplate).setIfAbsent(key, value);
    }

    /**
     * MSET
     *
     * @param map
     */
    public static void mset(RedisTemplate<String, String> redisTemplate, Map<String, String> map) {
        obtainValueOperations(redisTemplate).multiSet(map);
    }

    /**
     * MSETNX
     *
     * @param map
     * @return
     */
    public static Boolean msetnx(RedisTemplate<String, String> redisTemplate, Map<String, String> map) {
        return obtainValueOperations(redisTemplate).multiSetIfAbsent(map);
    }

    /**
     * GET
     *
     * @param key
     * @return
     */
    public static String get(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainValueOperations(redisTemplate).get(key);
    }

    /**
     * GETSET
     *
     * @param key
     * @param value
     * @return
     */
    public static String getset(RedisTemplate<String, String> redisTemplate, String key, String value) {
        return obtainValueOperations(redisTemplate).getAndSet(key, value);
    }

    /**
     * EXISTS
     *
     * @param key
     * @return
     */
    public static Boolean exists(RedisTemplate<String, String> redisTemplate, String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * mget
     *
     * @param keys
     * @return
     */
    public static List<String> mget(RedisTemplate<String, String> redisTemplate, Collection<String> keys) {
        return obtainValueOperations(redisTemplate).multiGet(keys);
    }

    /**
     * INCR
     *
     * @param key
     * @return
     */
    public static Long incr(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainValueOperations(redisTemplate).increment(key, 1);
    }

    /**
     * INCRBY
     *
     * @param key
     * @param delta
     * @return
     */
    public static Long incrby(RedisTemplate<String, String> redisTemplate, String key, long delta) {
        return obtainValueOperations(redisTemplate).increment(key, delta);
    }

    /**
     * INCRBYFLOAT
     *
     * @param key
     * @param delta
     * @return
     */
    public static Double incrbyfloat(RedisTemplate<String, String> redisTemplate, String key, double delta) {
        return obtainValueOperations(redisTemplate).increment(key, delta);
    }

    /**
     * APPEND
     *
     * @param key
     * @param value
     * @return
     */
    public static Integer append(RedisTemplate<String, String> redisTemplate, String key, String value) {
        return obtainValueOperations(redisTemplate).append(key, value);
    }

    /**
     * GETRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static String getrange(RedisTemplate<String, String> redisTemplate, String key, long start, long end) {
        return obtainValueOperations(redisTemplate).get(key, start, end);
    }

    /**
     * SETRANGE
     *
     * @return
     */
    public static void setrange(RedisTemplate<String, String> redisTemplate, String key, String value, long offset) {
        obtainValueOperations(redisTemplate).set(key, value, offset);
    }

    /**
     * STRLEN
     *
     * @param key
     * @return
     */
    public static Long strlen(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainValueOperations(redisTemplate).size(key);
    }

    /**
     * SETBIT
     *
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public static Boolean setbit(RedisTemplate<String, String> redisTemplate, String key, long offset, boolean value) {
        return obtainValueOperations(redisTemplate).setBit(key, offset, value);
    }

    /**
     * GETBIT
     *
     * @param key
     * @param offset
     * @return
     */
    public static Boolean getbit(RedisTemplate<String, String> redisTemplate, String key, long offset) {
        return obtainValueOperations(redisTemplate).getBit(key, offset);
    }

    /**
     * DEL
     *
     * @param redisTemplate
     * @param keys
     */
    public static void del(RedisTemplate<String, String> redisTemplate, String... keys) {
        redisTemplate.delete(Arrays.asList(keys));
    }

    /**
     * HEXISTS
     *
     * @param key
     * @param field
     * @return
     */
    public static Boolean hexists(RedisTemplate<String, String> redisTemplate, String key, String field) {
        return obtainHashOperations(redisTemplate).hasKey(key, field);
    }

    /**
     * HGET
     *
     * @param key
     * @param field
     * @return
     */
    public static String hget(RedisTemplate<String, String> redisTemplate, String key, String field) {
        return obtainHashOperations(redisTemplate).get(key, field);
    }

    /**
     * HGETALL
     *
     * @return
     */
    public static Map<String, String> hgetAll(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainHashOperations(redisTemplate).entries(key);
    }

    /**
     * HINCRBY
     *
     * @param key
     * @param field
     * @param increment
     * @return
     */
    public static Long hincrBy(RedisTemplate<String, String> redisTemplate, String key, String field, long increment) {
        return obtainHashOperations(redisTemplate).increment(key, field, increment);
    }

    /**
     * HINCRBYFLOAT
     *
     * @param key
     * @param field
     * @param increment
     * @return
     */
    public static Double hincrbyfloat(RedisTemplate<String, String> redisTemplate, String key, String field, double increment) {
        return obtainHashOperations(redisTemplate).increment(key, field, increment);
    }

    /**
     * HKEYS
     *
     * @param key
     * @return
     */
    public static Set<String> hkeys(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainHashOperations(redisTemplate).keys(key);
    }

    /**
     * HLEN
     *
     * @param key
     * @return
     */
    public static Long hlen(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainHashOperations(redisTemplate).size(key);
    }

    /**
     * HMGET
     *
     * @param key
     * @param fields
     */
    public static void hmget(RedisTemplate<String, String> redisTemplate, String key, String... fields) {
        obtainHashOperations(redisTemplate).multiGet(key, Arrays.asList(fields));
    }

    /**
     * HMSET
     *
     * @param key
     * @param map
     */
    public static void hmset(RedisTemplate<String, String> redisTemplate, String key, Map<String, String> map) {
        obtainHashOperations(redisTemplate).putAll(key, map);
    }

    /**
     * HSET
     *
     * @param key
     * @param field
     * @param value
     */
    public static void hset(RedisTemplate<String, String> redisTemplate, String key, String field, String value) {
        obtainHashOperations(redisTemplate).put(key, field, value);
    }

    /**
     * HSETNX
     *
     * @param key
     * @param field
     * @param value
     */
    public static void hsetnx(RedisTemplate<String, String> redisTemplate, String key, String field, String value) {
        obtainHashOperations(redisTemplate).putIfAbsent(key, field, value);
    }

    /**
     * HVALS
     *
     * @param key
     * @return
     */
    public static List<String> hvals(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainHashOperations(redisTemplate).values(key);
    }

    /**
     * EXPIRE
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public static Boolean expire(RedisTemplate<String, String> redisTemplate, String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * EXPIREAT
     *
     * @param key
     * @param date
     * @return
     */
    public static Boolean expireAt(RedisTemplate<String, String> redisTemplate, String key, Date date) {
        return redisTemplate.expireAt(key, date);
    }

    /**
     * HDEL
     *
     * @param key
     * @param fields
     * @return
     */
    public static Long hdel(RedisTemplate<String, String> redisTemplate, String key, String... fields) {
        return obtainHashOperations(redisTemplate).delete(key, fields);
    }

    /**
     * TTL
     *
     * @param key
     * @return
     */
    public static Long ttl(RedisTemplate<String, String> redisTemplate, String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * TTL
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public static Long ttl(RedisTemplate<String, String> redisTemplate, String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }

    /**
     * LRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static List<String> lrange(RedisTemplate<String, String> redisTemplate, String key, long start, long end) {
        return obtainListOperations(redisTemplate).range(key, start, end);
    }

    /**
     * LTRIM
     *
     * @param key
     * @param start
     * @param end
     */
    public static void ltrim(RedisTemplate<String, String> redisTemplate, String key, long start, long end) {
        obtainListOperations(redisTemplate).trim(key, start, end);
    }

    /**
     * LLEN
     *
     * @param key
     * @return
     */
    public static Long llen(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainListOperations(redisTemplate).size(key);
    }

    /**
     * LPUSH
     *
     * @param key
     * @param value
     * @return
     */
    public static Long lpush(RedisTemplate<String, String> redisTemplate, String key, String value) {
        return obtainListOperations(redisTemplate).leftPush(key, value);
    }

    /**
     * LPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long lpush(RedisTemplate<String, String> redisTemplate, String key, String... values) {
        return obtainListOperations(redisTemplate).leftPushAll(key, values);
    }

    /**
     * LPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long lpushx(RedisTemplate<String, String> redisTemplate, String key, String value) {
        return obtainListOperations(redisTemplate).leftPushIfPresent(key, value);
    }

    /**
     * LPUSH
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public static Long lpush(RedisTemplate<String, String> redisTemplate, String key, String pivot, String value) {
        return obtainListOperations(redisTemplate).leftPush(key, pivot, value);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param value
     * @return
     */
    public static Long rpush(RedisTemplate<String, String> redisTemplate, String key, String value) {
        return obtainListOperations(redisTemplate).rightPush(key, value);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long rpush(RedisTemplate<String, String> redisTemplate, String key, String... values) {
        return obtainListOperations(redisTemplate).rightPushAll(key, values);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long rpush(RedisTemplate<String, String> redisTemplate, String key, Collection<String> values) {
        return obtainListOperations(redisTemplate).rightPushAll(key, values);
    }

    /**
     * RPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long rpushx(RedisTemplate<String, String> redisTemplate, String key, String value) {
        return obtainListOperations(redisTemplate).rightPushIfPresent(key, value);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public static Long rpush(RedisTemplate<String, String> redisTemplate, String key, String pivot, String value) {
        return obtainListOperations(redisTemplate).rightPush(key, pivot, value);
    }

    /**
     * LSET
     *
     * @param key
     * @param index
     * @param value
     */
    public static void lset(RedisTemplate<String, String> redisTemplate, String key, long index, String value) {
        obtainListOperations(redisTemplate).set(key, index, value);
    }

    /**
     * LREM
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    public static Long lrem(RedisTemplate<String, String> redisTemplate, String key, long count, Object value) {
        return obtainListOperations(redisTemplate).remove(key, count, value);
    }

    /**
     * LINDEX
     *
     * @param key
     * @param index
     * @return
     */
    public static String lindex(RedisTemplate<String, String> redisTemplate, String key, long index) {
        return obtainListOperations(redisTemplate).index(key, index);
    }

    /**
     * LPOP
     *
     * @param key
     * @return
     */
    public static String lpop(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainListOperations(redisTemplate).leftPop(key);
    }

    /**
     * BLPOP
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public static String blpop(RedisTemplate<String, String> redisTemplate, String key, long timeout, TimeUnit unit) {
        return obtainListOperations(redisTemplate).leftPop(key, timeout, unit);
    }

    /**
     * RPOP
     *
     * @param key
     * @return
     */
    public static String rpop(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainListOperations(redisTemplate).rightPop(key);
    }

    /**
     * BRPOP
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public static String brpop(RedisTemplate<String, String> redisTemplate, String key, long timeout, TimeUnit unit) {
        return obtainListOperations(redisTemplate).rightPop(key, timeout, unit);
    }

    /**
     * RPOPLPUSH
     *
     * @param sourceKey
     * @param destinationKey
     * @return
     */
    public static String rpoplpush(RedisTemplate<String, String> redisTemplate, String sourceKey, String destinationKey) {
        return obtainListOperations(redisTemplate).rightPopAndLeftPush(sourceKey, destinationKey);
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
    public static String brpoplpush(RedisTemplate<String, String> redisTemplate, String sourceKey, String destinationKey, long timeout, TimeUnit unit) {
        return obtainListOperations(redisTemplate).rightPopAndLeftPush(sourceKey, destinationKey, timeout, unit);
    }

    /**
     * SADD
     *
     * @param key
     * @param values
     * @return
     */
    public static Long sadd(RedisTemplate<String, String> redisTemplate, String key, String... values) {
        return obtainSetOperations(redisTemplate).add(key, values);
    }

    /**
     * SREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long srem(RedisTemplate<String, String> redisTemplate, String key, Object... values) {
        return obtainSetOperations(redisTemplate).remove(key, values);
    }

    /**
     * SPOP
     *
     * @param key
     * @return
     */
    public static String spop(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainSetOperations(redisTemplate).pop(key);
    }

    /**
     * SPOP
     *
     * @param key
     * @param count
     * @return
     */
    public static List<String> spop(RedisTemplate<String, String> redisTemplate, String key, long count) {
        return obtainSetOperations(redisTemplate).pop(key, count);
    }

    /**
     * SMOVE
     *
     * @param key
     * @param value
     * @param destKey
     * @return
     */
    public static Boolean smove(RedisTemplate<String, String> redisTemplate, String key, String value, String destKey) {
        return obtainSetOperations(redisTemplate).move(key, value, destKey);
    }

    /**
     * SCARD
     *
     * @param key
     * @return
     */
    public static Long scard(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainSetOperations(redisTemplate).size(key);
    }

    /**
     * SISMEMBER
     *
     * @param key
     * @param object
     * @return
     */
    public static Boolean sismember(RedisTemplate<String, String> redisTemplate, String key, Object object) {
        return obtainSetOperations(redisTemplate).isMember(key, object);
    }

    /**
     * SINTER
     *
     * @param key
     * @param otherKey
     * @return
     */
    public static Set<String> sinter(RedisTemplate<String, String> redisTemplate, String key, String otherKey) {
        return obtainSetOperations(redisTemplate).intersect(key, otherKey);
    }

    /**
     * SINTER
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public static Set<String> sinter(RedisTemplate<String, String> redisTemplate, String key, Collection<String> otherKeys) {
        return obtainSetOperations(redisTemplate).intersect(key, otherKeys);
    }

    /**
     * SINTERSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long sinterstore(RedisTemplate<String, String> redisTemplate, String key, String otherKey, String destKey) {
        return obtainSetOperations(redisTemplate).intersectAndStore(key, otherKey, destKey);
    }

    /**
     * SINTERSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long sinterstore(RedisTemplate<String, String> redisTemplate, String key, Collection<String> otherKeys, String destKey) {
        return obtainSetOperations(redisTemplate).intersectAndStore(key, otherKeys, destKey);
    }

    /**
     * SUNION
     *
     * @param key
     * @param otherKey
     * @return
     */
    public static Set<String> sunion(RedisTemplate<String, String> redisTemplate, String key, String otherKey) {
        return obtainSetOperations(redisTemplate).union(key, otherKey);
    }

    /**
     * SUNION
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public static Set<String> sunion(RedisTemplate<String, String> redisTemplate, String key, Collection<String> otherKeys) {
        return obtainSetOperations(redisTemplate).union(key, otherKeys);
    }

    /**
     * SUNIONSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long sunionstore(RedisTemplate<String, String> redisTemplate, String key, String otherKey, String destKey) {
        return obtainSetOperations(redisTemplate).unionAndStore(key, otherKey, destKey);
    }

    /**
     * SUNIONSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long sunionstore(RedisTemplate<String, String> redisTemplate, String key, Collection<String> otherKeys, String destKey) {
        return obtainSetOperations(redisTemplate).unionAndStore(key, otherKeys, destKey);
    }

    /**
     * SDIFF
     *
     * @param key
     * @param otherKey
     * @return
     */
    public static Set<String> sdiff(RedisTemplate<String, String> redisTemplate, String key, String otherKey) {
        return obtainSetOperations(redisTemplate).difference(key, otherKey);
    }

    /**
     * SDIFF
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public static Set<String> sdiff(RedisTemplate<String, String> redisTemplate, String key, Collection<String> otherKeys) {
        return obtainSetOperations(redisTemplate).difference(key, otherKeys);
    }

    /**
     * SDIFFSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long sdiffstore(RedisTemplate<String, String> redisTemplate, String key, String otherKey, String destKey) {
        return obtainSetOperations(redisTemplate).differenceAndStore(key, otherKey, destKey);
    }

    /**
     * SDIFFSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long sdiffstore(RedisTemplate<String, String> redisTemplate, String key, Collection<String> otherKeys, String destKey) {
        return obtainSetOperations(redisTemplate).differenceAndStore(key, otherKeys, destKey);
    }

    /**
     * SMEMBERS
     *
     * @param key
     * @return
     */
    public static Set<String> smembers(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainSetOperations(redisTemplate).members(key);
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @return
     */
    public static String srandmember(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainSetOperations(redisTemplate).randomMember(key);
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @param count
     * @return
     */
    public static List<String> srandmember(RedisTemplate<String, String> redisTemplate, String key, long count) {
        return obtainSetOperations(redisTemplate).randomMembers(key, count);
    }

    /**
     * ZADD
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
    public static Boolean zadd(RedisTemplate<String, String> redisTemplate, String key, String value, double score) {
        return obtainZSetOperations(redisTemplate).add(key, value, score);
    }

    /**
     * ZADD
     *
     * @param key
     * @param tuples
     * @return
     */
    public static Long zadd(RedisTemplate<String, String> redisTemplate, String key, Set<ZSetOperations.TypedTuple<String>> tuples) {
        return obtainZSetOperations(redisTemplate).add(key, tuples);
    }

    /**
     * ZREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long zrem(RedisTemplate<String, String> redisTemplate, String key, Object... values) {
        return obtainZSetOperations(redisTemplate).remove(key, values);
    }

    /**
     * ZINCRBY
     *
     * @param key
     * @param value
     * @param delta
     * @return
     */
    public static Double zincrby(RedisTemplate<String, String> redisTemplate, String key, String value, double delta) {
        return obtainZSetOperations(redisTemplate).incrementScore(key, value, delta);
    }

    /**
     * ZRANK
     *
     * @param key
     * @param object
     * @return
     */
    public static Long zrank(RedisTemplate<String, String> redisTemplate, String key, Object object) {
        return obtainZSetOperations(redisTemplate).rank(key, object);
    }

    /**
     * ZREVRANK
     *
     * @param key
     * @param object
     * @return
     */
    public static Long zrevrank(RedisTemplate<String, String> redisTemplate, String key, Object object) {
        return obtainZSetOperations(redisTemplate).reverseRank(key, object);
    }

    /**
     * ZRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> zrange(RedisTemplate<String, String> redisTemplate, String key, long start, long end) {
        return obtainZSetOperations(redisTemplate).range(key, start, end);
    }

    /**
     * ZRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<String> zrangebyscore(RedisTemplate<String, String> redisTemplate, String key, double min, double max) {
        return obtainZSetOperations(redisTemplate).rangeByScore(key, min, max);
    }

    /**
     * ZRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<String> zrangebyscore(RedisTemplate<String, String> redisTemplate, String key, double min, double max, long offset, long count) {
        return obtainZSetOperations(redisTemplate).rangeByScore(key, min, max, offset, count);
    }

    /**
     * ZREVRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> zrevrange(RedisTemplate<String, String> redisTemplate, String key, long start, long end) {
        return obtainZSetOperations(redisTemplate).reverseRange(key, start, end);
    }

    /**
     * ZREVRANGE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<String> zrevrange(RedisTemplate<String, String> redisTemplate, String key, double min, double max) {
        return obtainZSetOperations(redisTemplate).reverseRangeByScore(key, min, max);
    }

    /**
     * ZREVRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<String> zrevrangebyscore(RedisTemplate<String, String> redisTemplate, String key, double min, double max, long offset, long count) {
        return obtainZSetOperations(redisTemplate).reverseRangeByScore(key, min, max, offset, count);
    }

    /**
     * ZCOUNT
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Long zcount(RedisTemplate<String, String> redisTemplate, String key, double min, double max) {
        return obtainZSetOperations(redisTemplate).count(key, min, max);
    }

    /**
     * ZCARD
     *
     * @param key
     * @return
     */
    public static Long zcard(RedisTemplate<String, String> redisTemplate, String key) {
        return obtainZSetOperations(redisTemplate).zCard(key);
    }

    /**
     * ZSCORE
     *
     * @param key
     * @param object
     * @return
     */
    public static Double zscore(RedisTemplate<String, String> redisTemplate, String key, Object object) {
        return obtainZSetOperations(redisTemplate).score(key, object);
    }

    /**
     * ZREMRANGEBYRANK
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Long zremrangebyrank(RedisTemplate<String, String> redisTemplate, String key, long start, long end) {
        return obtainZSetOperations(redisTemplate).removeRange(key, start, end);
    }

    /**
     * ZREMRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Long zremrangebyscore(RedisTemplate<String, String> redisTemplate, String key, double min, double max) {
        return obtainZSetOperations(redisTemplate).removeRangeByScore(key, min, max);
    }

    /**
     * ZUNIONSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long zunionstore(RedisTemplate<String, String> redisTemplate, String key, String otherKey, String destKey) {
        return obtainZSetOperations(redisTemplate).unionAndStore(key, otherKey, destKey);
    }

    /**
     * ZUNIONSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long zunionstore(RedisTemplate<String, String> redisTemplate, String key, Collection<String> otherKeys, String destKey) {
        return obtainZSetOperations(redisTemplate).unionAndStore(key, otherKeys, destKey);
    }

    /**
     * ZINTERSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long zinterstore(RedisTemplate<String, String> redisTemplate, String key, String otherKey, String destKey) {
        return obtainZSetOperations(redisTemplate).intersectAndStore(key, otherKey, destKey);
    }

    /**
     * ZINTERSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long zinterstore(RedisTemplate<String, String> redisTemplate, String key, Collection<String> otherKeys, String destKey) {
        return obtainZSetOperations(redisTemplate).intersectAndStore(key, otherKeys, destKey);
    }

    /**
     * GET
     *
     * @param key
     * @return
     */
    public static byte[] get(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.get(key));
    }

    /**
     * GETSET
     *
     * @param key
     * @param value
     * @return
     */
    public static byte[] getset(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.getSet(key, value));
    }

    /**
     * MGET
     *
     * @param keys
     * @return
     */
    public static List<byte[]> mget(RedisTemplate<String, String> redisTemplate, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.mGet(keys));
    }

    /**
     * SET
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean set(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.set(key, value));
    }

    /**
     * SETNX
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean setnx(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.setNX(key, value));
    }

    /**
     * SETEX
     *
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public static Boolean setex(RedisTemplate<String, String> redisTemplate, byte[] key, long seconds, byte[] value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.setEx(key, seconds, value));
    }

    /**
     * PSETEX
     *
     * @param key
     * @param milliseconds
     * @param value
     * @return
     */
    public static Boolean psetex(RedisTemplate<String, String> redisTemplate, byte[] key, long milliseconds, byte[] value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.pSetEx(key, milliseconds, value));
    }

    /**
     * MSET
     *
     * @param tuple
     * @return
     */
    public static Boolean _mset(RedisTemplate<String, String> redisTemplate, Map<byte[], byte[]> tuple) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.mSet(tuple));
    }

    /**
     * MSETNX
     *
     * @param tuple
     * @return
     */
    public static Boolean _msetnx(RedisTemplate<String, String> redisTemplate, Map<byte[], byte[]> tuple) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.mSetNX(tuple));
    }

    /**
     * INCR
     *
     * @param key
     * @return
     */
    public static Long incr(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.incr(key));
    }

    /**
     * INCRBY
     *
     * @param key
     * @param value
     * @return
     */
    public static Long incrby(RedisTemplate<String, String> redisTemplate, byte[] key, long value) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.incrBy(key, value));
    }

    /**
     * INCRBY
     *
     * @param key
     * @param value
     * @return
     */
    public static Double incrby(RedisTemplate<String, String> redisTemplate, byte[] key, double value) {
        return redisTemplate.execute((RedisCallback<Double>) connection -> connection.incrBy(key, value));
    }

    /**
     * DECR
     *
     * @param key
     * @return
     */
    public static Long decr(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.decr(key));
    }

    /**
     * DECRBY
     *
     * @param key
     * @param value
     * @return
     */
    public static Long decrBy(RedisTemplate<String, String> redisTemplate, byte[] key, long value) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.decrBy(key, value));
    }

    /**
     * APPEND
     *
     * @param key
     * @param value
     * @return
     */
    public static Long append(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.append(key, value));
    }

    /**
     * GETRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static byte[] getrange(RedisTemplate<String, String> redisTemplate, byte[] key, long start, long end) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.getRange(key, start, end));
    }

    /**
     * SETRANGE
     *
     * @param key
     * @param value
     * @param offset
     */
    public static void setrange(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value, long offset) {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.setRange(key, value, offset);
            return null;
        });
    }

    /**
     * GETBIT
     *
     * @param key
     * @param offset
     * @return
     */
    public static Boolean getbit(RedisTemplate<String, String> redisTemplate, byte[] key, long offset) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.getBit(key, offset));
    }

    /**
     * SETBIT
     *
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public static Boolean setbit(RedisTemplate<String, String> redisTemplate, byte[] key, long offset, boolean value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.setBit(key, offset, value));
    }

    /**
     * BITCOUNT
     *
     * @param key
     * @return
     */
    public static Long bitcount(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(key));
    }

    /**
     * BITCOUNT
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Long bitcount(RedisTemplate<String, String> redisTemplate, byte[] key, long start, long end) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(key, start, end));
    }

    /**
     * BITOP
     *
     * @param op
     * @param destination
     * @param keys
     * @return
     */
    public static Long bitop(RedisTemplate<String, String> redisTemplate, RedisStringCommands.BitOperation op, byte[] destination, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitOp(op, destination, keys));
    }

    /**
     * STRLEN
     *
     * @param key
     * @return
     */
    public static Long strlen(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.strLen(key));
    }

    /**
     * HSET
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static Boolean hset(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] field, byte[] value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.hSet(key, field, value));
    }

    /**
     * HSETNX
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static Boolean hsetnx(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] field, byte[] value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.hSetNX(key, field, value));
    }

    /**
     * HGET
     *
     * @param key
     * @param field
     * @return
     */
    public static byte[] hget(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] field) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.hGet(key, field));
    }

    /**
     * HMGET
     *
     * @param key
     * @param fields
     * @return
     */
    public static List<byte[]> hmget(RedisTemplate<String, String> redisTemplate, byte[] key, byte[]... fields) {
        return redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.hMGet(key, fields));
    }

    /**
     * HMSET
     *
     * @param key
     * @param hashes
     */
    public static void hmset(RedisTemplate<String, String> redisTemplate, byte[] key, Map<byte[], byte[]> hashes) {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.hMSet(key, hashes);
            return null;
        });
    }

    /**
     * HINCRBY
     *
     * @param key
     * @param field
     * @param delta
     * @return
     */
    public static Long hincrby(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] field, long delta) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.hIncrBy(key, field, delta));
    }

    /**
     * HINCRBYFLOAT
     *
     * @param key
     * @param field
     * @param delta
     * @return
     */
    public static Double hincrbyfloat(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] field, double delta) {
        return redisTemplate.execute((RedisCallback<Double>) connection -> connection.hIncrBy(key, field, delta));
    }

    /**
     * HEXISTS
     *
     * @param key
     * @param field
     * @return
     */
    public static Boolean hexists(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] field) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.hExists(key, field));
    }

    /**
     * HDEL
     *
     * @param key
     * @param fields
     * @return
     */
    public static Long hdel(RedisTemplate<String, String> redisTemplate, byte[] key, byte[]... fields) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.hDel(key, fields));
    }

    /**
     * HLEN
     *
     * @param key
     * @return
     */
    public static Long hlen(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.hLen(key));
    }

    /**
     * HKEYS
     *
     * @param key
     * @return
     */
    public static Set<byte[]> hkeys(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.hKeys(key));
    }

    /**
     * HVALS
     *
     * @param key
     * @return
     */
    public static List<byte[]> hvals(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.hVals(key));
    }

    /**
     * HGETALL
     *
     * @param key
     * @return
     */
    public static Map<byte[], byte[]> hgetall(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Map<byte[], byte[]>>) connection -> connection.hGetAll(key));
    }

    /**
     * HSCAN
     *
     * @param key
     * @param options
     * @return
     */
    public static Cursor<Map.Entry<byte[], byte[]>> hscan(RedisTemplate<String, String> redisTemplate, byte[] key, ScanOptions options) {
        return redisTemplate.execute((RedisCallback<Cursor<Map.Entry<byte[], byte[]>>>) connection -> connection.hScan(key, options));
    }

    /**
     * RPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long rpush(RedisTemplate<String, String> redisTemplate, byte[] key, byte[]... values) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.rPush(key, values));
    }

    /**
     * LPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long lpush(RedisTemplate<String, String> redisTemplate, byte[] key, byte[]... values) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.lPush(key, values));
    }

    /**
     * RPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long rpushx(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.rPushX(key, value));
    }

    /**
     * LPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long lpushx(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.lPushX(key, value));
    }

    /**
     * LLEN
     *
     * @param key
     * @return
     */
    public static Long llen(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.hLen(key));
    }

    /**
     * LRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static List<byte[]> lrange(RedisTemplate<String, String> redisTemplate, byte[] key, long start, long end) {
        return redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.lRange(key, start, end));
    }

    /**
     * LTRIM
     *
     * @param key
     * @param start
     * @param end
     */
    public static void ltrim(RedisTemplate<String, String> redisTemplate, byte[] key, long start, long end) {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.lTrim(key, start, end);
            return null;
        });
    }

    /**
     * LINDEX
     *
     * @param key
     * @param index
     * @return
     */
    public static byte[] lindex(RedisTemplate<String, String> redisTemplate, byte[] key, long index) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.lIndex(key, index));
    }

    /**
     * LINSERT
     *
     * @param key
     * @param where
     * @param pivot
     * @param value
     * @return
     */
    public static Long linsert(RedisTemplate<String, String> redisTemplate, byte[] key, RedisListCommands.Position where, byte[] pivot, byte[] value) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.lInsert(key, where, pivot, value));
    }

    /**
     * LSET
     *
     * @param key
     * @param index
     * @param value
     */
    public static void lset(RedisTemplate<String, String> redisTemplate, byte[] key, long index, byte[] value) {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.lSet(key, index, value);
            return null;
        });
    }

    /**
     * LREM
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    public static Long lrem(RedisTemplate<String, String> redisTemplate, byte[] key, long count, byte[] value) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.lRem(key, count, value));
    }

    /**
     * LPOP
     *
     * @param key
     * @return
     */
    public static byte[] lpop(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.lPop(connection.lPop(key)));
    }

    /**
     * RPOP
     *
     * @param key
     * @return
     */
    public static byte[] rpop(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.rPop(key));
    }

    /**
     * BLPOP
     *
     * @param timeout
     * @param keys
     * @return
     */
    public static List<byte[]> blpop(RedisTemplate<String, String> redisTemplate, int timeout, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.bLPop(timeout, keys));
    }

    /**
     * BRPOP
     *
     * @param timeout
     * @param keys
     * @return
     */
    public static List<byte[]> brpop(RedisTemplate<String, String> redisTemplate, int timeout, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.bRPop(timeout, keys));
    }

    /**
     * RPOPLPUSH
     *
     * @param srcKey
     * @param dstKey
     * @return
     */
    public static byte[] rpoplpush(RedisTemplate<String, String> redisTemplate, byte[] srcKey, byte[] dstKey) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.rPopLPush(srcKey, dstKey));
    }

    /**
     * BRPOPLPUSH
     *
     * @param timeout
     * @param srcKey
     * @param dstKey
     * @return
     */
    public static byte[] brpoplpush(RedisTemplate<String, String> redisTemplate, int timeout, byte[] srcKey, byte[] dstKey) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.bRPopLPush(timeout, srcKey, dstKey));
    }

    /**
     * SADD
     *
     * @param key
     * @param values
     * @return
     */
    public static Long sadd(RedisTemplate<String, String> redisTemplate, byte[] key, byte[]... values) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.sAdd(key, values));
    }

    /**
     * SREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long srem(RedisTemplate<String, String> redisTemplate, byte[] key, byte[]... values) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.sRem(key, values));
    }

    /**
     * SPOP
     *
     * @param key
     * @return
     */
    public static byte[] spop(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.sPop(key));
    }

    /**
     * SPOP
     *
     * @param key
     * @param count
     * @return
     */
    public static List<byte[]> spop(RedisTemplate<String, String> redisTemplate, byte[] key, long count) {
        return redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.sPop(key, count));
    }

    /**
     * SMOVE
     *
     * @param srcKey
     * @param destKey
     * @param value
     * @return
     */
    public static Boolean smove(RedisTemplate<String, String> redisTemplate, byte[] srcKey, byte[] destKey, byte[] value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.sMove(srcKey, destKey, value));
    }

    /**
     * SCARD
     *
     * @param key
     * @return
     */
    public static Long scard(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.sCard(key));
    }

    /**
     * SISMEMBER
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean sismember(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.sIsMember(key, value));
    }

    /**
     * SINTER
     *
     * @param keys
     * @return
     */
    public static Set<byte[]> sinter(RedisTemplate<String, String> redisTemplate, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.sInter(keys));
    }

    /**
     * SINTERSTORE
     *
     * @param destKey
     * @param keys
     * @return
     */
    public static Long sinterstore(RedisTemplate<String, String> redisTemplate, byte[] destKey, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.sInterStore(destKey, keys));
    }

    /**
     * SUNION
     *
     * @param keys
     * @return
     */
    public static Set<byte[]> sunion(RedisTemplate<String, String> redisTemplate, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.sUnion(keys));
    }

    /**
     * SUNIONSTORE
     *
     * @param destKey
     * @param keys
     * @return
     */
    public static Long sunionstore(RedisTemplate<String, String> redisTemplate, byte[] destKey, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.sUnionStore(destKey, keys));
    }

    /**
     * SDIFF
     *
     * @param keys
     * @return
     */
    public static Set<byte[]> sdiff(RedisTemplate<String, String> redisTemplate, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.sDiff(keys));
    }

    /**
     * SDIFFSTORE
     *
     * @param destKey
     * @param keys
     * @return
     */
    public static Long sdiffstore(RedisTemplate<String, String> redisTemplate, byte[] destKey, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.sDiffStore(destKey, keys));
    }

    /**
     * smembers
     *
     * @param key
     * @return
     */
    public static Set<byte[]> smembers(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.sMembers(key));
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @return
     */
    public static byte[] srandmember(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.sRandMember(key));
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @param count
     * @return
     */
    public static List<byte[]> srandmember(RedisTemplate<String, String> redisTemplate, byte[] key, long count) {
        return redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.sRandMember(key, count));
    }

    /**
     * SSCAN
     *
     * @param key
     * @param options
     * @return
     */
    public static Cursor<byte[]> sscan(RedisTemplate<String, String> redisTemplate, byte[] key, ScanOptions options) {
        return redisTemplate.execute((RedisCallback<Cursor<byte[]>>) connection -> connection.sScan(key, options));
    }

    /**
     * ZADD
     *
     * @param key
     * @param score
     * @param value
     * @return
     */
    public static Boolean zadd(RedisTemplate<String, String> redisTemplate, byte[] key, double score, byte[] value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.zAdd(key, score, value));
    }

    /**
     * ZADD
     *
     * @param key
     * @param tuples
     * @return
     */
    public static Long zadd(RedisTemplate<String, String> redisTemplate, byte[] key, Set<RedisZSetCommands.Tuple> tuples) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zAdd(key, tuples));
    }

    /**
     * ZREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long zrem(RedisTemplate<String, String> redisTemplate, byte[] key, byte[]... values) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zRem(key, values));
    }

    /**
     * ZINCRBY
     *
     * @param key
     * @param increment
     * @param value
     * @return
     */
    public static Double zincrby(RedisTemplate<String, String> redisTemplate, byte[] key, double increment, byte[] value) {
        return redisTemplate.execute((RedisCallback<Double>) connection -> connection.zIncrBy(key, increment, value));
    }

    /**
     * ZRANK
     *
     * @param key
     * @param value
     * @return
     */
    public static Long zrank(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zRank(key, value));
    }

    /**
     * ZREVRANK
     *
     * @param key
     * @param value
     * @return
     */
    public static Long zrevrank(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zRevRank(key, value));
    }

    /**
     * ZRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<byte[]> zrange(RedisTemplate<String, String> redisTemplate, byte[] key, long start, long end) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRange(key, start, end));
    }

    /**
     * ZRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<byte[]> zrangebyscore(RedisTemplate<String, String> redisTemplate, byte[] key, double min, double max) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByScore(key, min, max));
    }

    /**
     * ZRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<byte[]> zrangebyscore(RedisTemplate<String, String> redisTemplate, byte[] key, double min, double max, long offset, long count) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByScore(key, min, max, offset, count));
    }

    /**
     * ZREVRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<byte[]> zrevrange(RedisTemplate<String, String> redisTemplate, byte[] key, long start, long end) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRange(key, start, end));
    }

    /**
     * ZREVRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<byte[]> zrevrangebyscore(RedisTemplate<String, String> redisTemplate, byte[] key, double min, double max) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRangeByScore(key, min, max));
    }

    /**
     * ZREVRANGEBYSCORE
     *
     * @param key
     * @param range
     * @return
     */
    public static Set<byte[]> zrevrangebyscore(RedisTemplate<String, String> redisTemplate, byte[] key, RedisZSetCommands.Range range) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRangeByScore(key, range));
    }

    /**
     * ZREVRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<byte[]> zrevrangebyscore(RedisTemplate<String, String> redisTemplate, byte[] key, double min, double max, long offset, long count) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRangeByScore(key, min, max, offset, count));
    }

    /**
     * ZREVRANGEBYSCORE
     *
     * @param key
     * @param range
     * @param limit
     * @return
     */
    public static Set<byte[]> zrevrangebyscore(RedisTemplate<String, String> redisTemplate, byte[] key, RedisZSetCommands.Range range, RedisZSetCommands.Limit limit) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRangeByScore(key, range, limit));
    }

    /**
     * ZCOUNT
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Long zcount(RedisTemplate<String, String> redisTemplate, byte[] key, double min, double max) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zCount(key, min, max));
    }

    /**
     * ZCARD
     *
     * @param key
     * @return
     */
    public static Long zcard(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zCard(key));
    }

    /**
     * ZSCORE
     *
     * @param key
     * @param value
     * @return
     */
    public static Double zscore(RedisTemplate<String, String> redisTemplate, byte[] key, byte[] value) {
        return redisTemplate.execute((RedisCallback<Double>) connection -> connection.zScore(key, value));
    }

    /**
     * ZREMRANGEBYRANK
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Long zremrangebyrank(RedisTemplate<String, String> redisTemplate, byte[] key, long start, long end) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zRemRange(key, start, end));
    }

    /**
     * ZREMRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Long zremrangebyscore(RedisTemplate<String, String> redisTemplate, byte[] key, double min, double max) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zRemRangeByScore(key, min, max));
    }

    /**
     * ZUNIONSTORE
     *
     * @param destKey
     * @param sets
     * @return
     */
    public static Long zunionstore(RedisTemplate<String, String> redisTemplate, byte[] destKey, byte[]... sets) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zUnionStore(destKey, sets));
    }

    /**
     * ZINTERSTORE
     *
     * @param destKey
     * @param sets
     * @return
     */
    public static Long zinterstore(RedisTemplate<String, String> redisTemplate, byte[] destKey, byte[]... sets) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zInterStore(destKey, sets));
    }

    /**
     * ZSCAN
     *
     * @param key
     * @param options
     * @return
     */
    public static Cursor<RedisZSetCommands.Tuple> zscan(RedisTemplate<String, String> redisTemplate, byte[] key, ScanOptions options) {
        return redisTemplate.execute((RedisCallback<Cursor<RedisZSetCommands.Tuple>>) connection -> connection.zScan(key, options));
    }

    /**
     * ZRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<byte[]> zrangebyscore(RedisTemplate<String, String> redisTemplate, byte[] key, String min, String max) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByScore(key, min, max));
    }

    /**
     * ZRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<byte[]> zrangebyscore(RedisTemplate<String, String> redisTemplate, byte[] key, String min, String max, long offset, long count) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByScore(key, min, max, offset, count));
    }

    /**
     * ZRANGEBYLEX
     *
     * @param key
     * @return
     */
    public static Set<byte[]> zrangebylex(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByLex(key));
    }

    /**
     * EXISTS
     *
     * @param key
     * @return
     */
    public static Boolean exists(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.exists(key));
    }

    /**
     * DEL
     *
     * @param keys
     * @return
     */
    public static Long del(RedisTemplate<String, String> redisTemplate, byte[]... keys) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.del(keys));
    }

    /**
     * TYPE
     *
     * @param key
     * @return
     */
    public static String type(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<String>) connection -> connection.type(key).name());
    }

    /**
     * KEYS
     *
     * @param pattern
     * @return
     */
    public static Set<byte[]> keys(RedisTemplate<String, String> redisTemplate, byte[] pattern) {
        return redisTemplate.execute((RedisCallback<Set<byte[]>>) connection -> connection.keys(pattern));
    }

    /**
     * SCAN
     *
     * @param options
     * @return
     */
    public static Cursor<byte[]> scan(RedisTemplate<String, String> redisTemplate, ScanOptions options) {
        return redisTemplate.execute((RedisCallback<Cursor<byte[]>>) connection -> connection.scan(options));
    }

    /**
     * RANDOMKEY
     *
     * @return
     */
    public static byte[] randomkey(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.randomKey());
    }

    /**
     * RENAME
     *
     * @param sourceKey
     * @param targetKey
     */
    public static void rename(RedisTemplate<String, String> redisTemplate, byte[] sourceKey, byte[] targetKey) {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.rename(sourceKey, targetKey);
            return null;
        });
    }

    /**
     * RENAMENX
     *
     * @param sourceKey
     * @param targetKey
     * @return
     */
    public static Boolean renamenx(RedisTemplate<String, String> redisTemplate, byte[] sourceKey, byte[] targetKey) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.renameNX(sourceKey, targetKey));
    }

    /**
     * EXPIRE
     *
     * @param key
     * @param seconds
     * @return
     */
    public static Boolean expire(RedisTemplate<String, String> redisTemplate, byte[] key, long seconds) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.expire(key, seconds));
    }

    /**
     * PEXPIRE
     *
     * @param key
     * @param millis
     * @return
     */
    public static Boolean pexpire(RedisTemplate<String, String> redisTemplate, byte[] key, long millis) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.pExpire(key, millis));
    }

    /**
     * EXPIREAT
     *
     * @param key
     * @param unixTime
     * @return
     */
    public static Boolean expireAt(RedisTemplate<String, String> redisTemplate, byte[] key, long unixTime) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.expireAt(key, unixTime));
    }

    /**
     * PEXPIREAT
     *
     * @param key
     * @param unixTimeInMillis
     * @return
     */
    public static Boolean pexpireat(RedisTemplate<String, String> redisTemplate, byte[] key, long unixTimeInMillis) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.pExpireAt(key, unixTimeInMillis));
    }

    /**
     * PERSIST
     *
     * @param key
     * @return
     */
    public static Boolean persist(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.persist(key));
    }

    /**
     * MOVE
     *
     * @param key
     * @param dbIndex
     * @return
     */
    public static Boolean move(RedisTemplate<String, String> redisTemplate, byte[] key, int dbIndex) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.move(key, dbIndex));
    }

    /**
     * TTL
     *
     * @param key
     * @return
     */
    public static Long ttl(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.ttl(key));
    }

    /**
     * TTL
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public static Long ttl(RedisTemplate<String, String> redisTemplate, byte[] key, TimeUnit timeUnit) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.ttl(key, timeUnit));
    }

    /**
     * PTTL
     *
     * @param key
     * @return
     */
    public static Long pttl(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.pTtl(key));
    }

    /**
     * PTTL
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public static Long pttl(RedisTemplate<String, String> redisTemplate, byte[] key, TimeUnit timeUnit) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.pTtl(key, timeUnit));
    }

    /**
     * SORT
     *
     * @param key
     * @param params
     * @return
     */
    public static List<byte[]> sort(RedisTemplate<String, String> redisTemplate, byte[] key, SortParameters params) {
        return redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.sort(key, params));
    }

    /**
     * SORT
     *
     * @param key
     * @param params
     * @param storeKey
     * @return
     */
    public static Long sort(RedisTemplate<String, String> redisTemplate, byte[] key, SortParameters params, byte[] storeKey) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.sort(key, params, storeKey));
    }

    /**
     * DUMP
     *
     * @param key
     * @return
     */
    public static byte[] dump(RedisTemplate<String, String> redisTemplate, byte[] key) {
        return redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.dump(key));
    }

    /**
     * RESTORE
     *
     * @param key
     * @param ttlInMillis
     * @param serializedValue
     */
    public static void restore(RedisTemplate<String, String> redisTemplate, byte[] key, long ttlInMillis, byte[] serializedValue) {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.restore(key, ttlInMillis, serializedValue);
            return null;
        });
    }
}
