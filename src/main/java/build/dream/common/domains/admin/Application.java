package build.dream.common.domains.admin;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class Application extends BasicDomain {
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
    private Long serverId;

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

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public static class Builder {
        private final Application instance = new Application();

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

        public Builder serverId(Long serverId) {
            instance.setServerId(serverId);
            return this;
        }

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(Long createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(Long updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public Application build() {
            Application application = new Application();
            application.setPartitionCode(instance.getPartitionCode());
            application.setDeploymentEnvironment(instance.getDeploymentEnvironment());
            application.setServiceName(instance.getServiceName());
            application.setType(instance.getType());
            application.setVersion(instance.getVersion());
            application.setDeployedTime(instance.getDeployedTime());
            application.setDeployedUserId(instance.getDeployedUserId());
            application.setServerId(instance.getServerId());
            application.setId(instance.getId());
            application.setCreatedTime(instance.getCreatedTime());
            application.setCreatedUserId(instance.getCreatedUserId());
            application.setUpdatedTime(instance.getUpdatedTime());
            application.setUpdatedUserId(instance.getUpdatedUserId());
            application.setUpdatedRemark(instance.getUpdatedRemark());
            application.setDeletedTime(instance.getDeletedTime());
            application.setDeleted(instance.isDeleted());
            return application;
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
        public static final String SERVER_ID = "server_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String PARTITION_CODE = "partitionCode";
        public static final String DEPLOYMENT_ENVIRONMENT = "deploymentEnvironment";
        public static final String SERVICE_NAME = "serviceName";
        public static final String TYPE = "type";
        public static final String VERSION = "version";
        public static final String DEPLOYED_TIME = "deployedTime";
        public static final String DEPLOYED_USER_ID = "deployedUserId";
        public static final String SERVER_ID = "serverId";
    }
}
