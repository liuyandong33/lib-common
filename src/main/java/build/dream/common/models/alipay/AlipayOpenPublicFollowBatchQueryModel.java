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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicFollowBatchQueryModel instance = new AlipayOpenPublicFollowBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder nextUserId(String nextUserId) {
            instance.setNextUserId(nextUserId);
            return this;
        }

        public AlipayOpenPublicFollowBatchQueryModel build() {
            AlipayOpenPublicFollowBatchQueryModel alipayOpenPublicFollowBatchQueryModel = new AlipayOpenPublicFollowBatchQueryModel();
            build(alipayOpenPublicFollowBatchQueryModel);
            alipayOpenPublicFollowBatchQueryModel.setNextUserId(instance.getNextUserId());
            return alipayOpenPublicFollowBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}