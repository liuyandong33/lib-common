package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingVoucherStockUseModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "entity_no")
    private String entityNo;

    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    public String getEntityNo() {
        return entityNo;
    }

    public void setEntityNo(String entityNo) {
        this.entityNo = entityNo;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingVoucherStockUseModel> {
        public Builder entityNo(String entityNo) {
            instance.setEntityNo(entityNo);
            return this;
        }

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        @Override
        public AlipayMarketingVoucherStockUseModel build() {
            AlipayMarketingVoucherStockUseModel alipayMarketingVoucherStockUseModel = super.build();
            alipayMarketingVoucherStockUseModel.setEntityNo(instance.getEntityNo());
            alipayMarketingVoucherStockUseModel.setOutBizNo(instance.getOutBizNo());
            return alipayMarketingVoucherStockUseModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
