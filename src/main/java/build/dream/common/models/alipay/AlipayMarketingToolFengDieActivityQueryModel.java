package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingToolFengDieActivityQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 11)
    @JsonProperty(value = "activity_id")
    private String activityId;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingToolFengDieActivityQueryModel instance = new AlipayMarketingToolFengDieActivityQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder activityId(String activityId) {
            instance.setActivityId(activityId);
            return this;
        }

        public AlipayMarketingToolFengDieActivityQueryModel build() {
            AlipayMarketingToolFengDieActivityQueryModel alipayMarketingToolFengDieActivityQueryModel = new AlipayMarketingToolFengDieActivityQueryModel();
            build(alipayMarketingToolFengDieActivityQueryModel);
            alipayMarketingToolFengDieActivityQueryModel.setActivityId(instance.getActivityId());
            return alipayMarketingToolFengDieActivityQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
