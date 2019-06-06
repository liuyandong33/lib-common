package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AlipayMarketingVoucherTemplateListQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(min = 19, max = 19)
    @JsonProperty(value = "create_start_time")
    private String createStartTime;

    @NotNull
    @Length(min = 19, max = 19)
    @JsonProperty(value = "create_end_time")
    private String createEndTime;

    @NotNull
    @Min(value = 1)
    @Max(value = 9999999999L)
    private Long pageNum;

    @NotNull
    @Min(value = 1)
    @Max(value = 30)
    @JsonProperty(value = "page_size")
    private Integer pageSize;

    public String getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(String createStartTime) {
        this.createStartTime = createStartTime;
    }

    public String getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(String createEndTime) {
        this.createEndTime = createEndTime;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingVoucherTemplateListQueryModel instance = new AlipayMarketingVoucherTemplateListQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder createStartTime(String createStartTime) {
            instance.setCreateStartTime(createStartTime);
            return this;
        }

        public Builder createEndTime(String createEndTime) {
            instance.setCreateEndTime(createEndTime);
            return this;
        }

        public Builder pageNum(Long pageNum) {
            instance.setPageNum(pageNum);
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public AlipayMarketingVoucherTemplateListQueryModel build() {
            AlipayMarketingVoucherTemplateListQueryModel alipayMarketingVoucherTemplateListQueryModel = new AlipayMarketingVoucherTemplateListQueryModel();
            build(alipayMarketingVoucherTemplateListQueryModel);
            alipayMarketingVoucherTemplateListQueryModel.setCreateStartTime(instance.getCreateStartTime());
            alipayMarketingVoucherTemplateListQueryModel.setCreateEndTime(instance.getCreateEndTime());
            alipayMarketingVoucherTemplateListQueryModel.setPageNum(instance.getPageNum());
            alipayMarketingVoucherTemplateListQueryModel.setPageSize(instance.getPageSize());
            return alipayMarketingVoucherTemplateListQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
