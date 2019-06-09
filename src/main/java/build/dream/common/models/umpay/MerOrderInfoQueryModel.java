package build.dream.common.models.umpay;

import build.dream.common.constraints.InList;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class MerOrderInfoQueryModel extends UmPayBasicModel {
    /**
     * 原订单类型：1：消费 2：预授权
     */
    @InList(value = {"1", "2"})
    private String orderType;

    /**
     * 原商户订单号（商户订单号和U付订单号必传其一，如都传递则需两者互相匹配）
     */
    @Length(max = 32)
    private String orderId;

    /**
     * 商户下单时联动返回的交易号（商户订单号和U付订单号必传其一，如都传递则需两者互相匹配）
     */
    @Length(max = 16)
    private String tradeNo;

    /**
     * 原商户订单日期
     */
    @NotNull
    @Length(min = 8, max = 8)
    private String merDate;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getMerDate() {
        return merDate;
    }

    public void setMerDate(String merDate) {
        this.merDate = merDate;
    }

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(orderId) || StringUtils.isNotBlank(tradeNo));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(orderId) || StringUtils.isNotBlank(tradeNo), "orderId和tradeNo不能同时为空！");
    }

    public static class Builder extends UmPayBasicModel.Builder<Builder, MerOrderInfoQueryModel> {
        public Builder orderType(String orderType) {
            instance.setOrderType(orderType);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder tradeNo(String tradeNo) {
            instance.setTradeNo(tradeNo);
            return this;
        }

        public Builder merDate(String merDate) {
            instance.setMerDate(merDate);
            return this;
        }

        @Override
        public MerOrderInfoQueryModel build() {
            MerOrderInfoQueryModel merOrderInfoQueryModel = super.build();
            merOrderInfoQueryModel.setOrderType(instance.getOrderType());
            merOrderInfoQueryModel.setOrderId(instance.getOrderId());
            merOrderInfoQueryModel.setTradeNo(instance.getTradeNo());
            merOrderInfoQueryModel.setMerDate(instance.getMerDate());
            return merOrderInfoQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
