package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayTradePagePayModel extends BasicModel {
    private static final String[] GOODS_TYPES = {"0", "1"};
    private static final String[] QR_PAY_MODES = {"0", "1", "2", "3", "4"};
    @NotNull
    @Length(max = 64)
    @SerializedName(value = "out_trade_no", alternate = "outTradeNo")
    private String out_trade_no;

    @NotNull
    @Length(max = 64)
    @SerializedName(value = "product_code", alternate = "productCode")
    private String product_code;

    @NotNull
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000")
    @SerializedName(value = "total_amount", alternate = "totalAmount")
    private BigDecimal totalAmount;

    @NotNull
    @Length(max = 256)
    private String subject;

    @Length(max = 128)
    private String body;

    @SerializedName(value = "goods_detail", alternate = "goodsDetail")
    private String goodsDetail;

    @Length(max = 512)
    @SerializedName(value = "passback_params", alternate = "passbackParams")
    private String passbackParams;

    @SerializedName(value = "goods_type", alternate = "goodsType")
    private String goodsType;

    @Length(max = 6)
    @SerializedName(value = "timeout_express", alternate = "timeoutExpress")
    private String timeoutExpress;

    @Length(max = 128)
    @SerializedName(value = "enable_pay_channels", alternate = "enablePayChannels")
    private String enablePayChannels;

    @Length(max = 128)
    @SerializedName(value = "disable_pay_channels", alternate = "disablePayChannels")
    private String disablePayChannels;

    @Length(max = 40)
    @SerializedName(value = "auth_token", alternate = "authToken")
    private String authToken;

    @SerializedName(value = "qr_pay_mode", alternate = "qrPayMode")
    private String qrPayMode;

    @SerializedName(value = "qrcode_width", alternate = "qrcodeWidth")
    private String qrcodeWidth;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getPassbackParams() {
        return passbackParams;
    }

    public void setPassbackParams(String passbackParams) {
        this.passbackParams = passbackParams;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getEnablePayChannels() {
        return enablePayChannels;
    }

    public void setEnablePayChannels(String enablePayChannels) {
        this.enablePayChannels = enablePayChannels;
    }

    public String getDisablePayChannels() {
        return disablePayChannels;
    }

    public void setDisablePayChannels(String disablePayChannels) {
        this.disablePayChannels = disablePayChannels;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getQrPayMode() {
        return qrPayMode;
    }

    public void setQrPayMode(String qrPayMode) {
        this.qrPayMode = qrPayMode;
    }

    public String getQrcodeWidth() {
        return qrcodeWidth;
    }

    public void setQrcodeWidth(String qrcodeWidth) {
        this.qrcodeWidth = qrcodeWidth;
    }

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(goodsType) ? ArrayUtils.contains(GOODS_TYPES, goodsType) : true) && (StringUtils.isNotBlank(qrPayMode) ? ArrayUtils.contains(QR_PAY_MODES, qrPayMode) : true);
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if (StringUtils.isNotBlank(goodsType)) {
            ApplicationHandler.inArray(GOODS_TYPES, goodsType, "goodsType");
        }
        if (StringUtils.isNotBlank(qrPayMode)) {
            ApplicationHandler.inArray(QR_PAY_MODES, qrPayMode, "qrPayMode");
        }
    }
}
