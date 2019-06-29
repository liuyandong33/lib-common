package build.dream.common.models.jddj;

public class GetByOrderNoForOaosModel extends JDDJBasicModel {
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, GetByOrderNoForOaosModel> {
        public Builder orderNo(String orderNo) {
            instance.setOrderNo(orderNo);
            return this;
        }

        @Override
        public GetByOrderNoForOaosModel build() {
            GetByOrderNoForOaosModel getByOrderNoForOaosModel = super.build();
            getByOrderNoForOaosModel.setOrderNo(instance.getOrderNo());
            return getByOrderNoForOaosModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
