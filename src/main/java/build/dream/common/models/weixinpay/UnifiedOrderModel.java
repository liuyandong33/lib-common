package build.dream.common.models.weixinpay;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class UnifiedOrderModel extends BasicModel {
    private static final String[] TRADE_TYPES = {Constants.WEI_XIN_PAY_TRADE_TYPE_JSAPI, Constants.WEI_XIN_PAY_TRADE_TYPE_MINI_PROGRAM, Constants.WEI_XIN_PAY_TRADE_TYPE_NATIVE, Constants.WEI_XIN_PAY_TRADE_TYPE_APP, Constants.WEI_XIN_PAY_TRADE_TYPE_MWEB};
    private static final String[] SIGN_TYPES = {"MD5", "HMAC-SHA256"};
    private static final String[] FEE_TYPES = {"CNY"};
    private static final String[] LIMIT_PAYS = {"no_credit"};
    @NotNull
    private BigInteger userId;

    @Length(max = 32)
    private String deviceInfo;

    private String signType;

    @NotNull
    @Length(max = 128)
    private String body;

    @Length(max = 6000)
    private String detail;

    @Length(max = 127)
    private String attach;

    @NotNull
    @Length(max = 32)
    private String outTradeNo;

    private String feeType;

    @NotNull
    private Integer totalFee;

    @NotNull
    @Length(max = 16)
    private String spbillCreateIp;

    @Length(min = 14, max = 14)
    private String timeStart;

    @Length(min = 14, max = 14)
    private String timeExpire;

    @Length(max = 32)
    private String goodsTag;

    @NotNull
    @Length(max = 256)
    private String notifyUrl;

    private String tradeType;

    @Length(max = 32)
    private String productId;

    private String limitPay;

    @Length(max = 128)
    private String openId;

    @Length(max = 128)
    private String subOpenId;

    private SceneInfoModel sceneInfoModel;

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSubOpenId() {
        return subOpenId;
    }

    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }

    public SceneInfoModel getSceneInfoModel() {
        return sceneInfoModel;
    }

    public void setSceneInfoModel(SceneInfoModel sceneInfoModel) {
        this.sceneInfoModel = sceneInfoModel;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ApplicationHandler.inArray(SIGN_TYPES, signType, "signType");
        if (StringUtils.isNotBlank(feeType)) {
            ApplicationHandler.inArray(FEE_TYPES, feeType, "feeType");
        }
        ApplicationHandler.inArray(TRADE_TYPES, tradeType, "tradeType");
        if (StringUtils.isNotBlank(limitPay)) {
            ApplicationHandler.inArray(LIMIT_PAYS, limitPay, "limitPay");
        }
        if (sceneInfoModel != null) {
            ApplicationHandler.isTrue(sceneInfoModel.validate(), "sceneInfo");
        }
    }

    public static class SceneInfoModel extends BasicModel {
        @SerializedName(value = "store_info", alternate = "storeInfo")
        private StoreInfoModel storeInfoModel;
        @SerializedName(value = "h5_info", alternate = "h5Info")
        private H5InfoModel h5InfoModel;

        public StoreInfoModel getStoreInfoModel() {
            return storeInfoModel;
        }

        public void setStoreInfoModel(StoreInfoModel storeInfoModel) {
            this.storeInfoModel = storeInfoModel;
        }

        @Override
        public boolean validate() {
            if (!super.validate()) {
                return false;
            }
            if (storeInfoModel != null && !storeInfoModel.validate()) {
                return false;
            }
            if (h5InfoModel != null && !h5InfoModel.validate()) {
                return false;
            }
            return true;
        }

        @Override
        public void validateAndThrow() {
            super.validateAndThrow();
            if (storeInfoModel != null) {
                storeInfoModel.validateAndThrow();
            }
            if (h5InfoModel != null) {
                h5InfoModel.validateAndThrow();
            }
        }
    }

    public static class StoreInfoModel extends BasicModel {
        @Length(max = 32)
        private String id;

        @Length(max = 64)
        private String name;

        @Length(max = 6)
        @SerializedName(value = "area_code", alternate = "areaCode")
        private String areaCode;

        @Length(max = 128)
        private String address;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static class H5InfoModel extends BasicModel {
        @NotNull
        private String type;
        @NotNull
        @SerializedName(value = "wap_url", alternate = "wapUrl")
        private String wapUrl;
        @NotNull
        @SerializedName(value = "wap_name", alternate = "wapName")
        private String wapName;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getWapUrl() {
            return wapUrl;
        }

        public void setWapUrl(String wapUrl) {
            this.wapUrl = wapUrl;
        }

        public String getWapName() {
            return wapName;
        }

        public void setWapName(String wapName) {
            this.wapName = wapName;
        }
    }
}
