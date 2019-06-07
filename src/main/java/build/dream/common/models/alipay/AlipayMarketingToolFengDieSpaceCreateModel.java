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

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingToolFengDieSpaceCreateModel> {
        public Builder title(String title) {
            instance.setTitle(title);
            return this;
        }

        @Override
        public AlipayMarketingToolFengDieSpaceCreateModel build() {
            AlipayMarketingToolFengDieSpaceCreateModel alipayMarketingToolFengDieSpaceCreateModel = super.build();
            alipayMarketingToolFengDieSpaceCreateModel.setTitle(instance.getTitle());
            return alipayMarketingToolFengDieSpaceCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
