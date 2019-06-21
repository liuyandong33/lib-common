package build.dream.common.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class OrderAppointCancelModel extends DadaBasicModel {
    @NotNull
    @JsonProperty(value = "order_id")
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, OrderAppointCancelModel> {
        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }


        @Override
        public OrderAppointCancelModel build() {
            OrderAppointCancelModel orderAppointCancelModel = super.build();
            orderAppointCancelModel.setOrderId(instance.getOrderId());
            return orderAppointCancelModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
