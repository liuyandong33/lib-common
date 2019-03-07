package build.dream.common.models.alipay;

public class AlipayCommerceLotteryTypeListQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayCommerceLotteryTypeListQueryModel instance = new AlipayCommerceLotteryTypeListQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayCommerceLotteryTypeListQueryModel build() {
            AlipayCommerceLotteryTypeListQueryModel alipayCommerceLotteryTypeListQueryModel = new AlipayCommerceLotteryTypeListQueryModel();
            alipayCommerceLotteryTypeListQueryModel.setTenantId(instance.getTenantId());
            alipayCommerceLotteryTypeListQueryModel.setBranchId(instance.getBranchId());
            return alipayCommerceLotteryTypeListQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}