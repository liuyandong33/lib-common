package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicUserFollowQueryModel extends AlipayBasicModel {
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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicUserFollowQueryModel instance = new AlipayOpenPublicUserFollowQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public AlipayOpenPublicUserFollowQueryModel build() {
            AlipayOpenPublicUserFollowQueryModel alipayOpenPublicUserFollowQueryModel = new AlipayOpenPublicUserFollowQueryModel();
            build(alipayOpenPublicUserFollowQueryModel);
            alipayOpenPublicUserFollowQueryModel.setUserId(instance.getUserId());
            return alipayOpenPublicUserFollowQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
