package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingToolPrizeSendAuthModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "req_id")
    private String reqId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "prize_id")
    private String prizeId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "user_id")
    private String userId;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class Builder {
        private final KoubeiMarketingToolPrizeSendAuthModel instance = new KoubeiMarketingToolPrizeSendAuthModel();

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

        public Builder reqId(String reqId) {
            instance.setReqId(reqId);
            return this;
        }

        public Builder prizeId(String prizeId) {
            instance.setPrizeId(prizeId);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public KoubeiMarketingToolPrizeSendAuthModel build() {
            KoubeiMarketingToolPrizeSendAuthModel koubeiMarketingToolPrizeSendAuthModel = new KoubeiMarketingToolPrizeSendAuthModel();
            koubeiMarketingToolPrizeSendAuthModel.setTenantId(instance.getTenantId());
            koubeiMarketingToolPrizeSendAuthModel.setBranchId(instance.getBranchId());
            koubeiMarketingToolPrizeSendAuthModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingToolPrizeSendAuthModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingToolPrizeSendAuthModel.setAuthToken(instance.getAuthToken());
            koubeiMarketingToolPrizeSendAuthModel.setReqId(instance.getReqId());
            koubeiMarketingToolPrizeSendAuthModel.setPrizeId(instance.getPrizeId());
            koubeiMarketingToolPrizeSendAuthModel.setUserId(instance.getUserId());
            return koubeiMarketingToolPrizeSendAuthModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
