package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class UrgeDispatchingModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 操作时间
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

    public static class Builder extends JDDJBasicModel.Builder<Builder, UrgeDispatchingModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder updatePin(String updatePin) {
            instance.setUpdatePin(updatePin);
            return this;
        }

        @Override
        public UrgeDispatchingModel build() {
            UrgeDispatchingModel urgeDispatchingModel = super.build();
            urgeDispatchingModel.setOrderId(instance.getOrderId());
            urgeDispatchingModel.setUpdatePin(instance.getUpdatePin());
            return urgeDispatchingModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
