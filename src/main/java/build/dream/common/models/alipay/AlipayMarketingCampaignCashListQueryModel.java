package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AlipayMarketingCampaignCashListQueryModel extends AlipayBasicModel {
    @InList(value = {"ALL", "CREATED", "PAID", "READY", "PAUSE", "CLOSED", "SETTLE"})
    @JsonProperty(value = "camp_status")
    private String campStatus;

    @NotNull
    @Min(value = 1)
    @Max(value = 50)
    @JsonProperty(value = "page_size")
    private Integer pageSize;

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "page_index")
    private Integer pageIndex;

    public String getCampStatus() {
        return campStatus;
    }

    public void setCampStatus(String campStatus) {
        this.campStatus = campStatus;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCampaignCashListQueryModel instance = new AlipayMarketingCampaignCashListQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder campStatus(String campStatus) {
            instance.setCampStatus(campStatus);
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public Builder pageIndex(Integer pageIndex) {
            instance.setPageIndex(pageIndex);
            return this;
        }

        public AlipayMarketingCampaignCashListQueryModel build() {
            AlipayMarketingCampaignCashListQueryModel alipayMarketingCampaignCashListQueryModel = new AlipayMarketingCampaignCashListQueryModel();
            build(alipayMarketingCampaignCashListQueryModel);
            alipayMarketingCampaignCashListQueryModel.setCampStatus(instance.getCampStatus());
            alipayMarketingCampaignCashListQueryModel.setPageSize(instance.getPageSize());
            alipayMarketingCampaignCashListQueryModel.setPageIndex(instance.getPageIndex());
            return alipayMarketingCampaignCashListQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
