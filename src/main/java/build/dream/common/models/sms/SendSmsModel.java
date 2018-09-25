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
}
