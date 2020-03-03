package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.constants.Constants;
import build.dream.common.domains.saas.MqttConfig;
import build.dream.common.models.mqtt.ApplyTokenModel;
import build.dream.common.models.mqtt.QueryTokenModel;
import build.dream.common.models.mqtt.RevokeTokenModel;
import build.dream.common.mqtt.ConnectionOptionWrapper;
import build.dream.common.mqtt.MqttInfo;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.*;

public class MqttUtils {
    public static final String WPOS_MQTT_TOPIC = ConfigurationUtils.getConfiguration(Constants.WPOS_MQTT_TOPIC);
    private static final String MQ_AUTH_URL = "https://mqauth.aliyuncs.com";
    private static MqttClient mqttClient;

    public static MqttConfig obtainMqttConfig() {
        String partitionCode = ConfigurationUtils.getConfiguration(ConfigurationKeys.PARTITION_CODE);
        String serviceName = ConfigurationUtils.getConfiguration(ConfigurationKeys.SERVICE_NAME);

        Map<String, String> obtainMqttConfigRequestParameters = new HashMap<String, String>();
        obtainMqttConfigRequestParameters.put("partitionCode", partitionCode);
        obtainMqttConfigRequestParameters.put("serviceName", serviceName);
        ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "mqtt", "obtainMqttConfig", obtainMqttConfigRequestParameters);
        ValidateUtils.notNull(apiRest, apiRest.getError());
        return (MqttConfig) apiRest.getData();
    }

    public static MqttInfo obtainMqttInfo() {
        return obtainMqttInfo(obtainMqttConfig());
    }

    public static MqttInfo obtainMqttInfo(MqttConfig mqttConfig) {
        String clientId = mqttConfig.getGroupId() + "@@@" + UUID.randomUUID().toString();

        MqttInfo mqttInfo = new MqttInfo();
        mqttInfo.setInternalEndPoint(mqttConfig.getInternalEndPoint());
        mqttInfo.setEndPoint(mqttConfig.getEndPoint());
        mqttInfo.setClientId(clientId);
        mqttInfo.setUserName("Signature|" + AliyunUtils.ACCESS_KEY_ID + "|" + mqttConfig.getInstanceId());
        mqttInfo.setPassword(Base64.encodeBase64String(HmacUtils.hmacSha1(AliyunUtils.ACCESS_KEY_SECRET, clientId)));
        mqttInfo.setTopic(mqttConfig.getTopic());
        return mqttInfo;
    }

    public static MqttInfo obtainMqttInfo(Map<String, String> tokenMap) {
        return obtainMqttInfo(obtainMqttConfig(), tokenMap);
    }

    public static MqttInfo obtainMqttInfo(MqttConfig mqttConfig, Map<String, String> tokenMap) {
        String clientId = mqttConfig.getGroupId() + "@@@" + UUID.randomUUID().toString();

        MqttInfo mqttInfo = new MqttInfo();
        mqttInfo.setInternalEndPoint(mqttConfig.getInternalEndPoint());
        mqttInfo.setEndPoint(mqttConfig.getEndPoint());
        mqttInfo.setClientId(clientId);
        mqttInfo.setUserName("Token|" + AliyunUtils.ACCESS_KEY_ID + "|" + mqttConfig.getInstanceId());

        StringBuilder password = new StringBuilder();
        for (Map.Entry<String, String> entry : tokenMap.entrySet()) {
            password.append(entry.getKey()).append("|").append(entry.getValue()).append("|");
        }
        password.deleteCharAt(password.length() - 1);
        mqttInfo.setPassword(password.toString());
        mqttInfo.setTopic(mqttConfig.getTopic());
        return mqttInfo;
    }

    public static void mqttConnect() {
        try {
            MqttConfig mqttConfig = obtainMqttConfig();
            String instanceId = mqttConfig.getInstanceId();
            String endPoint = mqttConfig.getEndPoint();
            String groupId = mqttConfig.getGroupId();
            String topic = mqttConfig.getTopic();
            String clientId = groupId + "@@@" + UUID.randomUUID().toString();

            ConnectionOptionWrapper connectionOptionWrapper = new ConnectionOptionWrapper(instanceId, AliyunUtils.ACCESS_KEY_ID, AliyunUtils.ACCESS_KEY_SECRET, clientId);
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

    public static String generateSignature(Map<String, String> requestParameters, String accessKeySecret) {
        Map<String, String> sortedMap = new TreeMap<String, String>(requestParameters);
        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            pairs.add(entry.getKey() + "=" + entry.getValue());
        }
        return Base64.encodeBase64String(HmacUtils.hmacSha1(accessKeySecret, StringUtils.join(pairs, "&")));
    }

    /**
     * 申请 Token 接口
     *
     * @param applyTokenModel
     * @return
     */
    public static String applyToken(ApplyTokenModel applyTokenModel) {
        applyTokenModel.validateAndThrow();

        String actions = applyTokenModel.getActions();
        String resources = applyTokenModel.getResources();
        Long expireTime = applyTokenModel.getExpireTime();
        String proxyType = applyTokenModel.getProxyType();
        String serviceName = applyTokenModel.getServiceName();
        String instanceId = applyTokenModel.getInstanceId();

        Map<String, String> applyTokenRequestParameters = new HashMap<String, String>();
        applyTokenRequestParameters.put("actions", actions);
        applyTokenRequestParameters.put("resources", resources);
        applyTokenRequestParameters.put("expireTime", expireTime.toString());
        applyTokenRequestParameters.put("serviceName", serviceName);
        applyTokenRequestParameters.put("instanceId", instanceId);
        applyTokenRequestParameters.put("signature", generateSignature(applyTokenRequestParameters, AliyunUtils.ACCESS_KEY_SECRET));
        applyTokenRequestParameters.put("accessKey", AliyunUtils.ACCESS_KEY_ID);
        applyTokenRequestParameters.put("proxyType", proxyType);

        String result = OutUtils.doPostWithForm(MQ_AUTH_URL + "/token/apply", applyTokenRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(resources, String.class, Object.class);
        boolean success = MapUtils.getBooleanValue(resultMap, "success");
        ValidateUtils.isTrue(success, MapUtils.getString(resultMap, "message"));
        return MapUtils.getString(resultMap, "tokenData");
    }

    /**
     * 校验 Token 接口
     *
     * @param queryTokenModel
     * @return
     */
    public static boolean queryToken(QueryTokenModel queryTokenModel) {
        queryTokenModel.validateAndThrow();

        String token = queryTokenModel.getToken();

        Map<String, String> queryTokenRequestParameters = new HashMap<String, String>();
        queryTokenRequestParameters.put("token", token);
        queryTokenRequestParameters.put("signature", generateSignature(queryTokenRequestParameters, AliyunUtils.ACCESS_KEY_SECRET));
        queryTokenRequestParameters.put("accessKey", AliyunUtils.ACCESS_KEY_ID);

        String result = OutUtils.doPostWithForm(MQ_AUTH_URL + "/token/query", queryTokenRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return MapUtils.getBooleanValue(resultMap, "success");
    }

    /**
     * 吊销 Token 接口
     *
     * @param revokeTokenModel
     * @return
     */
    public static boolean revokeToken(RevokeTokenModel revokeTokenModel) {
        revokeTokenModel.validateAndThrow();

        String token = revokeTokenModel.getToken();

        Map<String, String> revokeTokenRequestParameters = new HashMap<String, String>();
        revokeTokenRequestParameters.put("token", token);
        revokeTokenRequestParameters.put("signature", generateSignature(revokeTokenRequestParameters, AliyunUtils.ACCESS_KEY_SECRET));
        revokeTokenRequestParameters.put("accessKey", AliyunUtils.ACCESS_KEY_ID);

        String result = OutUtils.doPostWithForm(MQ_AUTH_URL + "/token/revoke", revokeTokenRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return MapUtils.getBooleanValue(resultMap, "success");
    }
}
