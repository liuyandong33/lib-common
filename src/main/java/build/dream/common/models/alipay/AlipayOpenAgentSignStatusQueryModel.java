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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenAgentSignStatusQueryModel instance = new AlipayOpenAgentSignStatusQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder productCodes(List<String> productCodes) {
            instance.setProductCodes(productCodes);
            return this;
        }

        public AlipayOpenAgentSignStatusQueryModel build() {
            AlipayOpenAgentSignStatusQueryModel alipayOpenAgentSignStatusQueryModel = new AlipayOpenAgentSignStatusQueryModel();
            build(alipayOpenAgentSignStatusQueryModel);
            alipayOpenAgentSignStatusQueryModel.setProductCodes(instance.getProductCodes());
            return alipayOpenAgentSignStatusQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
