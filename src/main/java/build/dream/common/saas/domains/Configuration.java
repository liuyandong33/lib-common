package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class Configuration extends BasicDomain {
    /**
     * 部署环境
     */
    private String deploymentEnvironment;
    /**
     * 分区码
     */
    private String partitionCode;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 配置key
     */
    private String configurationKey;
    /**
     * 配置value
     */
    private String configurationValue;

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
}
