package build.dream.common.models.miya;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class OrderQueryModel extends MiyaBasicModel {
    /**
     * 商户订单号，原下单支付商户侧生成的订单号
     */
    @NotNull
    @Length(max = 32)
    private String b1;

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public static class Builder extends MiyaBasicModel.Builder<Builder, OrderQueryModel> {
        public Builder b1(String b1) {
            instance.setB1(b1);
            return this;
        }

        @Override
        public OrderQueryModel build() {
            OrderQueryModel orderQueryModel = super.build();
            orderQueryModel.setB1(instance.getB1());
            return orderQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
