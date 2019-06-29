package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class OrderShoudSettlementServiceModel extends JDDJBasicModel {
    /**
     * 订单编码
     */
    @NotNull
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, OrderShoudSettlementServiceModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        @Override
        public OrderShoudSettlementServiceModel build() {
            OrderShoudSettlementServiceModel orderShoudSettlementServiceModel = super.build();
            orderShoudSettlementServiceModel.setOrderId(instance.getOrderId());
            return orderShoudSettlementServiceModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
