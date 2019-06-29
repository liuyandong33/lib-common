package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class PrintOrderModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, PrintOrderModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        @Override
        public PrintOrderModel build() {
            PrintOrderModel printOrderModel = super.build();
            printOrderModel.setOrderId(instance.getOrderId());
            return printOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
