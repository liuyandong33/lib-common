package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingExchangeVoucherUseModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 28)
    @JsonProperty(value = "voucher_id")
    private String voucherId;

    @Length(max = 16)
    @JsonProperty(value = "user_id")
    private String userId;

    @Length(max = 128)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public static class Builder {
        private final AlipayMarketingExchangeVoucherUseModel instance = new AlipayMarketingExchangeVoucherUseModel();

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

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        public AlipayMarketingExchangeVoucherUseModel build() {
            AlipayMarketingExchangeVoucherUseModel alipayMarketingExchangeVoucherUseModel = new AlipayMarketingExchangeVoucherUseModel();
            alipayMarketingExchangeVoucherUseModel.setTenantId(instance.getTenantId());
            alipayMarketingExchangeVoucherUseModel.setBranchId(instance.getBranchId());
            alipayMarketingExchangeVoucherUseModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingExchangeVoucherUseModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingExchangeVoucherUseModel.setAuthToken(instance.getAuthToken());
            alipayMarketingExchangeVoucherUseModel.setVoucherId(instance.getVoucherId());
            alipayMarketingExchangeVoucherUseModel.setUserId(instance.getUserId());
            alipayMarketingExchangeVoucherUseModel.setOutBizNo(instance.getOutBizNo());
            return alipayMarketingExchangeVoucherUseModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
