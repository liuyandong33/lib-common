package build.dream.common.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class OrderAppointModel extends DadaBasicModel {
    @NotNull
    @JsonProperty(value = "order_id")
    private String orderId;

    @NotNull
    @JsonProperty(value = "transporter_id")
    private String transporterId;

    @NotNull
    @JsonProperty(value = "shop_no")
    private String shopNo;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransporterId() {
        return transporterId;
    }

    public void setTransporterId(String transporterId) {
        this.transporterId = transporterId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, OrderAppointModel> {
        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder transporterId(String transporterId) {
            instance.setTransporterId(transporterId);
            return this;
        }

        public Builder shopNo(String shopNo) {
            instance.setShopNo(shopNo);
            return this;
        }

        @Override
        public OrderAppointModel build() {
            OrderAppointModel orderAppointModel = super.build();
            orderAppointModel.setOrderId(instance.getOrderId());
            orderAppointModel.setTransporterId(instance.getTransporterId());
            orderAppointModel.setShopNo(instance.getShopNo());
            return orderAppointModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
