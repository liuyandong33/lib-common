package build.dream.common.models.beeleme;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

public class OrderDisAgreeRefundModel extends BeElemeBasicModel {
    @SerializedName(value = "order_id", alternate = "orderId")
    @JsonProperty(value = "order_id")
    @NotNull
    private String orderId;

    @SerializedName(value = "refuse_reason", alternate = "refuseReason")
    @JsonProperty(value = "refuse_reason")
    @NotNull
    private String refuseReason;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public static class Builder {
        private final OrderDisAgreeRefundModel instance = new OrderDisAgreeRefundModel();

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

        public Builder refuseReason(String refuseReason) {
            instance.setRefuseReason(refuseReason);
            return this;
        }

        public OrderDisAgreeRefundModel build() {
            OrderDisAgreeRefundModel orderDisAgreeRefundModel = new OrderDisAgreeRefundModel();
            orderDisAgreeRefundModel.setSource(instance.getSource());
            orderDisAgreeRefundModel.setEncrypt(instance.getEncrypt());
            orderDisAgreeRefundModel.setFields(instance.getFields());
            orderDisAgreeRefundModel.setOrderId(instance.getOrderId());
            orderDisAgreeRefundModel.setRefuseReason(instance.getRefuseReason());
            return orderDisAgreeRefundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
