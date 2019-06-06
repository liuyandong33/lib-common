package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingVoucherQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 28)
    @JsonProperty(value = "voucher_id")
    private String voucherId;

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingVoucherQueryModel instance = new AlipayMarketingVoucherQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder voucherId(String voucherId) {
            instance.setVoucherId(voucherId);
            return this;
        }

        public AlipayMarketingVoucherQueryModel build() {
            AlipayMarketingVoucherQueryModel alipayMarketingVoucherQueryModel = new AlipayMarketingVoucherQueryModel();
            build(alipayMarketingVoucherQueryModel);
            alipayMarketingVoucherQueryModel.setVoucherId(instance.getVoucherId());
            return alipayMarketingVoucherQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
