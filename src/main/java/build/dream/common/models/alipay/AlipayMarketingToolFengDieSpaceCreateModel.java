package build.dream.common.models.alipay;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingToolFengDieSpaceCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 100)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingToolFengDieSpaceCreateModel instance = new AlipayMarketingToolFengDieSpaceCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder title(String title) {
            instance.setTitle(title);
            return this;
        }

        public AlipayMarketingToolFengDieSpaceCreateModel build() {
            AlipayMarketingToolFengDieSpaceCreateModel alipayMarketingToolFengDieSpaceCreateModel = new AlipayMarketingToolFengDieSpaceCreateModel();
            build(alipayMarketingToolFengDieSpaceCreateModel);
            alipayMarketingToolFengDieSpaceCreateModel.setTitle(instance.getTitle());
            return alipayMarketingToolFengDieSpaceCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
