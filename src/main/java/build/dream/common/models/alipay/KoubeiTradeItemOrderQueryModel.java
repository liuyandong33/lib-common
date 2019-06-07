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

    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiTradeItemOrderQueryModel> {
        public Builder orderNo(String orderNo) {
            instance.setOrderNo(orderNo);
            return this;
        }

        @Override
        public KoubeiTradeItemOrderQueryModel build() {
            KoubeiTradeItemOrderQueryModel koubeiTradeItemOrderQueryModel = super.build();
            koubeiTradeItemOrderQueryModel.setOrderNo(instance.getOrderNo());
            return koubeiTradeItemOrderQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
