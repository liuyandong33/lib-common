package build.dream.common.saas.domains;

import java.math.BigInteger;
import java.util.Date;

public class AccessLog {
    private BigInteger id;
    private String partitionCode;
    private String serviceName;
    private String controllerName;
    private String actionName;
    private Date accessTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }
}
