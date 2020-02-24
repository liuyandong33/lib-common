package build.dream.common.models.weixinpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class DownloadBillModel extends BasicModel {
    @NotNull
    @Length(max = 32)
    private String appId;
    /**
     * 微信支付商户号
     */
    @NotNull
    @Length(max = 32)
    private String mchId;
    /**
     * api 秘钥
     */
    @NotNull
    private String apiKey;
    /**
     * 微信分配的子商户公众账号ID
     */
    @Length(max = 32)
    private String subAppId;
    /**
     * 子商户商户号
     */
    @Length(max = 32)
    private String subMchId;

    /**
     * 是否为受理关系
     */
    private boolean acceptanceModel;

    @NotNull
    @Length(max = 32)
    private String nonceStr = RandomStringUtils.randomAlphanumeric(32);

    /**
     * 下载对账单的日期，格式：20140603
     */
    @NotNull
    @Length(min = 8, max = 8)
    private String billDate;

    @InList(value = {Constants.DOWNLOAD_BILL_BILL_TYPE_ALL, Constants.DOWNLOAD_BILL_BILL_TYPE_SUCCESS, Constants.DOWNLOAD_BILL_BILL_TYPE_REFUND, Constants.DOWNLOAD_BILL_BILL_TYPE_RECHARGE_REFUND})
    private String billType = Constants.DOWNLOAD_BILL_BILL_TYPE_ALL;

    @InList(value = {Constants.DOWNLOAD_BILL_TAR_TYPE_GZIP})
    private String tarType;

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

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public boolean isAcceptanceModel() {
        return acceptanceModel;
    }

    public void setAcceptanceModel(boolean acceptanceModel) {
        this.acceptanceModel = acceptanceModel;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getTarType() {
        return tarType;
    }

    public void setTarType(String tarType) {
        this.tarType = tarType;
    }

    public static class Builder {
        private final DownloadBillModel instance = new DownloadBillModel();

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder mchId(String mchId) {
            instance.setMchId(mchId);
            return this;
        }

        public Builder apiKey(String apiKey) {
            instance.setApiKey(apiKey);
            return this;
        }

        public Builder subAppId(String subAppId) {
            instance.setSubAppId(subAppId);
            return this;
        }

        public Builder subMchId(String subMchId) {
            instance.setSubMchId(subMchId);
            return this;
        }

        public Builder acceptanceModel(boolean acceptanceModel) {
            instance.setAcceptanceModel(acceptanceModel);
            return this;
        }

        public Builder nonceStr(String nonceStr) {
            instance.setNonceStr(nonceStr);
            return this;
        }

        public Builder billDate(String billDate) {
            instance.setBillDate(billDate);
            return this;
        }

        public Builder billType(String billType) {
            instance.setBillType(billType);
            return this;
        }

        public Builder tarType(String tarType) {
            instance.setTarType(tarType);
            return this;
        }

        public DownloadBillModel build() {
            DownloadBillModel downloadBillModel = new DownloadBillModel();
            downloadBillModel.setAppId(instance.getAppId());
            downloadBillModel.setMchId(instance.getMchId());
            downloadBillModel.setApiKey(instance.getApiKey());
            downloadBillModel.setSubAppId(instance.getSubAppId());
            downloadBillModel.setSubMchId(instance.getSubMchId());
            downloadBillModel.setAcceptanceModel(instance.isAcceptanceModel());
            downloadBillModel.setNonceStr(instance.getNonceStr());
            downloadBillModel.setBillDate(instance.getBillDate());
            downloadBillModel.setBillType(instance.getBillType());
            downloadBillModel.setTarType(instance.getTarType());
            return downloadBillModel;
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}