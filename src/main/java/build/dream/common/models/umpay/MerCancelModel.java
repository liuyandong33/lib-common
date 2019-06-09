package build.dream.common.models.umpay;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class MerCancelModel extends UmPayBasicModel {
    /**
     * 商户订单号
     */
    @NotNull
    @Length(max = 32)
    private String orderId;

    /**
     * 原商户订单日期
     */
    @NotNull
    @Length(min = 8, max = 8)
    private String merDate;

    /**
     * 订单金额 如果是人民币，则以分为单位
     */
    @NotNull
    private Integer amount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMerDate() {
        return merDate;
    }

    public void setMerDate(String merDate) {
        this.merDate = merDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public static class Builder extends UmPayBasicModel.Builder<Builder, MerCancelModel> {
        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder merDate(String merDate) {
            instance.setMerDate(merDate);
            return this;
        }

        public Builder amount(Integer amount) {
            instance.setAmount(amount);
            return this;
        }

        @Override
        public MerCancelModel build() {
            MerCancelModel merCancelModel = super.build();
            merCancelModel.setOrderId(instance.getOrderId());
            merCancelModel.setMerDate(instance.getMerDate());
            merCancelModel.setAmount(instance.getAmount());
            return merCancelModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
