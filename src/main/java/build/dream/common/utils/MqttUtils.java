package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.catering.domains.MqttConfig;
import build.dream.common.constants.Constants;
import build.dream.common.mqtt.ConnectionOptionWrapper;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MqttUtils {
    private static MqttClient mqttClient;

    public static MqttConfig obtainMqttConfig() {
        String partitionCode = ConfigurationUtils.getConfiguration(Constants.PARTITION_CODE);
        String serviceName = ConfigurationUtils.getConfiguration(Constants.SERVICE_NAME);

        Map<String, String> obtainMqttConfigRequestParameters = new HashMap<String, String>();
        obtainMqttConfigRequestParameters.put("partitionCode", partitionCode);
        obtainMqttConfigRequestParameters.put("serviceName", serviceName);
        ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "mqtt", "obtainMqttConfig", obtainMqttConfigRequestParameters);
        ValidateUtils.notNull(apiRest, apiRest.getError());
        return (MqttConfig) apiRest.getData();
    }

    public static void mqttConnect() {
        try {
            MqttConfig mqttConfig = obtainMqttConfig();
            String instanceId = mqttConfig.getInstanceId();
            String endPoint = mqttConfig.getEndPoint();
            String accessKeyId = mqttConfig.getAccessKeyId();
            String accessKeySecret = mqttConfig.getAccessKeySecret();
            String groupId = mqttConfig.getGroupId();
            String topic = mqttConfig.getTopic();
            String clientId = groupId + "@@@" + UUID.randomUUID().toString();

            ConnectionOptionWrapper connectionOptionWrapper = new ConnectionOptionWrapper(instanceId, accessKeyId, accessKeySecret, clientId);
            MemoryPersistence memoryPersistence = new MemoryPersistence();
            mqttClient = new MqttClient("tcp://" + endPoint + ":1883", clientId, memoryPersistence);
            mqttClient.setTimeToWait(5000);
            mqttClient.setCallback(buildMqttCallbackExtended());
            mqttClient.connect(connectionOptionWrapper.getMqttConnectOptions());
            mqttClient.subscribe(topic, 0);
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

    public static void publish(String topic, MqttMessage mqttMessage) {
        ApplicationHandler.callMethodSuppressThrow(() -> mqttClient.publish(topic, mqttMessage));
    }
}
