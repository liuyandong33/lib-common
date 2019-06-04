package build.dream.common.models.beeleme;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

public class OrderConfirmModel extends BeElemeBasicModel {
    @SerializedName(value = "order_id", alternate = "orderId")
    @JsonProperty(value = "order_id")
    @NotNull
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public static class Builder {
        private final OrderConfirmModel instance = new OrderConfirmModel();

        public Builder source(String source) {
            instance.setSource(source);
            return this;
        }

        public Builder encrypt(String encrypt) {
            instance.setEncrypt(encrypt);
            return this;
        }

        public Builder fields(String fields) {
            instance.setFields(fields);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public OrderConfirmModel build() {
            OrderConfirmModel orderConfirmModel = new OrderConfirmModel();
            orderConfirmModel.setSource(instance.getSource());
            orderConfirmModel.setEncrypt(instance.getEncrypt());
            orderConfirmModel.setFields(instance.getFields());
            orderConfirmModel.setOrderId(instance.getOrderId());
            return orderConfirmModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
