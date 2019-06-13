package build.dream.common.models.miya;

import build.dream.common.constraints.InList;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CreateOrderModel extends MiyaBasicModel {
    /**
     * 支付方式， JSAPI、APP、H5、WXA(小程序)
     */
    @NotNull
    @InList(value = {"JSAPI", "APP", "H5", "WXA"})
    private String a11;

    /**
     * 支付渠道，1-微信 3-支付宝
     */
    @NotNull
    @InList(value = {"1", "3"})
    private String a12;

    /**
     * 商户订单号，商户侧生成的订单号，不可重复
     */
    @NotNull
    @Length(max = 32)
    private String b1;

    /**
     * 手机小票标题，顾客手机小票显示的标题
     */
    @NotNull
    @Length(max = 64)
    private String b3;

    /**
     * 金额，单位分，1分为1，1元为 100
     */
    @NotNull
    @Length(max = 12)
    private String b4;

    /**
     * 商品信息
     */
    @Length(max = 20480)
    private String b5;

    /**
     * 微信 openid 或支付宝 userid。支付宝必填，微信 openid 和 sub_openid 不能同时为空，JSAPI、WXA 必传
     */
    @Length(max = 64)
    private String b11;

    /**
     * 微信 sub_openid, JSAPI、WXA 必传
     */
    @Length(max = 100)
    private String b12;

    /**
     * 通知地址，接收异步通知回调地址
     */
    @NotNull
    @Length(max = 100)
    private String b13;

    /**
     * 用户ip，用户终端 ip。微信 H5、APP支付必填
     */
    @Length(max = 100)
    private String b14;

    /**
     * 商户微信 APPID
     */
    @Length(max = 32)
    private String b16;

    /**
     * 订单开始时间，格式 yyyy-MM-dd HH:mm:ss
     */
    @Length(max = 20)
    private String b17;

    /**
     * 订单过期时间，格式 yyyy-MM-dd HH:mm:ss
     */
    @Length(max = 20)
    private String b18;

    public String getA11() {
        return a11;
    }

    public void setA11(String a11) {
        this.a11 = a11;
    }

    public String getA12() {
        return a12;
    }

    public void setA12(String a12) {
        this.a12 = a12;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
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

    public String getB11() {
        return b11;
    }

    public void setB11(String b11) {
        this.b11 = b11;
    }

    public String getB12() {
        return b12;
    }

    public void setB12(String b12) {
        this.b12 = b12;
    }

    public String getB13() {
        return b13;
    }

    public void setB13(String b13) {
        this.b13 = b13;
    }

    public String getB14() {
        return b14;
    }

    public void setB14(String b14) {
        this.b14 = b14;
    }

    public String getB16() {
        return b16;
    }

    public void setB16(String b16) {
        this.b16 = b16;
    }

    public String getB17() {
        return b17;
    }

    public void setB17(String b17) {
        this.b17 = b17;
    }

    public String getB18() {
        return b18;
    }

    public void setB18(String b18) {
        this.b18 = b18;
    }

    public static class Builder extends MiyaBasicModel.Builder<Builder, CreateOrderModel> {
        public Builder a11(String a11) {
            instance.setA11(a11);
            return this;
        }

        public Builder a12(String a12) {
            instance.setA12(a12);
            return this;
        }

        public Builder b1(String b1) {
            instance.setB1(b1);
            return this;
        }

        public Builder b3(String b3) {
            instance.setB3(b3);
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

        public Builder b11(String b11) {
            instance.setB11(b11);
            return this;
        }

        public Builder b12(String b12) {
            instance.setB12(b12);
            return this;
        }

        public Builder b13(String b13) {
            instance.setB13(b13);
            return this;
        }

        public Builder b14(String b14) {
            instance.setB14(b14);
            return this;
        }

        public Builder b16(String b16) {
            instance.setB16(b16);
            return this;
        }

        public Builder b17(String b17) {
            instance.setB17(b17);
            return this;
        }

        public Builder b18(String b18) {
            instance.setB18(b18);
            return this;
        }

        public CreateOrderModel build() {
            CreateOrderModel createOrderModel = super.build();
            createOrderModel.setA11(instance.getA11());
            createOrderModel.setA12(instance.getA12());
            createOrderModel.setB1(instance.getB1());
            createOrderModel.setB3(instance.getB3());
            createOrderModel.setB4(instance.getB4());
            createOrderModel.setB5(instance.getB5());
            createOrderModel.setB11(instance.getB11());
            createOrderModel.setB12(instance.getB12());
            createOrderModel.setB13(instance.getB13());
            createOrderModel.setB14(instance.getB14());
            createOrderModel.setB16(instance.getB16());
            createOrderModel.setB17(instance.getB17());
            createOrderModel.setB18(instance.getB18());
            return createOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
