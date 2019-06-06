package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAgentCancelModel extends AlipayBasicModel {
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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenAgentCancelModel instance = new AlipayOpenAgentCancelModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder batchNo(String batchNo) {
            instance.setBatchNo(batchNo);
            return this;
        }

        public AlipayOpenAgentCancelModel build() {
            AlipayOpenAgentCancelModel alipayOpenAgentCancelModel = new AlipayOpenAgentCancelModel();
            build(alipayOpenAgentCancelModel);
            alipayOpenAgentCancelModel.setBatchNo(instance.getBatchNo());
            return alipayOpenAgentCancelModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
