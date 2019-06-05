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

    public static class Builder {
        private final RefundBarcodePayModel instance = new RefundBarcodePayModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder opSys(String opSys) {
            instance.setOpSys(opSys);
            return this;
        }

        public Builder characterSet(String characterSet) {
            instance.setCharacterSet(characterSet);
            return this;
        }

        public Builder latitude(String latitude) {
            instance.setLatitude(latitude);
            return this;
        }

        public Builder longitude(String longitude) {
            instance.setLongitude(longitude);
            return this;
        }

        public Builder oprId(String oprId) {
            instance.setOprId(oprId);
            return this;
        }

        public Builder trmTyp(String trmTyp) {
            instance.setTrmTyp(trmTyp);
            return this;
        }

        public Builder tradeNo(String tradeNo) {
            instance.setTradeNo(tradeNo);
            return this;
        }

        public Builder txnTime(String txnTime) {
            instance.setTxnTime(txnTime);
            return this;
        }

        public Builder addField(String addField) {
            instance.setAddField(addField);
            return this;
        }

        public Builder version(String version) {
            instance.setVersion(version);
            return this;
        }

        public Builder orderNo(String orderNo) {
            instance.setOrderNo(orderNo);
            return this;
        }

        public Builder txnAmt(Integer txnAmt) {
            instance.setTxnAmt(txnAmt);
            return this;
        }

        public RefundBarcodePayModel build() {
            RefundBarcodePayModel refundBarcodePayModel = new RefundBarcodePayModel();
            refundBarcodePayModel.setTenantId(instance.getTenantId());
            refundBarcodePayModel.setBranchId(instance.getBranchId());
            refundBarcodePayModel.setOpSys(instance.getOpSys());
            refundBarcodePayModel.setCharacterSet(instance.getCharacterSet());
            refundBarcodePayModel.setLatitude(instance.getLatitude());
            refundBarcodePayModel.setLongitude(instance.getLongitude());
            refundBarcodePayModel.setOprId(instance.getOprId());
            refundBarcodePayModel.setTrmTyp(instance.getTrmTyp());
            refundBarcodePayModel.setTradeNo(instance.getTradeNo());
            refundBarcodePayModel.setTxnTime(instance.getTxnTime());
            refundBarcodePayModel.setAddField(instance.getAddField());
            refundBarcodePayModel.setVersion(instance.getVersion());
            refundBarcodePayModel.setOrderNo(instance.getOrderNo());
            refundBarcodePayModel.setTxnAmt(instance.getTxnAmt());
            return refundBarcodePayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
