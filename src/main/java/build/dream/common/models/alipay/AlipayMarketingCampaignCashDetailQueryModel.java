package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingCampaignCashDetailQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "crowd_no")
    private String crowdNo;

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

    public String getCrowdNo() {
        return crowdNo;
    }

    public void setCrowdNo(String crowdNo) {
        this.crowdNo = crowdNo;
    }

    public static class Builder {
        private final AlipayMarketingCampaignCashDetailQueryModel instance = new AlipayMarketingCampaignCashDetailQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder crowdNo(String crowdNo) {
            instance.setCrowdNo(crowdNo);
            return this;
        }

        public AlipayMarketingCampaignCashDetailQueryModel build() {
            AlipayMarketingCampaignCashDetailQueryModel alipayMarketingCampaignCashDetailQueryModel = new AlipayMarketingCampaignCashDetailQueryModel();
            alipayMarketingCampaignCashDetailQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingCampaignCashDetailQueryModel.setBranchId(instance.getBranchId());
            alipayMarketingCampaignCashDetailQueryModel.setCrowdNo(instance.getCrowdNo());
            return alipayMarketingCampaignCashDetailQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
