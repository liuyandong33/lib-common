package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingCampaignCashDetailQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "crowd_no")
    private String crowdNo;

    public String getCrowdNo() {
        return crowdNo;
    }

    public void setCrowdNo(String crowdNo) {
        this.crowdNo = crowdNo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCampaignCashDetailQueryModel> {
        public Builder crowdNo(String crowdNo) {
            instance.setCrowdNo(crowdNo);
            return this;
        }

        @Override
        public AlipayMarketingCampaignCashDetailQueryModel build() {
            AlipayMarketingCampaignCashDetailQueryModel alipayMarketingCampaignCashDetailQueryModel = super.build();
            alipayMarketingCampaignCashDetailQueryModel.setCrowdNo(instance.getCrowdNo());
            return alipayMarketingCampaignCashDetailQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
