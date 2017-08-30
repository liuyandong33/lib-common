package build.dream.common.utils;

import build.dream.common.constants.Constants;
import redis.clients.jedis.*;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuyandong on 2017/6/16.
 */
public class CacheUtils {
    private static final String SESSION_PREFIX = "_session_";
    private static JedisSentinelPool jedisSentinelPool = null;
    private static JedisPool jedisPool = null;

    public static JedisPoolConfig createJedisPoolConfig() throws IOException {
        Integer maxTotal = Integer.valueOf(PropertyUtils.getProperty("redis.pool.maxTotal", "1000"));
        Integer maxWaitMillis = Integer.valueOf(PropertyUtils.getProperty("redis.pool.maxWaitMillis", "60000"));
        Integer maxIdle = Integer.valueOf(PropertyUtils.getProperty("redis.pool.maxIdle", "20"));
        Boolean testOnBorrow = Boolean.valueOf(PropertyUtils.getProperty("redis.pool.testOnBorrow", Constants.FALSE));
        Boolean testOnReturn = Boolean.valueOf(PropertyUtils.getProperty("redis.pool.testOnReturn", Constants.FALSE));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        return jedisPoolConfig;
    }

    private static void createJedisPool() throws IOException {
        JedisPoolConfig jedisPoolConfig = createJedisPoolConfig();
        String redisPoolHost = PropertyUtils.getProperty(Constants.REDIS_POOL_HOST);
        Integer redisPoolPort = Integer.valueOf(PropertyUtils.getProperty(Constants.REDIS_POOL_PORT));
        String redisPoolPassword = PropertyUtils.getProperty(Constants.REDIS_POOL_PASSWORD);
        jedisPool = new JedisPool(jedisPoolConfig, redisPoolHost, redisPoolPort, Protocol.DEFAULT_TIMEOUT, redisPoolPassword);
    }

    private static void createJedisSentinelPool() throws IOException {
        JedisPoolConfig jedisPoolConfig = createJedisPoolConfig();

        String redisSentinelConnect = PropertyUtils.getProperty("redis.sentinel.connect");
        String masterName = PropertyUtils.getProperty("redis.sentinel.masterName", "mymaster");
        String password = PropertyUtils.getProperty("redis.sentinel.password", "ftrend");
        Set<String> sentinels = new HashSet<String>();
        String[] sentinelArray = redisSentinelConnect.split(";");
        for (String sentinel : sentinelArray) {
            sentinels.add(sentinel);
        }
        jedisSentinelPool = new JedisSentinelPool(masterName, sentinels, jedisPoolConfig, password);
    }

    private static JedisSentinelPool getJedisSentinelPool() throws IOException {
        if (jedisSentinelPool == null) {
            createJedisSentinelPool();
        }
        return jedisSentinelPool;
    }

    private static JedisPool getJedisPool() throws IOException {
        if (jedisPool == null) {
            createJedisPool();
        }
        return jedisPool;
    }

    public static Jedis getJedisFromJedisSentinelPool() throws IOException {
        return getJedisSentinelPool().getResource();
    }

    public static Jedis getJedisFromJedisPool() throws IOException {
        return getJedisPool().getResource();
    }

    public static Jedis getJedis() throws IOException {
        String redisPoolType = PropertyUtils.getProperty(Constants.REDIS_POOL_TYPE);
        if (Constants.JEDIS_POOL.equals(redisPoolType)) {
            return getJedisFromJedisPool();
        } else if (Constants.JEDIS_SENTINEL_POOL.equals(redisPoolType)) {
            return getJedisFromJedisSentinelPool();
        }
        return null;
    }

    public static String set(String key, String value) throws IOException {
        Jedis jedis = getJedis();
        String returnValue = jedis.set(key, value);
        jedis.close();
        return returnValue;
    }

