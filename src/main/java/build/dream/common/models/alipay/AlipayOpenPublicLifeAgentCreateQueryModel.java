package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeAgentCreateQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicLifeAgentCreateQueryModel> {
        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        @Override
        public AlipayOpenPublicLifeAgentCreateQueryModel build() {
            AlipayOpenPublicLifeAgentCreateQueryModel alipayOpenPublicLifeAgentCreateQueryModel = super.build();
            alipayOpenPublicLifeAgentCreateQueryModel.setOutBizNo(instance.getOutBizNo());
            return alipayOpenPublicLifeAgentCreateQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
