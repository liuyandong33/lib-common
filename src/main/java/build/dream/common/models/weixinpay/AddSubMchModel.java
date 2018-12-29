package build.dream.common.models.weixinpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddSubMchModel extends BasicModel {
    @NotNull
    private String tenantId;

    @NotNull
    private String branchId;

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

    @NotNull
    @InList(value = {Constants.CONTACT_WE_CHAT_ID_TYPE_WE_CHAT_ID, Constants.CONTACT_WE_CHAT_ID_TYPE_OPEN_ID})
    private String contactWeChatIdType;

    @Length(max = 32)
    private String contactWeChatId;

    @NotNull
    @Length(max = 20)
    private String merchantRemark;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
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
}
