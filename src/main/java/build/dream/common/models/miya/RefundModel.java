package build.dream.common.models.miya;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RefundModel extends MiyaBasicModel {
    /**
     * 原商户订单号，原下单支付商户侧生成的订单号
     */
    @NotNull
    @Length(max = 32)
    private String b1;

    /**
     * 退款单号，商户生成的退款单号，同笔订单内不可重复
     */
    @NotNull
    @Length(max = 32)
    private String b2;

    /**
     * 退款金额，单位分， 1分为1，1元为 100
     */
    @NotNull
    @Length(max = 12)
    private String b4;

    /**
     * 商品信息
     */
    @Length(max = 20480)
    private String b5;

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

    public String getB4() {
        return b4;
    }

    public void setB4(String b4) {
        this.b4 = b4;
    }

    public String getB5() {
        return b5;
    }

    public void setB5(String b5) {
        this.b5 = b5;
    }

    public static class Builder extends MiyaBasicModel.Builder<Builder, RefundModel> {
        public Builder b1(String b1) {
            instance.setB1(b1);
            return this;
        }

        public Builder b2(String b2) {
            instance.setB2(b2);
            return this;
        }

        public Builder b4(String b4) {
            instance.setB4(b4);
            return this;
        }

        public Builder b5(String b5) {
            instance.setB5(b5);
            return this;
        }

        @Override
        public RefundModel build() {
            RefundModel refundModel = super.build();
            refundModel.setB1(instance.getB1());
            refundModel.setB2(instance.getB2());
            refundModel.setB4(instance.getB4());
            refundModel.setB5(instance.getB5());
            return refundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
