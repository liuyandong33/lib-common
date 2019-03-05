package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class KoubeiTradeItemOrderQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @JsonProperty(value = "order_no")
    private String orderNo;

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
