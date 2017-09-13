package build.dream.common.configurations;

import build.dream.common.listeners.ElemeOrderMessageListener;
import build.dream.common.utils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.io.IOException;

@Configuration
public class RedisMessageListenerConfiguration {
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;
    @Autowired
    private ElemeOrderMessageListener elemeOrderMessageListener;

    @Bean(destroyMethod = "destroy")
    public RedisMessageListenerContainer redisMessageListenerContainer() throws IOException {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(jedisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(elemeOrderMessageListener, new ChannelTopic(PropertyUtils.getProperty("partition.code")));
        return redisMessageListenerContainer;
    }
}
