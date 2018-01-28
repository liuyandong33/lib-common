package build.dream.common.saas.domains;

public class SystemPartition {
    private String deploymentEnvironment;
    private String partitionCode;
    private Integer type;
    private String serviceName;
    private String serviceDomain;
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
