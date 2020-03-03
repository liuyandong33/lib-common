package build.dream.common.domains.iot;

import build.dream.common.basic.BasicDomain;

public class Device extends BasicDomain {
    public static final String TABLE_NAME = "device";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private Long branchId;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备编号
     */
    private String code;

    /**
     * 设备类型，1-温控设备
     */
    private Integer type;

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 客户端秘钥
     */
    private String clientSecret;

    /**
     * MQTT Client Id
     */
    private String mqttClientId;

    /**
     * MQTT Token
     */
    private String mqttToken;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getMqttClientId() {
        return mqttClientId;
    }

    public void setMqttClientId(String mqttClientId) {
        this.mqttClientId = mqttClientId;
    }

    public String getMqttToken() {
        return mqttToken;
    }

    public void setMqttToken(String mqttToken) {
        this.mqttToken = mqttToken;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Device> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder clientId(String clientId) {
            instance.setClientId(clientId);
            return this;
        }

        public Builder clientSecret(String clientSecret) {
            instance.setClientSecret(clientSecret);
            return this;
        }

        public Builder mqttClientId(String mqttClientId) {
            instance.setMqttClientId(mqttClientId);
            return this;
        }

        public Builder mqttToken(String mqttToken) {
            instance.setMqttToken(mqttToken);
            return this;
        }

        @Override
        public Device build() {
            Device device = super.build();
            device.setTenantId(instance.getTenantId());
            device.setTenantCode(instance.getTenantCode());
            device.setBranchId(instance.getBranchId());
            device.setName(instance.getName());
            device.setCode(instance.getCode());
            device.setType(instance.getType());
            device.setClientId(instance.getClientId());
            device.setClientSecret(instance.getClientSecret());
            device.setMqttClientId(instance.getMqttClientId());
            device.setMqttToken(instance.getMqttToken());
            return device;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String NAME = "name";
        public static final String CODE = "code";
        public static final String TYPE = "type";
        public static final String CLIENT_ID = "client_id";
        public static final String CLIENT_SECRET = "client_secret";
        public static final String MQTT_CLIENT_ID = "mqtt_client_id";
        public static final String MQTT_TOKEN = "mqtt_token";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String NAME = "name";
        public static final String CODE = "code";
        public static final String TYPE = "type";
        public static final String CLIENT_ID = "clientId";
        public static final String CLIENT_SECRET = "clientSecret";
        public static final String MQTT_CLIENT_ID = "mqttClientId";
        public static final String MQTT_TOKEN = "mqttToken";
    }
}
