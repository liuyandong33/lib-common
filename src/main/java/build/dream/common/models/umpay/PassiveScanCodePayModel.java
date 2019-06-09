package build.dream.common.models.umpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PassiveScanCodePayModel extends UmPayBasicModel {
    @NotNull
    private String topic;

    /**
     * 商品号
     */
    @Length(max = 8)
    private String goodsId;

    /**
     * 商品描述信息
     */
    @NotNull
    @Length(max = 64)
    private String goodsInf;

    /**
     * 商户唯一订单号，订单号码支持数字、英文字母、-、_、*、+、#，其他字符将不支持。
     */
    @NotNull
    @Length(max = 32)
    private String orderId;

    /**
     * 商户订单日期，商户生成订单的日期，格式YYYYMMDD
     */
    @NotNull
    @Length(min = 8, max = 8)
    private String merDate;

    /**
     * 付款金额，是人民币，且以分为单位
     */
    @NotNull
    private Integer amount;

    /**
     * 付款币种，取值范围：RMB
     */
    @NotNull
    @InList(value = {Constants.RMB})
    private String amtType = Constants.RMB;

    /**
     * 商户私有域，联动优势支付平台原样返回，用于商户的私有信息。
     */
    @Length(max = 128)
    private String merPriv;

    /**
     * 用户IP地址，用户在创建交易时，该用户当前所使用机器的IP。用作防钓鱼校验
     */
    @Length(max = 16)
    private String userIp;

    /**
     * 业务扩展信息
     */
    @Length(max = 128)
    private String expand;

    /**
     * 订单过期时长，单位为分钟，默认1440分钟（24小时）
     */
    @Min(value = 1)
    private Integer expireTime;

    /**
     * 授权码，支付时从用户终端获取的用户标识(例如微信条形码编码)
     */
    @NotNull
    @Length(max = 32)
    private String authCode;

    /**
     * 用途说明
     */
    @NotNull
    @Length(max = 128)
    private String useDesc;

    /**
     * 扫码类型
     */
    @NotNull
    @InList(value = {Constants.UM_PAY_SCAN_CODE_TYPE_WECHAT, Constants.UM_PAY_SCAN_CODE_TYPE_ALIPAY})
    private String scanCodeType;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getUseDesc() {
        return useDesc;
    }

    public void setUseDesc(String useDesc) {
        this.useDesc = useDesc;
    }

    public String getScanCodeType() {
        return scanCodeType;
    }

    public void setScanCodeType(String scanCodeType) {
        this.scanCodeType = scanCodeType;
    }

    public static class Builder extends UmPayBasicModel.Builder<Builder, PassiveScanCodePayModel> {
        public Builder topic(String topic) {
            instance.setTopic(topic);
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

        public Builder authCode(String authCode) {
            instance.setAuthCode(authCode);
            return this;
        }

        public Builder useDesc(String useDesc) {
            instance.setUseDesc(useDesc);
            return this;
        }

        public Builder scanCodeType(String scanCodeType) {
            instance.setScanCodeType(scanCodeType);
            return this;
        }

        @Override
        public PassiveScanCodePayModel build() {
            PassiveScanCodePayModel passiveScanCodePayModel = super.build();
            passiveScanCodePayModel.setTopic(instance.getTopic());
            passiveScanCodePayModel.setGoodsId(instance.getGoodsId());
            passiveScanCodePayModel.setGoodsInf(instance.getGoodsInf());
            passiveScanCodePayModel.setOrderId(instance.getOrderId());
            passiveScanCodePayModel.setMerDate(instance.getMerDate());
            passiveScanCodePayModel.setAmount(instance.getAmount());
            passiveScanCodePayModel.setAmtType(instance.getAmtType());
            passiveScanCodePayModel.setMerPriv(instance.getMerPriv());
            passiveScanCodePayModel.setUserIp(instance.getUserIp());
            passiveScanCodePayModel.setExpand(instance.getExpand());
            passiveScanCodePayModel.setExpireTime(instance.getExpireTime());
            passiveScanCodePayModel.setAuthCode(instance.getAuthCode());
            passiveScanCodePayModel.setUseDesc(instance.getUseDesc());
            passiveScanCodePayModel.setScanCodeType(instance.getScanCodeType());
            return passiveScanCodePayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
