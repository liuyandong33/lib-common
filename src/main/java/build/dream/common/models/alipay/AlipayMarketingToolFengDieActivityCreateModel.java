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

    public static class Builder {
        private final AlipayMarketingToolFengDieActivityCreateModel instance = new AlipayMarketingToolFengDieActivityCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder templateId(String templateId) {
            instance.setTemplateId(templateId);
            return this;
        }

        public Builder activity(Activity activity) {
            instance.setActivity(activity);
            return this;
        }

        public AlipayMarketingToolFengDieActivityCreateModel build() {
            AlipayMarketingToolFengDieActivityCreateModel alipayMarketingToolFengDieActivityCreateModel = new AlipayMarketingToolFengDieActivityCreateModel();
            alipayMarketingToolFengDieActivityCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingToolFengDieActivityCreateModel.setBranchId(instance.getBranchId());
            alipayMarketingToolFengDieActivityCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingToolFengDieActivityCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingToolFengDieActivityCreateModel.setAuthToken(instance.getAuthToken());
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
