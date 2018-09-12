package build.dream.common.models.miya;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class OrderQueryModel extends BasicModel {
    @NotNull
    @Length(max = 10)
    private String posId;

    @NotNull
    @Length(max = 10)
    private String cashierId;

    @NotNull
    @Length(max = 32)
    private String orderNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

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
}
