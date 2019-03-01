package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicPersonalizedExtensionDeleteModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "extension_key")
    private String extensionKey;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getExtensionKey() {
        return extensionKey;
    }

    public void setExtensionKey(String extensionKey) {
        this.extensionKey = extensionKey;
    }

    public static class Builder {
        private final AlipayOpenPublicPersonalizedExtensionDeleteModel instance = new AlipayOpenPublicPersonalizedExtensionDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder extensionKey(String extensionKey) {
            instance.setExtensionKey(extensionKey);
            return this;
        }

        public AlipayOpenPublicPersonalizedExtensionDeleteModel build() {
            AlipayOpenPublicPersonalizedExtensionDeleteModel alipayOpenPublicPersonalizedExtensionDeleteModel = new AlipayOpenPublicPersonalizedExtensionDeleteModel();
            alipayOpenPublicPersonalizedExtensionDeleteModel.setTenantId(instance.getTenantId());
            alipayOpenPublicPersonalizedExtensionDeleteModel.setBranchId(instance.getBranchId());
            alipayOpenPublicPersonalizedExtensionDeleteModel.setExtensionKey(instance.getExtensionKey());
            return alipayOpenPublicPersonalizedExtensionDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}