package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class AlipayPromoRuleCenterRuleAnalyzeModel extends AlipayBasicModel {
    @NotNull
    @JsonProperty(value = "user_id")
    private String userId;

    @NotNull
    @JsonProperty(value = "rule_uuid")
    private String ruleUuid;

    @JsonProperty(value = "biz_id")
    private String bizId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRuleUuid() {
        return ruleUuid;
    }

    public void setRuleUuid(String ruleUuid) {
        this.ruleUuid = ruleUuid;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayPromoRuleCenterRuleAnalyzeModel> {
        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder ruleUuid(String ruleUuid) {
            instance.setRuleUuid(ruleUuid);
            return this;
        }

        public Builder bizId(String bizId) {
            instance.setBizId(bizId);
            return this;
        }

        @Override
        public AlipayPromoRuleCenterRuleAnalyzeModel build() {
            AlipayPromoRuleCenterRuleAnalyzeModel alipayPromoRuleCenterRuleAnalyzeModel = super.build();
            alipayPromoRuleCenterRuleAnalyzeModel.setUserId(instance.getUserId());
            alipayPromoRuleCenterRuleAnalyzeModel.setRuleUuid(instance.getRuleUuid());
            alipayPromoRuleCenterRuleAnalyzeModel.setBizId(instance.getBizId());
            return alipayPromoRuleCenterRuleAnalyzeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
