package build.dream.common.utils;

import build.dream.common.annotations.RocketMQMessageListener;
import build.dream.common.rocketmq.RocketMQProperties;
import com.aliyun.openservices.ons.api.*;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.*;

public class RocketMQUtils {
    private static ProducerBean producerBean;

    private static ProducerBean obtainProducerBean() {
        if (Objects.isNull(producerBean)) {
            producerBean = ApplicationHandler.getBean(ProducerBean.class);
        }
        return producerBean;
    }


    public static SendResult send(Message message) {
        return obtainProducerBean().send(message);
    }

    public static void sendOneway(Message message) {
        obtainProducerBean().sendOneway(message);
    }

    public static void sendAsync(Message message, SendCallback sendCallback) {
        obtainProducerBean().sendAsync(message, sendCallback);
    }

    public static ProducerBean buildProducer(RocketMQProperties rocketMQProperties) {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.AccessKey, rocketMQProperties.getAccessKey());
        properties.setProperty(PropertyKeyConst.SecretKey, rocketMQProperties.getSecretKey());
        properties.setProperty(PropertyKeyConst.NAMESRV_ADDR, rocketMQProperties.getNameSrvAddr());
        properties.setProperty(PropertyKeyConst.GROUP_ID, rocketMQProperties.getProducerGroupId());
        ProducerBean producerBean = new ProducerBean();
        producerBean.setProperties(properties);
        return producerBean;
    }

    public static Consumer buildConsumer(RocketMQProperties rocketMQProperties, ApplicationContext applicationContext, Environment environment) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.AccessKey, rocketMQProperties.getAccessKey());
        properties.put(PropertyKeyConst.SecretKey, rocketMQProperties.getSecretKey());
        properties.put(PropertyKeyConst.NAMESRV_ADDR, rocketMQProperties.getNameSrvAddr());
        properties.put(PropertyKeyConst.GROUP_ID, rocketMQProperties.getConsumerGroupId());
        Consumer consumer = ONSFactory.createConsumer(properties);

        Collection<MessageListener> messageListeners = applicationContext.getBeansOfType(MessageListener.class).values();
        for (MessageListener messageListener : messageListeners) {
            RocketMQMessageListener rocketMQMessageListener = AnnotationUtils.findAnnotation(messageListener.getClass(), RocketMQMessageListener.class);
            String topic = environment.resolvePlaceholders(rocketMQMessageListener.topic());
            String subExpression = environment.resolvePlaceholders(rocketMQMessageListener.subExpression());
            consumer.subscribe(topic, subExpression, messageListener);
        }
        consumer.start();
        return consumer;
    }

    public static Map<Subscription, MessageListener> buildSubscriptionTable(ApplicationContext applicationContext) {
        Environment environment = applicationContext.getEnvironment();
        Collection<MessageListener> messageListeners = applicationContext.getBeansOfType(MessageListener.class).values();

        Map<Subscription, MessageListener> subscriptionTable = new HashMap<Subscription, MessageListener>();
        for (MessageListener messageListener : messageListeners) {
            RocketMQMessageListener rocketMQMessageListener = AnnotationUtils.findAnnotation(messageListener.getClass(), RocketMQMessageListener.class);
            String topic = environment.resolvePlaceholders(rocketMQMessageListener.topic());
            String subExpression = environment.resolvePlaceholders(rocketMQMessageListener.subExpression());

            Subscription subscription = new Subscription();
            subscription.setTopic(topic);
            subscription.setExpression(subExpression);
            subscriptionTable.put(subscription, messageListener);
        }
        return subscriptionTable;
    }
}
