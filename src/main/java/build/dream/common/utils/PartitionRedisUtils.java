package build.dream.common.utils;

import org.springframework.data.redis.connection.RedisListCommands;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class PartitionRedisUtils {
    private static RedisTemplate<String, String> redisTemplate = null;

    private static RedisTemplate<String, String> obtainRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = RedisHelper.obtainPartitionStringRedisTemplate();
        }
        return redisTemplate;
    }

    /**
     * KEYS
     *
     * @param pattern
     * @return
     */
    public static Set<String> keys(String pattern) {
        return RedisUtils.keys(obtainRedisTemplate(), pattern);
    }

    /**
     * SET
     *
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        RedisUtils.set(obtainRedisTemplate(), key, value);
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
        RedisUtils.setex(obtainRedisTemplate(), key, value, timeout, unit);
    }

    /**
     * SETNX
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean setnx(String key, String value) {
        return RedisUtils.setnx(obtainRedisTemplate(), key, value);
    }

    /**
     * MSET
     *
     * @param map
     */
    public static void mset(Map<String, String> map) {
        RedisUtils.mset(obtainRedisTemplate(), map);
    }

    /**
     * MSETNX
     *
     * @param map
     * @return
     */
    public static Boolean msetnx(Map<String, String> map) {
        return RedisUtils.msetnx(obtainRedisTemplate(), map);
    }

    /**
     * GET
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        return RedisUtils.get(obtainRedisTemplate(), key);
    }

    /**
     * GETSET
     *
     * @param key
     * @param value
     * @return
     */
    public static String getset(String key, String value) {
        return RedisUtils.getset(obtainRedisTemplate(), key, value);
    }

    /**
     * EXISTS
     *
     * @param key
     * @return
     */
    public static Boolean exists(String key) {
        return RedisUtils.exists(obtainRedisTemplate(), key);
    }

    /**
     * mget
     *
     * @param keys
     * @return
     */
    public static List<String> mget(Collection<String> keys) {
        return RedisUtils.mget(obtainRedisTemplate(), keys);
    }

    /**
     * INCR
     *
     * @param key
     * @return
     */
    public static Long incr(String key) {
        return RedisUtils.incr(obtainRedisTemplate(), key);
    }

    /**
     * INCRBY
     *
     * @param key
     * @param delta
     * @return
     */
    public static Long incrby(String key, long delta) {
        return RedisUtils.incrby(obtainRedisTemplate(), key, delta);
    }

    /**
     * INCRBYFLOAT
     *
     * @param key
     * @param delta
     * @return
     */
    public static Double incrbyfloat(String key, double delta) {
        return RedisUtils.incrbyfloat(obtainRedisTemplate(), key, delta);
    }

    /**
     * APPEND
     *
     * @param key
     * @param value
     * @return
     */
    public static Integer append(String key, String value) {
        return RedisUtils.append(obtainRedisTemplate(), key, value);
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
        return RedisUtils.getrange(obtainRedisTemplate(), key, start, end);
    }

    /**
     * SETRANGE
     *
     * @return
     */
    public static void setrange(String key, String value, long offset) {
        RedisUtils.setrange(obtainRedisTemplate(), key, value, offset);
    }

    /**
     * STRLEN
     *
     * @param key
     * @return
     */
    public static Long strlen(String key) {
        return RedisUtils.strlen(obtainRedisTemplate(), key);
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
        return RedisUtils.setbit(obtainRedisTemplate(), key, offset, value);
    }

    /**
     * GETBIT
     *
     * @param key
     * @param offset
     * @return
     */
    public static Boolean getbit(String key, long offset) {
        return RedisUtils.getbit(obtainRedisTemplate(), key, offset);
    }

    /**
     * DEL
     *
     * @param keys
     */
    public static void del(String... keys) {
        RedisUtils.del(obtainRedisTemplate(), keys);
    }

    /**
     * HEXISTS
     *
     * @param key
     * @param field
     * @return
     */
    public static Boolean hexists(String key, String field) {
        return RedisUtils.hexists(obtainRedisTemplate(), key, field);
    }

    /**
     * HGET
     *
     * @param key
     * @param field
     * @return
     */
    public static String hget(String key, String field) {
        return RedisUtils.hget(obtainRedisTemplate(), key, field);
    }

    /**
     * HGETALL
     *
     * @return
     */
    public static Map<String, String> hgetAll(String key) {
        return RedisUtils.hgetAll(obtainRedisTemplate(), key);
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
        return RedisUtils.hincrBy(obtainRedisTemplate(), key, field, increment);
    }

    /**
     * HINCRBYFLOAT
     *
     * @param key
     * @param field
     * @param increment
     * @return
     */
    public static Double hincrbyfloat(String key, String field, double increment) {
        return RedisUtils.hincrbyfloat(obtainRedisTemplate(), key, field, increment);
    }

    /**
     * HKEYS
     *
     * @param key
     * @return
     */
    public static Set<String> hkeys(String key) {
        return RedisUtils.hkeys(obtainRedisTemplate(), key);
    }

    /**
     * HLEN
     *
     * @param key
     * @return
     */
    public static Long hlen(String key) {
        return RedisUtils.hlen(obtainRedisTemplate(), key);
    }

    /**
     * HMGET
     *
     * @param key
     * @param fields
     */
    public static void hmget(String key, String... fields) {
        RedisUtils.hmget(obtainRedisTemplate(), key, fields);
    }

    /**
     * HMSET
     *
     * @param key
     * @param map
     */
    public static void hmset(String key, Map<String, String> map) {
        RedisUtils.hmset(obtainRedisTemplate(), key, map);
    }

    /**
     * HSET
     *
     * @param key
     * @param field
     * @param value
     */
    public static void hset(String key, String field, String value) {
        RedisUtils.hset(obtainRedisTemplate(), key, field, value);
    }

    /**
     * HSETNX
     *
     * @param key
     * @param field
     * @param value
     */
    public static void hsetnx(String key, String field, String value) {
        RedisUtils.hsetnx(obtainRedisTemplate(), key, field, value);
    }

    /**
     * HVALS
     *
     * @param key
     * @return
     */
    public static List<String> hvals(String key) {
        return RedisUtils.hvals(obtainRedisTemplate(), key);
    }

    /**
     * EXPIRE
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public static Boolean expire(String key, long timeout, TimeUnit unit) {
        return RedisUtils.expire(obtainRedisTemplate(), key, timeout, unit);
    }

    /**
     * EXPIREAT
     *
     * @param key
     * @param date
     * @return
     */
    public static Boolean expireAt(String key, Date date) {
        return RedisUtils.expireAt(obtainRedisTemplate(), key, date);
    }

    /**
     * HDEL
     *
     * @param key
     * @param fields
     * @return
     */
    public static Long hdel(String key, String... fields) {
        return RedisUtils.hdel(obtainRedisTemplate(), key, fields);
    }

    /**
     * TTL
     *
     * @param key
     * @return
     */
    public static Long ttl(String key) {
        return RedisUtils.ttl(obtainRedisTemplate(), key);
    }

    /**
     * TTL
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public static Long ttl(String key, TimeUnit timeUnit) {
        return RedisUtils.ttl(obtainRedisTemplate(), key, timeUnit);
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
        return RedisUtils.lrange(obtainRedisTemplate(), key, start, end);
    }

    /**
     * LTRIM
     *
     * @param key
     * @param start
     * @param end
     */
    public static void ltrim(String key, long start, long end) {
        RedisUtils.ltrim(obtainRedisTemplate(), key, start, end);
    }

    /**
     * LLEN
     *
     * @param key
     * @return
     */
    public static Long llen(String key) {
        return RedisUtils.llen(obtainRedisTemplate(), key);
    }

    /**
     * LPUSH
     *
     * @param key
     * @param value
     * @return
     */
    public static Long lpush(String key, String value) {
        return RedisUtils.lpush(obtainRedisTemplate(), key, value);
    }

    /**
     * LPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long lpush(String key, String... values) {
        return RedisUtils.lpush(obtainRedisTemplate(), key, values);
    }

    /**
     * LPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long lpushx(String key, String value) {
        return RedisUtils.lpushx(obtainRedisTemplate(), key, value);
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
        return RedisUtils.lpush(obtainRedisTemplate(), key, pivot, value);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param value
     * @return
     */
    public static Long rpush(String key, String value) {
        return RedisUtils.rpush(obtainRedisTemplate(), key, value);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long rpush(String key, String... values) {
        return RedisUtils.rpush(obtainRedisTemplate(), key, values);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long rpush(String key, Collection<String> values) {
        return RedisUtils.rpush(obtainRedisTemplate(), key, values);
    }

    /**
     * RPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long rpushx(String key, String value) {
        return RedisUtils.rpushx(obtainRedisTemplate(), key, value);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public static Long rpush(String key, String pivot, String value) {
        return RedisUtils.rpush(obtainRedisTemplate(), key, pivot, value);
    }

    /**
     * LSET
     *
     * @param key
     * @param index
     * @param value
     */
    public static void lset(String key, long index, String value) {
        RedisUtils.lset(obtainRedisTemplate(), key, index, value);
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
        return RedisUtils.lrem(obtainRedisTemplate(), key, count, value);
    }

    /**
     * LINDEX
     *
     * @param key
     * @param index
     * @return
     */
    public static String lindex(String key, long index) {
        return RedisUtils.lindex(obtainRedisTemplate(), key, index);
    }

    /**
     * LPOP
     *
     * @param key
     * @return
     */
    public static String lpop(String key) {
        return RedisUtils.lpop(obtainRedisTemplate(), key);
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
        return RedisUtils.blpop(obtainRedisTemplate(), key, timeout, unit);
    }

    /**
     * RPOP
     *
     * @param key
     * @return
     */
    public static String rpop(String key) {
        return RedisUtils.rpop(obtainRedisTemplate(), key);
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
        return RedisUtils.brpop(obtainRedisTemplate(), key, timeout, unit);
    }

    /**
     * RPOPLPUSH
     *
     * @param sourceKey
     * @param destinationKey
     * @return
     */
    public static String rpoplpush(String sourceKey, String destinationKey) {
        return RedisUtils.rpoplpush(obtainRedisTemplate(), sourceKey, destinationKey);
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
        return RedisUtils.brpoplpush(obtainRedisTemplate(), sourceKey, destinationKey, timeout, unit);
    }

    /**
     * SADD
     *
     * @param key
     * @param values
     * @return
     */
    public static Long sadd(String key, String... values) {
        return RedisUtils.sadd(obtainRedisTemplate(), key, values);
    }

    /**
     * SREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long srem(String key, Object... values) {
        return RedisUtils.srem(obtainRedisTemplate(), key, values);
    }

    /**
     * SPOP
     *
     * @param key
     * @return
     */
    public static String spop(String key) {
        return RedisUtils.spop(obtainRedisTemplate(), key);
    }

    /**
     * SPOP
     *
     * @param key
     * @param count
     * @return
     */
    public static List<String> spop(String key, long count) {
        return RedisUtils.spop(obtainRedisTemplate(), key, count);
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
        return RedisUtils.smove(obtainRedisTemplate(), key, value, destKey);
    }

    /**
     * SCARD
     *
     * @param key
     * @return
     */
    public static Long scard(String key) {
        return RedisUtils.scard(obtainRedisTemplate(), key);
    }

    /**
     * SISMEMBER
     *
     * @param key
     * @param object
     * @return
     */
    public static Boolean sismember(String key, Object object) {
        return RedisUtils.sismember(obtainRedisTemplate(), key, object);
    }

    /**
     * SINTER
     *
     * @param key
     * @param otherKey
     * @return
     */
    public static Set<String> sinter(String key, String otherKey) {
        return RedisUtils.sinter(obtainRedisTemplate(), key, otherKey);
    }

    /**
     * SINTER
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public static Set<String> sinter(String key, Collection<String> otherKeys) {
        return RedisUtils.sinter(obtainRedisTemplate(), key, otherKeys);
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
        return RedisUtils.sinterstore(obtainRedisTemplate(), key, otherKey, destKey);
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
        return RedisUtils.sinterstore(obtainRedisTemplate(), key, otherKeys, destKey);
    }

    /**
     * SUNION
     *
     * @param key
     * @param otherKey
     * @return
     */
    public static Set<String> sunion(String key, String otherKey) {
        return RedisUtils.sunion(obtainRedisTemplate(), key, otherKey);
    }

    /**
     * SUNION
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public static Set<String> sunion(String key, Collection<String> otherKeys) {
        return RedisUtils.sunion(obtainRedisTemplate(), key, otherKeys);
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
        return RedisUtils.sunionstore(obtainRedisTemplate(), key, otherKey, destKey);
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
        return RedisUtils.sunionstore(obtainRedisTemplate(), key, otherKeys, destKey);
    }

    /**
     * SDIFF
     *
     * @param key
     * @param otherKey
     * @return
     */
    public static Set<String> sdiff(String key, String otherKey) {
        return RedisUtils.sdiff(obtainRedisTemplate(), key, otherKey);
    }

    /**
     * SDIFF
     *
     * @param key
     * @param otherKeys
     * @return
     */
    public static Set<String> sdiff(String key, Collection<String> otherKeys) {
        return RedisUtils.sdiff(obtainRedisTemplate(), key, otherKeys);
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
        return RedisUtils.sdiffstore(obtainRedisTemplate(), key, otherKey, destKey);
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
        return RedisUtils.sdiffstore(obtainRedisTemplate(), key, otherKeys, destKey);
    }

    /**
     * SMEMBERS
     *
     * @param key
     * @return
     */
    public static Set<String> smembers(String key) {
        return RedisUtils.smembers(obtainRedisTemplate(), key);
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @return
     */
    public static String srandmember(String key) {
        return RedisUtils.srandmember(obtainRedisTemplate(), key);
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @param count
     * @return
     */
    public static List<String> srandmember(String key, long count) {
        return RedisUtils.srandmember(obtainRedisTemplate(), key, count);
    }

    /**
     * ZADD
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
    public static Boolean zadd(String key, String value, double score) {
        return RedisUtils.zadd(obtainRedisTemplate(), key, value, score);
    }

    /**
     * ZADD
     *
     * @param key
     * @param tuples
     * @return
     */
    public static Long zadd(String key, Set<ZSetOperations.TypedTuple<String>> tuples) {
        return RedisUtils.zadd(obtainRedisTemplate(), key, tuples);
    }

    /**
     * ZREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long zrem(String key, Object... values) {
        return RedisUtils.zrem(obtainRedisTemplate(), key, values);
    }

    /**
     * ZINCRBY
     *
     * @param key
     * @param value
     * @param delta
     * @return
     */
    public static Double zincrby(String key, String value, double delta) {
        return RedisUtils.zincrby(obtainRedisTemplate(), key, value, delta);
    }

    /**
     * ZRANK
     *
     * @param key
     * @param object
     * @return
     */
    public static Long zrank(String key, Object object) {
        return RedisUtils.zrank(obtainRedisTemplate(), key, object);
    }

    /**
     * ZREVRANK
     *
     * @param key
     * @param object
     * @return
     */
    public static Long zrevrank(String key, Object object) {
        return RedisUtils.zrevrank(obtainRedisTemplate(), key, object);
    }

    /**
     * ZRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> zrange(String key, long start, long end) {
        return RedisUtils.zrange(obtainRedisTemplate(), key, start, end);
    }

    /**
     * ZRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<String> zrangebyscore(String key, double min, double max) {
        return RedisUtils.zrangebyscore(obtainRedisTemplate(), key, min, max);
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
    public static Set<String> zrangebyscore(String key, double min, double max, long offset, long count) {
        return RedisUtils.zrangebyscore(obtainRedisTemplate(), key, min, max, offset, count);
    }

    /**
     * ZREVRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> zrevrange(String key, long start, long end) {
        return RedisUtils.zrevrange(obtainRedisTemplate(), key, start, end);
    }

    /**
     * ZREVRANGE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<String> zrevrange(String key, double min, double max) {
        return RedisUtils.zrevrange(obtainRedisTemplate(), key, min, max);
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
    public static Set<String> zrevrangebyscore(String key, double min, double max, long offset, long count) {
        return RedisUtils.zrevrangebyscore(obtainRedisTemplate(), key, min, max, offset, count);
    }

    /**
     * ZCOUNT
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Long zcount(String key, double min, double max) {
        return RedisUtils.zcount(obtainRedisTemplate(), key, min, max);
    }

    /**
     * ZCARD
     *
     * @param key
     * @return
     */
    public static Long zcard(String key) {
        return RedisUtils.zcard(obtainRedisTemplate(), key);
    }

    /**
     * ZSCORE
     *
     * @param key
     * @param object
     * @return
     */
    public static Double zscore(String key, Object object) {
        return RedisUtils.zscore(obtainRedisTemplate(), key, object);
    }

    /**
     * ZREMRANGEBYRANK
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Long zremrangebyrank(String key, long start, long end) {
        return RedisUtils.zremrangebyrank(obtainRedisTemplate(), key, start, end);
    }

    /**
     * ZREMRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Long zremrangebyscore(String key, double min, double max) {
        return RedisUtils.zremrangebyscore(obtainRedisTemplate(), key, min, max);
    }

    /**
     * ZUNIONSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long zunionstore(String key, String otherKey, String destKey) {
        return RedisUtils.zunionstore(obtainRedisTemplate(), key, otherKey, destKey);
    }

    /**
     * ZUNIONSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long zunionstore(String key, Collection<String> otherKeys, String destKey) {
        return RedisUtils.zunionstore(obtainRedisTemplate(), key, otherKeys, destKey);
    }

    /**
     * ZINTERSTORE
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public static Long zinterstore(String key, String otherKey, String destKey) {
        return RedisUtils.zinterstore(obtainRedisTemplate(), key, otherKey, destKey);
    }

    /**
     * ZINTERSTORE
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public static Long zinterstore(String key, Collection<String> otherKeys, String destKey) {
        return RedisUtils.zinterstore(obtainRedisTemplate(), key, otherKeys, destKey);
    }

    /**
     * GET
     *
     * @param key
     * @return
     */
    public static byte[] get(byte[] key) {
        return RedisUtils.get(obtainRedisTemplate(), key);
    }

    /**
     * GETSET
     *
     * @param key
     * @param value
     * @return
     */
    public static byte[] getset(byte[] key, byte[] value) {
        return RedisUtils.getset(obtainRedisTemplate(), key, value);
    }

    /**
     * MGET
     *
     * @param keys
     * @return
     */
    public static List<byte[]> mget(byte[]... keys) {
        return RedisUtils.mget(obtainRedisTemplate(), keys);
    }

    /**
     * SET
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean set(byte[] key, byte[] value) {
        return RedisUtils.set(obtainRedisTemplate(), key, value);
    }

    /**
     * SETNX
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean setnx(byte[] key, byte[] value) {
        return RedisUtils.setnx(obtainRedisTemplate(), key, value);
    }

    /**
     * SETEX
     *
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public static Boolean setex(byte[] key, long seconds, byte[] value) {
        return RedisUtils.setex(obtainRedisTemplate(), key, seconds, value);
    }

    /**
     * PSETEX
     *
     * @param key
     * @param milliseconds
     * @param value
     * @return
     */
    public static Boolean psetex(byte[] key, long milliseconds, byte[] value) {
        return RedisUtils.psetex(obtainRedisTemplate(), key, milliseconds, value);
    }

    /**
     * MSET
     *
     * @param tuple
     * @return
     */
    public static Boolean _mset(Map<byte[], byte[]> tuple) {
        return RedisUtils._mset(obtainRedisTemplate(), tuple);
    }

    /**
     * MSETNX
     *
     * @param tuple
     * @return
     */
    public static Boolean _msetnx(Map<byte[], byte[]> tuple) {
        return RedisUtils._msetnx(obtainRedisTemplate(), tuple);
    }

    /**
     * INCR
     *
     * @param key
     * @return
     */
    public static Long incr(byte[] key) {
        return RedisUtils.incr(obtainRedisTemplate(), key);
    }

    /**
     * INCRBY
     *
     * @param key
     * @param value
     * @return
     */
    public static Long incrby(byte[] key, long value) {
        return RedisUtils.incrby(obtainRedisTemplate(), key, value);
    }

    /**
     * INCRBY
     *
     * @param key
     * @param value
     * @return
     */
    public static Double incrby(byte[] key, double value) {
        return RedisUtils.incrby(obtainRedisTemplate(), key, value);
    }

    /**
     * DECR
     *
     * @param key
     * @return
     */
    public static Long decr(byte[] key) {
        return RedisUtils.decr(obtainRedisTemplate(), key);
    }

    /**
     * DECRBY
     *
     * @param key
     * @param value
     * @return
     */
    public static Long decrBy(byte[] key, long value) {
        return RedisUtils.decrBy(obtainRedisTemplate(), key, value);
    }

    /**
     * APPEND
     *
     * @param key
     * @param value
     * @return
     */
    public static Long append(byte[] key, byte[] value) {
        return RedisUtils.append(obtainRedisTemplate(), key, value);
    }

    /**
     * GETRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static byte[] getrange(byte[] key, long start, long end) {
        return RedisUtils.getrange(obtainRedisTemplate(), key, start, end);
    }

    /**
     * SETRANGE
     *
     * @param key
     * @param value
     * @param offset
     */
    public static void setrange(byte[] key, byte[] value, long offset) {
        RedisUtils.setrange(obtainRedisTemplate(), key, value, offset);
    }

    /**
     * GETBIT
     *
     * @param key
     * @param offset
     * @return
     */
    public static Boolean getbit(byte[] key, long offset) {
        return RedisUtils.getbit(obtainRedisTemplate(), key, offset);
    }

    /**
     * SETBIT
     *
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public static Boolean setbit(byte[] key, long offset, boolean value) {
        return RedisUtils.setbit(obtainRedisTemplate(), key, offset, value);
    }

    /**
     * BITCOUNT
     *
     * @param key
     * @return
     */
    public static Long bitcount(byte[] key) {
        return RedisUtils.bitcount(obtainRedisTemplate(), key);
    }

    /**
     * BITCOUNT
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Long bitcount(byte[] key, long start, long end) {
        return RedisUtils.bitcount(obtainRedisTemplate(), key, start, end);
    }

    /**
     * BITOP
     *
     * @param op
     * @param destination
     * @param keys
     * @return
     */
    public static Long bitop(RedisStringCommands.BitOperation op, byte[] destination, byte[]... keys) {
        return RedisUtils.bitop(obtainRedisTemplate(), op, destination, keys);
    }

    /**
     * STRLEN
     *
     * @param key
     * @return
     */
    public static Long strlen(byte[] key) {
        return RedisUtils.strlen(obtainRedisTemplate(), key);
    }

    /**
     * HSET
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static Boolean hset(byte[] key, byte[] field, byte[] value) {
        return RedisUtils.hset(obtainRedisTemplate(), key, field, value);
    }

    /**
     * HSETNX
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static Boolean hsetnx(byte[] key, byte[] field, byte[] value) {
        return RedisUtils.hsetnx(obtainRedisTemplate(), key, field, value);
    }

    /**
     * HGET
     *
     * @param key
     * @param field
     * @return
     */
    public static byte[] hget(byte[] key, byte[] field) {
        return RedisUtils.hget(obtainRedisTemplate(), key, field);
    }

    /**
     * HMGET
     *
     * @param key
     * @param fields
     * @return
     */
    public static List<byte[]> hmget(byte[] key, byte[]... fields) {
        return RedisUtils.hmget(obtainRedisTemplate(), key, fields);
    }

    /**
     * HMSET
     *
     * @param key
     * @param hashes
     */
    public static void hmset(byte[] key, Map<byte[], byte[]> hashes) {
        RedisUtils.hmset(obtainRedisTemplate(), key, hashes);
    }

    /**
     * HINCRBY
     *
     * @param key
     * @param field
     * @param delta
     * @return
     */
    public static Long hincrby(byte[] key, byte[] field, long delta) {
        return RedisUtils.hincrby(obtainRedisTemplate(), key, field, delta);
    }

    /**
     * HINCRBYFLOAT
     *
     * @param key
     * @param field
     * @param delta
     * @return
     */
    public static Double hincrbyfloat(byte[] key, byte[] field, double delta) {
        return RedisUtils.hincrbyfloat(obtainRedisTemplate(), key, field, delta);
    }

    /**
     * HEXISTS
     *
     * @param key
     * @param field
     * @return
     */
    public static Boolean hexists(byte[] key, byte[] field) {
        return RedisUtils.hexists(obtainRedisTemplate(), key, field);
    }

    /**
     * HDEL
     *
     * @param key
     * @param fields
     * @return
     */
    public static Long hdel(byte[] key, byte[]... fields) {
        return RedisUtils.hdel(obtainRedisTemplate(), key, fields);
    }

    /**
     * HLEN
     *
     * @param key
     * @return
     */
    public static Long hlen(byte[] key) {
        return RedisUtils.hlen(obtainRedisTemplate(), key);
    }

    /**
     * HKEYS
     *
     * @param key
     * @return
     */
    public static Set<byte[]> hkeys(byte[] key) {
        return RedisUtils.hkeys(obtainRedisTemplate(), key);
    }

    /**
     * HVALS
     *
     * @param key
     * @return
     */
    public static List<byte[]> hvals(byte[] key) {
        return RedisUtils.hvals(obtainRedisTemplate(), key);
    }

    /**
     * HGETALL
     *
     * @param key
     * @return
     */
    public static Map<byte[], byte[]> hgetall(byte[] key) {
        return RedisUtils.hgetall(obtainRedisTemplate(), key);
    }

    /**
     * HSCAN
     *
     * @param key
     * @param options
     * @return
     */
    public static Cursor<Map.Entry<byte[], byte[]>> hscan(byte[] key, ScanOptions options) {
        return RedisUtils.hscan(obtainRedisTemplate(), key, options);
    }

    /**
     * RPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long rpush(byte[] key, byte[]... values) {
        return RedisUtils.rpush(obtainRedisTemplate(), key, values);
    }

    /**
     * LPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long lpush(byte[] key, byte[]... values) {
        return RedisUtils.lpush(obtainRedisTemplate(), key, values);
    }

    /**
     * RPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long rpushx(byte[] key, byte[] value) {
        return RedisUtils.rpushx(obtainRedisTemplate(), key, value);
    }

    /**
     * LPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long lpushx(byte[] key, byte[] value) {
        return RedisUtils.lpushx(obtainRedisTemplate(), key, value);
    }

    /**
     * LLEN
     *
     * @param key
     * @return
     */
    public static Long llen(byte[] key) {
        return RedisUtils.llen(obtainRedisTemplate(), key);
    }

    /**
     * LRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static List<byte[]> lrange(byte[] key, long start, long end) {
        return RedisUtils.lrange(obtainRedisTemplate(), key, start, end);
    }

    /**
     * LTRIM
     *
     * @param key
     * @param start
     * @param end
     */
    public static void ltrim(byte[] key, long start, long end) {
        RedisUtils.ltrim(obtainRedisTemplate(), key, start, end);
    }

    /**
     * LINDEX
     *
     * @param key
     * @param index
     * @return
     */
    public static byte[] lindex(byte[] key, long index) {
        return RedisUtils.lindex(obtainRedisTemplate(), key, index);
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
    public static Long linsert(byte[] key, RedisListCommands.Position where, byte[] pivot, byte[] value) {
        return RedisUtils.linsert(obtainRedisTemplate(), key, where, pivot, value);
    }

    /**
     * LSET
     *
     * @param key
     * @param index
     * @param value
     */
    public static void lset(byte[] key, long index, byte[] value) {
        RedisUtils.lset(obtainRedisTemplate(), key, index, value);
    }

    /**
     * LREM
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    public static Long lrem(byte[] key, long count, byte[] value) {
        return RedisUtils.lrem(obtainRedisTemplate(), key, count, value);
    }

    /**
     * LPOP
     *
     * @param key
     * @return
     */
    public static byte[] lpop(byte[] key) {
        return RedisUtils.lpop(obtainRedisTemplate(), key);
    }

    /**
     * RPOP
     *
     * @param key
     * @return
     */
    public static byte[] rpop(byte[] key) {
        return RedisUtils.rpop(obtainRedisTemplate(), key);
    }

    /**
     * BLPOP
     *
     * @param timeout
     * @param keys
     * @return
     */
    public static List<byte[]> blpop(int timeout, byte[]... keys) {
        return RedisUtils.blpop(obtainRedisTemplate(), timeout, keys);
    }

    /**
     * BRPOP
     *
     * @param timeout
     * @param keys
     * @return
     */
    public static List<byte[]> brpop(int timeout, byte[]... keys) {
        return RedisUtils.brpop(obtainRedisTemplate(), timeout, keys);
    }

    /**
     * RPOPLPUSH
     *
     * @param srcKey
     * @param dstKey
     * @return
     */
    public static byte[] rpoplpush(byte[] srcKey, byte[] dstKey) {
        return RedisUtils.rpoplpush(obtainRedisTemplate(), srcKey, dstKey);
    }

    /**
     * BRPOPLPUSH
     *
     * @param timeout
     * @param srcKey
     * @param dstKey
     * @return
     */
    public static byte[] brpoplpush(int timeout, byte[] srcKey, byte[] dstKey) {
        return RedisUtils.brpoplpush(obtainRedisTemplate(), timeout, srcKey, dstKey);
    }

    /**
     * SADD
     *
     * @param key
     * @param values
     * @return
     */
    public static Long sadd(byte[] key, byte[]... values) {
        return RedisUtils.sadd(obtainRedisTemplate(), key, values);
    }

    /**
     * SREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long srem(byte[] key, byte[]... values) {
        return RedisUtils.srem(obtainRedisTemplate(), key, values);
    }

    /**
     * SPOP
     *
     * @param key
     * @return
     */
    public static byte[] spop(byte[] key) {
        return RedisUtils.spop(obtainRedisTemplate(), key);
    }

    /**
     * SPOP
     *
     * @param key
     * @param count
     * @return
     */
    public static List<byte[]> spop(byte[] key, long count) {
        return RedisUtils.spop(obtainRedisTemplate(), key, count);
    }

    /**
     * SMOVE
     *
     * @param srcKey
     * @param destKey
     * @param value
     * @return
     */
    public static Boolean smove(byte[] srcKey, byte[] destKey, byte[] value) {
        return RedisUtils.smove(obtainRedisTemplate(), srcKey, destKey, value);
    }

    /**
     * SCARD
     *
     * @param key
     * @return
     */
    public static Long scard(byte[] key) {
        return RedisUtils.scard(obtainRedisTemplate(), key);
    }

    /**
     * SISMEMBER
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean sismember(byte[] key, byte[] value) {
        return RedisUtils.sismember(obtainRedisTemplate(), key, value);
    }

    /**
     * SINTER
     *
     * @param keys
     * @return
     */
    public static Set<byte[]> sinter(byte[]... keys) {
        return RedisUtils.sinter(obtainRedisTemplate(), keys);
    }

    /**
     * SINTERSTORE
     *
     * @param destKey
     * @param keys
     * @return
     */
    public static Long sinterstore(byte[] destKey, byte[]... keys) {
        return RedisUtils.sinterstore(obtainRedisTemplate(), destKey, keys);
    }

    /**
     * SUNION
     *
     * @param keys
     * @return
     */
    public static Set<byte[]> sunion(byte[]... keys) {
        return RedisUtils.sunion(obtainRedisTemplate(), keys);
    }

    /**
     * SUNIONSTORE
     *
     * @param destKey
     * @param keys
     * @return
     */
    public static Long sunionstore(byte[] destKey, byte[]... keys) {
        return RedisUtils.sunionstore(obtainRedisTemplate(), destKey, keys);
    }

    /**
     * SDIFF
     *
     * @param keys
     * @return
     */
    public static Set<byte[]> sdiff(byte[]... keys) {
        return RedisUtils.sdiff(obtainRedisTemplate(), keys);
    }

    /**
     * SDIFFSTORE
     *
     * @param destKey
     * @param keys
     * @return
     */
    public static Long sdiffstore(byte[] destKey, byte[]... keys) {
        return RedisUtils.sdiffstore(obtainRedisTemplate(), destKey, keys);
    }

    /**
     * smembers
     *
     * @param key
     * @return
     */
    public static Set<byte[]> smembers(byte[] key) {
        return RedisUtils.smembers(obtainRedisTemplate(), key);
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @return
     */
    public static byte[] srandmember(byte[] key) {
        return RedisUtils.srandmember(obtainRedisTemplate(), key);
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @param count
     * @return
     */
    public static List<byte[]> srandmember(byte[] key, long count) {
        return RedisUtils.srandmember(obtainRedisTemplate(), key, count);
    }

    /**
     * SSCAN
     *
     * @param key
     * @param options
     * @return
     */
    public static Cursor<byte[]> sscan(byte[] key, ScanOptions options) {
        return RedisUtils.sscan(obtainRedisTemplate(), key, options);
    }

    /**
     * ZADD
     *
     * @param key
     * @param score
     * @param value
     * @return
     */
    public static Boolean zadd(byte[] key, double score, byte[] value) {
        return RedisUtils.zadd(obtainRedisTemplate(), key, score, value);
    }

    /**
     * ZADD
     *
     * @param key
     * @param tuples
     * @return
     */
    public static Long zadd(byte[] key, Set<RedisZSetCommands.Tuple> tuples) {
        return RedisUtils.zadd(obtainRedisTemplate(), key, tuples);
    }

    /**
     * ZREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long zrem(byte[] key, byte[]... values) {
        return RedisUtils.zrem(obtainRedisTemplate(), key, values);
    }

    /**
     * ZINCRBY
     *
     * @param key
     * @param increment
     * @param value
     * @return
     */
    public static Double zincrby(byte[] key, double increment, byte[] value) {
        return RedisUtils.zincrby(obtainRedisTemplate(), key, increment, value);
    }

    /**
     * ZRANK
     *
     * @param key
     * @param value
     * @return
     */
    public static Long zrank(byte[] key, byte[] value) {
        return RedisUtils.zrank(obtainRedisTemplate(), key, value);
    }

    /**
     * ZREVRANK
     *
     * @param key
     * @param value
     * @return
     */
    public static Long zrevrank(byte[] key, byte[] value) {
        return RedisUtils.zrevrank(obtainRedisTemplate(), key, value);
    }

    /**
     * ZRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<byte[]> zrange(byte[] key, long start, long end) {
        return RedisUtils.zrange(obtainRedisTemplate(), key, start, end);
    }

    /**
     * ZRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<byte[]> zrangebyscore(byte[] key, double min, double max) {
        return RedisUtils.zrangebyscore(obtainRedisTemplate(), key, min, max);
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
    public static Set<byte[]> zrangebyscore(byte[] key, double min, double max, long offset, long count) {
        return RedisUtils.zrangebyscore(obtainRedisTemplate(), key, min, max, offset, count);
    }

    /**
     * ZREVRANGE
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<byte[]> zrevrange(byte[] key, long start, long end) {
        return RedisUtils.zrevrange(obtainRedisTemplate(), key, start, end);
    }

    /**
     * ZREVRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<byte[]> zrevrangebyscore(byte[] key, double min, double max) {
        return RedisUtils.zrevrangebyscore(obtainRedisTemplate(), key, min, max);
    }

    /**
     * ZREVRANGEBYSCORE
     *
     * @param key
     * @param range
     * @return
     */
    public static Set<byte[]> zrevrangebyscore(byte[] key, RedisZSetCommands.Range range) {
        return RedisUtils.zrevrangebyscore(obtainRedisTemplate(), key, range);
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
    public static Set<byte[]> zrevrangebyscore(byte[] key, double min, double max, long offset, long count) {
        return RedisUtils.zrevrangebyscore(obtainRedisTemplate(), key, min, max, offset, count);
    }

    /**
     * ZREVRANGEBYSCORE
     *
     * @param key
     * @param range
     * @param limit
     * @return
     */
    public static Set<byte[]> zrevrangebyscore(byte[] key, RedisZSetCommands.Range range, RedisZSetCommands.Limit limit) {
        return RedisUtils.zrevrangebyscore(obtainRedisTemplate(), key, range, limit);
    }

    /**
     * ZCOUNT
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Long zcount(byte[] key, double min, double max) {
        return RedisUtils.zcount(obtainRedisTemplate(), key, min, max);
    }

    /**
     * ZCARD
     *
     * @param key
     * @return
     */
    public static Long zcard(byte[] key) {
        return RedisUtils.zcard(obtainRedisTemplate(), key);
    }

    /**
     * ZSCORE
     *
     * @param key
     * @param value
     * @return
     */
    public static Double zscore(byte[] key, byte[] value) {
        return RedisUtils.zscore(obtainRedisTemplate(), key, value);
    }

    /**
     * ZREMRANGEBYRANK
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Long zremrangebyrank(byte[] key, long start, long end) {
        return RedisUtils.zremrangebyrank(obtainRedisTemplate(), key, start, end);
    }

    /**
     * ZREMRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Long zremrangebyscore(byte[] key, double min, double max) {
        return RedisUtils.zremrangebyscore(obtainRedisTemplate(), key, min, max);
    }

    /**
     * ZUNIONSTORE
     *
     * @param destKey
     * @param sets
     * @return
     */
    public static Long zunionstore(byte[] destKey, byte[]... sets) {
        return RedisUtils.zunionstore(obtainRedisTemplate(), destKey, sets);
    }

    /**
     * ZINTERSTORE
     *
     * @param destKey
     * @param sets
     * @return
     */
    public static Long zinterstore(byte[] destKey, byte[]... sets) {
        return RedisUtils.zinterstore(obtainRedisTemplate(), destKey, sets);
    }

    /**
     * ZSCAN
     *
     * @param key
     * @param options
     * @return
     */
    public static Cursor<RedisZSetCommands.Tuple> zscan(byte[] key, ScanOptions options) {
        return RedisUtils.zscan(obtainRedisTemplate(), key, options);
    }

    /**
     * ZRANGEBYSCORE
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<byte[]> zrangebyscore(byte[] key, String min, String max) {
        return RedisUtils.zrangebyscore(obtainRedisTemplate(), key, min, max);
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
    public static Set<byte[]> zrangebyscore(byte[] key, String min, String max, long offset, long count) {
        return RedisUtils.zrangebyscore(obtainRedisTemplate(), key, min, max, offset, count);
    }

    /**
     * ZRANGEBYLEX
     *
     * @param key
     * @return
     */
    public static Set<byte[]> zrangebylex(byte[] key) {
        return RedisUtils.zrangebylex(obtainRedisTemplate(), key);
    }

    /**
     * EXISTS
     *
     * @param key
     * @return
     */
    public static Boolean exists(byte[] key) {
        return RedisUtils.exists(obtainRedisTemplate(), key);
    }

    /**
     * DEL
     *
     * @param keys
     * @return
     */
    public static Long del(byte[]... keys) {
        return RedisUtils.del(obtainRedisTemplate(), keys);
    }

    /**
     * TYPE
     *
     * @param key
     * @return
     */
    public static String type(byte[] key) {
        return RedisUtils.type(obtainRedisTemplate(), key);
    }

    /**
     * KEYS
     *
     * @param pattern
     * @return
     */
    public static Set<byte[]> keys(byte[] pattern) {
        return RedisUtils.keys(obtainRedisTemplate(), pattern);
    }

    /**
     * SCAN
     *
     * @param options
     * @return
     */
    public static Cursor<byte[]> scan(ScanOptions options) {
        return RedisUtils.scan(obtainRedisTemplate(), options);
    }

    /**
     * RANDOMKEY
     *
     * @return
     */
    public static byte[] randomkey() {
        return RedisUtils.randomkey(obtainRedisTemplate());
    }

    /**
     * RENAME
     *
     * @param sourceKey
     * @param targetKey
     */
    public static void rename(byte[] sourceKey, byte[] targetKey) {
        RedisUtils.rename(obtainRedisTemplate(), sourceKey, targetKey);
    }

    /**
     * RENAMENX
     *
     * @param sourceKey
     * @param targetKey
     * @return
     */
    public static Boolean renamenx(byte[] sourceKey, byte[] targetKey) {
        return RedisUtils.renamenx(obtainRedisTemplate(), sourceKey, targetKey);
    }

    /**
     * EXPIRE
     *
     * @param key
     * @param seconds
     * @return
     */
    public static Boolean expire(byte[] key, long seconds) {
        return RedisUtils.expire(obtainRedisTemplate(), key, seconds);
    }

    /**
     * PEXPIRE
     *
     * @param key
     * @param millis
     * @return
     */
    public static Boolean pexpire(byte[] key, long millis) {
        return RedisUtils.pexpire(obtainRedisTemplate(), key, millis);
    }

    /**
     * EXPIREAT
     *
     * @param key
     * @param unixTime
     * @return
     */
    public static Boolean expireAt(byte[] key, long unixTime) {
        return RedisUtils.expireAt(obtainRedisTemplate(), key, unixTime);
    }

    /**
     * PEXPIREAT
     *
     * @param key
     * @param unixTimeInMillis
     * @return
     */
    public static Boolean pexpireat(byte[] key, long unixTimeInMillis) {
        return RedisUtils.pexpireat(obtainRedisTemplate(), key, unixTimeInMillis);
    }

    /**
     * PERSIST
     *
     * @param key
     * @return
     */
    public static Boolean persist(byte[] key) {
        return RedisUtils.persist(obtainRedisTemplate(), key);
    }

    /**
     * MOVE
     *
     * @param key
     * @param dbIndex
     * @return
     */
    public static Boolean move(byte[] key, int dbIndex) {
        return RedisUtils.move(obtainRedisTemplate(), key, dbIndex);
    }

    /**
     * TTL
     *
     * @param key
     * @return
     */
    public static Long ttl(byte[] key) {
        return RedisUtils.ttl(obtainRedisTemplate(), key);
    }

    /**
     * TTL
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public static Long ttl(byte[] key, TimeUnit timeUnit) {
        return RedisUtils.ttl(obtainRedisTemplate(), key, timeUnit);
    }

    /**
     * PTTL
     *
     * @param key
     * @return
     */
    public static Long pttl(byte[] key) {
        return RedisUtils.pttl(obtainRedisTemplate(), key);
    }

    /**
     * PTTL
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public static Long pttl(byte[] key, TimeUnit timeUnit) {
        return RedisUtils.pttl(obtainRedisTemplate(), key, timeUnit);
    }

    /**
     * SORT
     *
     * @param key
     * @param params
     * @return
     */
    public static List<byte[]> sort(byte[] key, SortParameters params) {
        return RedisUtils.sort(obtainRedisTemplate(), key, params);
    }

    /**
     * SORT
     *
     * @param key
     * @param params
     * @param storeKey
     * @return
     */
    public static Long sort(byte[] key, SortParameters params, byte[] storeKey) {
        return RedisUtils.sort(obtainRedisTemplate(), key, params, storeKey);
    }

    /**
     * DUMP
     *
     * @param key
     * @return
     */
    public static byte[] dump(byte[] key) {
        return RedisUtils.dump(obtainRedisTemplate(), key);
    }

    /**
     * RESTORE
     *
     * @param key
     * @param ttlInMillis
     * @param serializedValue
     */
    public static void restore(byte[] key, long ttlInMillis, byte[] serializedValue) {
        RedisUtils.restore(obtainRedisTemplate(), key, ttlInMillis, serializedValue);
    }
}
