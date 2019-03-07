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

    public static class Builder {
        private final AlipayPromoRuleCenterRuleAnalyzeModel instance = new AlipayPromoRuleCenterRuleAnalyzeModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

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

        public AlipayPromoRuleCenterRuleAnalyzeModel build() {
            AlipayPromoRuleCenterRuleAnalyzeModel alipayPromoRuleCenterRuleAnalyzeModel = new AlipayPromoRuleCenterRuleAnalyzeModel();
            alipayPromoRuleCenterRuleAnalyzeModel.setTenantId(instance.getTenantId());
            alipayPromoRuleCenterRuleAnalyzeModel.setBranchId(instance.getBranchId());
            alipayPromoRuleCenterRuleAnalyzeModel.setReturnUrl(instance.getReturnUrl());
            alipayPromoRuleCenterRuleAnalyzeModel.setNotifyUrl(instance.getNotifyUrl());
            alipayPromoRuleCenterRuleAnalyzeModel.setAuthToken(instance.getAuthToken());
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
