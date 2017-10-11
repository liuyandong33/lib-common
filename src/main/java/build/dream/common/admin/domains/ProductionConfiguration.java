package build.dream.common.admin.domains;

import java.math.BigInteger;
import java.util.Date;

public class ProductionConfiguration {
    private BigInteger id;
    private String deploymentEnvironment;
    private String partitionCode;
    private String serviceName;
    private String configurationKey;
    private String configurationValue;
    private Date createTime;
    private BigInteger createUserId;
    private Date lastUpdateTime;
    private BigInteger lastUpdateUserId;
    private String lastUpdateRemark;
    private boolean deleted;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getConfigurationKey() {
        return configurationKey;
    }

    public void setConfigurationKey(String configurationKey) {
        this.configurationKey = configurationKey;
    }

    public String getConfigurationValue() {
        return configurationValue;
    }

    public void setConfigurationValue(String configurationValue) {
        this.configurationValue = configurationValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigInteger getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(BigInteger createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public BigInteger getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(BigInteger lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getLastUpdateRemark() {
        return lastUpdateRemark;
    }

    public void setLastUpdateRemark(String lastUpdateRemark) {
        this.lastUpdateRemark = lastUpdateRemark;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
