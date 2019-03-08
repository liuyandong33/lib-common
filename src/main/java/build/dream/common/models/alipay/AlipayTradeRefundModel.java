package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class AlipayTradeRefundModel extends AlipayBasicModel {
    @Length(max = 64)
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @Length(max = 64)
    @JsonProperty(value = "trade_no")
    private String tradeNo;

    @NotNull
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000")
    @JsonProperty(value = "refund_amount")
    private BigDecimal refundAmount;

    @JsonProperty(value = "refund_currency")
    private String refundCurrency;

    @Length(max = 256)
    @JsonProperty(value = "refund_reason")
    private String refundReason;

    @Length(max = 64)
    @JsonProperty(value = "out_request_no")
    private String outRequestNo;

    @Length(max = 30)
    @JsonProperty(value = "operator_id")
    private String operatorId;

    @Length(max = 32)
    @JsonProperty(value = "store_id")
    private String storeId;

    @Length(max = 32)
    @JsonProperty(value = "terminal_id")
    private String terminalId;

    @JsonProperty(value = "goods_detail")
    private List<GoodsDetail> goodsDetails;

    @JsonProperty(value = "refund_royalty_parameters")
    private List<OpenApiRoyaltyDetailInfoPojo> refundRoyaltyParameters;

    @Length(max = 16)
    @JsonProperty(value = "org_pid")
    private String orgPid;

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

    public String getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(String orgPid) {
        this.orgPid = orgPid;
    }

    public static class Builder {
        private final AlipayTradeRefundModel instance = new AlipayTradeRefundModel();

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

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder tradeNo(String tradeNo) {
            instance.setTradeNo(tradeNo);
            return this;
        }

        public Builder refundAmount(BigDecimal refundAmount) {
            instance.setRefundAmount(refundAmount);
            return this;
        }

        public Builder refundCurrency(String refundCurrency) {
            instance.setRefundCurrency(refundCurrency);
            return this;
        }

        public Builder refundReason(String refundReason) {
            instance.setRefundReason(refundReason);
            return this;
        }

        public Builder outRequestNo(String outRequestNo) {
            instance.setOutRequestNo(outRequestNo);
            return this;
        }

        public Builder operatorId(String operatorId) {
            instance.setOperatorId(operatorId);
            return this;
        }

        public Builder storeId(String storeId) {
            instance.setStoreId(storeId);
            return this;
        }

        public Builder terminalId(String terminalId) {
            instance.setTerminalId(terminalId);
            return this;
        }

        public Builder goodsDetails(List<GoodsDetail> goodsDetails) {
            instance.setGoodsDetails(goodsDetails);
            return this;
        }

        public Builder refundRoyaltyParameters(List<OpenApiRoyaltyDetailInfoPojo> refundRoyaltyParameters) {
            instance.setRefundRoyaltyParameters(refundRoyaltyParameters);
            return this;
        }

        public AlipayTradeRefundModel build() {
            AlipayTradeRefundModel alipayTradeRefundModel = new AlipayTradeRefundModel();
            alipayTradeRefundModel.setTenantId(instance.getTenantId());
            alipayTradeRefundModel.setBranchId(instance.getBranchId());
            alipayTradeRefundModel.setReturnUrl(instance.getReturnUrl());
            alipayTradeRefundModel.setNotifyUrl(instance.getNotifyUrl());
            alipayTradeRefundModel.setAuthToken(instance.getAuthToken());
            alipayTradeRefundModel.setOutTradeNo(instance.getOutTradeNo());
            alipayTradeRefundModel.setTradeNo(instance.getTradeNo());
            alipayTradeRefundModel.setRefundAmount(instance.getRefundAmount());
            alipayTradeRefundModel.setRefundCurrency(instance.getRefundCurrency());
            alipayTradeRefundModel.setRefundReason(instance.getRefundReason());
            alipayTradeRefundModel.setOutRequestNo(instance.getOutRequestNo());
            alipayTradeRefundModel.setOperatorId(instance.getOperatorId());
            alipayTradeRefundModel.setStoreId(instance.getStoreId());
            alipayTradeRefundModel.setTerminalId(instance.getTerminalId());
            alipayTradeRefundModel.setGoodsDetails(instance.getGoodsDetails());
            alipayTradeRefundModel.setRefundRoyaltyParameters(instance.getRefundRoyaltyParameters());
            alipayTradeRefundModel.setOrgPid(instance.getOrgPid());
            return alipayTradeRefundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
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
        @NotNull
        @Length(max = 32)
        @JsonProperty(value = "goods_id")
        private String goodsId;

        @Length(max = 32)
        @JsonProperty(value = "alipay_goods_id")
        private String alipayGoodsId;

        @NotNull
        @Length(max = 256)
        @JsonProperty(value = "goods_name")
        private String goodsName;

        @NotNull
        private BigDecimal quantity;

        @NotNull
        private BigDecimal price;

        @Length(max = 24)
        @JsonProperty(value = "goods_category")
        private String goodsCategory;

        @Length(max = 128)
        @JsonProperty(value = "categories_tree")
        private String categoriesTree;

        @Length(max = 1000)
        private String body;

        @Length(max = 400)
        @JsonProperty(value = "show_url")
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

        public String getCategoriesTree() {
            return categoriesTree;
        }

        public void setCategoriesTree(String categoriesTree) {
            this.categoriesTree = categoriesTree;
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
        @InList(value = {"transfer", "replenish"})
        @JsonProperty(value = "royalty_type")
        private String royaltyType;

        @Length(max = 16)
        @JsonProperty(value = "trans_out")
        private String transOut;

        @InList(value = {"userId", "loginName"})
        @JsonProperty(value = "trans_out_type")
        private String transOutType;

        @InList(value = {"userId", "cardSerialNo", "loginName"})
        @JsonProperty(value = "trans_in_type")
        private String transInType;

        @Length(max = 16)
        @JsonProperty(value = "trans_in")
        private String transIn;

        private BigDecimal amount;

        @Min(value = 1)
        @Max(value = 100)
        @JsonProperty(value = "amount_percentage")
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
    }
}