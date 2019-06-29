package build.dream.common.models.jddj;

import build.dream.common.utils.ApplicationHandler;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.NotNull;

public class OrderCancelOperateModel extends JDDJBasicModel {
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

    /**
     * 取消备注
     */
    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean validate() {
        if (!super.validate()) {
            return false;
        }

        if (!isAgreed && StringUtils.isBlank(remark)) {
            return false;
        }

        return true;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if (!isAgreed) {
            ApplicationHandler.notBlank(remark, "remark");
        }
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, OrderCancelOperateModel> {
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

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        @Override
        public OrderCancelOperateModel build() {
            OrderCancelOperateModel orderCancelOperateModel = super.build();
            orderCancelOperateModel.setOrderId(instance.getOrderId());
            orderCancelOperateModel.setIsAgreed(instance.getIsAgreed());
            orderCancelOperateModel.setOperator(instance.getOperator());
            orderCancelOperateModel.setRemark(instance.getRemark());
            return orderCancelOperateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
