package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class SystemPartition extends BasicDomain {
    /**
     * 部署环境
     */
    private String deploymentEnvironment;
    /**
     * 分区码
     */
    private String partitionCode;
    /**
     * 服务类型，1-公共服务，2-分区服务
     */
    private Integer type;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 服务地址
     */
    private String serviceDomain;
    /**
     * 外网服务地址
     */
    private String outsideServiceDomain;

    public String getDeploymentEnvironment() {
        return deploymentEnvironment;
    }

    public void setDeploymentEnvironment(String deploymentEnvironment) {
        this.deploymentEnvironment = deploymentEnvironment;
    }

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDomain() {
        return serviceDomain;
    }

    public void setServiceDomain(String serviceDomain) {
        this.serviceDomain = serviceDomain;
    }

    public String getOutsideServiceDomain() {
        return outsideServiceDomain;
    }

    public void setOutsideServiceDomain(String outsideServiceDomain) {
        this.outsideServiceDomain = outsideServiceDomain;
    }

    public static class Builder {
        private final SystemPartition instance = new SystemPartition();

        public Builder deploymentEnvironment(String deploymentEnvironment) {
            instance.setDeploymentEnvironment(deploymentEnvironment);
            return this;
        }

        public Builder partitionCode(String partitionCode) {
            instance.setPartitionCode(partitionCode);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder serviceName(String serviceName) {
            instance.setServiceName(serviceName);
            return this;
        }

        public Builder serviceDomain(String serviceDomain) {
            instance.setServiceDomain(serviceDomain);
            return this;
        }

        public Builder outsideServiceDomain(String outsideServiceDomain) {
            instance.setOutsideServiceDomain(outsideServiceDomain);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public SystemPartition build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String DEPLOYMENT_ENVIRONMENT = "deployment_environment";
        public static final String PARTITION_CODE = "partition_code";
        public static final String TYPE = "type";
        public static final String SERVICE_NAME = "service_name";
        public static final String SERVICE_DOMAIN = "service_domain";
        public static final String OUTSIDE_SERVICE_DOMAIN = "outside_service_domain";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String DEPLOYMENT_ENVIRONMENT = "deploymentEnvironment";
        public static final String PARTITION_CODE = "partitionCode";
        public static final String TYPE = "type";
        public static final String SERVICE_NAME = "serviceName";
        public static final String SERVICE_DOMAIN = "serviceDomain";
        public static final String OUTSIDE_SERVICE_DOMAIN = "outsideServiceDomain";
    }
}
