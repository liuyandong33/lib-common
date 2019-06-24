package build.dream.common.models.anubis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class OrderQueryModel extends AnubisBasicModel {
    @NotNull
    @Length(max = 128)
    @SerializedName(value = "partner_order_code", alternate = "partnerOrderCode")
    @JsonProperty(value = "partner_order_code")
    private String partnerOrderCode;

    public String getPartnerOrderCode() {
        return partnerOrderCode;
    }

    public void setPartnerOrderCode(String partnerOrderCode) {
        this.partnerOrderCode = partnerOrderCode;
    }

    public static class Builder extends AnubisBasicModel.Builder<Builder, OrderQueryModel> {
        public Builder partnerOrderCode(String partnerOrderCode) {
            instance.setPartnerOrderCode(partnerOrderCode);
            return this;
        }

        @Override
        public OrderQueryModel build() {
            OrderQueryModel orderQueryModel = super.build();
            orderQueryModel.setPartnerOrderCode(instance.getPartnerOrderCode());
            return orderQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
