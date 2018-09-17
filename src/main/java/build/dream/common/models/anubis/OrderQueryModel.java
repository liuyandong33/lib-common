package build.dream.common.models.anubis;

import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class OrderQueryModel extends BasicModel {
    @NotNull
    @Length(max = 128)
    @SerializedName(value = "partner_order_code", alternate = "partnerOrderCode")
    private String partnerOrderCode;

    public String getPartnerOrderCode() {
        return partnerOrderCode;
    }

    public void setPartnerOrderCode(String partnerOrderCode) {
        this.partnerOrderCode = partnerOrderCode;
    }
}
