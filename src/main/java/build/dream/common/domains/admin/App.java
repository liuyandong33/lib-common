package build.dream.common.domains.admin;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class App extends BasicDomain {
    /**
     * 分区码
     */
    private String partitionCode;
    /**
     * 部署环境
     */
    private String deploymentEnvironment;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 类型，snapshot-快照版，release-最终版
     */
    private String type;
    /**
     * 版本
     */
    private String version;
    /**
     * 部署时间
     */
    private Date deployedTime;
    /**
     * 部署用户ID
     */
    private Long deployedUserId;
    /**
     * 服务器ID
     */
    private Long hostId;

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
    }

    public String getDeploymentEnvironment() {
        return deploymentEnvironment;
    }

    public void setDeploymentEnvironment(String deploymentEnvironment) {
        this.deploymentEnvironment = deploymentEnvironment;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public Date getDeployedTime() {
        return deployedTime;
    }

    public void setDeployedTime(Date deployedTime) {
        this.deployedTime = deployedTime;
    }

    public Long getDeployedUserId() {
        return deployedUserId;
    }

    public void setDeployedUserId(Long deployedUserId) {
        this.deployedUserId = deployedUserId;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public static class Builder extends BasicDomain.Builder<Builder, App> {
        public Builder partitionCode(String partitionCode) {
            instance.setPartitionCode(partitionCode);
            return this;
        }

        public Builder deploymentEnvironment(String deploymentEnvironment) {
            instance.setDeploymentEnvironment(deploymentEnvironment);
            return this;
        }

        public Builder serviceName(String serviceName) {
            instance.setServiceName(serviceName);
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

        public Builder deployedTime(Date deployedTime) {
            instance.setDeployedTime(deployedTime);
            return this;
        }

        public Builder deployedUserId(Long deployedUserId) {
            instance.setDeployedUserId(deployedUserId);
            return this;
        }

        public Builder hostId(Long hostId) {
            instance.setHostId(hostId);
            return this;
        }

        public App build() {
            App app = super.build();
            app.setPartitionCode(instance.getPartitionCode());
            app.setDeploymentEnvironment(instance.getDeploymentEnvironment());
            app.setServiceName(instance.getServiceName());
            app.setType(instance.getType());
            app.setVersion(instance.getVersion());
            app.setDeployedTime(instance.getDeployedTime());
            app.setDeployedUserId(instance.getDeployedUserId());
            app.setHostId(instance.getHostId());
            return app;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String PARTITION_CODE = "partition_code";
        public static final String DEPLOYMENT_ENVIRONMENT = "deployment_environment";
        public static final String SERVICE_NAME = "service_name";
        public static final String TYPE = "type";
        public static final String VERSION = "version";
        public static final String DEPLOYED_TIME = "deployed_time";
        public static final String DEPLOYED_USER_ID = "deployed_user_id";
        public static final String HOST_ID = "host_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String PARTITION_CODE = "partitionCode";
        public static final String DEPLOYMENT_ENVIRONMENT = "deploymentEnvironment";
        public static final String SERVICE_NAME = "serviceName";
        public static final String TYPE = "type";
        public static final String VERSION = "version";
        public static final String DEPLOYED_TIME = "deployedTime";
        public static final String DEPLOYED_USER_ID = "deployedUserId";
        public static final String HOST_ID = "hostId";
    }
}
