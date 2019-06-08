package build.dream.common.models.miya;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CancelOrderModel extends MiyaBasicModel {
    @NotNull
    @Length(max = 32)
    private String b1;

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public static class Builder extends MiyaBasicModel.Builder<Builder, CancelOrderModel> {
        public Builder b1(String b1) {
            instance.setB1(b1);
            return this;
        }

        @Override
        public CancelOrderModel build() {
            CancelOrderModel cancelOrderModel = super.build();
            cancelOrderModel.setB1(instance.getB1());
            return cancelOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
