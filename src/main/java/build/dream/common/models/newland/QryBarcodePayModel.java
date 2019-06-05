package build.dream.common.models.newland;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class QryBarcodePayModel extends NewLandBasicModel {
    @NotNull
    @Length(max = 64)
    private String qryNo;

    public String getQryNo() {
        return qryNo;
    }

    public void setQryNo(String qryNo) {
        this.qryNo = qryNo;
    }

    public static class Builder {
        private final QryBarcodePayModel instance = new QryBarcodePayModel();

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

        public Builder qryNo(String qryNo) {
            instance.setQryNo(qryNo);
            return this;
        }

        public QryBarcodePayModel build() {
            QryBarcodePayModel qryBarcodePayModel = new QryBarcodePayModel();
            qryBarcodePayModel.setTenantId(instance.getTenantId());
            qryBarcodePayModel.setBranchId(instance.getBranchId());
            qryBarcodePayModel.setOpSys(instance.getOpSys());
            qryBarcodePayModel.setCharacterSet(instance.getCharacterSet());
            qryBarcodePayModel.setLatitude(instance.getLatitude());
            qryBarcodePayModel.setLongitude(instance.getLongitude());
            qryBarcodePayModel.setOprId(instance.getOprId());
            qryBarcodePayModel.setTrmTyp(instance.getTrmTyp());
            qryBarcodePayModel.setTradeNo(instance.getTradeNo());
            qryBarcodePayModel.setTxnTime(instance.getTxnTime());
            qryBarcodePayModel.setAddField(instance.getAddField());
            qryBarcodePayModel.setVersion(instance.getVersion());
            qryBarcodePayModel.setQryNo(instance.getQryNo());
            return qryBarcodePayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
