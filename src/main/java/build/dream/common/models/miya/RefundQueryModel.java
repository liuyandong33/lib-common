package build.dream.common.models.miya;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RefundQueryModel extends MiyaBasicModel {
    /**
     * 原商户订单号，原下单支付商户侧生成的订单号
     */
    @NotNull
    @Length(max = 32)
    private String b1;

    /**
     * 退款单号，原商户侧生成的退款订单号
     */
    @NotNull
    @Length(max = 32)
    private String b2;

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public static class Builder extends MiyaBasicModel.Builder<Builder, RefundQueryModel> {
        public Builder b1(String b1) {
            instance.setB1(b1);
            return this;
        }

        public Builder b2(String b2) {
            instance.setB2(b2);
            return this;
        }

        @Override
        public RefundQueryModel build() {
            RefundQueryModel refundQueryModel = super.build();
            refundQueryModel.setB1(instance.getB1());
            refundQueryModel.setB2(instance.getB2());
            return refundQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
