package build.dream.common.beans;

import java.util.Date;

public class WeiXinBill {
    /**
     * ﻿交易时间
     */
    private Date tradeTime;

    /**
     * 公众账号ID
     */
    private String appId;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 特约商户号
     */
    private String subMchId;

    /**
     * 设备号
     */
    private String deviceInfo;

    /**
     * 微信订单号
     */
    private String transactionId;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 用户标识
     */
    private String openId;

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 交易状态
     */
    private String tradeState;

    /**
     * 付款银行
     */
    private String bankType;

    /**
     * 货币种类
     */
    private String feeType;

    /**
     * 应结订单金额
     */
    private Double settlementTotalFee;

    /**
     * 代金券金额
     */
    private Double couponFee;

    /**
     * 微信退款单号
     */
    private String refundId;

    /**
     * 商户退款单号
     */
    private String outRefundNo;

    /**
     * 退款金额
     */
    private Double settlementRefundFee;

    /**
     * 充值券退款金额
     */
    private Double cashRefundFee;

    /**
     * 退款类型
     */
    private String refundType;

    /**
     * 退款状态
     */
    private String refundState;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商户数据包
     */
    private String dataPacket;

    /**
     * 手续费
     */
    private Double serviceFee;

    /**
     * 费率
     */
    private String rate;

    /**
     * 订单金额
     */
    private Double totalFee;

    /**
     * 申请退款金额
     */
    private Double refundFee;

    /**
     * 费率备注
     */
    private String rateRemark;

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

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

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Double getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(Double settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public Double getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Double couponFee) {
        this.couponFee = couponFee;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public Double getSettlementRefundFee() {
        return settlementRefundFee;
    }

    public void setSettlementRefundFee(Double settlementRefundFee) {
        this.settlementRefundFee = settlementRefundFee;
    }

    public Double getCashRefundFee() {
        return cashRefundFee;
    }

    public void setCashRefundFee(Double cashRefundFee) {
        this.cashRefundFee = cashRefundFee;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getDataPacket() {
        return dataPacket;
    }

    public void setDataPacket(String dataPacket) {
        this.dataPacket = dataPacket;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    public Double getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Double refundFee) {
        this.refundFee = refundFee;
    }

    public String getRateRemark() {
        return rateRemark;
    }

    public void setRateRemark(String rateRemark) {
        this.rateRemark = rateRemark;
    }

    public static class Builder {
        private final WeiXinBill instance = new WeiXinBill();

        public Builder tradeTime(Date tradeTime) {
            instance.setTradeTime(tradeTime);
            return this;
        }

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder mchId(String mchId) {
            instance.setMchId(mchId);
            return this;
        }

        public Builder subMchId(String subMchId) {
            instance.setSubMchId(subMchId);
            return this;
        }

        public Builder deviceInfo(String deviceInfo) {
            instance.setDeviceInfo(deviceInfo);
            return this;
        }

        public Builder transactionId(String transactionId) {
            instance.setTransactionId(transactionId);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder openId(String openId) {
            instance.setOpenId(openId);
            return this;
        }

        public Builder tradeType(String tradeType) {
            instance.setTradeType(tradeType);
            return this;
        }

        public Builder tradeState(String tradeState) {
            instance.setTradeState(tradeState);
            return this;
        }

        public Builder bankType(String bankType) {
            instance.setBankType(bankType);
            return this;
        }

        public Builder feeType(String feeType) {
            instance.setFeeType(feeType);
            return this;
        }

        public Builder settlementTotalFee(Double settlementTotalFee) {
            instance.setSettlementTotalFee(settlementTotalFee);
            return this;
        }

        public Builder couponFee(Double couponFee) {
            instance.setCouponFee(couponFee);
            return this;
        }

        public Builder refundId(String refundId) {
            instance.setRefundId(refundId);
            return this;
        }

        public Builder outRefundNo(String outRefundNo) {
            instance.setOutRefundNo(outRefundNo);
            return this;
        }

        public Builder settlementRefundFee(Double settlementRefundFee) {
            instance.setSettlementRefundFee(settlementRefundFee);
            return this;
        }

        public Builder cashRefundFee(Double cashRefundFee) {
            instance.setCashRefundFee(cashRefundFee);
            return this;
        }

        public Builder refundType(String refundType) {
            instance.setRefundType(refundType);
            return this;
        }

        public Builder refundState(String refundState) {
            instance.setRefundState(refundState);
            return this;
        }

        public Builder goodsName(String goodsName) {
            instance.setGoodsName(goodsName);
            return this;
        }

        public Builder dataPacket(String dataPacket) {
            instance.setDataPacket(dataPacket);
            return this;
        }

        public Builder serviceFee(Double serviceFee) {
            instance.setServiceFee(serviceFee);
            return this;
        }

        public Builder rate(String rate) {
            instance.setRate(rate);
            return this;
        }

        public Builder totalFee(Double totalFee) {
            instance.setTotalFee(totalFee);
            return this;
        }

        public Builder refundFee(Double refundFee) {
            instance.setRefundFee(refundFee);
            return this;
        }

        public Builder rateRemark(String rateRemark) {
            instance.setRateRemark(rateRemark);
            return this;
        }

        public WeiXinBill build() {
            WeiXinBill weiXinBill = new WeiXinBill();
            weiXinBill.setTradeTime(instance.getTradeTime());
            weiXinBill.setAppId(instance.getAppId());
            weiXinBill.setMchId(instance.getMchId());
            weiXinBill.setSubMchId(instance.getSubMchId());
            weiXinBill.setDeviceInfo(instance.getDeviceInfo());
            weiXinBill.setTransactionId(instance.getTransactionId());
            weiXinBill.setOutTradeNo(instance.getOutTradeNo());
            weiXinBill.setOpenId(instance.getOpenId());
            weiXinBill.setTradeType(instance.getTradeType());
            weiXinBill.setTradeState(instance.getTradeState());
            weiXinBill.setBankType(instance.getBankType());
            weiXinBill.setFeeType(instance.getFeeType());
            weiXinBill.setSettlementTotalFee(instance.getSettlementTotalFee());
            weiXinBill.setCouponFee(instance.getCouponFee());
            weiXinBill.setRefundId(instance.getRefundId());
            weiXinBill.setOutRefundNo(instance.getOutRefundNo());
            weiXinBill.setSettlementRefundFee(instance.getSettlementRefundFee());
            weiXinBill.setCashRefundFee(instance.getCashRefundFee());
            weiXinBill.setRefundType(instance.getRefundType());
            weiXinBill.setRefundState(instance.getRefundState());
            weiXinBill.setGoodsName(instance.getGoodsName());
            weiXinBill.setDataPacket(instance.getDataPacket());
            weiXinBill.setServiceFee(instance.getServiceFee());
            weiXinBill.setRate(instance.getRate());
            weiXinBill.setTotalFee(instance.getTotalFee());
            weiXinBill.setRefundFee(instance.getRefundFee());
            weiXinBill.setRateRemark(instance.getRateRemark());
            return weiXinBill;
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}