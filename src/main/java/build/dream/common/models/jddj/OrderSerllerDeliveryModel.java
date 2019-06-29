package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class OrderSerllerDeliveryModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 操作人
     */
    @NotNull
    private String operator;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, OrderSerllerDeliveryModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder operator(String operator) {
            instance.setOperator(operator);
            return this;
        }

        @Override
        public OrderSerllerDeliveryModel build() {
            OrderSerllerDeliveryModel orderSerllerDeliveryModel = super.build();
            orderSerllerDeliveryModel.setOrderId(instance.getOrderId());
            orderSerllerDeliveryModel.setOperator(instance.getOperator());
            return orderSerllerDeliveryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
