package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class GetCommentByOrderIdModel extends JDDJBasicModel {
    @NotNull
    private Long orderId;

    private String storeId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, GetCommentByOrderIdModel> {
        public Builder storeNo(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder storeId(String storeId) {
            instance.setStoreId(storeId);
            return this;
        }

        @Override
        public GetCommentByOrderIdModel build() {
            GetCommentByOrderIdModel getCommentByOrderIdModel = super.build();
            getCommentByOrderIdModel.setOrderId(instance.getOrderId());
            getCommentByOrderIdModel.setStoreId(instance.getStoreId());
            return getCommentByOrderIdModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
