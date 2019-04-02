package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ZolozIdentificationUserWebQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "biz_id")
    private String bizId;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "zim_id")
    private String zimId;

    @Length(max = 1024)
    @JsonProperty(value = "extern_param")
    private String externParam;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getZimId() {
        return zimId;
    }

    public void setZimId(String zimId) {
        this.zimId = zimId;
    }

    public String getExternParam() {
        return externParam;
    }

    public void setExternParam(String externParam) {
        this.externParam = externParam;
    }

    public static class Builder {
        private final ZolozIdentificationUserWebQueryModel instance = new ZolozIdentificationUserWebQueryModel();

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

        public Builder bizId(String bizId) {
            instance.setBizId(bizId);
            return this;
        }

        public Builder zimId(String zimId) {
            instance.setZimId(zimId);
            return this;
        }

        public Builder externParam(String externParam) {
            instance.setExternParam(externParam);
            return this;
        }

        public ZolozIdentificationUserWebQueryModel build() {
            ZolozIdentificationUserWebQueryModel zolozIdentificationUserWebQueryModel = new ZolozIdentificationUserWebQueryModel();
            zolozIdentificationUserWebQueryModel.setTenantId(instance.getTenantId());
            zolozIdentificationUserWebQueryModel.setBranchId(instance.getBranchId());
            zolozIdentificationUserWebQueryModel.setReturnUrl(instance.getReturnUrl());
            zolozIdentificationUserWebQueryModel.setNotifyUrl(instance.getNotifyUrl());
            zolozIdentificationUserWebQueryModel.setAuthToken(instance.getAuthToken());
            zolozIdentificationUserWebQueryModel.setBizId(instance.getBizId());
            zolozIdentificationUserWebQueryModel.setZimId(instance.getZimId());
            zolozIdentificationUserWebQueryModel.setExternParam(instance.getExternParam());
            return zolozIdentificationUserWebQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}