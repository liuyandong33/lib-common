package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicTopicDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "topic_id")
    private String topicId;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public static class Builder {
        private final AlipayOpenPublicTopicDeleteModel instance = new AlipayOpenPublicTopicDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder topicId(String topicId) {
            instance.setTopicId(topicId);
            return this;
        }

        public AlipayOpenPublicTopicDeleteModel build() {
            AlipayOpenPublicTopicDeleteModel alipayOpenPublicTopicDeleteModel = new AlipayOpenPublicTopicDeleteModel();
            alipayOpenPublicTopicDeleteModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTopicDeleteModel.setBranchId(instance.getBranchId());
            alipayOpenPublicTopicDeleteModel.setTopicId(instance.getTopicId());
            return alipayOpenPublicTopicDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
