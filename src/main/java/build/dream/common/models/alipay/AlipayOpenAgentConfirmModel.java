package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAgentConfirmModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 25)
    @JsonProperty(value = "batch_no")
    private String batchNo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenAgentConfirmModel> {
        public Builder batchNo(String batchNo) {
            instance.setBatchNo(batchNo);
            return this;
        }

        @Override
        public AlipayOpenAgentConfirmModel build() {
            AlipayOpenAgentConfirmModel alipayOpenAgentConfirmModel = super.build();
            alipayOpenAgentConfirmModel.setBatchNo(instance.getBatchNo());
            return alipayOpenAgentConfirmModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
