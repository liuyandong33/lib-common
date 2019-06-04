package build.dream.common.models.beeleme;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

public class OrderPartRefundGetModel extends BeElemeBasicModel {
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
        private final OrderPartRefundGetModel instance = new OrderPartRefundGetModel();

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

        public OrderPartRefundGetModel build() {
            OrderPartRefundGetModel orderPartRefundGetModel = new OrderPartRefundGetModel();
            orderPartRefundGetModel.setSource(instance.getSource());
            orderPartRefundGetModel.setEncrypt(instance.getEncrypt());
            orderPartRefundGetModel.setFields(instance.getFields());
            orderPartRefundGetModel.setOrderId(instance.getOrderId());
            return orderPartRefundGetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
