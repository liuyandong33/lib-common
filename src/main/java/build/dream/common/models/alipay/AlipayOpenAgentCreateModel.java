package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAgentCreateModel extends AlipayBasicModel {
    @NotNull
    @JsonProperty(value = "contact_info")
    private ContactInfo contactInfo;

    @Length(max = 40)
    @JsonProperty(value = "order_ticket")
    private String orderTicket;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getOrderTicket() {
        return orderTicket;
    }

    public void setOrderTicket(String orderTicket) {
        this.orderTicket = orderTicket;
    }

    @Override
    public boolean validate() {
        return super.validate() && contactInfo.validate();
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ApplicationHandler.isTrue(contactInfo.validate(), "contactInfo");
    }

    public static class Builder {
        private final AlipayOpenAgentCreateModel instance = new AlipayOpenAgentCreateModel();

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

        public Builder contactInfo(ContactInfo contactInfo) {
            instance.setContactInfo(contactInfo);
            return this;
        }

        public Builder orderTicket(String orderTicket) {
            instance.setOrderTicket(orderTicket);
            return this;
        }

        public AlipayOpenAgentCreateModel build() {
            AlipayOpenAgentCreateModel alipayOpenAgentCreateModel = new AlipayOpenAgentCreateModel();
            alipayOpenAgentCreateModel.setTenantId(instance.getTenantId());
            alipayOpenAgentCreateModel.setBranchId(instance.getBranchId());
            alipayOpenAgentCreateModel.setContactInfo(instance.getContactInfo());
            alipayOpenAgentCreateModel.setOrderTicket(instance.getOrderTicket());
            return alipayOpenAgentCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class ContactInfo extends BasicModel {
        @NotNull
        @Length(max = 64)
        @JsonProperty(value = "contact_name")
        private String contactName;

        @NotNull
        @Length(max = 16)
        @JsonProperty(value = "contact_mobile")
        private String contactMobile;

        @NotNull
        @Length(max = 64)
        @JsonProperty(value = "contact_email")
        private String contactEmail;

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactMobile() {
            return contactMobile;
        }

        public void setContactMobile(String contactMobile) {
            this.contactMobile = contactMobile;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }
    }
}
