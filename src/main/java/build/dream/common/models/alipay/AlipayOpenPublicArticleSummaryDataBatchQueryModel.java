package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicArticleSummaryDataBatchQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(min = 8, max = 8)
    @JsonProperty(value = "begin_date")
    private String beginDate;

    @NotNull
    @Length(min = 8, max = 8)
    @JsonProperty(value = "end_date")
    private String endDate;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicArticleSummaryDataBatchQueryModel> {
        public Builder beginDate(String beginDate) {
            instance.setBeginDate(beginDate);
            return this;
        }

        public Builder endDate(String endDate) {
            instance.setEndDate(endDate);
            return this;
        }

        @Override
        public AlipayOpenPublicArticleSummaryDataBatchQueryModel build() {
            AlipayOpenPublicArticleSummaryDataBatchQueryModel alipayOpenPublicArticleSummaryDataBatchQueryModel = super.build();
            alipayOpenPublicArticleSummaryDataBatchQueryModel.setBeginDate(instance.getBeginDate());
            alipayOpenPublicArticleSummaryDataBatchQueryModel.setEndDate(instance.getEndDate());
            return alipayOpenPublicArticleSummaryDataBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
