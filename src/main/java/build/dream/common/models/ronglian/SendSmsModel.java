package build.dream.common.models.ronglian;

import build.dream.common.models.BasicModel;

import java.util.List;

public class SendSmsModel extends BasicModel {
    private String accountSid;

    private String authToken;
    /**
     * 应用Id
     */
    private String appId;

    /**
     * 短信接收端手机号码集合，用英文逗号分开，每批发送的手机号数量不得超过200个
     */
    private String to;

    /**
     * 模板Id
     */
    private String templateId;

    /**
     * 内容数据外层节点，模板如果没有变量，此参数可不传
     */
    private List<String> datas;

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public List<String> getDatas() {
        return datas;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    public static class Builder {
        private final SendSmsModel instance = new SendSmsModel();

        public Builder accountSid(String accountSid) {
            instance.setAccountSid(accountSid);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder to(String to) {
            instance.setTo(to);
            return this;
        }

        public Builder templateId(String templateId) {
            instance.setTemplateId(templateId);
            return this;
        }

        public Builder datas(List<String> datas) {
            instance.setDatas(datas);
            return this;
        }

        public SendSmsModel build() {
            SendSmsModel sendSmsModel = new SendSmsModel();
            sendSmsModel.setAccountSid(instance.getAccountSid());
            sendSmsModel.setAuthToken(instance.getAuthToken());
            sendSmsModel.setAppId(instance.getAppId());
            sendSmsModel.setTo(instance.getTo());
            sendSmsModel.setTemplateId(instance.getTemplateId());
            sendSmsModel.setDatas(instance.getDatas());
            return sendSmsModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
