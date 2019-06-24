package build.dream.common.models.anubis;

import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.ArrayUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class OrderCancelModel extends AnubisBasicModel {
    private static final Integer[] ORDER_CANCEL_REASON_CODES = {2};
    private static final Integer[] ORDER_CANCEL_CODES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    @NotNull
    @Length(max = 128)
    @SerializedName(value = "partner_order_code", alternate = "partnerOrderCode")
    @JsonProperty(value = "partner_order_code")
    private String partnerOrderCode;

    @NotNull
    @SerializedName(value = "order_cancel_reason_code", alternate = "orderCancelReasonCode")
    @JsonProperty(value = "order_cancel_reason_code")
    private Integer orderCancelReasonCode;

    @NotNull
    @SerializedName(value = "order_cancel_code", alternate = "orderCancelCode")
    @JsonProperty(value = "order_cancel_code")
    private Integer orderCancelCode;

    @Length(max = 128)
    @SerializedName(value = "order_cancel_description", alternate = "orderCancelDescription")
    @JsonProperty(value = "order_cancel_description")
    private String orderCancelDescription;

    @NotNull
    @SerializedName(value = "order_cancel_time", alternate = "orderCancelTime")
    @JsonProperty(value = "order_cancel_time")
    private Long orderCancelTime;

    public String getPartnerOrderCode() {
        return partnerOrderCode;
    }

    public void setPartnerOrderCode(String partnerOrderCode) {
        this.partnerOrderCode = partnerOrderCode;
    }

    public Integer getOrderCancelReasonCode() {
        return orderCancelReasonCode;
    }

    public void setOrderCancelReasonCode(Integer orderCancelReasonCode) {
        this.orderCancelReasonCode = orderCancelReasonCode;
    }

    public Integer getOrderCancelCode() {
        return orderCancelCode;
    }

    public void setOrderCancelCode(Integer orderCancelCode) {
        this.orderCancelCode = orderCancelCode;
    }

    public String getOrderCancelDescription() {
        return orderCancelDescription;
    }

    public void setOrderCancelDescription(String orderCancelDescription) {
        this.orderCancelDescription = orderCancelDescription;
    }

    public Long getOrderCancelTime() {
        return orderCancelTime;
    }

    public void setOrderCancelTime(Long orderCancelTime) {
        this.orderCancelTime = orderCancelTime;
    }

    @Override
    public boolean validate() {
        return super.validate() && ArrayUtils.contains(ORDER_CANCEL_REASON_CODES, orderCancelReasonCode) && ArrayUtils.contains(ORDER_CANCEL_CODES, orderCancelCode);
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ApplicationHandler.inArray(ORDER_CANCEL_REASON_CODES, orderCancelReasonCode, "orderCancelReasonCode");
        ApplicationHandler.inArray(ORDER_CANCEL_CODES, orderCancelCode, "orderCancelCode");
    }

    public static class Builder extends AnubisBasicModel.Builder<Builder, OrderCancelModel> {
        public Builder partnerOrderCode(String partnerOrderCode) {
            instance.setPartnerOrderCode(partnerOrderCode);
            return this;
        }

        public Builder orderCancelReasonCode(Integer orderCancelReasonCode) {
            instance.setOrderCancelReasonCode(orderCancelReasonCode);
            return this;
        }

        public Builder orderCancelCode(Integer orderCancelCode) {
            instance.setOrderCancelCode(orderCancelCode);
            return this;
        }

        public Builder orderCancelDescription(String orderCancelDescription) {
            instance.setOrderCancelDescription(orderCancelDescription);
            return this;
        }

        public Builder orderCancelTime(Long orderCancelTime) {
            instance.setOrderCancelTime(orderCancelTime);
            return this;
        }

        @Override
        public OrderCancelModel build() {
            OrderCancelModel orderCancelModel = super.build();
            orderCancelModel.setPartnerOrderCode(instance.getPartnerOrderCode());
            orderCancelModel.setOrderCancelReasonCode(instance.getOrderCancelReasonCode());
            orderCancelModel.setOrderCancelCode(instance.getOrderCancelCode());
            orderCancelModel.setOrderCancelDescription(instance.getOrderCancelDescription());
            orderCancelModel.setOrderCancelTime(instance.getOrderCancelTime());
            return orderCancelModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
