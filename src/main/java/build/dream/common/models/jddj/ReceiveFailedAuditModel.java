package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class ReceiveFailedAuditModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 是否同意
     */
    @NotNull
    private Boolean isAgreed;

    /**
     * 操作人
     */
    @NotNull
    private String operator;

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

    public static class Builder extends JDDJBasicModel.Builder<Builder, ReceiveFailedAuditModel> {
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
        public ReceiveFailedAuditModel build() {
            ReceiveFailedAuditModel receiveFailedAuditModel = super.build();
            receiveFailedAuditModel.setOrderId(instance.getOrderId());
            receiveFailedAuditModel.setIsAgreed(instance.getIsAgreed());
            receiveFailedAuditModel.setOperator(instance.getOperator());
            receiveFailedAuditModel.setRemark(instance.getRemark());
            return receiveFailedAuditModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
