package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.redis.RedisProperties;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RedisHelper {
    public static RedisConnectionFactory createRedisConnectionFactory(RedisProperties redisProperties) {
        ClientResources clientResources = DefaultClientResources.create();
        LettuceClientConfiguration lettuceClientConfiguration = getLettuceClientConfiguration(clientResources, redisProperties);

        RedisSentinelConfiguration redisSentinelConfiguration = getSentinelConfig(redisProperties);
        if (Objects.nonNull(redisSentinelConfiguration)) {
            return new LettuceConnectionFactory(redisSentinelConfiguration, lettuceClientConfiguration);
        }

        RedisClusterConfiguration redisClusterConfiguration = getClusterConfiguration(redisProperties);
        if (Objects.nonNull(redisClusterConfiguration)) {
            return new LettuceConnectionFactory(getClusterConfiguration(redisProperties), lettuceClientConfiguration);
        }

        return new LettuceConnectionFactory(getStandaloneConfig(redisProperties), lettuceClientConfiguration);
    }

    private static LettuceClientConfiguration getLettuceClientConfiguration(ClientResources clientResources, RedisProperties redisProperties) {
        LettuceClientConfiguration.LettuceClientConfigurationBuilder builder = createBuilder(redisProperties.getLettuce().getPool());
        applyProperties(builder, redisProperties);
        builder.clientResources(clientResources);
        return builder.build();
    }

    private static LettuceClientConfiguration.LettuceClientConfigurationBuilder applyProperties(LettuceClientConfiguration.LettuceClientConfigurationBuilder builder, RedisProperties redisProperties) {
        if (redisProperties.isSsl()) {
            builder.useSsl();
        }

        Duration timeout = redisProperties.getTimeout();
        if (Objects.nonNull(timeout)) {
            builder.commandTimeout(timeout);
        }

        RedisProperties.Lettuce lettuce = redisProperties.getLettuce();
        if (Objects.nonNull(lettuce)) {
            Duration shutdownTimeout = lettuce.getShutdownTimeout();
            if (Objects.nonNull(shutdownTimeout) && !shutdownTimeout.isZero()) {
                builder.shutdownTimeout(shutdownTimeout);
            }
        }
        return builder;
    }

    private static RedisSentinelConfiguration getSentinelConfig(RedisProperties redisProperties) {
        RedisProperties.Sentinel sentinelProperties = redisProperties.getSentinel();
        if (Objects.isNull(sentinelProperties)) {
            return null;
        }

        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        redisSentinelConfiguration.master(sentinelProperties.getMaster());
        redisSentinelConfiguration.setSentinels(createSentinels(sentinelProperties));

        String password = redisProperties.getPassword();
        if (Objects.nonNull(password)) {
            redisSentinelConfiguration.setPassword(RedisPassword.of(password));
        }
        return redisSentinelConfiguration;
    }

    private static List<RedisNode> createSentinels(RedisProperties.Sentinel sentinel) {
        List<RedisNode> nodes = new ArrayList<>();
        for (String node : sentinel.getNodes()) {
            try {
                String[] parts = StringUtils.split(node, ":");
                Assert.state(parts.length == 2, "Must be defined as 'host:port'");
                nodes.add(new RedisNode(parts[0], Integer.valueOf(parts[1])));
            } catch (RuntimeException ex) {
                throw new IllegalStateException("Invalid redis sentinel " + "property '" + node + "'", ex);
            }
        }
        return nodes;
    }

    private static RedisClusterConfiguration getClusterConfiguration(RedisProperties redisProperties) {
        RedisProperties.Cluster clusterProperties = redisProperties.getCluster();
        if (Objects.isNull(clusterProperties)) {
            return null;
        }
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(clusterProperties.getNodes());
        Integer maxRedirects = clusterProperties.getMaxRedirects();
        if (Objects.nonNull(maxRedirects)) {
            redisClusterConfiguration.setMaxRedirects(maxRedirects);
        }

        String password = redisProperties.getPassword();
        if (Objects.nonNull(password)) {
            redisClusterConfiguration.setPassword(RedisPassword.of(password));
        }
        return redisClusterConfiguration;
    }

    private static RedisStandaloneConfiguration getStandaloneConfig(RedisProperties redisProperties) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisProperties.getHost());
        redisStandaloneConfiguration.setPort(redisProperties.getPort());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
        redisStandaloneConfiguration.setDatabase(redisProperties.getDatabase());
        return redisStandaloneConfiguration;
    }

    private static LettuceClientConfiguration.LettuceClientConfigurationBuilder createBuilder(RedisProperties.Pool pool) {
        if (Objects.isNull(pool)) {
            return LettuceClientConfiguration.builder();
        }
        return new PoolBuilderFactory().createBuilder(pool);
    }

    private static class PoolBuilderFactory {
        public LettuceClientConfiguration.LettuceClientConfigurationBuilder createBuilder(RedisProperties.Pool properties) {
            return LettucePoolingClientConfiguration.builder().poolConfig(getPoolConfig(properties));
        }

        private GenericObjectPoolConfig getPoolConfig(RedisProperties.Pool properties) {
            GenericObjectPoolConfig config = new GenericObjectPoolConfig();
            config.setMaxTotal(properties.getMaxActive());
            config.setMaxIdle(properties.getMaxIdle());
            config.setMinIdle(properties.getMinIdle());

            Duration maxWait = properties.getMaxWait();
            if (Objects.nonNull(maxWait)) {
                config.setMaxWaitMillis(maxWait.toMillis());
            }
            return config;
        }
    }

    public static StringRedisTemplate obtainCommonStringRedisTemplate() {
        return ApplicationHandler.getBean(Constants.COMMON_STRING_REDIS_TEMPLATE, StringRedisTemplate.class);
    }

    public static StringRedisTemplate obtainPartitionStringRedisTemplate() {
        return ApplicationHandler.getBean(Constants.PARTITION_STRING_REDIS_TEMPLATE, StringRedisTemplate.class);
    }
}
