package build.dream.common.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class OrderCancelModel extends DadaBasicModel {
    /**
     * 第三方订单编号
     */
    @NotNull
    @JsonProperty(value = "order_id")
    private String orderId;

    /**
     * 取消原因ID
     */
    @NotNull
    @JsonProperty(value = "cancel_reason_id")
    private String cancelReasonId;

    /**
     * 取消原因(当取消原因ID为其他时，此字段必填)
     */
    @NotNull
    @JsonProperty(value = "cancel_reason")
    private String cancelReason;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCancelReasonId() {
        return cancelReasonId;
    }

    public void setCancelReasonId(String cancelReasonId) {
        this.cancelReasonId = cancelReasonId;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, OrderCancelModel> {
        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder cancelReasonId(String cancelReasonId) {
            instance.setCancelReasonId(cancelReasonId);
            return this;
        }

        public Builder cancelReason(String cancelReason) {
            instance.setCancelReason(cancelReason);
            return this;
        }

        @Override
        public OrderCancelModel build() {
            OrderCancelModel orderCancelModel = super.build();
            orderCancelModel.setOrderId(instance.getOrderId());
            orderCancelModel.setCancelReasonId(instance.getCancelReasonId());
            orderCancelModel.setCancelReason(instance.getCancelReason());
            return orderCancelModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
