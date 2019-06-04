package build.dream.common.models.beeleme;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

public class OrderCompleteModel extends BeElemeBasicModel {
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
        private final OrderCompleteModel instance = new OrderCompleteModel();

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

        public OrderCompleteModel build() {
            OrderCompleteModel orderCompleteModel = new OrderCompleteModel();
            orderCompleteModel.setSource(instance.getSource());
            orderCompleteModel.setEncrypt(instance.getEncrypt());
            orderCompleteModel.setFields(instance.getFields());
            orderCompleteModel.setOrderId(instance.getOrderId());
            orderCompleteModel.setPhone(instance.getPhone());
            return orderCompleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
