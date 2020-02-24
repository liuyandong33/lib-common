package build.dream.common.models.weixinpay;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class QuerySubMchModel extends BasicModel {
    /**
     * 服务商的公众账号ID
     */
    @NotNull
    @Length(max = 32)
    private String appId;

    /**
     * 银行服务商的商户号
     */
    @NotNull
    @Length(max = 32)
    private String mchId;

    @Length(max = 50)
    private String merchantName;

    /**
     * 微信支付分配的商户识别码
     */
    @Length(max = 32)
    private String subMchId;

    @NotNull
    private Integer pageIndex;

    private Integer pageSize;

    /**
     * api 秘钥
     */
    @NotNull
    private String apiKey;

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

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
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
        private final QuerySubMchModel instance = new QuerySubMchModel();

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

        public Builder subMchId(String subMchId) {
            instance.setSubMchId(subMchId);
            return this;
        }

        public Builder pageIndex(Integer pageIndex) {
            instance.setPageIndex(pageIndex);
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public Builder apiKey(String apiKey) {
            instance.setApiKey(apiKey);
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

        public QuerySubMchModel build() {
            QuerySubMchModel querySubMchModel = new QuerySubMchModel();
            querySubMchModel.setAppId(instance.getAppId());
            querySubMchModel.setMchId(instance.getMchId());
            querySubMchModel.setMerchantName(instance.getMerchantName());
            querySubMchModel.setSubMchId(instance.getSubMchId());
            querySubMchModel.setPageIndex(instance.getPageIndex());
            querySubMchModel.setPageSize(instance.getPageSize());
            querySubMchModel.setApiKey(instance.getApiKey());
            querySubMchModel.setOperationCertificate(instance.getOperationCertificate());
            querySubMchModel.setOperationCertificatePassword(instance.getOperationCertificatePassword());
            return querySubMchModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
