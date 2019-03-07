package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicAccountQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "user_id")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class Builder {
        private final AlipayOpenPublicAccountQueryModel instance = new AlipayOpenPublicAccountQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public AlipayOpenPublicAccountQueryModel build() {
            AlipayOpenPublicAccountQueryModel alipayOpenPublicAccountQueryModel = new AlipayOpenPublicAccountQueryModel();
            alipayOpenPublicAccountQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicAccountQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicAccountQueryModel.setUserId(instance.getUserId());
            return alipayOpenPublicAccountQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
