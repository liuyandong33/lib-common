package build.dream.common.models.newland;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class QryBarcodePayModel extends CommonModel {
    @NotNull
    @Length(max = 64)
    private String qryNo;

    public String getQryNo() {
        return qryNo;
    }

    public void setQryNo(String qryNo) {
        this.qryNo = qryNo;
    }
}
