package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenAgentSignStatusQueryModel extends BasicModel {
    @NotNull
    private String tenantId;

    @NotNull
    private String branchId;

    @NotEmpty
    private List<String> productCodes;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchId() {
        return branchId;
    }

    public List<String> getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(List<String> productCodes) {
        this.productCodes = productCodes;
    }

    public static class Builder {
        private final AlipayOpenAgentSignStatusQueryModel instance = new AlipayOpenAgentSignStatusQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder productCodes(List<String> productCodes) {
            instance.setProductCodes(productCodes);
            return this;
        }

        public AlipayOpenAgentSignStatusQueryModel build() {
            AlipayOpenAgentSignStatusQueryModel alipayOpenAgentSignStatusQueryModel = new AlipayOpenAgentSignStatusQueryModel();
            alipayOpenAgentSignStatusQueryModel.setTenantId(instance.getTenantId());
            alipayOpenAgentSignStatusQueryModel.setBranchId(instance.getBranchId());
            alipayOpenAgentSignStatusQueryModel.setProductCodes(instance.getProductCodes());
            return alipayOpenAgentSignStatusQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
