package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

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
}
