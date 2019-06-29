package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CancelAndRefundModel extends JDDJBasicModel {
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
     * 操作备注
     */
    @NotNull
    private String operRemark;

    /**
     * 操作时间
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

    public String getOperRemark() {
        return operRemark;
    }

    public void setOperRemark(String operRemark) {
        this.operRemark = operRemark;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, CancelAndRefundModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder operPin(String operPin) {
            instance.setOperPin(operPin);
            return this;
        }

        public Builder operRemark(String operRemark) {
            instance.setOperRemark(operRemark);
            return this;
        }

        public Builder operTime(Date operTime) {
            instance.setOperTime(operTime);
            return this;
        }

        @Override
        public CancelAndRefundModel build() {
            CancelAndRefundModel cancelAndRefundModel = super.build();
            cancelAndRefundModel.setOrderId(instance.getOrderId());
            cancelAndRefundModel.setOperPin(instance.getOperPin());
            cancelAndRefundModel.setOperRemark(instance.getOperRemark());
            cancelAndRefundModel.setOperTime(instance.getOperTime());
            return cancelAndRefundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
