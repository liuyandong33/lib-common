package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

public class MqttConfig extends BasicDomain {
    /**
     * 实例ID
     */
    private String instanceId;

    /**
     * 内网接入地址
     */
    private String internalEndPoint;

    /**
     * 公网接入地址
     */
    private String endPoint;

    /**
     * group id
     */
    private String groupId;

    /**
     * topic
     */
    private String topic;

    /**
     * 分区码
     */
    private String partitionCode;

    /**
     * 服务名称
     */
    private String serviceName;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInternalEndPoint() {
        return internalEndPoint;
    }

    public void setInternalEndPoint(String internalEndPoint) {
        this.internalEndPoint = internalEndPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public static class Builder extends BasicDomain.Builder<Builder, MqttConfig> {
        public Builder instanceId(String instanceId) {
            instance.setInstanceId(instanceId);
            return this;
        }

        public Builder endPoint(String endPoint) {
            instance.setEndPoint(endPoint);
            return this;
        }

        public Builder groupId(String groupId) {
            instance.setGroupId(groupId);
            return this;
        }

        public Builder topic(String topic) {
            instance.setTopic(topic);
            return this;
        }

        public Builder partitionCode(String partitionCode) {
            instance.setPartitionCode(partitionCode);
            return this;
        }

        public Builder serviceName(String serviceName) {
            instance.setServiceName(serviceName);
            return this;
        }

        @Override
        public MqttConfig build() {
            MqttConfig mqttConfig = super.build();
            mqttConfig.setInstanceId(instance.getInstanceId());
            mqttConfig.setEndPoint(instance.getEndPoint());
            mqttConfig.setGroupId(instance.getGroupId());
            mqttConfig.setTopic(instance.getTopic());
            mqttConfig.setPartitionCode(instance.getPartitionCode());
            mqttConfig.setServiceName(instance.getServiceName());
            return mqttConfig;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String INSTANCE_ID = "instance_id";
        public static final String INTERNAL_END_POINT = "internal_end_point";
        public static final String END_POINT = "end_point";
        public static final String GROUP_ID = "group_id";
        public static final String TOPIC = "topic";
        public static final String PARTITION_CODE = "partition_code";
        public static final String SERVICE_NAME = "service_name";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String INSTANCE_ID = "instanceId";
        public static final String INTERNAL_END_POINT = "internalEndPoint";
        public static final String END_POINT = "endPoint";
        public static final String GROUP_ID = "groupId";
        public static final String TOPIC = "topic";
        public static final String PARTITION_CODE = "partitionCode";
        public static final String SERVICE_NAME = "serviceName";
    }
}
