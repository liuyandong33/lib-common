package build.dream.common.models.miya;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class RefundModel extends BasicModel {
    @NotNull
    private BigInteger posId;

    @NotNull
    private BigInteger cashierId;

    @NotNull
    @Length(max = 32)
    private String orderNumber;

    @NotNull
    @Length(max = 32)
    private String refundNumber;

    @NotNull
    private Integer refundAmount;

    public BigInteger getPosId() {
        return posId;
    }

    public void setPosId(BigInteger posId) {
        this.posId = posId;
    }

    public BigInteger getCashierId() {
        return cashierId;
    }

    public void setCashierId(BigInteger cashierId) {
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
