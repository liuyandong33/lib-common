package build.dream.common.models.alipay;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingUseRulePidQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 16)
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingUseRulePidQueryModel instance = new AlipayMarketingUseRulePidQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder pid(String pid) {
            instance.setPid(pid);
            return this;
        }

        public AlipayMarketingUseRulePidQueryModel build() {
            AlipayMarketingUseRulePidQueryModel alipayMarketingUseRulePidQueryModel = new AlipayMarketingUseRulePidQueryModel();
            build(alipayMarketingUseRulePidQueryModel);
            alipayMarketingUseRulePidQueryModel.setPid(instance.getPid());
            return alipayMarketingUseRulePidQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
