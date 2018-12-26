package build.dream.common.utils;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

public class RabbitUtils {
    private static RabbitTemplate rabbitTemplate;

    private static RabbitTemplate obtainRabbitTemplate() {
        if (rabbitTemplate == null) {
            rabbitTemplate = ApplicationHandler.getBean(RabbitTemplate.class);
        }
        return rabbitTemplate;
    }

    public static void send(Message message) throws AmqpException {
        obtainRabbitTemplate().send(message);
    }

    public static void send(String routingKey, Message message) throws AmqpException {
        obtainRabbitTemplate().send(routingKey, message);
    }

    public static void send(String exchange, String routingKey, Message message) throws AmqpException {
        obtainRabbitTemplate().send(exchange, routingKey, message);
    }

    public static void send(String exchange, String routingKey, Message message, CorrelationData correlationData) throws AmqpException {
        obtainRabbitTemplate().send(exchange, routingKey, message, correlationData);
    }

    public static Message sendAndReceive(Message message) throws AmqpException {
        return obtainRabbitTemplate().sendAndReceive(message);
    }

    public static Message sendAndReceive(Message message, CorrelationData correlationData) throws AmqpException {
        return obtainRabbitTemplate().sendAndReceive(message, correlationData);
    }

    public static Message sendAndReceive(String routingKey, Message message) throws AmqpException {
        return obtainRabbitTemplate().sendAndReceive(routingKey, message);
    }

    public static Message sendAndReceive(String routingKey, Message message, CorrelationData correlationData) throws AmqpException {
        return obtainRabbitTemplate().sendAndReceive(routingKey, message, correlationData);
    }

    public static Message sendAndReceive(String exchange, String routingKey, Message message) throws AmqpException {
        return obtainRabbitTemplate().sendAndReceive(exchange, routingKey, message);
    }

    public static Message sendAndReceive(String exchange, String routingKey, Message message, CorrelationData correlationData) throws AmqpException {
        return obtainRabbitTemplate().sendAndReceive(exchange, routingKey, message, correlationData);
    }

    public static void convertAndSend(Object message) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(message);
    }

    public static void convertAndSend(String routingKey, Object message) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(routingKey, message);
    }

    public static void convertAndSend(String routingKey, Object message, CorrelationData correlationData) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(routingKey, message, correlationData);
    }

    public static void convertAndSend(String exchange, String routingKey, Object message) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(exchange, routingKey, message);
    }

    public static void convertAndSend(String exchange, String routingKey, Object message, CorrelationData correlationData) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(exchange, routingKey, message, correlationData);
    }

    public static void convertAndSend(Object message, MessagePostProcessor messagePostProcessor) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(message, messagePostProcessor);
    }

    public static void convertAndSend(String routingKey, Object message, MessagePostProcessor messagePostProcessor) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(routingKey, message, messagePostProcessor);
    }

    public static void convertAndSend(Object message, MessagePostProcessor messagePostProcessor, CorrelationData correlationData) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(message, messagePostProcessor, correlationData);
    }

    public static void convertAndSend(String routingKey, Object message, MessagePostProcessor messagePostProcessor, CorrelationData correlationData) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(routingKey, message, messagePostProcessor, correlationData);
    }

    public static void convertAndSend(String exchange, String routingKey, Object message, MessagePostProcessor messagePostProcessor) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(exchange, routingKey, message, messagePostProcessor);
    }

    public static void convertAndSend(String exchange, String routingKey, Object message, MessagePostProcessor messagePostProcessor, CorrelationData correlationData) throws AmqpException {
        obtainRabbitTemplate().convertAndSend(exchange, routingKey, message, messagePostProcessor, correlationData);
    }
}
