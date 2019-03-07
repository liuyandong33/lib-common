package build.dream.common.models.alipay;

public class AlipayOpenPublicTemplateMessageGetModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicTemplateMessageGetModel instance = new AlipayOpenPublicTemplateMessageGetModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicTemplateMessageGetModel build() {
            AlipayOpenPublicTemplateMessageGetModel alipayOpenPublicTemplateMessageGetModel = new AlipayOpenPublicTemplateMessageGetModel();
            alipayOpenPublicTemplateMessageGetModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTemplateMessageGetModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicTemplateMessageGetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
