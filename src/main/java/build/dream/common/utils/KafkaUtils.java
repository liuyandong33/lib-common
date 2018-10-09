package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.support.converter.MessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KafkaUtils {
    private static KafkaTemplate<String, String> kafkaTemplate;

    public static KafkaTemplate<String, String> obtainKafkaTemplate() {
        if (kafkaTemplate == null) {
            kafkaTemplate = ApplicationHandler.getBean(KafkaTemplate.class);
        }
        return kafkaTemplate;
    }

    public static String getDefaultTopic() {
        return obtainKafkaTemplate().getDefaultTopic();
    }

    public static void setDefaultTopic(String defaultTopic) {
        obtainKafkaTemplate().setDefaultTopic(defaultTopic);
    }

    public void setProducerListener(ProducerListener<String, String> producerListener) {
        obtainKafkaTemplate().setProducerListener(producerListener);
    }

    public static MessageConverter getMessageConverter() {
        return obtainKafkaTemplate().getMessageConverter();
    }

    public static void setMessageConverter(RecordMessageConverter messageConverter) {
        obtainKafkaTemplate().setMessageConverter(messageConverter);
    }

    public static boolean isTransactional() {
        return obtainKafkaTemplate().isTransactional();
    }

    public static ListenableFuture<SendResult<String, String>> sendDefault(String data) {
        return obtainKafkaTemplate().sendDefault(data);
    }

    public static ListenableFuture<SendResult<String, String>> sendDefault(String key, String data) {
        return obtainKafkaTemplate().sendDefault(key, data);
    }

    public static ListenableFuture<SendResult<String, String>> sendDefault(Integer partition, String key, String data) {
        return obtainKafkaTemplate().sendDefault(partition, key, data);
    }

    public static ListenableFuture<SendResult<String, String>> sendDefault(Integer partition, Long timestamp, String key, String data) {
        return obtainKafkaTemplate().sendDefault(partition, timestamp, key, data);
    }

    public static ListenableFuture<SendResult<String, String>> send(String topic, String data) {
        return obtainKafkaTemplate().send(topic, data);
    }

    public static ListenableFuture<SendResult<String, String>> send(String topic, String key, String data) {
        return obtainKafkaTemplate().send(topic, key, data);
    }

    public static ListenableFuture<SendResult<String, String>> send(String topic, Integer partition, String key, String data) {
        return obtainKafkaTemplate().send(topic, partition, key, data);
    }

    public static ListenableFuture<SendResult<String, String>> send(String topic, Integer partition, Long timestamp, String key, String data) {
        return obtainKafkaTemplate().send(topic, partition, timestamp, key, data);
    }


    public static ListenableFuture<SendResult<String, String>> send(ProducerRecord<String, String> record) {
        return obtainKafkaTemplate().send(record);
    }

    public static ListenableFuture<SendResult<String, String>> send(Message<?> message) {
        return obtainKafkaTemplate().send(message);
    }

    public static List<PartitionInfo> partitionsFor(String topic) {
        return obtainKafkaTemplate().partitionsFor(topic);
    }

    public static Map<MetricName, ? extends Metric> metrics() {
        return obtainKafkaTemplate().metrics();
    }

    public static <T> T execute(KafkaOperations.ProducerCallback<String, String, T> callback) {
        return obtainKafkaTemplate().execute(callback);
    }

    public static <T> T executeInTransaction(KafkaOperations.OperationsCallback<String, String, T> callback) {
        return obtainKafkaTemplate().executeInTransaction(callback);
    }

    public static void flush() {
        obtainKafkaTemplate().flush();
    }


    public static void sendOffsetsToTransaction(Map<TopicPartition, OffsetAndMetadata> offsets) {
        obtainKafkaTemplate().sendOffsetsToTransaction(offsets);
    }

    public static void sendOffsetsToTransaction(Map<TopicPartition, OffsetAndMetadata> offsets, String consumerGroupId) {
        obtainKafkaTemplate().sendOffsetsToTransaction(offsets, consumerGroupId);
    }

    public static void fixedTimeSend(String topic, String key, String data, Date sendTime) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("topic", topic);
        requestParameters.put("key", key);
        requestParameters.put("data", data);
        requestParameters.put("sendTime", CustomDateUtils.format(sendTime, Constants.DEFAULT_DATE_PATTERN));
        String partitionCode = ConfigurationUtils.getConfiguration(Constants.PARTITION_CODE);
        ApiRest apiRest = ProxyUtils.doPostWithRequestParameters(partitionCode, Constants.SERVICE_NAME_JOB, "kafka", "fixedTimeSend", requestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
    }
}
