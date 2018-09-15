package build.dream.common.models.anubis;

import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class OrderModel extends BasicModel {
    @Length(max = 255)
    @SerializedName(value = "partner_remark", alternate = "partnerRemark")
    private String partnerRemark;

    @NotNull
    @Length(max = 128)
    @SerializedName(value = "partner_order_code", alternate = "partnerOrderCode")
    private String partnerOrderCode;
}
