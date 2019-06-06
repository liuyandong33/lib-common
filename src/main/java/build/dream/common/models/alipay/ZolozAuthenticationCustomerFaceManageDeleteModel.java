package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ZolozAuthenticationCustomerFaceManageDeleteModel extends AlipayBasicModel {
    @NotNull
    @InList(value = {"IDCARD", "ALIPAY_USER", "ALIPAY_TEL", "CUSTOMER"})
    @JsonProperty(value = "facetype")
    private String faceType;

    @NotNull
    @Length(max = 40960)
    @JsonProperty(value = "faceval")
    private String faceVal;

    @Length(max = 50)
    @JsonProperty(value = "validtimes")
    private String validTimes;

    @NotNull
    @Length(max = 100)
    @JsonProperty(value = "devicenum")
    private String deviceNum;

    @Length(max = 50)
    @JsonProperty(value = "storecode")
    private String storeCode;

    @Length(max = 20)
    @JsonProperty(value = "brandcode")
    private String brandCode;

    @Length(max = 20)
    private String group;

    @Length(max = 20)
    @JsonProperty(value = "areacode")
    private String areaCode;

    @Length(max = 20)
    @JsonProperty(value = "bizscale")
    private String bizScale;

    @JsonProperty(value = "biz_type")
    private String bizType;

    @Length(max = 5000)
    @JsonProperty(value = "extinfo")
    private String extInfo;

    public String getFaceType() {
        return faceType;
    }

    public void setFaceType(String faceType) {
        this.faceType = faceType;
    }

    public String getFaceVal() {
        return faceVal;
    }

    public void setFaceVal(String faceVal) {
        this.faceVal = faceVal;
    }

    public String getValidTimes() {
        return validTimes;
    }

    public void setValidTimes(String validTimes) {
        this.validTimes = validTimes;
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getBizScale() {
        return bizScale;
    }

    public void setBizScale(String bizScale) {
        this.bizScale = bizScale;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final ZolozAuthenticationCustomerFaceManageDeleteModel instance = new ZolozAuthenticationCustomerFaceManageDeleteModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder faceType(String faceType) {
            instance.setFaceType(faceType);
            return this;
        }

        public Builder faceVal(String faceVal) {
            instance.setFaceVal(faceVal);
            return this;
        }

        public Builder validTimes(String validTimes) {
            instance.setValidTimes(validTimes);
            return this;
        }

        public Builder deviceNum(String deviceNum) {
            instance.setDeviceNum(deviceNum);
            return this;
        }

        public Builder storeCode(String storeCode) {
            instance.setStoreCode(storeCode);
            return this;
        }

        public Builder brandCode(String brandCode) {
            instance.setBrandCode(brandCode);
            return this;
        }

        public Builder group(String group) {
            instance.setGroup(group);
            return this;
        }

        public Builder areaCode(String areaCode) {
            instance.setAreaCode(areaCode);
            return this;
        }

        public Builder bizScale(String bizScale) {
            instance.setBizScale(bizScale);
            return this;
        }

        public Builder bizType(String bizType) {
            instance.setBizType(bizType);
            return this;
        }

        public Builder extInfo(String extInfo) {
            instance.setExtInfo(extInfo);
            return this;
        }

        public ZolozAuthenticationCustomerFaceManageDeleteModel build() {
            ZolozAuthenticationCustomerFaceManageDeleteModel zolozAuthenticationCustomerFaceManageDeleteModel = new ZolozAuthenticationCustomerFaceManageDeleteModel();
            build(zolozAuthenticationCustomerFaceManageDeleteModel);
            zolozAuthenticationCustomerFaceManageDeleteModel.setFaceType(instance.getFaceType());
            zolozAuthenticationCustomerFaceManageDeleteModel.setFaceVal(instance.getFaceVal());
            zolozAuthenticationCustomerFaceManageDeleteModel.setValidTimes(instance.getValidTimes());
            zolozAuthenticationCustomerFaceManageDeleteModel.setDeviceNum(instance.getDeviceNum());
            zolozAuthenticationCustomerFaceManageDeleteModel.setStoreCode(instance.getStoreCode());
            zolozAuthenticationCustomerFaceManageDeleteModel.setBrandCode(instance.getBrandCode());
            zolozAuthenticationCustomerFaceManageDeleteModel.setGroup(instance.getGroup());
            zolozAuthenticationCustomerFaceManageDeleteModel.setAreaCode(instance.getAreaCode());
            zolozAuthenticationCustomerFaceManageDeleteModel.setBizScale(instance.getBizScale());
            zolozAuthenticationCustomerFaceManageDeleteModel.setBizType(instance.getBizType());
            zolozAuthenticationCustomerFaceManageDeleteModel.setExtInfo(instance.getExtInfo());
            return zolozAuthenticationCustomerFaceManageDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
