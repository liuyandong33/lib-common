package build.dream.common.mqtt;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class ApplyTokenModel extends BasicModel {
    @NotNull
    private String actions;

    @NotNull
    private String resources;

    @NotNull
    private Long expireTime;

    @NotNull
    private String proxyType;

    @NotNull
    private String serviceName;

    @NotNull
    private String instanceId;

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getProxyType() {
        return proxyType;
    }

    public void setProxyType(String proxyType) {
        this.proxyType = proxyType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
