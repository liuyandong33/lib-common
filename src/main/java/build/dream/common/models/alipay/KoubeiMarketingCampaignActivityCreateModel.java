package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingCampaignActivityCreateModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchId() {
        return branchId;
    }

    public static class Builder {
        private final KoubeiMarketingCampaignActivityCreateModel instance = new KoubeiMarketingCampaignActivityCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public KoubeiMarketingCampaignActivityCreateModel build() {
            KoubeiMarketingCampaignActivityCreateModel koubeiMarketingCampaignActivityCreateModel = new KoubeiMarketingCampaignActivityCreateModel();
            koubeiMarketingCampaignActivityCreateModel.setTenantId(instance.getTenantId());
            koubeiMarketingCampaignActivityCreateModel.setBranchId(instance.getBranchId());
            return koubeiMarketingCampaignActivityCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
