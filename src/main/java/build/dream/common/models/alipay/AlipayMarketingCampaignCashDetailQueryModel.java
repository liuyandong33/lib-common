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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCampaignCashDetailQueryModel instance = new AlipayMarketingCampaignCashDetailQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder crowdNo(String crowdNo) {
            instance.setCrowdNo(crowdNo);
            return this;
        }

        public AlipayMarketingCampaignCashDetailQueryModel build() {
            AlipayMarketingCampaignCashDetailQueryModel alipayMarketingCampaignCashDetailQueryModel = new AlipayMarketingCampaignCashDetailQueryModel();
            build(alipayMarketingCampaignCashDetailQueryModel);
            alipayMarketingCampaignCashDetailQueryModel.setCrowdNo(instance.getCrowdNo());
            return alipayMarketingCampaignCashDetailQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
