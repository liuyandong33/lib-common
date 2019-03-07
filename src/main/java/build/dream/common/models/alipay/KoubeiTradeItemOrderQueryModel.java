package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class KoubeiTradeItemOrderQueryModel extends AlipayBasicModel {
    @NotNull
    @JsonProperty(value = "order_no")
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public static class Builder {
        private final KoubeiTradeItemOrderQueryModel instance = new KoubeiTradeItemOrderQueryModel();

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

        public Builder orderNo(String orderNo) {
            instance.setOrderNo(orderNo);
            return this;
        }

        public KoubeiTradeItemOrderQueryModel build() {
            KoubeiTradeItemOrderQueryModel koubeiTradeItemOrderQueryModel = new KoubeiTradeItemOrderQueryModel();
            koubeiTradeItemOrderQueryModel.setTenantId(instance.getTenantId());
            koubeiTradeItemOrderQueryModel.setBranchId(instance.getBranchId());
            koubeiTradeItemOrderQueryModel.setOrderNo(instance.getOrderNo());
            return koubeiTradeItemOrderQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
