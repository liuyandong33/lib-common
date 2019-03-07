package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAppQRCodeCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 256)
    @JsonProperty(value = "url_param")
    private String urlParam;

    @NotNull
    @Length(max = 256)
    @JsonProperty(value = "query_param")
    private String queryParam;

    @NotNull
    @Length(max = 32)
    private String describe;

    public String getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(String urlParam) {
        this.urlParam = urlParam;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public static class Builder {
        private final AlipayOpenAppQRCodeCreateModel instance = new AlipayOpenAppQRCodeCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder urlParam(String urlParam) {
            instance.setUrlParam(urlParam);
            return this;
        }

        public Builder queryParam(String queryParam) {
            instance.setQueryParam(queryParam);
            return this;
        }

        public Builder describe(String describe) {
            instance.setDescribe(describe);
            return this;
        }

        public AlipayOpenAppQRCodeCreateModel build() {
            AlipayOpenAppQRCodeCreateModel alipayOpenAppQRCodeCreateModel = new AlipayOpenAppQRCodeCreateModel();
            alipayOpenAppQRCodeCreateModel.setTenantId(instance.getTenantId());
            alipayOpenAppQRCodeCreateModel.setBranchId(instance.getBranchId());
            alipayOpenAppQRCodeCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenAppQRCodeCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenAppQRCodeCreateModel.setAuthToken(instance.getAuthToken());
            alipayOpenAppQRCodeCreateModel.setUrlParam(instance.getUrlParam());
            alipayOpenAppQRCodeCreateModel.setQueryParam(instance.getQueryParam());
            alipayOpenAppQRCodeCreateModel.setDescribe(instance.getDescribe());
            return alipayOpenAppQRCodeCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
