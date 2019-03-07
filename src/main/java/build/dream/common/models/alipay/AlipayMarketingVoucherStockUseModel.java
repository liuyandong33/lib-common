package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingVoucherStockUseModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "entity_no")
    private String entityNo;

    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    public String getEntityNo() {
        return entityNo;
    }

    public void setEntityNo(String entityNo) {
        this.entityNo = entityNo;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public static class Builder {
        private final AlipayMarketingVoucherStockUseModel instance = new AlipayMarketingVoucherStockUseModel();

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

        public Builder entityNo(String entityNo) {
            instance.setEntityNo(entityNo);
            return this;
        }

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        public AlipayMarketingVoucherStockUseModel build() {
            AlipayMarketingVoucherStockUseModel alipayMarketingVoucherStockUseModel = new AlipayMarketingVoucherStockUseModel();
            alipayMarketingVoucherStockUseModel.setTenantId(instance.getTenantId());
            alipayMarketingVoucherStockUseModel.setBranchId(instance.getBranchId());
            alipayMarketingVoucherStockUseModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingVoucherStockUseModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingVoucherStockUseModel.setAuthToken(instance.getAuthToken());
            alipayMarketingVoucherStockUseModel.setEntityNo(instance.getEntityNo());
            alipayMarketingVoucherStockUseModel.setOutBizNo(instance.getOutBizNo());
            return alipayMarketingVoucherStockUseModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
