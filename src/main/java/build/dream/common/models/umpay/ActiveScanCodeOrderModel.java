package build.dream.common.models.umpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ActiveScanCodeOrderModel extends BasicModel {
    @NotNull
    @InList(value = {Constants.CHARSET_NAME_UTF_8, Constants.CHARSET_NAME_GBK, Constants.CHARSET_NAME_GB2312, Constants.CHARSET_NAME_GB18030})
    private String charset = Constants.CHARSET_NAME_UTF_8;

    @NotNull
    @Length(max = 8)
    private String merId;

    @NotNull
    @InList(value = {Constants.RSA})
    private String signType = Constants.RSA;

    @NotNull
    private String topic;

    @NotNull
    @InList(value = Constants.HTML)
    private String resFormat = Constants.HTML;

    @NotNull
    @InList(value = {Constants.UM_PAY_VERSION})
    private String version = Constants.UM_PAY_VERSION;

    @Length(max = 8)
    private String goodsId;

    @NotNull
    @Length(max = 64)
    private String goodsInf;

    @NotNull
    @Length(max = 32)
    private String orderId;

    @NotNull
    @Length(min = 8, max = 8)
    private String merDate;

    @NotNull
    private Integer amount;

    @NotNull
    @InList(value = {Constants.RMB})
    private String amtType = Constants.RMB;

    @Length(max = 128)
    private String merPriv;

    @Length(max = 16)
    private String userIp;

    @Length(max = 128)
    private String expand;

    @Min(value = 1)
    private Integer expireTime;

    @NotNull
    @InList(value = {Constants.UM_PAY_SCAN_CODE_TYPE_WECHAT, Constants.UM_PAY_SCAN_CODE_TYPE_ALIPAY})
    private String scanCodeType;

    @NotNull
    private String merchantPrivateKey;

    @NotNull
    private String platformPublicKey;

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getResFormat() {
        return resFormat;
    }

    public void setResFormat(String resFormat) {
        this.resFormat = resFormat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsInf() {
        return goodsInf;
    }

    public void setGoodsInf(String goodsInf) {
        this.goodsInf = goodsInf;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMerDate() {
        return merDate;
    }

    public void setMerDate(String merDate) {
        this.merDate = merDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAmtType() {
        return amtType;
    }

    public void setAmtType(String amtType) {
        this.amtType = amtType;
    }

    public String getMerPriv() {
        return merPriv;
    }

    public void setMerPriv(String merPriv) {
        this.merPriv = merPriv;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public String getScanCodeType() {
        return scanCodeType;
    }

    public void setScanCodeType(String scanCodeType) {
        this.scanCodeType = scanCodeType;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public String getPlatformPublicKey() {
        return platformPublicKey;
    }

    public void setPlatformPublicKey(String platformPublicKey) {
        this.platformPublicKey = platformPublicKey;
    }

    public static class Builder {
        private final ActiveScanCodeOrderModel instance = new ActiveScanCodeOrderModel();

        public Builder charset(String charset) {
            instance.setCharset(charset);
            return this;
        }

        public Builder merId(String merId) {
            instance.setMerId(merId);
            return this;
        }

        public Builder signType(String signType) {
            instance.setSignType(signType);
            return this;
        }

        public Builder topic(String topic) {
            instance.setTopic(topic);
            return this;
        }

        public Builder resFormat(String resFormat) {
            instance.setResFormat(resFormat);
            return this;
        }

        public Builder version(String version) {
            instance.setVersion(version);
            return this;
        }

        public Builder goodsId(String goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsInf(String goodsInf) {
            instance.setGoodsInf(goodsInf);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder merDate(String merDate) {
            instance.setMerDate(merDate);
            return this;
        }

        public Builder amount(Integer amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder amtType(String amtType) {
            instance.setAmtType(amtType);
            return this;
        }

        public Builder merPriv(String merPriv) {
            instance.setMerPriv(merPriv);
            return this;
        }

        public Builder userIp(String userIp) {
            instance.setUserIp(userIp);
            return this;
        }

        public Builder expand(String expand) {
            instance.setExpand(expand);
            return this;
        }

        public Builder expireTime(Integer expireTime) {
            instance.setExpireTime(expireTime);
            return this;
        }

        public Builder scanCodeType(String scanCodeType) {
            instance.setScanCodeType(scanCodeType);
            return this;
        }

        public Builder merchantPrivateKey(String merchantPrivateKey) {
            instance.setMerchantPrivateKey(merchantPrivateKey);
            return this;
        }

        public Builder platformPublicKey(String platformPublicKey) {
            instance.setPlatformPublicKey(platformPublicKey);
            return this;
        }

        public ActiveScanCodeOrderModel build() {
            ActiveScanCodeOrderModel activeScanCodeOrderModel = new ActiveScanCodeOrderModel();
            activeScanCodeOrderModel.setCharset(instance.getCharset());
            activeScanCodeOrderModel.setMerId(instance.getMerId());
            activeScanCodeOrderModel.setSignType(instance.getSignType());
            activeScanCodeOrderModel.setTopic(instance.getTopic());
            activeScanCodeOrderModel.setResFormat(instance.getResFormat());
            activeScanCodeOrderModel.setVersion(instance.getVersion());
            activeScanCodeOrderModel.setGoodsId(instance.getGoodsId());
            activeScanCodeOrderModel.setGoodsInf(instance.getGoodsInf());
            activeScanCodeOrderModel.setOrderId(instance.getOrderId());
            activeScanCodeOrderModel.setMerDate(instance.getMerDate());
            activeScanCodeOrderModel.setAmount(instance.getAmount());
            activeScanCodeOrderModel.setAmtType(instance.getAmtType());
            activeScanCodeOrderModel.setMerPriv(instance.getMerPriv());
            activeScanCodeOrderModel.setUserIp(instance.getUserIp());
            activeScanCodeOrderModel.setExpand(instance.getExpand());
            activeScanCodeOrderModel.setExpireTime(instance.getExpireTime());
            activeScanCodeOrderModel.setScanCodeType(instance.getScanCodeType());
            activeScanCodeOrderModel.setMerchantPrivateKey(instance.getMerchantPrivateKey());
            activeScanCodeOrderModel.setPlatformPublicKey(instance.getPlatformPublicKey());
            return activeScanCodeOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
