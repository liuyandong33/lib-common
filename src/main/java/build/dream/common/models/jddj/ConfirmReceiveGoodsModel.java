package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ConfirmReceiveGoodsModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 操作时间
     */
    @NotNull
    private Date operateTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, ConfirmReceiveGoodsModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder operateTime(Date operateTime) {
            instance.setOperateTime(operateTime);
            return this;
        }

        @Override
        public ConfirmReceiveGoodsModel build() {
            ConfirmReceiveGoodsModel confirmReceiveGoodsModel = super.build();
            confirmReceiveGoodsModel.setOrderId(instance.getOrderId());
            confirmReceiveGoodsModel.setOperateTime(instance.getOperateTime());
            return confirmReceiveGoodsModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
