package build.dream.common.models.anubis;

import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.ArrayUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class OrderComplaintModel extends AnubisBasicModel {
    private static final Integer[] ORDER_COMPLAINT_CODES = {230, 150, 160, 190, 170, 140, 210, 220, 200, 130};
    @NotNull
    @Length(max = 128)
    @SerializedName(value = "partner_order_code", alternate = "partnerOrderCode")
    @JsonProperty(value = "partner_order_code")
    private String partnerOrderCode;

    @SerializedName(value = "order_complaint_code", alternate = "orderComplaintCode")
    @JsonProperty(value = "order_complaint_code")
    private Integer orderComplaintCode;

    @Length(max = 128)
    @SerializedName(value = "order_complaint_desc", alternate = "orderComplaintDesc")
    @JsonProperty(value = "order_complaint_desc")
    private String orderComplaintDesc;

    @NotNull
    @SerializedName(value = "order_complaint_time", alternate = "orderComplaintTime")
    @JsonProperty(value = "order_complaint_time")
    private Long orderComplaintTime;

    public String getPartnerOrderCode() {
        return partnerOrderCode;
    }

    public void setPartnerOrderCode(String partnerOrderCode) {
        this.partnerOrderCode = partnerOrderCode;
    }

    public Integer getOrderComplaintCode() {
        return orderComplaintCode;
    }

    public void setOrderComplaintCode(Integer orderComplaintCode) {
        this.orderComplaintCode = orderComplaintCode;
    }

    public String getOrderComplaintDesc() {
        return orderComplaintDesc;
    }

    public void setOrderComplaintDesc(String orderComplaintDesc) {
        this.orderComplaintDesc = orderComplaintDesc;
    }

    public Long getOrderComplaintTime() {
        return orderComplaintTime;
    }

    public void setOrderComplaintTime(Long orderComplaintTime) {
        this.orderComplaintTime = orderComplaintTime;
    }

    @Override
    public boolean validate() {
        return super.validate() && ArrayUtils.contains(ORDER_COMPLAINT_CODES, orderComplaintCode);
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ApplicationHandler.inArray(ORDER_COMPLAINT_CODES, orderComplaintCode, "orderComplaintCode");
        if (orderComplaintCode == 230) {
            ApplicationHandler.notBlank(orderComplaintDesc, "orderComplaintDesc");
        }
    }

    public static class Builder extends AnubisBasicModel.Builder<Builder, OrderComplaintModel> {
        public Builder partnerOrderCode(String partnerOrderCode) {
            instance.setPartnerOrderCode(partnerOrderCode);
            return this;
        }

        public Builder orderComplaintCode(Integer orderComplaintCode) {
            instance.setOrderComplaintCode(orderComplaintCode);
            return this;
        }

        public Builder orderComplaintDesc(String orderComplaintDesc) {
            instance.setOrderComplaintDesc(orderComplaintDesc);
            return this;
        }

        public Builder orderComplaintTime(Long orderComplaintTime) {
            instance.setOrderComplaintTime(orderComplaintTime);
            return this;
        }

        @Override
        public OrderComplaintModel build() {
            OrderComplaintModel orderComplaintModel = super.build();
            orderComplaintModel.setPartnerOrderCode(instance.getPartnerOrderCode());
            orderComplaintModel.setOrderComplaintCode(instance.getOrderComplaintCode());
            orderComplaintModel.setOrderComplaintDesc(instance.getOrderComplaintDesc());
            orderComplaintModel.setOrderComplaintTime(instance.getOrderComplaintTime());
            return orderComplaintModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
