package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class AlipayBasicModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @JsonIgnore
    private String returnUrl;

    @JsonIgnore
    private String topic;

    @JsonIgnore
    private String authToken;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public static class Builder<T extends Builder<T>> {
        private AlipayBasicModel instance;

        protected void setAlipayBasicModel(AlipayBasicModel alipayBasicModel) {
            this.instance = alipayBasicModel;
        }

        public T tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return (T) this;
        }

        public T branchId(String branchId) {
            instance.setBranchId(branchId);
            return (T) this;
        }

        public T returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return (T) this;
        }

        public T topic(String topic) {
            instance.setTopic(topic);
            return (T) this;
        }

        public T authToken(String authToken) {
            instance.setAuthToken(authToken);
            return (T) this;
        }

        protected void build(AlipayBasicModel alipayBasicModel) {
            alipayBasicModel.setTenantId(instance.getTenantId());
            alipayBasicModel.setBranchId(instance.getBranchId());
            alipayBasicModel.setReturnUrl(instance.getReturnUrl());
            alipayBasicModel.setTopic(instance.getTopic());
            alipayBasicModel.setAuthToken(instance.getAuthToken());
        }
    }
}
