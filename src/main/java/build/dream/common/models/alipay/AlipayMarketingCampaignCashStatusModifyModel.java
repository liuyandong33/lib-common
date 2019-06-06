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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCampaignCashStatusModifyModel instance = new AlipayMarketingCampaignCashStatusModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
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
            build(alipayMarketingCampaignCashStatusModifyModel);
            alipayMarketingCampaignCashStatusModifyModel.setCrowdNo(instance.getCrowdNo());
            alipayMarketingCampaignCashStatusModifyModel.setCampStatus(instance.getCampStatus());
            return alipayMarketingCampaignCashStatusModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
