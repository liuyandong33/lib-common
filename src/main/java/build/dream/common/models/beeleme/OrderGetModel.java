package build.dream.common.models.beeleme;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class OrderGetModel extends BeElemeBasicModel {
    @SerializedName(value = "order_id", alternate = "orderId")
    @JsonProperty(value = "order_id")
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public static class Builder {
        private final OrderGetModel instance = new OrderGetModel();

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

        public OrderGetModel build() {
            OrderGetModel orderGetModel = new OrderGetModel();
            orderGetModel.setSource(instance.getSource());
            orderGetModel.setEncrypt(instance.getEncrypt());
            orderGetModel.setFields(instance.getFields());
            orderGetModel.setOrderId(instance.getOrderId());
            return orderGetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
