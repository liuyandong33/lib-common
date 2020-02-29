package build.dream.common.models.umpay;

import build.dream.common.beans.MqConfig;
import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.utils.CustomDateUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ActiveScanCodeOrderModel extends UmPayBasicModel {
    @NotNull
    private MqConfig mqConfig;

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
    private String merDate = CustomDateUtils.format(new Date(), "yyyyMMdd");

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

    public MqConfig getMqConfig() {
        return mqConfig;
    }

    public void setMqConfig(MqConfig mqConfig) {
        this.mqConfig = mqConfig;
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

    public static class Builder extends UmPayBasicModel.Builder<Builder, ActiveScanCodeOrderModel> {
        public Builder mqConfig(MqConfig mqConfig) {
            instance.setMqConfig(mqConfig);
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

        @Override
        public ActiveScanCodeOrderModel build() {
            ActiveScanCodeOrderModel activeScanCodeOrderModel = super.build();
            activeScanCodeOrderModel.setMqConfig(instance.getMqConfig());
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
            return activeScanCodeOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
