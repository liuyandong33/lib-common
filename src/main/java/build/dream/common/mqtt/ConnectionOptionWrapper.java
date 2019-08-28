package build.dream.common.mqtt;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionOptionWrapper {
    /**
     * 内部连接参数
     */
    private MqttConnectOptions mqttConnectOptions;
    private Map<String, String> tokenData = new ConcurrentHashMap<String, String>();

    /**
     * Token 鉴权模式下构造方法
     *
     * @param instanceId  MQ4IOT 实例 ID，购买后控制台获取
     * @param accessKeyId 账号 accessKeyId，从账号系统控制台获取
     * @param tokenData   客户端使用的 Token 参数，仅在 Token 鉴权模式下需要设置
     */
    public ConnectionOptionWrapper(String instanceId, String accessKeyId, Map<String, String> tokenData) {
        if (Objects.nonNull(tokenData)) {
            this.tokenData.putAll(tokenData);
        }
        mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName("Token|" + accessKeyId + "|" + instanceId);
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : tokenData.entrySet()) {
            stringBuilder.append(entry.getKey()).append("|").append(entry.getValue()).append("|");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        mqttConnectOptions.setPassword(stringBuilder.toString().toCharArray());
        mqttConnectOptions.setCleanSession(true);
        mqttConnectOptions.setKeepAliveInterval(90);
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
        mqttConnectOptions.setConnectionTimeout(5000);
    }

    /**
     * Signature 鉴权模式下构造方法
     *
     * @param instanceId      MQ4IOT 实例 ID，购买后控制台获取
     * @param accessKeyId     账号 accessKeyId，从账号系统控制台获取
     * @param clientId        MQ4IOT clientId，由业务系统分配
     * @param accessKeySecret 账号 secretKey，从账号系统控制台获取
     */
    public ConnectionOptionWrapper(String instanceId, String accessKeyId, String accessKeySecret, String clientId) {
        mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName("Signature|" + accessKeyId + "|" + instanceId);
        mqttConnectOptions.setPassword(Base64.encodeBase64String(HmacUtils.hmacSha1(accessKeySecret, clientId)).toCharArray());
        mqttConnectOptions.setCleanSession(true);
        mqttConnectOptions.setKeepAliveInterval(90);
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
        mqttConnectOptions.setConnectionTimeout(5000);
    }

    public MqttConnectOptions getMqttConnectOptions() {
        return mqttConnectOptions;
    }
}
