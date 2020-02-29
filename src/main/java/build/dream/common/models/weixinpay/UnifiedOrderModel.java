package build.dream.common.models.weixinpay;

import build.dream.common.beans.MqConfig;
import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UnifiedOrderModel extends WeiXinPayBasicModel {
    @Length(max = 32)
    private String deviceInfo;

    @NotNull
    @InList(value = {Constants.MD5, Constants.HMAC_SHA256})
    private String signType = Constants.MD5;

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

    @InList(value = {Constants.CNY})
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
    private MqConfig mqConfig;

    private String tradeType;

    @Length(max = 32)
    private String productId;

    @InList(value = {Constants.LIMIT_PAY_NO_CREDIT})
    private String limitPay;

    @Length(max = 128)
    private String openId;

    @Length(max = 128)
    private String subOpenId;

    private SceneInfoModel sceneInfoModel;

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

    public MqConfig getMqConfig() {
        return mqConfig;
    }

    public void setMqConfig(MqConfig mqConfig) {
        this.mqConfig = mqConfig;
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
        if (Objects.nonNull(sceneInfoModel)) {
            ApplicationHandler.isTrue(sceneInfoModel.validate(), "sceneInfo");
        }
    }

    public static class SceneInfoModel extends BasicModel {
        @SerializedName(value = "store_info", alternate = "storeInfo")
        @JsonProperty(value = "store_info")
        private StoreInfoModel storeInfoModel;

        @SerializedName(value = "h5_info", alternate = "h5Info")
        @JsonProperty(value = "h5_info")
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
            if (Objects.nonNull(storeInfoModel) && !storeInfoModel.validate()) {
                return false;
            }
            if (Objects.nonNull(h5InfoModel) && !h5InfoModel.validate()) {
                return false;
            }
            return true;
        }

        @Override
        public void validateAndThrow() {
            super.validateAndThrow();
            if (Objects.nonNull(storeInfoModel)) {
                storeInfoModel.validateAndThrow();
            }
            if (Objects.nonNull(h5InfoModel)) {
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
        @JsonProperty(value = "area_code")
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
        @JsonProperty(value = "wap_url")
        private String wapUrl;

        @NotNull
        @SerializedName(value = "wap_name", alternate = "wapName")
        @JsonProperty(value = "wap_name")
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

    public static class Builder extends WeiXinPayBasicModel.Builder<Builder, UnifiedOrderModel> {
        public Builder deviceInfo(String deviceInfo) {
            instance.setDeviceInfo(deviceInfo);
            return this;
        }

        public Builder signType(String signType) {
            instance.setSignType(signType);
            return this;
        }

        public Builder body(String body) {
            instance.setBody(body);
            return this;
        }

        public Builder detail(String detail) {
            instance.setDetail(detail);
            return this;
        }

        public Builder attach(String attach) {
            instance.setAttach(attach);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder feeType(String feeType) {
            instance.setFeeType(feeType);
            return this;
        }

        public Builder totalFee(Integer totalFee) {
            instance.setTotalFee(totalFee);
            return this;
        }

        public Builder spbillCreateIp(String spbillCreateIp) {
            instance.setSpbillCreateIp(spbillCreateIp);
            return this;
        }

        public Builder timeStart(String timeStart) {
            instance.setTimeStart(timeStart);
            return this;
        }

        public Builder timeExpire(String timeExpire) {
            instance.setTimeExpire(timeExpire);
            return this;
        }

        public Builder goodsTag(String goodsTag) {
            instance.setGoodsTag(goodsTag);
            return this;
        }

        public Builder mqConfig(MqConfig mqConfig) {
            instance.setMqConfig(mqConfig);
            return this;
        }

        public Builder tradeType(String tradeType) {
            instance.setTradeType(tradeType);
            return this;
        }

        public Builder productId(String productId) {
            instance.setProductId(productId);
            return this;
        }

        public Builder limitPay(String limitPay) {
            instance.setLimitPay(limitPay);
            return this;
        }

        public Builder openId(String openId) {
            instance.setOpenId(openId);
            return this;
        }

        public Builder subOpenId(String subOpenId) {
            instance.setSubOpenId(subOpenId);
            return this;
        }

        public Builder sceneInfoModel(SceneInfoModel sceneInfoModel) {
            instance.setSceneInfoModel(sceneInfoModel);
            return this;
        }

        @Override
        public UnifiedOrderModel build() {
            UnifiedOrderModel unifiedOrderModel = super.build();
            unifiedOrderModel.setDeviceInfo(instance.getDeviceInfo());
            unifiedOrderModel.setSignType(instance.getSignType());
            unifiedOrderModel.setBody(instance.getBody());
            unifiedOrderModel.setDetail(instance.getDetail());
            unifiedOrderModel.setAttach(instance.getAttach());
            unifiedOrderModel.setOutTradeNo(instance.getOutTradeNo());
            unifiedOrderModel.setFeeType(instance.getFeeType());
            unifiedOrderModel.setTotalFee(instance.getTotalFee());
            unifiedOrderModel.setSpbillCreateIp(instance.getSpbillCreateIp());
            unifiedOrderModel.setTimeStart(instance.getTimeStart());
            unifiedOrderModel.setTimeExpire(instance.getTimeExpire());
            unifiedOrderModel.setGoodsTag(instance.getGoodsTag());
            unifiedOrderModel.setMqConfig(instance.getMqConfig());
            unifiedOrderModel.setTradeType(instance.getTradeType());
            unifiedOrderModel.setProductId(instance.getProductId());
            unifiedOrderModel.setLimitPay(instance.getLimitPay());
            unifiedOrderModel.setOpenId(instance.getOpenId());
            unifiedOrderModel.setSubOpenId(instance.getSubOpenId());
            unifiedOrderModel.setSceneInfoModel(instance.getSceneInfoModel());
            return unifiedOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}