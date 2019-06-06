package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AlipayMarketingToolFengDieTemplateQueryModel extends AlipayBasicModel {
    @Length(max = 10)
    @JsonProperty(value = "page_number")
    private String pageNumber;

    @Length(max = 2)
    @JsonProperty(value = "page_size")
    private String pageSize;

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingToolFengDieTemplateQueryModel instance = new AlipayMarketingToolFengDieTemplateQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder pageNumber(String pageNumber) {
            instance.setPageNumber(pageNumber);
            return this;
        }

        public Builder pageSize(String pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public AlipayMarketingToolFengDieTemplateQueryModel build() {
            AlipayMarketingToolFengDieTemplateQueryModel alipayMarketingToolFengDieTemplateQueryModel = new AlipayMarketingToolFengDieTemplateQueryModel();
            build(alipayMarketingToolFengDieTemplateQueryModel);
            alipayMarketingToolFengDieTemplateQueryModel.setPageNumber(instance.getPageNumber());
            alipayMarketingToolFengDieTemplateQueryModel.setPageSize(instance.getPageSize());
            return alipayMarketingToolFengDieTemplateQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
