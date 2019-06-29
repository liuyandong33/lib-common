package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DeliveryEndOrderModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 操作人
     */
    @NotNull
    private String operPin;

    /**
     * 操作时间，日期格式的字符串
     */
    @NotNull
    private Date operTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOperPin() {
        return operPin;
    }

    public void setOperPin(String operPin) {
        this.operPin = operPin;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, DeliveryEndOrderModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder operPin(String operPin) {
            instance.setOperPin(operPin);
            return this;
        }

        public Builder operTime(Date operTime) {
            instance.setOperTime(operTime);
            return this;
        }

        @Override
        public DeliveryEndOrderModel build() {
            DeliveryEndOrderModel deliveryEndOrderModel = super.build();
            deliveryEndOrderModel.setOrderId(instance.getOrderId());
            deliveryEndOrderModel.setOperPin(instance.getOperPin());
            deliveryEndOrderModel.setOperTime(instance.getOperTime());
            return deliveryEndOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
