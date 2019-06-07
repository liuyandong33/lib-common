package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayMarketingToolFengDieActivityCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 11)
    @JsonProperty(value = "template_id")
    private String templateId;

    private Activity activity;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingToolFengDieActivityCreateModel> {
        public Builder templateId(String templateId) {
            instance.setTemplateId(templateId);
            return this;
        }

        public Builder activity(Activity activity) {
            instance.setActivity(activity);
            return this;
        }

        @Override
        public AlipayMarketingToolFengDieActivityCreateModel build() {
            AlipayMarketingToolFengDieActivityCreateModel alipayMarketingToolFengDieActivityCreateModel = super.build();
            alipayMarketingToolFengDieActivityCreateModel.setTemplateId(instance.getTemplateId());
            alipayMarketingToolFengDieActivityCreateModel.setActivity(instance.getActivity());
            return alipayMarketingToolFengDieActivityCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Page extends BasicModel {
        @Length(max = 500)
        private String name;

        @Length(max = 100)
        private String schemaData;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSchemaData() {
            return schemaData;
        }

        public void setSchemaData(String schemaData) {
            this.schemaData = schemaData;
        }
    }

    public static class Activity extends BasicModel {
        @Length(max = 100)
        private String title;

        @Length(max = 100)
        private String name;

        @Length(min = 19, max = 19)
        @JsonProperty(value = "offline_time")
        private String offlineTime;

        @JsonProperty(value = "page")
        private List<Page> pages;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOfflineTime() {
            return offlineTime;
        }

        public void setOfflineTime(String offlineTime) {
            this.offlineTime = offlineTime;
        }

        public List<Page> getPages() {
            return pages;
        }

        public void setPages(List<Page> pages) {
            this.pages = pages;
        }
    }
}
