package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class AlipayTradeRefundModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @SerializedName(value = "out_trade_no", alternate = "outTradeNo")
    @Length(max = 64)
    private String outTradeNo;

    @SerializedName(value = "trade_no", alternate = "tradeNo")
    @Length(max = 64)
    private String tradeNo;

    @SerializedName(value = "refund_amount", alternate = "refundAmount")
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000")
    private BigDecimal refundAmount;

    @SerializedName(value = "refund_currency", alternate = "refundCurrency")
    private String refundCurrency;

    @SerializedName(value = "refund_reason", alternate = "refundReason")
    @Length(max = 256)
    private String refundReason;

    @SerializedName(value = "out_request_no", alternate = "outRequestNo")
    @Length(max = 64)
    private String outRequestNo;

    @SerializedName(value = "operator_id", alternate = "operatorId")
    @Length(max = 30)
    private String operatorId;

    @SerializedName(value = "store_id", alternate = "storeId")
    @Length(max = 32)
    private String storeId;

    @SerializedName(value = "terminal_id", alternate = "terminalId")
    @Length(max = 32)
    private String terminalId;

    @SerializedName(value = "goods_detail", alternate = "goodsDetail")
    private List<GoodsDetail> goodsDetails;

    @SerializedName(value = "refund_royalty_parameters", alternate = "refundRoyaltyParameters")
    private List<OpenApiRoyaltyDetailInfoPojo> refundRoyaltyParameters;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public List<GoodsDetail> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public List<OpenApiRoyaltyDetailInfoPojo> getRefundRoyaltyParameters() {
        return refundRoyaltyParameters;
    }

    public void setRefundRoyaltyParameters(List<OpenApiRoyaltyDetailInfoPojo> refundRoyaltyParameters) {
        this.refundRoyaltyParameters = refundRoyaltyParameters;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if (CollectionUtils.isNotEmpty(goodsDetails)) {
            for (GoodsDetail goodsDetail : goodsDetails) {
                ApplicationHandler.isTrue(goodsDetail.validate(), "goodsDetails");
            }
        }
        if (CollectionUtils.isNotEmpty(refundRoyaltyParameters)) {
            for (OpenApiRoyaltyDetailInfoPojo refundRoyaltyParameter : refundRoyaltyParameters) {
                ApplicationHandler.isTrue(refundRoyaltyParameter.validate(), "refundRoyaltyParameters");
            }
        }
    }

    public static class GoodsDetail extends BasicModel {
        @SerializedName(value = "goods_id", alternate = "goodsId")
        @NotNull
        @Length(max = 32)
        private String goodsId;

        @SerializedName(value = "alipay_goods_id", alternate = "alipayGoodsId")
        @Length(max = 32)
        private String alipayGoodsId;

        @SerializedName(value = "goods_name", alternate = "goodsName")
        @NotNull
        @Length(max = 256)
        private String goodsName;

        @NotNull
        private BigDecimal quantity;

        @NotNull
        private BigDecimal price;

        @SerializedName(value = "goods_category", alternate = "goodsCategory")
        @Length(max = 24)
        private String goodsCategory;

        @Length(max = 1000)
        private String body;

        @SerializedName(value = "show_url", alternate = "showUrl")
        @Length(max = 400)
        private String showUrl;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getAlipayGoodsId() {
            return alipayGoodsId;
        }

        public void setAlipayGoodsId(String alipayGoodsId) {
            this.alipayGoodsId = alipayGoodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public BigDecimal getQuantity() {
            return quantity;
        }

        public void setQuantity(BigDecimal quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getGoodsCategory() {
            return goodsCategory;
        }

        public void setGoodsCategory(String goodsCategory) {
            this.goodsCategory = goodsCategory;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getShowUrl() {
            return showUrl;
        }

        public void setShowUrl(String showUrl) {
            this.showUrl = showUrl;
        }
    }

    private static class OpenApiRoyaltyDetailInfoPojo extends BasicModel {
        private static final String[] ROYALTY_TYPES = {"transfer", "replenish"};
        private static final String[] TRANS_OUT_TYPES = {"userId", "loginName"};
        private static final String[] TRANS_IN_TYPES = {"userId", "cardSerialNo", "loginName"};

        @SerializedName(value = "royalty_type", alternate = "royaltyType")
        private String royaltyType;

        @SerializedName(value = "trans_out", alternate = "transOut")
        @Length(max = 16)
        private String transOut;

        @SerializedName(value = "trans_out_type", alternate = "transOutType")
        private String transOutType;

        @SerializedName(value = "trans_in_type", alternate = "transInType")
        private String transInType;

        @SerializedName(value = "trans_in", alternate = "transIn")
        @Length(max = 16)
        private String transIn;

        private BigDecimal amount;

        @SerializedName(value = "amount_percentage", alternate = "amountPercentage")
        @Min(value = 1)
        @Max(value = 100)
        private Integer amountPercentage;

        @Length(max = 1000)
        private String desc;

        public String getRoyaltyType() {
            return royaltyType;
        }

        public void setRoyaltyType(String royaltyType) {
            this.royaltyType = royaltyType;
        }

        public String getTransOut() {
            return transOut;
        }

        public void setTransOut(String transOut) {
            this.transOut = transOut;
        }

        public String getTransOutType() {
            return transOutType;
        }

        public void setTransOutType(String transOutType) {
            this.transOutType = transOutType;
        }

        public String getTransInType() {
            return transInType;
        }

        public void setTransInType(String transInType) {
            this.transInType = transInType;
        }

        public String getTransIn() {
            return transIn;
        }

        public void setTransIn(String transIn) {
            this.transIn = transIn;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public Integer getAmountPercentage() {
            return amountPercentage;
        }

        public void setAmountPercentage(Integer amountPercentage) {
            this.amountPercentage = amountPercentage;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public boolean validate() {
            boolean isOk = super.validate();
            if (!isOk) {
                return false;
            }
            if (StringUtils.isNotBlank(royaltyType)) {
                isOk = ArrayUtils.contains(ROYALTY_TYPES, royaltyType);
                if (!isOk) {
                    return false;
                }
            }
            if (StringUtils.isNotBlank(transOutType)) {
                isOk = ArrayUtils.contains(TRANS_OUT_TYPES, transOutType);
                if (!isOk) {
                    return false;
                }
            }
            if (StringUtils.isNotBlank(transInType)) {
                isOk = ArrayUtils.contains(TRANS_IN_TYPES, transInType);
                if (!isOk) {
                    return false;
                }
            }
            return true;
        }
    }
}
