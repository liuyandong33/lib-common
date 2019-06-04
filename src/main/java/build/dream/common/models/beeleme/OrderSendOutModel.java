package build.dream.common.models.beeleme;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

public class OrderSendOutModel extends BeElemeBasicModel {
    @SerializedName(value = "order_id", alternate = "orderId")
    @JsonProperty(value = "order_id")
    @NotNull
    private String orderId;

    private String phone;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static class Builder {
        private final OrderSendOutModel instance = new OrderSendOutModel();

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

        public Builder phone(String phone) {
            instance.setPhone(phone);
            return this;
        }

        public OrderSendOutModel build() {
            OrderSendOutModel orderSendOutModel = new OrderSendOutModel();
            orderSendOutModel.setSource(instance.getSource());
            orderSendOutModel.setEncrypt(instance.getEncrypt());
            orderSendOutModel.setFields(instance.getFields());
            orderSendOutModel.setOrderId(instance.getOrderId());
            orderSendOutModel.setPhone(instance.getPhone());
            return orderSendOutModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
