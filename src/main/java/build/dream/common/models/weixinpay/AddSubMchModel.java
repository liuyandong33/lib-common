package build.dream.common.models.weixinpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddSubMchModel extends BasicModel {
    @NotNull
    @Length(max = 32)
    private String appId;

    @NotNull
    @Length(max = 32)
    private String mchId;

    @NotNull
    @Length(max = 50)
    private String merchantName;

    @NotNull
    @Length(max = 20)
    private String merchantShortName;

    @NotNull
    @Length(max = 20)
    private String servicePhone;

    @Length(max = 10)
    private String contact;

    @Length(max = 11)
    private String contactPhone;

    @Length(max = 30)
    private String contactEmail;

    @NotNull
    @Length(max = 32)
    private String channelId;

    @NotNull
    @Length(max = 10)
    private String business;

    @InList(value = {Constants.CONTACT_WE_CHAT_ID_TYPE_WE_CHAT_ID, Constants.CONTACT_WE_CHAT_ID_TYPE_OPEN_ID})
    private String contactWeChatIdType;

    @Length(max = 32)
    private String contactWeChatId;

    @NotNull
    @Length(max = 20)
    private String merchantRemark;

    /**
     * api 秘钥
     */
    @NotNull
    private String apiSecretKey;

    @NotNull
    private String operationCertificate;
    /**
     * 操作证书密码
     */
    @NotNull
    private String operationCertificatePassword;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantShortName() {
        return merchantShortName;
    }

    public void setMerchantShortName(String merchantShortName) {
        this.merchantShortName = merchantShortName;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getContactWeChatIdType() {
        return contactWeChatIdType;
    }

    public void setContactWeChatIdType(String contactWeChatIdType) {
        this.contactWeChatIdType = contactWeChatIdType;
    }

    public String getContactWeChatId() {
        return contactWeChatId;
    }

    public void setContactWeChatId(String contactWeChatId) {
        this.contactWeChatId = contactWeChatId;
    }

    public String getMerchantRemark() {
        return merchantRemark;
    }

    public void setMerchantRemark(String merchantRemark) {
        this.merchantRemark = merchantRemark;
    }

    public String getApiSecretKey() {
        return apiSecretKey;
    }

    public void setApiSecretKey(String apiSecretKey) {
        this.apiSecretKey = apiSecretKey;
    }

    public String getOperationCertificate() {
        return operationCertificate;
    }

    public void setOperationCertificate(String operationCertificate) {
        this.operationCertificate = operationCertificate;
    }

    public String getOperationCertificatePassword() {
        return operationCertificatePassword;
    }

    public void setOperationCertificatePassword(String operationCertificatePassword) {
        this.operationCertificatePassword = operationCertificatePassword;
    }

    public static class Builder {
        private final AddSubMchModel instance = new AddSubMchModel();

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder mchId(String mchId) {
            instance.setMchId(mchId);
            return this;
        }

        public Builder merchantName(String merchantName) {
            instance.setMerchantName(merchantName);
            return this;
        }

        public Builder merchantShortName(String merchantShortName) {
            instance.setMerchantShortName(merchantShortName);
            return this;
        }

        public Builder servicePhone(String servicePhone) {
            instance.setServicePhone(servicePhone);
            return this;
        }

        public Builder contact(String contact) {
            instance.setContact(contact);
            return this;
        }

        public Builder contactPhone(String contactPhone) {
            instance.setContactPhone(contactPhone);
            return this;
        }

        public Builder contactEmail(String contactEmail) {
            instance.setContactEmail(contactEmail);
            return this;
        }

        public Builder channelId(String channelId) {
            instance.setChannelId(channelId);
            return this;
        }

        public Builder business(String business) {
            instance.setBusiness(business);
            return this;
        }

        public Builder contactWeChatIdType(String contactWeChatIdType) {
            instance.setContactWeChatIdType(contactWeChatIdType);
            return this;
        }

        public Builder contactWeChatId(String contactWeChatId) {
            instance.setContactWeChatId(contactWeChatId);
            return this;
        }

        public Builder merchantRemark(String merchantRemark) {
            instance.setMerchantRemark(merchantRemark);
            return this;
        }

        public Builder apiSecretKey(String apiSecretKey) {
            instance.setApiSecretKey(apiSecretKey);
            return this;
        }

        public Builder operationCertificate(String operationCertificate) {
            instance.setOperationCertificate(operationCertificate);
            return this;
        }

        public Builder operationCertificatePassword(String operationCertificatePassword) {
            instance.setOperationCertificatePassword(operationCertificatePassword);
            return this;
        }

        public AddSubMchModel build() {
            AddSubMchModel addSubMchModel = new AddSubMchModel();
            addSubMchModel.setAppId(instance.getAppId());
            addSubMchModel.setMchId(instance.getMchId());
            addSubMchModel.setMerchantName(instance.getMerchantName());
            addSubMchModel.setMerchantShortName(instance.getMerchantShortName());
            addSubMchModel.setServicePhone(instance.getServicePhone());
            addSubMchModel.setContact(instance.getContact());
            addSubMchModel.setContactPhone(instance.getContactPhone());
            addSubMchModel.setContactEmail(instance.getContactEmail());
            addSubMchModel.setChannelId(instance.getChannelId());
            addSubMchModel.setBusiness(instance.getBusiness());
            addSubMchModel.setContactWeChatIdType(instance.getContactWeChatIdType());
            addSubMchModel.setContactWeChatId(instance.getContactWeChatId());
            addSubMchModel.setMerchantRemark(instance.getMerchantRemark());
            addSubMchModel.setApiSecretKey(instance.getApiSecretKey());
            addSubMchModel.setOperationCertificate(instance.getOperationCertificate());
            addSubMchModel.setOperationCertificatePassword(instance.getOperationCertificatePassword());
            return addSubMchModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
