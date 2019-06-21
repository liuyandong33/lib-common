package build.dream.common.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ComplaintDadaModel extends DadaBasicModel {
    /**
     * 第三方订单编号
     */
    @NotNull
    @JsonProperty(value = "order_id")
    private String orderId;

    /**
     * 投诉原因ID
     */
    @NotNull
    @JsonProperty(value = "reason_id")
    private String reasonId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, ComplaintDadaModel> {
        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder reasonId(String reasonId) {
            instance.setReasonId(reasonId);
            return this;
        }

        @Override
        public ComplaintDadaModel build() {
            ComplaintDadaModel complaintDadaModel = super.build();
            complaintDadaModel.setOrderId(instance.getOrderId());
            complaintDadaModel.setReasonId(instance.getReasonId());
            return complaintDadaModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
