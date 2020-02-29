package build.dream.common.models.umpay;

import build.dream.common.beans.MqConfig;
import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.utils.CustomDateUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PublicNumberAndVerticalCodeModel extends UmPayBasicModel {
    @NotNull
    private MqConfig mqConfig;

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
    private String merDate = CustomDateUtils.format(new Date(), "yyyyMMdd");

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
     * 用户IP地址，用户在创建交易时，该用户当前所使用机器的IP。用作防钓鱼校验
     */
    @Length(max = 16)
    private String userIp;

    /**
     * 订单过期时长，单位为分钟，默认1440分钟（24小时）
     */
    @Min(value = 1)
    private Integer expireTime;

    /**
     * 商户私有域，联动优势支付平台原样返回，用于商户的私有信息。
     */
    @Length(max = 128)
    private String merPriv;

    /**
     * 业务扩展信息
     */
    @Length(max = 128)
    private String expand;

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
     * 是否是公众号支付 Y公众号支付 N立码支付
     */
    @NotNull
    @InList(value = {"Y", "N"})
    private String isPublicNumber;

    public MqConfig getMqConfig() {
        return mqConfig;
    }

    public void setMqConfig(MqConfig mqConfig) {
        this.mqConfig = mqConfig;
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

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public String getMerPriv() {
        return merPriv;
    }

    public void setMerPriv(String merPriv) {
        this.merPriv = merPriv;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
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

    public String getIsPublicNumber() {
        return isPublicNumber;
    }

    public void setIsPublicNumber(String isPublicNumber) {
        this.isPublicNumber = isPublicNumber;
    }

    public static class Builder extends UmPayBasicModel.Builder<Builder, PublicNumberAndVerticalCodeModel> {
        public Builder mqConfig(MqConfig mqConfig) {
            instance.setMqConfig(mqConfig);
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

        public Builder userIp(String userIp) {
            instance.setUserIp(userIp);
            return this;
        }

        public Builder expireTime(Integer expireTime) {
            instance.setExpireTime(expireTime);
            return this;
        }

        public Builder merPriv(String merPriv) {
            instance.setMerPriv(merPriv);
            return this;
        }

        public Builder expand(String expand) {
            instance.setExpand(expand);
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

        public Builder isPublicNumber(String isPublicNumber) {
            instance.setIsPublicNumber(isPublicNumber);
            return this;
        }

        @Override
        public PublicNumberAndVerticalCodeModel build() {
            PublicNumberAndVerticalCodeModel publicNumberAndVerticalCodeModel = super.build();
            publicNumberAndVerticalCodeModel.setMqConfig(instance.getMqConfig());
            publicNumberAndVerticalCodeModel.setOrderId(instance.getOrderId());
            publicNumberAndVerticalCodeModel.setMerDate(instance.getMerDate());
            publicNumberAndVerticalCodeModel.setAmount(instance.getAmount());
            publicNumberAndVerticalCodeModel.setAmtType(instance.getAmtType());
            publicNumberAndVerticalCodeModel.setUserIp(instance.getUserIp());
            publicNumberAndVerticalCodeModel.setExpireTime(instance.getExpireTime());
            publicNumberAndVerticalCodeModel.setMerPriv(instance.getMerPriv());
            publicNumberAndVerticalCodeModel.setExpand(instance.getExpand());
            publicNumberAndVerticalCodeModel.setGoodsId(instance.getGoodsId());
            publicNumberAndVerticalCodeModel.setGoodsInf(instance.getGoodsInf());
            publicNumberAndVerticalCodeModel.setIsPublicNumber(instance.getIsPublicNumber());
            return publicNumberAndVerticalCodeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
