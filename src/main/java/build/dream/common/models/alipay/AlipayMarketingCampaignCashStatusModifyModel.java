package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingCampaignCashStatusModifyModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "crowd_no")
    private String crowdNo;

    @NotNull
    @InList(value = {"PAUSE", "READY", "CLOSED"})
    @JsonProperty(value = "camp_status")
    private String campStatus;

    public String getCrowdNo() {
        return crowdNo;
    }

    public void setCrowdNo(String crowdNo) {
        this.crowdNo = crowdNo;
    }

    public String getCampStatus() {
        return campStatus;
    }

    public void setCampStatus(String campStatus) {
        this.campStatus = campStatus;
    }

    public static class Builder {
        private final AlipayMarketingCampaignCashStatusModifyModel instance = new AlipayMarketingCampaignCashStatusModifyModel();

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

        public Builder crowdNo(String crowdNo) {
            instance.setCrowdNo(crowdNo);
            return this;
        }

        public Builder campStatus(String campStatus) {
            instance.setCampStatus(campStatus);
            return this;
        }

        public AlipayMarketingCampaignCashStatusModifyModel build() {
            AlipayMarketingCampaignCashStatusModifyModel alipayMarketingCampaignCashStatusModifyModel = new AlipayMarketingCampaignCashStatusModifyModel();
            alipayMarketingCampaignCashStatusModifyModel.setTenantId(instance.getTenantId());
            alipayMarketingCampaignCashStatusModifyModel.setBranchId(instance.getBranchId());
            alipayMarketingCampaignCashStatusModifyModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingCampaignCashStatusModifyModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingCampaignCashStatusModifyModel.setAuthToken(instance.getAuthToken());
            alipayMarketingCampaignCashStatusModifyModel.setCrowdNo(instance.getCrowdNo());
            alipayMarketingCampaignCashStatusModifyModel.setCampStatus(instance.getCampStatus());
            return alipayMarketingCampaignCashStatusModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
