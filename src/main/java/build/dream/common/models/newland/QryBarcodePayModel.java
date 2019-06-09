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

    public static class Builder extends NewLandBasicModel.Builder<Builder, QryBarcodePayModel> {
        public Builder qryNo(String qryNo) {
            instance.setQryNo(qryNo);
            return this;
        }

        @Override
        public QryBarcodePayModel build() {
            QryBarcodePayModel qryBarcodePayModel = super.build();
            qryBarcodePayModel.setQryNo(instance.getQryNo());
            return qryBarcodePayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
