package build.dream.common.utils;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.core.MessagePostProcessor;

import java.util.Map;
import java.util.Objects;

public class ActiveMQUtils {
    private static JmsMessagingTemplate jmsMessagingTemplate;

    private ActiveMQUtils() {
        throw new AssertionError("No build.dream.common.utils.ActiveMQUtils instances for you!");
    }

    private static JmsMessagingTemplate obtainJmsMessagingTemplate() {
        if (Objects.isNull(jmsMessagingTemplate)) {
            jmsMessagingTemplate = ApplicationHandler.getBean(JmsMessagingTemplate.class);
        }
        return jmsMessagingTemplate;
    }

    public static void convertAndSend(Object payload) throws MessagingException {
        obtainJmsMessagingTemplate().convertAndSend(payload);
    }

    public static void convertAndSend(Object payload, MessagePostProcessor postProcessor) throws MessagingException {
        obtainJmsMessagingTemplate().convertAndSend(payload, postProcessor);
    }

    public static void convertAndSend(String destinationName, Object payload) throws MessagingException {
        obtainJmsMessagingTemplate().convertAndSend(destinationName, payload);
    }

    public static void convertAndSend(String destinationName, Object payload, Map<String, Object> headers) throws MessagingException {
        obtainJmsMessagingTemplate().convertAndSend(destinationName, payload, headers);
    }

    public static void convertAndSend(String destinationName, Object payload, MessagePostProcessor postProcessor) throws MessagingException {
        obtainJmsMessagingTemplate().convertAndSend(destinationName, payload, postProcessor);
    }

    public static void convertAndSend(String destinationName, Object payload, Map<String, Object> headers, MessagePostProcessor postProcessor) throws MessagingException {
        obtainJmsMessagingTemplate().convertAndSend(destinationName, payload, headers, postProcessor);
    }

    public static <T> T convertSendAndReceive(String destinationName, Object request, Class<T> targetClass) throws MessagingException {
        return obtainJmsMessagingTemplate().convertSendAndReceive(destinationName, request, targetClass);
    }

    public static <T> T convertSendAndReceive(Object request, Class<T> targetClass) {
        return obtainJmsMessagingTemplate().convertSendAndReceive(request, targetClass);
    }

    public static <T> T convertSendAndReceive(String destinationName, Object request, Map<String, Object> headers, Class<T> targetClass) throws MessagingException {
        return obtainJmsMessagingTemplate().convertSendAndReceive(destinationName, request, headers, targetClass);
    }

    public static <T> T convertSendAndReceive(Object request, Class<T> targetClass, MessagePostProcessor postProcessor) {
        return obtainJmsMessagingTemplate().convertSendAndReceive(request, targetClass, postProcessor);
    }

    public static <T> T convertSendAndReceive(String destinationName, Object request, Class<T> targetClass, MessagePostProcessor requestPostProcessor) throws MessagingException {
        return obtainJmsMessagingTemplate().convertSendAndReceive(destinationName, request, targetClass, requestPostProcessor);
    }

    public static <T> T convertSendAndReceive(String destinationName, Object request, Map<String, Object> headers, Class<T> targetClass, MessagePostProcessor requestPostProcessor) throws MessagingException {
        return obtainJmsMessagingTemplate().convertSendAndReceive(destinationName, request, headers, targetClass, requestPostProcessor);
    }
}
