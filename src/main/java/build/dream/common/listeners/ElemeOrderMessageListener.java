package build.dream.common.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class ElemeOrderMessageListener implements MessageListener {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer<String> stringRedisSerializer = stringRedisTemplate.getStringSerializer();
        String channel = stringRedisSerializer.deserialize(message.getChannel());
        String body = stringRedisSerializer.deserialize(message.getBody());
        System.out.println(message.toString());
    }
}
