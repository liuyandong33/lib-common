package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class ModifySellerDeliveryModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 操作人
     */
    @NotNull
    private String updatePin;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUpdatePin() {
        return updatePin;
    }

    public void setUpdatePin(String updatePin) {
        this.updatePin = updatePin;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, ModifySellerDeliveryModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder updatePin(String updatePin) {
            instance.setUpdatePin(updatePin);
            return this;
        }

        @Override
        public ModifySellerDeliveryModel build() {
            ModifySellerDeliveryModel modifySellerDeliveryModel = super.build();
            modifySellerDeliveryModel.setOrderId(instance.getOrderId());
            modifySellerDeliveryModel.setUpdatePin(instance.getUpdatePin());
            return modifySellerDeliveryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
