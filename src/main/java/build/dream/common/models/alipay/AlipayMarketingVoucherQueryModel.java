package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingVoucherQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 28)
    @JsonProperty(value = "voucher_id")
    private String voucherId;

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public static class Builder {
        private final AlipayMarketingVoucherQueryModel instance = new AlipayMarketingVoucherQueryModel();

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

        public Builder voucherId(String voucherId) {
            instance.setVoucherId(voucherId);
            return this;
        }

        public AlipayMarketingVoucherQueryModel build() {
            AlipayMarketingVoucherQueryModel alipayMarketingVoucherQueryModel = new AlipayMarketingVoucherQueryModel();
            alipayMarketingVoucherQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingVoucherQueryModel.setBranchId(instance.getBranchId());
            alipayMarketingVoucherQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingVoucherQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingVoucherQueryModel.setAuthToken(instance.getAuthToken());
            alipayMarketingVoucherQueryModel.setVoucherId(instance.getVoucherId());
            return alipayMarketingVoucherQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
