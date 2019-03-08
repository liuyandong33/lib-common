package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class MyBankPaymentTradeOrderCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "partner_id")
    private String partnerId;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "recon_related_no")
    private String reconRelatedNo;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "pd_code")
    private String pdCode;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "ev_code")
    private String evCode;

    @DecimalMin(value = "1")
    @DecimalMax(value = "100000000")
    @JsonProperty(value = "total_amount")
    private BigDecimal totalAmount;

    @Length(max = 16)
    @JsonProperty(value = "currency_code")
    private String currencyCode;

    @NotEmpty
    @JsonProperty(value = "goods_info")
    private List<GoodsInfo> goodsInfos;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "seller_id")
    private String sellerId;

    @NotNull
    @InList(value = {"pay", "refund"})
    @JsonProperty(value = "pay_type")
    private String payType;

    @NotNull
    @Length(min = 19, max = 19)
    @JsonProperty(value = "pay_date")
    private String payDate;

    @Length(max = 256)
    private String remark;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getReconRelatedNo() {
        return reconRelatedNo;
    }

    public void setReconRelatedNo(String reconRelatedNo) {
        this.reconRelatedNo = reconRelatedNo;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getEvCode() {
        return evCode;
    }

    public void setEvCode(String evCode) {
        this.evCode = evCode;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<GoodsInfo> getGoodsInfos() {
        return goodsInfos;
    }

    public void setGoodsInfos(List<GoodsInfo> goodsInfos) {
        this.goodsInfos = goodsInfos;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder {
        private final MyBankPaymentTradeOrderCreateModel instance = new MyBankPaymentTradeOrderCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder partnerId(String partnerId) {
            instance.setPartnerId(partnerId);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder reconRelatedNo(String reconRelatedNo) {
            instance.setReconRelatedNo(reconRelatedNo);
            return this;
        }

        public Builder pdCode(String pdCode) {
            instance.setPdCode(pdCode);
            return this;
        }

        public Builder evCode(String evCode) {
            instance.setEvCode(evCode);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            instance.setCurrencyCode(currencyCode);
            return this;
        }

        public Builder goodsInfos(List<GoodsInfo> goodsInfos) {
            instance.setGoodsInfos(goodsInfos);
            return this;
        }

        public Builder sellerId(String sellerId) {
            instance.setSellerId(sellerId);
            return this;
        }

        public Builder payType(String payType) {
            instance.setPayType(payType);
            return this;
        }

        public Builder payDate(String payDate) {
            instance.setPayDate(payDate);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        public MyBankPaymentTradeOrderCreateModel build() {
            MyBankPaymentTradeOrderCreateModel myBankPaymentTradeOrderCreateModel = new MyBankPaymentTradeOrderCreateModel();
            myBankPaymentTradeOrderCreateModel.setTenantId(instance.getTenantId());
            myBankPaymentTradeOrderCreateModel.setBranchId(instance.getBranchId());
            myBankPaymentTradeOrderCreateModel.setReturnUrl(instance.getReturnUrl());
            myBankPaymentTradeOrderCreateModel.setNotifyUrl(instance.getNotifyUrl());
            myBankPaymentTradeOrderCreateModel.setAuthToken(instance.getAuthToken());
            myBankPaymentTradeOrderCreateModel.setPartnerId(instance.getPartnerId());
            myBankPaymentTradeOrderCreateModel.setOutTradeNo(instance.getOutTradeNo());
            myBankPaymentTradeOrderCreateModel.setReconRelatedNo(instance.getReconRelatedNo());
            myBankPaymentTradeOrderCreateModel.setPdCode(instance.getPdCode());
            myBankPaymentTradeOrderCreateModel.setEvCode(instance.getEvCode());
            myBankPaymentTradeOrderCreateModel.setTotalAmount(instance.getTotalAmount());
            myBankPaymentTradeOrderCreateModel.setCurrencyCode(instance.getCurrencyCode());
            myBankPaymentTradeOrderCreateModel.setGoodsInfos(instance.getGoodsInfos());
            myBankPaymentTradeOrderCreateModel.setSellerId(instance.getSellerId());
            myBankPaymentTradeOrderCreateModel.setPayType(instance.getPayType());
            myBankPaymentTradeOrderCreateModel.setPayDate(instance.getPayDate());
            myBankPaymentTradeOrderCreateModel.setRemark(instance.getRemark());
            return myBankPaymentTradeOrderCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class GoodsInfo extends BasicModel {
        @NotNull
        @Length(max = 256)
        @JsonProperty(value = "goods_name")
        private String goodsName;

        @NotNull
        @DecimalMin(value = "0.01")
        @DecimalMax(value = "99999999999")
        @JsonProperty(value = "goods_price")
        private BigDecimal goodsPrice;

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public BigDecimal getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(BigDecimal goodsPrice) {
            this.goodsPrice = goodsPrice;
        }
    }
}
