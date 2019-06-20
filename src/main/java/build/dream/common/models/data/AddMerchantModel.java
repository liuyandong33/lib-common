package build.dream.common.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class AddMerchantModel extends DadaBasicModel {
    @NotNull
    private String mobile;

    @NotNull
    @JsonProperty(value = "city_name")
    private String cityName;

    @NotNull
    @JsonProperty(value = "enterprise_name")
    private String enterpriseName;

    @NotNull
    @JsonProperty(value = "enterprise_address")
    private String enterpriseAddress;

    @NotNull
    @JsonProperty(value = "contact_name")
    private String contactName;

    @NotNull
    @JsonProperty(value = "contact_phone")
    private String contactPhone;

    @NotNull
    private String email;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, AddMerchantModel> {
        public Builder mobile(String mobile) {
            instance.setMobile(mobile);
            return this;
        }

        public Builder cityName(String cityName) {
            instance.setCityName(cityName);
            return this;
        }

        public Builder enterpriseName(String enterpriseName) {
            instance.setEnterpriseName(enterpriseName);
            return this;
        }

        public Builder enterpriseAddress(String enterpriseAddress) {
            instance.setEnterpriseAddress(enterpriseAddress);
            return this;
        }

        public Builder contactName(String contactName) {
            instance.setContactName(contactName);
            return this;
        }

        public Builder contactPhone(String contactPhone) {
            instance.setContactPhone(contactPhone);
            return this;
        }

        public Builder email(String email) {
            instance.setEmail(email);
            return this;
        }

        @Override
        public AddMerchantModel build() {
            AddMerchantModel addMerchantModel = super.build();
            addMerchantModel.setMobile(instance.getMobile());
            addMerchantModel.setCityName(instance.getCityName());
            addMerchantModel.setEnterpriseName(instance.getEnterpriseName());
            addMerchantModel.setEnterpriseAddress(instance.getEnterpriseAddress());
            addMerchantModel.setContactName(instance.getContactName());
            addMerchantModel.setContactPhone(instance.getContactPhone());
            addMerchantModel.setEmail(instance.getEmail());
            return addMerchantModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
