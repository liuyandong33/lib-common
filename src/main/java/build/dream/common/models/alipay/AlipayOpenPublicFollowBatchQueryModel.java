package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AlipayOpenPublicFollowBatchQueryModel extends AlipayBasicModel {
    @Length(max = 32)
    @JsonProperty(value = "next_user_id")
    private String nextUserId;

    public String getNextUserId() {
        return nextUserId;
    }

    public void setNextUserId(String nextUserId) {
        this.nextUserId = nextUserId;
    }

    public static class Builder {
        private final AlipayOpenPublicFollowBatchQueryModel instance = new AlipayOpenPublicFollowBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder nextUserId(String nextUserId) {
            instance.setNextUserId(nextUserId);
            return this;
        }

        public AlipayOpenPublicFollowBatchQueryModel build() {
            AlipayOpenPublicFollowBatchQueryModel copy = new AlipayOpenPublicFollowBatchQueryModel();
            copy.setTenantId(instance.getTenantId());
            copy.setBranchId(instance.getBranchId());
            copy.setNextUserId(instance.getNextUserId());
            return copy;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}