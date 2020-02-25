package build.dream.common.models.weixinpay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ApplyMentModel {
    private String businessCode;
    private ContactInfo contactInfo;

    public static class ContactInfo extends BasicModel {
        @NotNull
        @Length(max = 2048)
        private String contactName;

        @Length(max = 2048)
        private String contactIdNumber;

        @Length(max = 128)
        private String openid;

        @NotNull
        @Length(max = 2048)
        private String mobilePhone;

        @NotNull
        @Length(max = 2048)
        private String contactEmail;

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactIdNumber() {
            return contactIdNumber;
        }

        public void setContactIdNumber(String contactIdNumber) {
            this.contactIdNumber = contactIdNumber;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        @Override
        public boolean validate() {
            return super.validate() && (StringUtils.isNotBlank(contactIdNumber) || StringUtils.isNotBlank(openid));
        }

        @Override
        public void validateAndThrow() {
            super.validateAndThrow();
            ValidateUtils.isTrue(StringUtils.isNotBlank(contactIdNumber) || StringUtils.isNotBlank(openid), "超级管理员身份证号码和超级管理员微信openid不能同时为空！");
        }
    }

    public static class SubjectInfo extends BasicModel {
        @NotNull
        @InList(value = {"SUBJECT_TYPE_INDIVIDUAL", "SUBJECT_TYPE_ENTERPRISE", "SUBJECT_TYPE_INSTITUTIONS", "SUBJECT_TYPE_OTHERS"})
        private String subjectType;

        private BusinessLicenseInfo businessLicenseInfo;
    }

    public static class BusinessLicenseInfo extends BasicModel {
        @NotNull
        @Length(max = 255)
        private String licenseCopy;

        @NotNull
        @Length(max = 32)
        private String licenseNumber;

        @NotNull
        @Length(max = 128)
        private String merchant_name;

        @NotNull
        @Length(max = 64)
        private String legalPerson;

        public String getLicenseCopy() {
            return licenseCopy;
        }

        public void setLicenseCopy(String licenseCopy) {
            this.licenseCopy = licenseCopy;
        }

        public String getLicenseNumber() {
            return licenseNumber;
        }

        public void setLicenseNumber(String licenseNumber) {
            this.licenseNumber = licenseNumber;
        }

        public String getMerchant_name() {
            return merchant_name;
        }

        public void setMerchant_name(String merchant_name) {
            this.merchant_name = merchant_name;
        }

        public String getLegalPerson() {
            return legalPerson;
        }

        public void setLegalPerson(String legalPerson) {
            this.legalPerson = legalPerson;
        }
    }
}
