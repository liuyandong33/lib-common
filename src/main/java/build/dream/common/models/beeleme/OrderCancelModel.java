package build.dream.common.models.beeleme;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

public class OrderCancelModel extends BeElemeBasicModel {
    @SerializedName(value = "order_id", alternate = "orderId")
    @JsonProperty(value = "order_id")
    @NotNull
    private String orderId;

    @NotNull
    private String type;

    @NotNull
    private String reason;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class Builder {
        private final OrderCancelModel instance = new OrderCancelModel();

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

        public Builder type(String type) {
            instance.setType(type);
            return this;
        }

        public Builder reason(String reason) {
            instance.setReason(reason);
            return this;
        }

        public OrderCancelModel build() {
            OrderCancelModel orderCancelModel = new OrderCancelModel();
            orderCancelModel.setSource(instance.getSource());
            orderCancelModel.setEncrypt(instance.getEncrypt());
            orderCancelModel.setFields(instance.getFields());
            orderCancelModel.setOrderId(instance.getOrderId());
            orderCancelModel.setType(instance.getType());
            orderCancelModel.setReason(instance.getReason());
            return orderCancelModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
