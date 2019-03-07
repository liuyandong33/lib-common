package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingCampaignActivityQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "camp_id")
    private String campId;

    @Length(max = 32)
    @JsonProperty(value = "operator_id")
    private String operatorId;

    @InList(value = {"MER", "MER_OPERATOR", "PROVIDER", "PROVIDER_STAFF"})
    @JsonProperty(value = "operator_type")
    private String operatorType;

    public String getCampId() {
        return campId;
    }

    public void setCampId(String campId) {
        this.campId = campId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public static class Builder {
        private final KoubeiMarketingCampaignActivityQueryModel instance = new KoubeiMarketingCampaignActivityQueryModel();

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

        public Builder campId(String campId) {
            instance.setCampId(campId);
            return this;
        }

        public Builder operatorId(String operatorId) {
            instance.setOperatorId(operatorId);
            return this;
        }

        public Builder operatorType(String operatorType) {
            instance.setOperatorType(operatorType);
            return this;
        }

        public KoubeiMarketingCampaignActivityQueryModel build() {
            KoubeiMarketingCampaignActivityQueryModel koubeiMarketingCampaignActivityQueryModel = new KoubeiMarketingCampaignActivityQueryModel();
            koubeiMarketingCampaignActivityQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingCampaignActivityQueryModel.setBranchId(instance.getBranchId());
            koubeiMarketingCampaignActivityQueryModel.setCampId(instance.getCampId());
            koubeiMarketingCampaignActivityQueryModel.setOperatorId(instance.getOperatorId());
            koubeiMarketingCampaignActivityQueryModel.setOperatorType(instance.getOperatorType());
            return koubeiMarketingCampaignActivityQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
