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

    public static class Builder {
        private final ApplyTokenModel instance = new ApplyTokenModel();

        public Builder actions(String actions) {
            instance.setActions(actions);
            return this;
        }

        public Builder resources(String resources) {
            instance.setResources(resources);
            return this;
        }

        public Builder expireTime(Long expireTime) {
            instance.setExpireTime(expireTime);
            return this;
        }

        public Builder proxyType(String proxyType) {
            instance.setProxyType(proxyType);
            return this;
        }

        public Builder serviceName(String serviceName) {
            instance.setServiceName(serviceName);
            return this;
        }

        public Builder instanceId(String instanceId) {
            instance.setInstanceId(instanceId);
            return this;
        }

        public ApplyTokenModel build() {
            ApplyTokenModel applyTokenModel = new ApplyTokenModel();
            applyTokenModel.setActions(instance.getActions());
            applyTokenModel.setResources(instance.getResources());
            applyTokenModel.setExpireTime(instance.getExpireTime());
            applyTokenModel.setProxyType(instance.getProxyType());
            applyTokenModel.setServiceName(instance.getServiceName());
            applyTokenModel.setInstanceId(instance.getInstanceId());
            return applyTokenModel;
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}
