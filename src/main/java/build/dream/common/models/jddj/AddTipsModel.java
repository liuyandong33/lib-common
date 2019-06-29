package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class AddTipsModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 小费金额,单位分
     */
    @NotNull
    private Integer tips;

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

    public Integer getTips() {
        return tips;
    }

    public void setTips(Integer tips) {
        this.tips = tips;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, AddTipsModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder tips(Integer tips) {
            instance.setTips(tips);
            return this;
        }

        public Builder operator(String operator) {
            instance.setOperator(operator);
            return this;
        }

        @Override
        public AddTipsModel build() {
            AddTipsModel addTipsModel = super.build();
            addTipsModel.setOrderId(instance.getOrderId());
            addTipsModel.setTips(instance.getTips());
            addTipsModel.setOperator(instance.getOperator());
            return addTipsModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
