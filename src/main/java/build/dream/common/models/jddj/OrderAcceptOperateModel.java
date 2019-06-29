package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class OrderAcceptOperateModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 操作类型 true 接单 false不接单
     */
    @NotNull
    private Boolean isAgreed;

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

    public Boolean getIsAgreed() {
        return isAgreed;
    }

    public void setIsAgreed(Boolean isAgreed) {
        this.isAgreed = isAgreed;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, OrderAcceptOperateModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder isAgreed(Boolean isAgreed) {
            instance.setIsAgreed(isAgreed);
            return this;
        }

        public Builder operator(String operator) {
            instance.setOperator(operator);
            return this;
        }

        @Override
        public OrderAcceptOperateModel build() {
            OrderAcceptOperateModel orderAcceptOperateModel = super.build();
            orderAcceptOperateModel.setOrderId(instance.getOrderId());
            orderAcceptOperateModel.setIsAgreed(instance.getIsAgreed());
            orderAcceptOperateModel.setOperator(instance.getOperator());
            return orderAcceptOperateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
