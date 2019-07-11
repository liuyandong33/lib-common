package build.dream.common.models.sms;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class SendSmsModel extends BasicModel {
    @NotNull
    private String phoneNumbers;

    @NotNull
    private String signName;

    @NotNull
    private String templateCode;

    @NotNull
    private String templateParam;

    private String outId;

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public static class Builder {
        private final SendSmsModel instance = new SendSmsModel();

        public Builder phoneNumbers(String phoneNumbers) {
            instance.setPhoneNumbers(phoneNumbers);
            return this;
        }

        public Builder signName(String signName) {
            instance.setSignName(signName);
            return this;
        }

        public Builder templateCode(String templateCode) {
            instance.setTemplateCode(templateCode);
            return this;
        }

        public Builder templateParam(String templateParam) {
            instance.setTemplateCode(templateParam);
            return this;
        }

        public Builder outId(String outId) {
            instance.setOutId(outId);
            return this;
        }

        public SendSmsModel build() {
            SendSmsModel sendSmsModel = new SendSmsModel();
            sendSmsModel.setPhoneNumbers(instance.getPhoneNumbers());
            sendSmsModel.setSignName(instance.getSignName());
            sendSmsModel.setTemplateCode(instance.getTemplateCode());
            sendSmsModel.setTemplateParam(instance.getTemplateParam());
            sendSmsModel.setOutId(instance.getOutId());
            return sendSmsModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
