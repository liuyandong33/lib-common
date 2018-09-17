package build.dream.common.models.anubis;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.ArrayUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CancelOrderModel extends BasicModel {
    private static final Integer[] ORDER_CANCEL_REASON_CODES = {2};
    private static final Integer[] ORDER_CANCEL_CODES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    @NotNull
    @Length(max = 128)
    @SerializedName(value = "partner_order_code", alternate = "partnerOrderCode")
    private String partnerOrderCode;

    @NotNull
    @SerializedName(value = "order_cancel_reason_code", alternate = "orderCancelReasonCode")
    private Integer orderCancelReasonCode;

    @NotNull
    @SerializedName(value = "order_cancel_code", alternate = "orderCancelCode")
    private Integer orderCancelCode;

    @Length(max = 128)
    @SerializedName(value = "order_cancel_description", alternate = "orderCancelDescription")
    private String orderCancelDescription;

    @NotNull
    @SerializedName(value = "order_cancel_time", alternate = "orderCancelTime")
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
}
