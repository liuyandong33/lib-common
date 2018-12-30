package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayTradeAppPayModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @JsonIgnore
    private String notifyUrl;

    @Length(max = 6)
    @SerializedName(value = "timeout_express", alternate = "timeoutExpress")
    @JsonProperty(value = "timeout_express")
    private String timeoutExpress;

    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000")
    @SerializedName(value = "total_amount", alternate = "totalAmount")
    @JsonProperty(value = "total_amount")
    private BigDecimal totalAmount;

    @Length(max = 16)
    @SerializedName(value = "seller_id", alternate = "sellerId")
    @JsonProperty(value = "seller_id")
    private String sellerId;

    @Length(max = 64)
    @SerializedName(value = "product_code", alternate = "productCode")
    @JsonProperty(value = "product_code")
    private String productCode;

    @Length(max = 128)
    private String body;

    @Length(max = 256)
    private String subject;

    @Length(max = 64)
    @SerializedName(value = "out_trade_no", alternate = "outTradeNo")
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @Length(min = 15, max = 15)
    @SerializedName(value = "time_expire", alternate = "timeExpire")
    @JsonProperty(value = "time_expire")
    private String timeExpire;

    @InList(value = {"0", "1"})
    @SerializedName(value = "goods_type", alternate = "goodsType")
    @JsonProperty(value = "goods_type")
    private String goodsType;

    @Length(max = 512)
    @SerializedName(value = "promo_params", alternate = "promoParams")
    @JsonProperty(value = "promo_params")
    private String promo_params;

    @Length(max = 512)
    @SerializedName(value = "passback_params", alternate = "passbackParams")
    @JsonProperty(value = "passback_params")
    private String passback_params;

    public static class RoyaltyInfo extends BasicModel {
        @InList(value = {"ROYALTY"})
        @SerializedName(value = "royalty_type", alternate = "royaltyType")
        private String royaltyType;
    }

    public static class RoyaltyDetailInfo extends BasicModel {
        private Integer serial_no;
    }
}