    public static String set(String key, String value, String nxxx) throws IOException {
        Jedis jedis = getJedis();
        String returnValue = jedis.set(key, value, nxxx);
        jedis.close();
        return returnValue;
    }

    public static String set(String key, String value, String nxxx, String expx, int time) throws IOException {
        Jedis jedis = getJedis();
        String returnValue = jedis.set(key, value, nxxx, expx, time);
        jedis.close();
        return returnValue;
    }

    public static String set(String key, String value, String nxxx, String expx, long time) throws IOException {
        Jedis jedis = getJedis();
        String returnValue = jedis.set(key, value, nxxx, expx, time);
        jedis.close();
        return returnValue;
    }

    public static String get(String key) throws IOException {
        Jedis jedis = getJedis();
        String returnValue = jedis.get(key);
        jedis.close();
        return returnValue;
    }

    public static Long del(String key) throws IOException {
        Jedis jedis = getJedis();
        Long returnValue = jedis.del(key);
        jedis.close();
        return returnValue;
    }

    public static Long del(String...keys) throws IOException {
        Jedis jedis = getJedis();
        Long returnValue = jedis.del(keys);
        jedis.close();
        return returnValue;
    }

    public static Long del(Set<String> keys) throws IOException {
        int size = keys.size();
        Iterator<String> iterator = keys.iterator();
        String[] keyArray = new String[size];
        int index = 0;
        while (iterator.hasNext()) {
            keyArray[index] = iterator.next();
            index++;
        }
        Jedis jedis = getJedis();
        Long returnValue = jedis.del(keyArray);
        jedis.close();
        return returnValue;
    }

    public static Set<String> keys(String pattern) throws IOException {
        Jedis jedis = getJedis();
        Set<String> returnValue = jedis.keys(pattern);
        jedis.close();
        return returnValue;
    }

    public static Map<String, String> hgetAll(String key) throws IOException {
        Jedis jedis = getJedis();
        Map<String, String> returnValue = jedis.hgetAll(key);
        jedis.close();
        return returnValue;
    }

    public static String hget(String key, String field) throws IOException {
        Jedis jedis = getJedis();
        String returnValue = jedis.hget(key, field);
        jedis.close();
        return returnValue;
    }

    public static Long hset(String key, String field, String value) throws IOException {
        Jedis jedis = getJedis();
        Long returnValue = jedis.hset(key, field, value);
        jedis.close();
        return returnValue;
    }

    public static String hmset(String key, Map<String, String> hash) throws IOException {
        Jedis jedis = getJedis();
        String returnValue = jedis.hmset(key, hash);
        jedis.close();
        return returnValue;
    }

    public static String getFromSession(String sessionId, String key) throws IOException {
        return hget(getSessionId(sessionId), key);
    }

    public static Long setToSession(String sessionId, String key, String value) throws IOException {
        return hset(getSessionId(sessionId), key, value);
    }

    public static String setToSession(String sessionId, Map<String, String> hash) throws IOException {
        return hmset(getSessionId(sessionId), hash);
    }

    public static Long expire(String key, int seconds) throws IOException {
        Jedis jedis = getJedis();
        Long returnValue = jedis.expire(key, seconds);
        jedis.close();
        return returnValue;
    }

    public static Long expire(byte[] key, int seconds) throws IOException {
        Jedis jedis = getJedis();
        Long returnValue = jedis.expire(key, seconds);
        jedis.close();
        return returnValue;
    }

    public static Long expireAt(String key, long unixTime) throws IOException {
        Jedis jedis = getJedis();
        Long returnValue = jedis.expireAt(key, unixTime);
        jedis.close();
        return returnValue;
    }

    public static Long expireAt(byte[] key, long unixTime) throws IOException {
        Jedis jedis = getJedis();
        Long returnValue = jedis.expireAt(key, unixTime);
        jedis.close();
        return returnValue;
    }

    public static String getSessionId(String sessionId) {
        return SESSION_PREFIX + sessionId.toLowerCase();
    }
}
