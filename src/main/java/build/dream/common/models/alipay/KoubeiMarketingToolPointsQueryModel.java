package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingToolPointsQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "activity_account")
    private String activityAccount;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "user_id")
    private String userId;

    public String getActivityAccount() {
        return activityAccount;
    }

    public void setActivityAccount(String activityAccount) {
        this.activityAccount = activityAccount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiMarketingToolPointsQueryModel instance = new KoubeiMarketingToolPointsQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder activityAccount(String activityAccount) {
            instance.setActivityAccount(activityAccount);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public KoubeiMarketingToolPointsQueryModel build() {
            KoubeiMarketingToolPointsQueryModel koubeiMarketingToolPointsQueryModel = new KoubeiMarketingToolPointsQueryModel();
            build(koubeiMarketingToolPointsQueryModel);
            koubeiMarketingToolPointsQueryModel.setActivityAccount(instance.getActivityAccount());
            koubeiMarketingToolPointsQueryModel.setUserId(instance.getUserId());
            return koubeiMarketingToolPointsQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
