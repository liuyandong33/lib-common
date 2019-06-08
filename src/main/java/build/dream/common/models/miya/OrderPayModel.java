package build.dream.common.models.miya;

import build.dream.common.constraints.InList;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class OrderPayModel extends MiyaBasicModel {
    @Length(max = 30)
    private String a10;

    @InList(value = {"A", "B"})
    private String a11;

    @NotNull
    @Length(max = 32)
    private String b1;

    @NotNull
    @Length(max = 32)
    private String b2;

    @Length(max = 64)
    private String b3;

    @NotNull
    @Length(max = 12)
    private String b4;

    @Length(max = 2048)
    private String b5;

    @Length(max = 64)
    private String b6;

    @Length(max = 12)
    private String b7;

    @Length(max = 64)
    private String b8;

    @Length(max = 32)
    private String b15;

    public String getA10() {
        return a10;
    }

    public void setA10(String a10) {
        this.a10 = a10;
    }

    public String getA11() {
        return a11;
    }

    public void setA11(String a11) {
        this.a11 = a11;
    }

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

    public String getB6() {
        return b6;
    }

    public void setB6(String b6) {
        this.b6 = b6;
    }

    public String getB7() {
        return b7;
    }

    public void setB7(String b7) {
        this.b7 = b7;
    }

    public String getB8() {
        return b8;
    }

    public void setB8(String b8) {
        this.b8 = b8;
    }

    public String getB15() {
        return b15;
    }

    public void setB15(String b15) {
        this.b15 = b15;
    }

    public static class Builder extends MiyaBasicModel.Builder<Builder, OrderPayModel> {
        public Builder a10(String a10) {
            instance.setA10(a10);
            return this;
        }

        public Builder a11(String a11) {
            instance.setA11(a11);
            return this;
        }

        public Builder b1(String b1) {
            instance.setB1(b1);
            return this;
        }

        public Builder b2(String b2) {
            instance.setB2(b2);
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

        public Builder b6(String b6) {
            instance.setB6(b6);
            return this;
        }

        public Builder b7(String b7) {
            instance.setB7(b7);
            return this;
        }

        public Builder b8(String b8) {
            instance.setB8(b8);
            return this;
        }


        public Builder b15(String b15) {
            instance.setB15(b15);
            return this;
        }

        @Override
        public OrderPayModel build() {
            OrderPayModel orderPayModel = super.build();
            orderPayModel.setA10(instance.getA10());
            orderPayModel.setA11(instance.getA11());
            orderPayModel.setB1(instance.getB1());
            orderPayModel.setB2(instance.getB2());
            orderPayModel.setB3(instance.getB3());
            orderPayModel.setB4(instance.getB4());
            orderPayModel.setB5(instance.getB5());
            orderPayModel.setB6(instance.getB6());
            orderPayModel.setB7(instance.getB7());
            orderPayModel.setB8(instance.getB8());
            orderPayModel.setB15(instance.getB15());
            return orderPayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
