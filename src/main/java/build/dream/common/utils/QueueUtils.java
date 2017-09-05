package build.dream.common.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.io.IOException;

public class QueueUtils {
    public static Long publish(String channel, String message) throws IOException {
        Jedis jedis = CacheUtils.getJedis();
        Long returnValue = jedis.publish(channel, message);
        jedis.close();
        return returnValue;
    }

    public static void subscribe(JedisPubSub jedisPubSub, String... channels) throws IOException {
        Jedis jedis = CacheUtils.getJedis();
        jedis.subscribe(jedisPubSub, channels);
        jedis.close();
    }
}
