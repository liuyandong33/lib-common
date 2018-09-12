package build.dream.common.models.miya;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RefundModel extends BasicModel {
    @NotNull
    @Length(max = 10)
    private String posId;

    @NotNull
    @Length(max = 10)
    private String cashierId;

    @NotNull
    @Length(max = 32)
    private String orderNumber;

    @NotNull
    @Length(max = 32)
    private String refundNumber;

    @NotNull
    private Integer refundAmount;

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRefundNumber() {
        return refundNumber;
    }

    public void setRefundNumber(String refundNumber) {
        this.refundNumber = refundNumber;
    }

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }
}
