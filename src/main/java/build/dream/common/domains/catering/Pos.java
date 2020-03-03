package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

@ShardingColumn(fieldName = Pos.FieldName.TENANT_ID, columnName = Pos.ColumnName.TENANT_ID)
public class Pos extends BasicDomain {
    public static final String TABLE_NAME = "pos";
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
     * 门店编号
     */
    private String branchCode;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 设备ID，mac地址
     */
    private String deviceId;
    /**
     * pos 类型，安卓-android，苹果-ios
     */
    private String type;
    /**
     * pos 版本号
     */
    private String version;
    /**
     * 是否在线
     */
    private boolean online;

    /**
     * 阿里云推送服务设备ID
     */
    private String cloudPushDeviceId;

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

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getCloudPushDeviceId() {
        return cloudPushDeviceId;
    }

    public void setCloudPushDeviceId(String cloudPushDeviceId) {
        this.cloudPushDeviceId = cloudPushDeviceId;
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

    public static class Builder extends BasicDomain.Builder<Builder, Pos> {
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

        public Builder branchCode(String branchCode) {
            instance.setBranchCode(branchCode);
            return this;
        }

        public Builder userId(Long userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder deviceId(String deviceId) {
            instance.setDeviceId(deviceId);
            return this;
        }

        public Builder type(String type) {
            instance.setType(type);
            return this;
        }

        public Builder version(String version) {
            instance.setVersion(version);
            return this;
        }

        public Builder online(boolean online) {
            instance.setOnline(online);
            return this;
        }

        public Builder cloudPushDeviceId(String cloudPushDeviceId) {
            instance.setCloudPushDeviceId(cloudPushDeviceId);
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
        public Pos build() {
            Pos pos = super.build();
            pos.setTenantId(instance.getTenantId());
            pos.setTenantCode(instance.getTenantCode());
            pos.setBranchId(instance.getBranchId());
            pos.setBranchCode(instance.getBranchCode());
            pos.setUserId(instance.getUserId());
            pos.setDeviceId(instance.getDeviceId());
            pos.setType(instance.getType());
            pos.setVersion(instance.getVersion());
            pos.setOnline(instance.isOnline());
            pos.setCloudPushDeviceId(instance.getCloudPushDeviceId());
            pos.setMqttClientId(instance.getMqttClientId());
            pos.setMqttToken(instance.getMqttToken());
            return pos;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String BRANCH_CODE = "branch_code";
        public static final String USER_ID = "user_id";
        public static final String DEVICE_ID = "device_id";
        public static final String TYPE = "type";
        public static final String VERSION = "version";
        public static final String ONLINE = "online";
        public static final String CLOUD_PUSH_DEVICE_ID = "cloud_push_device_id";
        public static final String MQTT_CLIENT_ID = "mqtt_client_id";
        public static final String MQTT_TOKEN = "mqtt_token";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String BRANCH_CODE = "branchCode";
        public static final String USER_ID = "userId";
        public static final String DEVICE_ID = "deviceId";
        public static final String TYPE = "type";
        public static final String VERSION = "version";
        public static final String ONLINE = "online";
        public static final String CLOUD_PUSH_DEVICE_ID = "cloudPushDeviceId";
        public static final String MQTT_CLIENT_ID = "mqttClientId";
        public static final String MQTT_TOKEN = "mqttToken";
    }
}
