package build.dream.common.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderQueryModel extends DadaBasicModel {
    @JsonProperty(value = "order_id")
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, OrderQueryModel> {
        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }


        @Override
        public OrderQueryModel build() {
            OrderQueryModel orderQueryModel = super.build();
            orderQueryModel.setOrderId(instance.getOrderId());
            return orderQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
