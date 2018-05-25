package build.dream.common.models.alipay;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.GsonUtils;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayTradePayModel extends BasicModel {
    private static final String[] SCENES = {"bar_code", "wave_code"};
    @NotNull
    @Length(max = 64)
    @SerializedName(value = "out_trade_no", alternate = "outTradeNo")
    private String outTradeNo;

    private String scene;

    @NotNull
    @Length(max = 32)
    @SerializedName(value = "auth_code", alternate = "authCode")
    private String authCode;

    @Length(max = 32)
    @SerializedName(value = "product_code", alternate = "productCode")
    private String productCode;

    @NotNull
    @Length(max = 256)
    private String subject;

    @Length(max = 28)
    @SerializedName(value = "buyer_id", alternate = "buyerId")
    private String buyerId;

    @Length(max = 28)
    @SerializedName(value = "seller_id", alternate = "sellerId")
    private String sellerId;

    @Length(max = 11)
    @SerializedName(value = "total_amount", alternate = "totalAmount")
    private String totalAmount;

    @Length(max = 11)
    @SerializedName(value = "discountable_amount", alternate = "discountableAmount")
    private String discountableAmount;

    @Length(max = 128)
    private String body;

    @SerializedName(value = "goods_detail", alternate = "goodsDetails")
    private List<GoodsDetail> goodsDetails;

    @Length(max = 28)
    @SerializedName(value = "operator_id", alternate = "operatorId")
    private String operatorId;

    @Length(max = 32)
    @SerializedName(value = "store_id", alternate = "storeId")
    private String storeId;

    @Length(max = 32)
    @SerializedName(value = "terminal_id", alternate = "terminalId")
    private String terminalId;

    @SerializedName(value = "extend_params", alternate = "extendParams")
    private ExtendParams extendParams;

    @Length(max = 6)
    @SerializedName(value = "timeout_express", alternate = "timeoutExpress")
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDiscountableAmount() {
        return discountableAmount;
    }

    public void setDiscountableAmount(String discountableAmount) {
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
        this.goodsDetails = GsonUtils.jsonToList(goodsDetails, GoodsDetail.class);
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

    public static class GoodsDetail {
        @SerializedName(value = "goods_id", alternate = "goodsId")
        private String goodsId;

        @SerializedName(value = "goods_name", alternate = "goodsName")
        private String goodsName;

        private String quantity;

        private String price;

        @SerializedName(value = "goods_category", alternate = "goodsCategory")
        private String goodsCategory;

        private String body;

        @SerializedName(value = "show_url", alternate = "showUrl")
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

    public static class ExtendParams {
        @Length(max = 64)
        @SerializedName(value = "sys_service_provider_id", alternate = "sysServiceProviderId")
        private String sysServiceProviderId;

        public String getSysServiceProviderId() {
            return sysServiceProviderId;
        }

        public void setSysServiceProviderId(String sysServiceProviderId) {
            this.sysServiceProviderId = sysServiceProviderId;
        }
    }
}
