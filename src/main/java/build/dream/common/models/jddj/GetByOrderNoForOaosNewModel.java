package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class GetByOrderNoForOaosNewModel extends JDDJBasicModel {
    @NotNull
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, GetByOrderNoForOaosNewModel> {
        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        @Override
        public GetByOrderNoForOaosNewModel build() {
            GetByOrderNoForOaosNewModel getByOrderNoForOaosNewModel = super.build();
            getByOrderNoForOaosNewModel.setOrderId(instance.getOrderId());
            return getByOrderNoForOaosNewModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
