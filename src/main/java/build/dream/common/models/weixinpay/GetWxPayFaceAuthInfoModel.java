package build.dream.common.models.weixinpay;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class GetWxPayFaceAuthInfoModel extends BasicModel {
    @NotNull
    private String tenantId;

    @NotNull
    private String branchId;

    @NotNull
    @Length(max = 32)
    private String storeId;

    @NotNull
    @Length(max = 128)
    private String storeName;

    @NotNull
    @Length(max = 32)
    private String deviceId;

    private String attach;

    @NotNull
    @Length(max = 2048)
    private String rawData;

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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public static class Builder {
        private GetWxPayFaceAuthInfoModel instance = new GetWxPayFaceAuthInfoModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder storeId(String storeId) {
            instance.setStoreId(storeId);
            return this;
        }

        public Builder storeName(String storeName) {
            instance.setStoreName(storeName);
            return this;
        }

        public Builder deviceId(String deviceId) {
            instance.setDeviceId(deviceId);
            return this;
        }

        public Builder attach(String attach) {
            instance.setAttach(attach);
            return this;
        }

        public Builder rawData(String rawData) {
            instance.setRawData(rawData);
            return this;
        }

        public GetWxPayFaceAuthInfoModel build() {
            GetWxPayFaceAuthInfoModel getWxPayFaceAuthInfoModel = new GetWxPayFaceAuthInfoModel();
            getWxPayFaceAuthInfoModel.setTenantId(instance.getTenantId());
            getWxPayFaceAuthInfoModel.setBranchId(instance.getBranchId());
            getWxPayFaceAuthInfoModel.setStoreId(instance.getStoreId());
            getWxPayFaceAuthInfoModel.setStoreName(instance.getStoreName());
            getWxPayFaceAuthInfoModel.setDeviceId(instance.getDeviceId());
            getWxPayFaceAuthInfoModel.setAttach(instance.getAttach());
            getWxPayFaceAuthInfoModel.setRawData(instance.getRawData());
            return getWxPayFaceAuthInfoModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
