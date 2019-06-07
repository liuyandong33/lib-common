package build.dream.common.models.alipay;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class AlipayOpenAgentSignStatusQueryModel extends AlipayBasicModel {
    @NotEmpty
    private List<String> productCodes;

    public List<String> getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(List<String> productCodes) {
        this.productCodes = productCodes;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenAgentSignStatusQueryModel> {
        public Builder productCodes(List<String> productCodes) {
            instance.setProductCodes(productCodes);
            return this;
        }

        @Override
        public AlipayOpenAgentSignStatusQueryModel build() {
            AlipayOpenAgentSignStatusQueryModel alipayOpenAgentSignStatusQueryModel = super.build();
            alipayOpenAgentSignStatusQueryModel.setProductCodes(instance.getProductCodes());
            return alipayOpenAgentSignStatusQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
