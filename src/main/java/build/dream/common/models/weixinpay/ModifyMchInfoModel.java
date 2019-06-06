package build.dream.common.models.weixinpay;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ModifyMchInfoModel extends BasicModel {
    /**
     * 银行服务商的商户号
     */
    @NotNull
    @Length(max = 32)
    private String mchId;

    /**
     * 微信支付分配的商户识别码
     */
    @NotNull
    @Length(max = 32)
    private String subMchId;

    /**
     * 该名称是显示给消费者看的商户名称
     */
    @Length(max = 20)
    private String merchantShortName;

    /**
     * 方便微信在必要时能联系上商家，会在支付详情展示给消费者
     */
    @Length(max = 20)
    private String servicePhone;

    /**
     * api 秘钥
     */
    @NotNull
    private String apiSecretKey;

    /**
     * 操作证书
     */
    @NotNull
    private String operationCertificate;
    /**
     * 操作证书密码
     */
    @NotNull
    private String operationCertificatePassword;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
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
        private final ModifyMchInfoModel instance = new ModifyMchInfoModel();

        public Builder mchId(String mchId) {
            instance.setMchId(mchId);
            return this;
        }

        public Builder subMchId(String subMchId) {
            instance.setSubMchId(subMchId);
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

        public ModifyMchInfoModel build() {
            ModifyMchInfoModel modifyMchInfoModel = new ModifyMchInfoModel();
            modifyMchInfoModel.setMchId(instance.getMchId());
            modifyMchInfoModel.setSubMchId(instance.getSubMchId());
            modifyMchInfoModel.setMerchantShortName(instance.getMerchantShortName());
            modifyMchInfoModel.setServicePhone(instance.getServicePhone());
            modifyMchInfoModel.setApiSecretKey(instance.getApiSecretKey());
            modifyMchInfoModel.setOperationCertificate(instance.getOperationCertificate());
            modifyMchInfoModel.setOperationCertificatePassword(instance.getOperationCertificatePassword());
            return modifyMchInfoModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
