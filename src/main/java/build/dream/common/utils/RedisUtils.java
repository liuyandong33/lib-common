package build.dream.common.utils;

import org.springframework.data.redis.connection.RedisListCommands;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RedisUtils {
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

    public static ZSetOperations<String, String> obtainZSetOperations() {
        return obtainStringRedisTemplate().opsForZSet();
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

    /**
     * EXISTS
     *
     * @param key
     * @return
     */
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

    /**
     * DEL
     *
     * @param keys
     */
    public static void del(String... keys) {
        obtainStringRedisTemplate().delete(Arrays.asList(keys));
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
    public static Double hincrbyfloat(String key, String field, double increment) {
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

    /**
     * EXPIRE
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public static Boolean expire(String key, long timeout, TimeUnit unit) {
        return obtainStringRedisTemplate().expire(key, timeout, unit);
    }

    /**
     * EXPIREAT
     *
     * @param key
     * @param date
     * @return
     */
    public static Boolean expireAt(String key, Date date) {
        return obtainStringRedisTemplate().expireAt(key, date);
    }

    /**
     * HDEL
     *
     * @param key
     * @param fields
     * @return
     */
    public static Long hdel(String key, String... fields) {
        return obtainHashOperations().delete(key, fields);
    }

    /**
     * TTL
     *
     * @param key
     * @return
     */
    public static Long ttl(String key) {
        return obtainStringRedisTemplate().getExpire(key);
    }

    /**
     * TTL
     *
     * @param key
     * @param timeUnit
     * @return
     */
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
    public static Long lpush(String key, String... values) {
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
    public static Long rpush(String key, String pivot, String value) {
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
    public static Set<String> sdiff(String key, Collection<String> otherKeys) {
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

    /**
     * ZADD
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
    public static Boolean zadd(String key, String value, double score) {
        return obtainZSetOperations().add(key, value, score);
    }

    /**
     * ZADD
     *
     * @param key
     * @param tuples
     * @return
     */
    public static Long zadd(String key, Set<ZSetOperations.TypedTuple<String>> tuples) {
        return obtainZSetOperations().add(key, tuples);
    }

    /**
     * ZREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long zrem(String key, Object... values) {
        return obtainZSetOperations().remove(key, values);
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
        return obtainZSetOperations().incrementScore(key, value, delta);
    }

    /**
     * ZRANK
     *
     * @param key
     * @param object
     * @return
     */
    public static Long zrank(String key, Object object) {
        return obtainZSetOperations().rank(key, object);
    }

    /**
     * ZREVRANK
     *
     * @param key
     * @param object
     * @return
     */
    public static Long zrevrank(String key, Object object) {
        return obtainZSetOperations().reverseRank(key, object);
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
        return obtainZSetOperations().range(key, start, end);
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
        return obtainZSetOperations().rangeByScore(key, min, max);
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
        return obtainZSetOperations().rangeByScore(key, min, max, offset, count);
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
        return obtainZSetOperations().reverseRange(key, start, end);
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
        return obtainZSetOperations().reverseRangeByScore(key, min, max);
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
        return obtainZSetOperations().reverseRangeByScore(key, min, max, offset, count);
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
        return obtainZSetOperations().count(key, min, max);
    }

    /**
     * ZCARD
     *
     * @param key
     * @return
     */
    public static Long zcard(String key) {
        return obtainZSetOperations().zCard(key);
    }

    /**
     * ZSCORE
     *
     * @param key
     * @param object
     * @return
     */
    public static Double zscore(String key, Object object) {
        return obtainZSetOperations().score(key, object);
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
        return obtainZSetOperations().removeRange(key, start, end);
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
        return obtainZSetOperations().removeRangeByScore(key, min, max);
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
        return obtainZSetOperations().unionAndStore(key, otherKey, destKey);
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
        return obtainZSetOperations().unionAndStore(key, otherKeys, destKey);
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
        return obtainZSetOperations().intersectAndStore(key, otherKey, destKey);
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
        return obtainZSetOperations().intersectAndStore(key, otherKeys, destKey);
    }

    /**
     * GET
     *
     * @param key
     * @return
     */
    public static byte[] get(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.get(key));
    }

    /**
     * GETSET
     *
     * @param key
     * @param value
     * @return
     */
    public static byte[] getset(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.getSet(key, value));
    }

    /**
     * MGET
     *
     * @param keys
     * @return
     */
    public static List<byte[]> mget(byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<List<byte[]>>) connection -> connection.mGet(keys));
    }

    /**
     * SET
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean set(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.set(key, value));
    }

    /**
     * SETNX
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean setnx(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.setNX(key, value));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.setEx(key, seconds, value));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.pSetEx(key, milliseconds, value));
    }

    /**
     * MSET
     *
     * @param tuple
     * @return
     */
    public static Boolean _mset(Map<byte[], byte[]> tuple) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.mSet(tuple));
    }

    /**
     * MSETNX
     *
     * @param tuple
     * @return
     */
    public static Boolean _msetnx(Map<byte[], byte[]> tuple) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.mSetNX(tuple));
    }

    /**
     * INCR
     *
     * @param key
     * @return
     */
    public static Long incr(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.incr(key));
    }

    /**
     * INCRBY
     *
     * @param key
     * @param value
     * @return
     */
    public static Long incrby(byte[] key, long value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.incrBy(key, value));
    }

    /**
     * INCRBY
     *
     * @param key
     * @param value
     * @return
     */
    public static Double incrby(byte[] key, double value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Double>) connection -> connection.incrBy(key, value));
    }

    /**
     * DECR
     *
     * @param key
     * @return
     */
    public static Long decr(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.decr(key));
    }

    /**
     * DECRBY
     *
     * @param key
     * @param value
     * @return
     */
    public static Long decrBy(byte[] key, long value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.decrBy(key, value));
    }

    /**
     * APPEND
     *
     * @param key
     * @param value
     * @return
     */
    public static Long append(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.append(key, value));
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
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.getRange(key, start, end));
    }

    /**
     * SETRANGE
     *
     * @param key
     * @param value
     * @param offset
     */
    public static void setrange(byte[] key, byte[] value, long offset) {
        obtainStringRedisTemplate().execute((RedisCallback<Object>) connection -> {
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
    public static Boolean getbit(byte[] key, long offset) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.getBit(key, offset));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.setBit(key, offset, value));
    }

    /**
     * BITCOUNT
     *
     * @param key
     * @return
     */
    public static Long bitcount(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.bitCount(key));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.bitCount(key, start, end));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.bitOp(op, destination, keys));
    }

    /**
     * STRLEN
     *
     * @param key
     * @return
     */
    public static Long strlen(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.strLen(key));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.hSet(key, field, value));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.hSetNX(key, field, value));
    }

    /**
     * HGET
     *
     * @param key
     * @param field
     * @return
     */
    public static byte[] hget(byte[] key, byte[] field) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.hGet(key, field));
    }

    /**
     * HMGET
     *
     * @param key
     * @param fields
     * @return
     */
    public static List<byte[]> hmget(byte[] key, byte[]... fields) {
        return obtainStringRedisTemplate().execute((RedisCallback<List<byte[]>>) connection -> connection.hMGet(key, fields));
    }

    /**
     * HMSET
     *
     * @param key
     * @param hashes
     */
    public static void hmset(byte[] key, Map<byte[], byte[]> hashes) {
        obtainStringRedisTemplate().execute((RedisCallback<Object>) connection -> {
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
    public static Long hincrby(byte[] key, byte[] field, long delta) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.hIncrBy(key, field, delta));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Double>) connection -> connection.hIncrBy(key, field, delta));
    }

    /**
     * HEXISTS
     *
     * @param key
     * @param field
     * @return
     */
    public static Boolean hexists(byte[] key, byte[] field) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.hExists(key, field));
    }

    /**
     * HDEL
     *
     * @param key
     * @param fields
     * @return
     */
    public static Long hdel(byte[] key, byte[]... fields) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.hDel(key, fields));
    }

    /**
     * HLEN
     *
     * @param key
     * @return
     */
    public static Long hlen(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.hLen(key));
    }

    /**
     * HKEYS
     *
     * @param key
     * @return
     */
    public static Set<byte[]> hkeys(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.hKeys(key));
    }

    /**
     * HVALS
     *
     * @param key
     * @return
     */
    public static List<byte[]> hvals(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<List<byte[]>>) connection -> connection.hVals(key));
    }

    /**
     * HGETALL
     *
     * @param key
     * @return
     */
    public static Map<byte[], byte[]> hgetall(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Map<byte[], byte[]>>) connection -> connection.hGetAll(key));
    }

    /**
     * HSCAN
     *
     * @param key
     * @param options
     * @return
     */
    public static Cursor<Map.Entry<byte[], byte[]>> hscan(byte[] key, ScanOptions options) {
        return obtainStringRedisTemplate().execute((RedisCallback<Cursor<Map.Entry<byte[], byte[]>>>) connection -> connection.hScan(key, options));
    }

    /**
     * RPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long rpush(byte[] key, byte[]... values) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.rPush(key, values));
    }

    /**
     * LPUSH
     *
     * @param key
     * @param values
     * @return
     */
    public static Long lpush(byte[] key, byte[]... values) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.lPush(key, values));
    }

    /**
     * RPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long rpushx(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.rPushX(key, value));
    }

    /**
     * LPUSHX
     *
     * @param key
     * @param value
     * @return
     */
    public static Long lpushx(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.lPushX(key, value));
    }

    /**
     * LLEN
     *
     * @param key
     * @return
     */
    public static Long llen(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.hLen(key));
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
        return obtainStringRedisTemplate().execute((RedisCallback<List<byte[]>>) connection -> connection.lRange(key, start, end));
    }

    /**
     * LTRIM
     *
     * @param key
     * @param start
     * @param end
     */
    public static void ltrim(byte[] key, long start, long end) {
        obtainStringRedisTemplate().execute((RedisCallback<Object>) connection -> {
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
    public static byte[] lindex(byte[] key, long index) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.lIndex(key, index));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.lInsert(key, where, pivot, value));
    }

    /**
     * LSET
     *
     * @param key
     * @param index
     * @param value
     */
    public static void lset(byte[] key, long index, byte[] value) {
        obtainStringRedisTemplate().execute((RedisCallback<Object>) connection -> {
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
    public static Long lrem(byte[] key, long count, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.lRem(key, count, value));
    }

    /**
     * LPOP
     *
     * @param key
     * @return
     */
    public static byte[] lpop(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.lPop(connection.lPop(key)));
    }

    /**
     * RPOP
     *
     * @param key
     * @return
     */
    public static byte[] rpop(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.rPop(key));
    }

    /**
     * BLPOP
     *
     * @param timeout
     * @param keys
     * @return
     */
    public static List<byte[]> blpop(int timeout, byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<List<byte[]>>) connection -> connection.bLPop(timeout, keys));
    }

    /**
     * BRPOP
     *
     * @param timeout
     * @param keys
     * @return
     */
    public static List<byte[]> brpop(int timeout, byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<List<byte[]>>) connection -> connection.bRPop(timeout, keys));
    }

    /**
     * RPOPLPUSH
     *
     * @param srcKey
     * @param dstKey
     * @return
     */
    public static byte[] rpoplpush(byte[] srcKey, byte[] dstKey) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.rPopLPush(srcKey, dstKey));
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
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.bRPopLPush(timeout, srcKey, dstKey));
    }

    /**
     * SADD
     *
     * @param key
     * @param values
     * @return
     */
    public static Long sadd(byte[] key, byte[]... values) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.sAdd(key, values));
    }

    /**
     * SREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long srem(byte[] key, byte[]... values) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.sRem(key, values));
    }

    /**
     * SPOP
     *
     * @param key
     * @return
     */
    public static byte[] spop(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.sPop(key));
    }

    /**
     * SPOP
     *
     * @param key
     * @param count
     * @return
     */
    public static List<byte[]> spop(byte[] key, long count) {
        return obtainStringRedisTemplate().execute((RedisCallback<List<byte[]>>) connection -> connection.sPop(key, count));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.sMove(srcKey, destKey, value));
    }

    /**
     * SCARD
     *
     * @param key
     * @return
     */
    public static Long scard(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.sCard(key));
    }

    /**
     * SISMEMBER
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean sismember(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.sIsMember(key, value));
    }

    /**
     * SINTER
     *
     * @param keys
     * @return
     */
    public static Set<byte[]> sinter(byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.sInter(keys));
    }

    /**
     * SINTERSTORE
     *
     * @param destKey
     * @param keys
     * @return
     */
    public static Long sinterstore(byte[] destKey, byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.sInterStore(destKey, keys));
    }

    /**
     * SUNION
     *
     * @param keys
     * @return
     */
    public static Set<byte[]> sunion(byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.sUnion(keys));
    }

    /**
     * SUNIONSTORE
     *
     * @param destKey
     * @param keys
     * @return
     */
    public static Long sunionstore(byte[] destKey, byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.sUnionStore(destKey, keys));
    }

    /**
     * SDIFF
     *
     * @param keys
     * @return
     */
    public static Set<byte[]> sdiff(byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.sDiff(keys));
    }

    /**
     * SDIFFSTORE
     *
     * @param destKey
     * @param keys
     * @return
     */
    public static Long sdiffstore(byte[] destKey, byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.sDiffStore(destKey, keys));
    }

    /**
     * smembers
     *
     * @param key
     * @return
     */
    public static Set<byte[]> smembers(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.sMembers(key));
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @return
     */
    public static byte[] srandmember(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.sRandMember(key));
    }

    /**
     * SRANDMEMBER
     *
     * @param key
     * @param count
     * @return
     */
    public static List<byte[]> srandmember(byte[] key, long count) {
        return obtainStringRedisTemplate().execute((RedisCallback<List<byte[]>>) connection -> connection.sRandMember(key, count));
    }

    /**
     * SSCAN
     *
     * @param key
     * @param options
     * @return
     */
    public static Cursor<byte[]> sscan(byte[] key, ScanOptions options) {
        return obtainStringRedisTemplate().execute((RedisCallback<Cursor<byte[]>>) connection -> connection.sScan(key, options));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.zAdd(key, score, value));
    }

    /**
     * ZADD
     *
     * @param key
     * @param tuples
     * @return
     */
    public static Long zadd(byte[] key, Set<RedisZSetCommands.Tuple> tuples) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zAdd(key, tuples));
    }

    /**
     * ZREM
     *
     * @param key
     * @param values
     * @return
     */
    public static Long zrem(byte[] key, byte[]... values) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zRem(key, values));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Double>) connection -> connection.zIncrBy(key, increment, value));
    }

    /**
     * ZRANK
     *
     * @param key
     * @param value
     * @return
     */
    public static Long zrank(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zRank(key, value));
    }

    /**
     * ZREVRANK
     *
     * @param key
     * @param value
     * @return
     */
    public static Long zrevrank(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zRevRank(key, value));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRange(key, start, end));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByScore(key, min, max));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByScore(key, min, max, offset, count));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRange(key, start, end));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRangeByScore(key, min, max));
    }

    /**
     * ZREVRANGEBYSCORE
     *
     * @param key
     * @param range
     * @return
     */
    public static Set<byte[]> zrevrangebyscore(byte[] key, RedisZSetCommands.Range range) {
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRangeByScore(key, range));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRangeByScore(key, min, max, offset, count));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRevRangeByScore(key, range, limit));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zCount(key, min, max));
    }

    /**
     * ZCARD
     *
     * @param key
     * @return
     */
    public static Long zcard(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zCard(key));
    }

    /**
     * ZSCORE
     *
     * @param key
     * @param value
     * @return
     */
    public static Double zscore(byte[] key, byte[] value) {
        return obtainStringRedisTemplate().execute((RedisCallback<Double>) connection -> connection.zScore(key, value));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zRemRange(key, start, end));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zRemRangeByScore(key, min, max));
    }

    /**
     * ZUNIONSTORE
     *
     * @param destKey
     * @param sets
     * @return
     */
    public static Long zunionstore(byte[] destKey, byte[]... sets) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zUnionStore(destKey, sets));
    }

    /**
     * ZINTERSTORE
     *
     * @param destKey
     * @param sets
     * @return
     */
    public static Long zinterstore(byte[] destKey, byte[]... sets) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.zInterStore(destKey, sets));
    }

    /**
     * ZSCAN
     *
     * @param key
     * @param options
     * @return
     */
    public static Cursor<RedisZSetCommands.Tuple> zscan(byte[] key, ScanOptions options) {
        return obtainStringRedisTemplate().execute((RedisCallback<Cursor<RedisZSetCommands.Tuple>>) connection -> connection.zScan(key, options));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByScore(key, min, max));
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
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByScore(key, min, max, offset, count));
    }

    /**
     * ZRANGEBYLEX
     *
     * @param key
     * @return
     */
    public static Set<byte[]> zrangebylex(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.zRangeByLex(key));
    }

    /**
     * EXISTS
     *
     * @param key
     * @return
     */
    public static Boolean exists(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.exists(key));
    }

    /**
     * DEL
     *
     * @param keys
     * @return
     */
    public static Long del(byte[]... keys) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.del(keys));
    }

    /**
     * TYPE
     *
     * @param key
     * @return
     */
    public static String type(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<String>) connection -> connection.type(key).name());
    }

    /**
     * KEYS
     *
     * @param pattern
     * @return
     */
    public static Set<byte[]> keys(byte[] pattern) {
        return obtainStringRedisTemplate().execute((RedisCallback<Set<byte[]>>) connection -> connection.keys(pattern));
    }

    /**
     * SCAN
     *
     * @param options
     * @return
     */
    public static Cursor<byte[]> scan(ScanOptions options) {
        return obtainStringRedisTemplate().execute((RedisCallback<Cursor<byte[]>>) connection -> connection.scan(options));
    }

    /**
     * RANDOMKEY
     *
     * @return
     */
    public static byte[] randomkey() {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.randomKey());
    }

    /**
     * RENAME
     * @param sourceKey
     * @param targetKey
     */
    public static void rename(byte[] sourceKey, byte[] targetKey) {
        obtainStringRedisTemplate().execute((RedisCallback<Object>) connection -> {
            connection.rename(sourceKey, targetKey);
            return null;
        });
    }

    /**
     * RENAMENX
     * @param sourceKey
     * @param targetKey
     * @return
     */
    public static Boolean renamenx(byte[] sourceKey, byte[] targetKey) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.renameNX(sourceKey, targetKey));
    }

    /**
     * EXPIRE
     * @param key
     * @param seconds
     * @return
     */
    public static Boolean expire(byte[] key, long seconds) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.expire(key, seconds));
    }

    /**
     * PEXPIRE
     * @param key
     * @param millis
     * @return
     */
    public static Boolean pexpire(byte[] key, long millis) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.pExpire(key, millis));
    }

    /**
     * EXPIREAT
     * @param key
     * @param unixTime
     * @return
     */
    public static Boolean expireAt(byte[] key, long unixTime) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.expireAt(key, unixTime));
    }

    /**
     * PEXPIREAT
     * @param key
     * @param unixTimeInMillis
     * @return
     */
    public static Boolean pexpireat(byte[] key, long unixTimeInMillis) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.pExpireAt(key, unixTimeInMillis));
    }

    /**
     * PERSIST
     * @param key
     * @return
     */
    public static Boolean persist(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.persist(key));
    }

    /**
     * MOVE
     * @param key
     * @param dbIndex
     * @return
     */
    public static Boolean move(byte[] key, int dbIndex) {
        return obtainStringRedisTemplate().execute((RedisCallback<Boolean>) connection -> connection.move(key, dbIndex));
    }

    /**
     * TTL
     * @param key
     * @return
     */
    public static Long ttl(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.ttl(key));
    }

    /**
     * TTL
     * @param key
     * @param timeUnit
     * @return
     */
    public static Long ttl(byte[] key, TimeUnit timeUnit) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.ttl(key, timeUnit));
    }

    /**
     * PTTL
     * @param key
     * @return
     */
    public static Long pttl(byte[] key){
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.pTtl(key));
    }

    /**
     * PTTL
     * @param key
     * @param timeUnit
     * @return
     */
    public static Long pttl(byte[] key, TimeUnit timeUnit) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.pTtl(key, timeUnit));
    }

    /**
     * SORT
     * @param key
     * @param params
     * @return
     */
    public static List<byte[]> sort(byte[] key, SortParameters params) {
        return obtainStringRedisTemplate().execute((RedisCallback<List<byte[]>>) connection -> connection.sort(key, params));
    }

    /**
     * SORT
     * @param key
     * @param params
     * @param storeKey
     * @return
     */
    public static Long sort(byte[] key, SortParameters params, byte[] storeKey) {
        return obtainStringRedisTemplate().execute((RedisCallback<Long>) connection -> connection.sort(key, params, storeKey));
    }

    /**
     * DUMP
     * @param key
     * @return
     */
    public static byte[] dump(byte[] key) {
        return obtainStringRedisTemplate().execute((RedisCallback<byte[]>) connection -> connection.dump(key));
    }

    /**
     * RESTORE
     * @param key
     * @param ttlInMillis
     * @param serializedValue
     */
    public static void restore(byte[] key, long ttlInMillis, byte[] serializedValue) {
        obtainStringRedisTemplate().execute((RedisCallback<Object>) connection -> {
            connection.restore(key, ttlInMillis, serializedValue);
            return null;
        });
    }
}
