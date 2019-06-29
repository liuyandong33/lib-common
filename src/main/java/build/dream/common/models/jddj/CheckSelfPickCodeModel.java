package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class CheckSelfPickCodeModel extends JDDJBasicModel {
    /**
     * 自提码
     */
    @NotNull
    private String selfPickCode;

    /**
     * 订单编号
     */
    @NotNull
    private String orderId;

    /**
     * 操作人
     */
    @NotNull
    private String operPin;

    public String getSelfPickCode() {
        return selfPickCode;
    }

    public void setSelfPickCode(String selfPickCode) {
        this.selfPickCode = selfPickCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOperPin() {
        return operPin;
    }

    public void setOperPin(String operPin) {
        this.operPin = operPin;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, CheckSelfPickCodeModel> {
        public Builder selfPickCode(String selfPickCode) {
            instance.setSelfPickCode(selfPickCode);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder operPin(String operPin) {
            instance.setOperPin(operPin);
            return this;
        }

        @Override
        public CheckSelfPickCodeModel build() {
            CheckSelfPickCodeModel checkSelfPickCodeModel = super.build();
            checkSelfPickCodeModel.setSelfPickCode(instance.getSelfPickCode());
            checkSelfPickCodeModel.setOrderId(instance.getOrderId());
            checkSelfPickCodeModel.setOperPin(instance.getOperPin());
            return checkSelfPickCodeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
