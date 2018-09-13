package build.dream.common.models.newland;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RefundBarcodePayModel extends CommonModel {
    @NotNull
    @Length(max = 64)
    private String orderNo;

    private Integer txnAmt;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(Integer txnAmt) {
        this.txnAmt = txnAmt;
    }
}
