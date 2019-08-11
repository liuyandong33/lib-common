package build.dream.common.utils;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class RocketMQUtils {
    private static RocketMQTemplate rocketMQTemplate;

    private static RocketMQTemplate obtainRocketMQTemplate() {
        if (Objects.isNull(rocketMQTemplate)) {
            rocketMQTemplate = ApplicationHandler.getBean(RocketMQTemplate.class);
        }
        return rocketMQTemplate;
    }

    public static SendResult syncSend(String destination, Message<?> message) {
        return obtainRocketMQTemplate().syncSend(destination, message);
    }

    public static SendResult syncSend(String destination, Message<?> message, long timeout) {
        return obtainRocketMQTemplate().syncSend(destination, message, timeout);
    }

    public static SendResult syncSend(String destination, Collection<Message<?>> messages, long timeout) {
        return obtainRocketMQTemplate().syncSend(destination, messages, timeout);
    }

    public static SendResult syncSend(String destination, Message<?> message, long timeout, int delayLevel) {
        return obtainRocketMQTemplate().syncSend(destination, message, timeout, delayLevel);
    }

    public static SendResult syncSend(String destination, Object payload) {
        return obtainRocketMQTemplate().syncSend(destination, payload);
    }

    public static SendResult syncSend(String destination, Object payload, long timeout) {
        return obtainRocketMQTemplate().syncSend(destination, payload, timeout);
    }

    public static SendResult syncSendOrderly(String destination, Message<?> message, String hashKey) {
        return obtainRocketMQTemplate().syncSendOrderly(destination, message, hashKey);
    }

    public static SendResult syncSendOrderly(String destination, Message<?> message, String hashKey, long timeout) {
        return obtainRocketMQTemplate().syncSendOrderly(destination, message, hashKey, timeout);
    }

    public static SendResult syncSendOrderly(String destination, Object payload, String hashKey) {
        return obtainRocketMQTemplate().syncSendOrderly(destination, payload, hashKey);
    }

    public static SendResult syncSendOrderly(String destination, Object payload, String hashKey, long timeout) {
        return obtainRocketMQTemplate().syncSendOrderly(destination, payload, hashKey, timeout);
    }

    public static void asyncSend(String destination, Message<?> message, SendCallback sendCallback, long timeout, int delayLevel) {
        obtainRocketMQTemplate().asyncSend(destination, message, sendCallback, timeout, delayLevel);
    }

    public static void asyncSend(String destination, Message<?> message, SendCallback sendCallback, long timeout) {
        obtainRocketMQTemplate().asyncSend(destination, message, sendCallback, timeout);
    }

    public static void asyncSend(String destination, Message<?> message, SendCallback sendCallback) {
        obtainRocketMQTemplate().asyncSend(destination, message, sendCallback);
    }

    public static void asyncSend(String destination, Object payload, SendCallback sendCallback, long timeout) {
        obtainRocketMQTemplate().asyncSend(destination, payload, sendCallback, timeout);
    }

    public static void asyncSend(String destination, Object payload, SendCallback sendCallback) {
        obtainRocketMQTemplate().asyncSend(destination, payload, sendCallback);
    }

    public static void asyncSendOrderly(String destination, Message<?> message, String hashKey, SendCallback sendCallback, long timeout) {
        obtainRocketMQTemplate().asyncSendOrderly(destination, message, hashKey, sendCallback, timeout);
    }

    public static void asyncSendOrderly(String destination, Message<?> message, String hashKey, SendCallback sendCallback) {
        obtainRocketMQTemplate().asyncSendOrderly(destination, message, hashKey, sendCallback);
    }

    public static void asyncSendOrderly(String destination, Object payload, String hashKey, SendCallback sendCallback) {
        obtainRocketMQTemplate().asyncSendOrderly(destination, payload, hashKey, sendCallback);
    }

    public static void asyncSendOrderly(String destination, Object payload, String hashKey, SendCallback sendCallback, long timeout) {
        obtainRocketMQTemplate().asyncSendOrderly(destination, payload, hashKey, sendCallback, timeout);
    }

    public static void sendOneWay(String destination, Message<?> message) {
        obtainRocketMQTemplate().sendOneWay(destination, message);
    }

    public static void sendOneWay(String destination, Object payload) {
        obtainRocketMQTemplate().sendOneWay(destination, payload);
    }

    public static void sendOneWayOrderly(String destination, Message<?> message, String hashKey) {
        obtainRocketMQTemplate().sendOneWayOrderly(destination, message, hashKey);
    }

    public static void sendOneWayOrderly(String destination, Object payload, String hashKey) {
        obtainRocketMQTemplate().sendOneWayOrderly(destination, payload, hashKey);
    }

    public static TransactionSendResult sendMessageInTransaction(final String txProducerGroup, final String destination, final Message<?> message, final Object arg) throws MessagingException {
        return obtainRocketMQTemplate().sendMessageInTransaction(txProducerGroup, destination, message, arg);
    }

    public static void removeTransactionMQProducer(String txProducerGroup) throws MessagingException {
        obtainRocketMQTemplate().removeTransactionMQProducer(txProducerGroup);
    }

    public static boolean createAndStartTransactionMQProducer(String txProducerGroup, RocketMQLocalTransactionListener transactionListener, ExecutorService executorService, RPCHook rpcHook) throws MessagingException {
        return obtainRocketMQTemplate().createAndStartTransactionMQProducer(txProducerGroup, transactionListener, executorService, rpcHook);
    }
}
