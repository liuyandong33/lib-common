package build.dream.common.utils;

import build.dream.common.mqtt.ConnectionOptionWrapper;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.UUID;

public class MQTTUtils {
    /**
     * MQ4IOT 实例 ID，购买后控制台获取
     */
    private static final String INSTANCE_ID = "post-cn-45918p55a02";
    /**
     * 接入点地址，购买 MQ4IOT 实例，且配置完成后即可获取，接入点地址必须填写分配的域名，不得使用 IP 地址直接连接，否则可能会导致客户端异常。
     */
    private static final String END_POINT = "post-cn-45918p55a02.mqtt.aliyuncs.com";
    /**
     * 账号 accesskey，从账号系统控制台获取
     */
    private static final String ACCESS_KEY_ID = "LTAI13Q9MtL90vHh";
    /**
     * 账号 secretKey，从账号系统控制台获取，仅在Signature鉴权模式下需要设置
     */
    private static final String ACCESS_KEY_SECRET = "xL9bYrZ6MqyzYkAwjwGqQE4NGaDPlt";

    private static final String GROUP_ID = "GID-eleme_message";
    /**
     * MQ4IOT clientId，由业务系统分配，需要保证每个 tcp 连接都不一样，保证全局唯一，如果不同的客户端对象（tcp 连接）使用了相同的 clientId 会导致连接异常断开。
     * clientId 由两部分组成，格式为 GroupID@@@DeviceId，其中 groupId 在 MQ4IOT 控制台申请，DeviceId 由业务方自己设置，clientId 总长度不得超过64个字符。
     */
    private static final String CLIENT_ID = GROUP_ID + "@@@" + UUID.randomUUID().toString();
    /**
     * MQ4IOT 消息的一级 topic，需要在控制台申请才能使用。
     * 如果使用了没有申请或者没有被授权的 topic 会导致鉴权失败，服务端会断开客户端连接。
     */
    private static final String PARENT_TOPIC = "_eleme_message";
    private static final int QOS_LEVEL = 0;
    private static MqttClient mqttClient;

    public static void mqttConnect() {
        try {
            ConnectionOptionWrapper connectionOptionWrapper = new ConnectionOptionWrapper(INSTANCE_ID, ACCESS_KEY_ID, ACCESS_KEY_SECRET, CLIENT_ID);
            MemoryPersistence memoryPersistence = new MemoryPersistence();
            mqttClient = new MqttClient("tcp://" + END_POINT + ":1883", CLIENT_ID, memoryPersistence);
            mqttClient.setTimeToWait(5000);
            mqttClient.setCallback(buildMqttCallbackExtended());
            mqttClient.connect(connectionOptionWrapper.getMqttConnectOptions());
            mqttClient.subscribe(PARENT_TOPIC, 0);
        } catch (Exception e) {
            ThreadUtils.sleepSafe(2000);
            mqttConnect();
        }
    }

    public static MqttCallbackExtended buildMqttCallbackExtended() {
        return new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean reconnect, String serverURI) {
                System.out.println("connect success");
            }

            @Override
            public void connectionLost(Throwable throwable) {
                ThreadUtils.sleepSafe(2000);
                mqttConnect();
            }

            @Override
            public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                System.out.println("receive msg from topic " + s + " , body is " + new String(mqttMessage.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                System.out.println("send msg succeed topic is : " + iMqttDeliveryToken.getTopics()[0]);
            }
        };
    }

    public static void publish(String topic, MqttMessage mqttMessage) throws MqttException {
        mqttClient.publish(topic, mqttMessage);
    }
}
