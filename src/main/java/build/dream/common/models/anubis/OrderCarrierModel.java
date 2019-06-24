package build.dream.common.models.anubis;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class OrderCarrierModel extends AnubisBasicModel {
    @NotNull
    @JsonProperty(value = "partner_order_code")
    private String partnerOrderCode;

    public String getPartnerOrderCode() {
        return partnerOrderCode;
    }

    public void setPartnerOrderCode(String partnerOrderCode) {
        this.partnerOrderCode = partnerOrderCode;
    }

    public static class Builder extends AnubisBasicModel.Builder<Builder, OrderCarrierModel> {
        public Builder partnerOrderCode(String partnerOrderCode) {
            instance.setPartnerOrderCode(partnerOrderCode);
            return this;
        }

        @Override
        public OrderCarrierModel build() {
            OrderCarrierModel orderCarrierModel = super.build();
            orderCarrierModel.setPartnerOrderCode(instance.getPartnerOrderCode());
            return orderCarrierModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
