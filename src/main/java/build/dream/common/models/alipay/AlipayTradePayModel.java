package build.dream.common.models.alipay;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.GsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class AlipayTradePayModel extends AlipayBasicModel {
    private static final String[] SCENES = {Constants.SCENE_BAR_CODE, Constants.SCENE_WAVE_CODE};
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    private String scene;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "auth_code")
    private String authCode;

    @Length(max = 32)
    @JsonProperty(value = "product_code")
    private String productCode;

    @NotNull
    @Length(max = 256)
    private String subject;

    @Length(max = 28)
    @JsonProperty(value = "buyer_id")
    private String buyerId;

    @Length(max = 28)
    @JsonProperty(value = "seller_id")
    private String sellerId;

    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000")
    @JsonProperty(value = "total_amount")
    private BigDecimal totalAmount;

    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000")
    @JsonProperty(value = "discountable_amount")
    private BigDecimal discountableAmount;

    @Length(max = 128)
    private String body;

    @JsonProperty(value = "goods_detail")
    private List<GoodsDetail> goodsDetails;

    @Length(max = 28)
    @JsonProperty(value = "operator_id")
    private String operatorId;

    @Length(max = 32)
    @JsonProperty(value = "store_id")
    private String storeId;

    @Length(max = 32)
    @JsonProperty(value = "terminal_id")
    private String terminalId;

    @JsonProperty(value = "extend_params")
    private ExtendParams extendParams;

    @Length(max = 6)
    @JsonProperty(value = "timeout_express")
    private String timeoutExpress;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountableAmount() {
        return discountableAmount;
    }

    public void setDiscountableAmount(BigDecimal discountableAmount) {
        this.discountableAmount = discountableAmount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<GoodsDetail> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        ApplicationHandler.validateJson(goodsDetails, Constants.ALIPAY_GOODS_DETAILS_SCHEMA_FILE_PATH, "goodsDetails");
        this.goodsDetails = GsonUtils.fromJsonToList(goodsDetails, GoodsDetail.class);
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

    public ExtendParams getExtendParams() {
        return extendParams;
    }

    public void setExtendParams(ExtendParams extendParams) {
        this.extendParams = extendParams;
    }

    public void setExtendParams(String extendParams) {
        ApplicationHandler.validateJson(extendParams, Constants.ALIPAY_EXTEND_PARAMS_SCHEMA_FILE_PATH, "extendParams");
        this.extendParams = GsonUtils.fromJson(extendParams, ExtendParams.class);
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ApplicationHandler.inArray(SCENES, scene, "scene");
    }

    public static class GoodsDetail extends BasicModel {
        @JsonProperty(value = "goods_id")
        private String goodsId;

        @JsonProperty(value = "goods_name")
        private String goodsName;

        private String quantity;

        private String price;

        @JsonProperty(value = "goods_category")
        private String goodsCategory;

        private String body;

        @JsonProperty(value = "show_url")
        private String showUrl;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
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

    public static class ExtendParams extends BasicModel {
        @Length(max = 64)
        @JsonProperty(value = "sys_service_provider_id")
        private String sysServiceProviderId;

        public String getSysServiceProviderId() {
            return sysServiceProviderId;
        }

        public void setSysServiceProviderId(String sysServiceProviderId) {
            this.sysServiceProviderId = sysServiceProviderId;
        }
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayTradePayModel> {
        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder scene(String scene) {
            instance.setScene(scene);
            return this;
        }

        public Builder authCode(String authCode) {
            instance.setAuthCode(authCode);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder subject(String subject) {
            instance.setSubject(subject);
            return this;
        }

        public Builder buyerId(String buyerId) {
            instance.setBuyerId(buyerId);
            return this;
        }

        public Builder sellerId(String sellerId) {
            instance.setSellerId(sellerId);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountableAmount(BigDecimal discountableAmount) {
            instance.setDiscountableAmount(discountableAmount);
            return this;
        }

        public Builder body(String body) {
            instance.setBody(body);
            return this;
        }

        public Builder goodsDetails(List<GoodsDetail> goodsDetails) {
            instance.setGoodsDetails(goodsDetails);
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

        public Builder extendParams(ExtendParams extendParams) {
            instance.setExtendParams(extendParams);
            return this;
        }

        public Builder timeoutExpress(String timeoutExpress) {
            instance.setTimeoutExpress(timeoutExpress);
            return this;
        }

        @Override
        public AlipayTradePayModel build() {
            AlipayTradePayModel alipayTradePayModel = super.build();
            alipayTradePayModel.setOutTradeNo(instance.getOutTradeNo());
            alipayTradePayModel.setScene(instance.getScene());
            alipayTradePayModel.setAuthCode(instance.getAuthCode());
            alipayTradePayModel.setProductCode(instance.getProductCode());
            alipayTradePayModel.setSubject(instance.getSubject());
            alipayTradePayModel.setBuyerId(instance.getBuyerId());
            alipayTradePayModel.setSellerId(instance.getSellerId());
            alipayTradePayModel.setTotalAmount(instance.getTotalAmount());
            alipayTradePayModel.setDiscountableAmount(instance.getDiscountableAmount());
            alipayTradePayModel.setBody(instance.getBody());
            alipayTradePayModel.setGoodsDetails(instance.getGoodsDetails());
            alipayTradePayModel.setOperatorId(instance.getOperatorId());
            alipayTradePayModel.setStoreId(instance.getStoreId());
            alipayTradePayModel.setTerminalId(instance.getTerminalId());
            alipayTradePayModel.setExtendParams(instance.getExtendParams());
            alipayTradePayModel.setTimeoutExpress(instance.getTimeoutExpress());
            return alipayTradePayModel;
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}