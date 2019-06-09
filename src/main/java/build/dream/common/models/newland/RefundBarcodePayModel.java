package build.dream.common.models.newland;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RefundBarcodePayModel extends NewLandBasicModel {
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

    public static class Builder extends NewLandBasicModel.Builder<Builder, RefundBarcodePayModel> {
        public Builder orderNo(String orderNo) {
            instance.setOrderNo(orderNo);
            return this;
        }

        public Builder txnAmt(Integer txnAmt) {
            instance.setTxnAmt(txnAmt);
            return this;
        }

        @Override
        public RefundBarcodePayModel build() {
            RefundBarcodePayModel refundBarcodePayModel = super.build();
            refundBarcodePayModel.setOrderNo(instance.getOrderNo());
            refundBarcodePayModel.setTxnAmt(instance.getTxnAmt());
            return refundBarcodePayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
