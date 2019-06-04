package build.dream.common.models.beeleme;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

public class OrderPartRefundUnTreListModel extends BeElemeBasicModel {
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
        private final OrderPartRefundUnTreListModel instance = new OrderPartRefundUnTreListModel();

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

        public OrderPartRefundUnTreListModel build() {
            OrderPartRefundUnTreListModel orderPartRefundUnTreListModel = new OrderPartRefundUnTreListModel();
            orderPartRefundUnTreListModel.setSource(instance.getSource());
            orderPartRefundUnTreListModel.setEncrypt(instance.getEncrypt());
            orderPartRefundUnTreListModel.setFields(instance.getFields());
            orderPartRefundUnTreListModel.setOrderId(instance.getOrderId());
            return orderPartRefundUnTreListModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
