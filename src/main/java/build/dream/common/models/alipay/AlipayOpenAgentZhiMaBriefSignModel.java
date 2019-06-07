package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAgentZhiMaBriefSignModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 25)
    @JsonProperty(value = "batch_no")
    private String batchNo;

    @NotNull
    @Length(max = 16)
    @JsonProperty(value = "mcc_code")
    private String mccCode;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getMccCode() {
        return mccCode;
    }

    public void setMccCode(String mccCode) {
        this.mccCode = mccCode;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenAgentZhiMaBriefSignModel> {
        public Builder batchNo(String batchNo) {
            instance.setBatchNo(batchNo);
            return this;
        }

        public Builder mccCode(String mccCode) {
            instance.setMccCode(mccCode);
            return this;
        }

        @Override
        public AlipayOpenAgentZhiMaBriefSignModel build() {
            AlipayOpenAgentZhiMaBriefSignModel alipayOpenAgentZhiMaBriefSignModel = super.build();
            alipayOpenAgentZhiMaBriefSignModel.setBatchNo(instance.getBatchNo());
            alipayOpenAgentZhiMaBriefSignModel.setMccCode(instance.getMccCode());
            return alipayOpenAgentZhiMaBriefSignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
