package build.dream.common.models.data;

import build.dream.common.constants.Constants;
import build.dream.common.utils.NotifyUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ReAddOrderModel extends DadaBasicModel {
    /**
     * 门店编号，门店创建后可在门店列表和单页查看
     */
    @NotNull
    @JsonProperty(value = "shop_no")
    private String shopNo;

    /**
     * 第三方订单ID
     */
    @NotNull
    @JsonProperty(value = "origin_id")
    private String originId;

    /**
     * 订单所在城市的code
     */
    @NotNull
    @JsonProperty(value = "city_code")
    private String cityCode;

    /**
     * 订单金额
     */
    @NotNull
    @JsonProperty(value = "cargo_price")
    private Double cargoPrice;

    /**
     * 是否需要垫付 1:是 0:否 (垫付订单金额，非运费)
     */
    @NotNull
    @JsonProperty(value = "is_prepay")
    private Integer isPrepay;

    /**
     * 收货人姓名
     */
    @NotNull
    @JsonProperty(value = "receiver_name")
    private String receiverName;

    /**
     * 收货人地址
     */
    @NotNull
    @JsonProperty(value = "receiver_address")
    private String receiverAddress;

    /**
     * 收货人地址维度（高德坐标系）
     */
    @NotNull
    @JsonProperty(value = "receiver_lat")
    private Double receiverLat;

    /**
     * 收货人地址经度（高德坐标系）
     */
    @NotNull
    @JsonProperty(value = "receiver_lng")
    private Double receiverLng;

    /**
     * 回调URL
     */
    @NotNull
    private String callback = NotifyUtils.obtainNotifyUrl(Constants.NOTIFY_TYPE_DADA_ORDER_CALLBACK, "order_id");

    @NotNull
    private String topic;

    /**
     * 收货人手机号（手机号和座机号必填一项）
     */
    @JsonProperty(value = "receiver_phone")
    private String receiverPhone;

    /**
     * 收货人座机号（手机号和座机号必填一项）
     */
    @JsonProperty(value = "receiver_tel")
    private String receiverTel;

    /**
     * 小费（单位：元，精确小数点后一位）
     */
    private Double tips;

    /**
     * 订单备注
     */
    private String info;

    /**
     * 订单商品类型：食品小吃-1,饮料-2,鲜花-3,文印票务-8,便利店-9,水果生鲜-13,同城电商-19, 医药-20,蛋糕-21,酒品-24,小商品市场-25,服装-26,汽修零配-27,数码-28,小龙虾-29, 其他-5
     */
    @JsonProperty(value = "cargo_type")
    private Integer cargoType;

    /**
     * 订单重量（单位：Kg）
     */
    @JsonProperty(value = "cargo_weight")
    private Double cargoWeight;

    /**
     * 订单商品数量
     */
    @JsonProperty(value = "cargo_num")
    private Integer cargoNum;

    /**
     * 发票抬头
     */
    @JsonProperty(value = "invoice_title")
    private String invoiceTitle;

    /**
     * 订单来源标示（该字段可以显示在达达app订单详情页面，只支持字母，最大长度为10）
     */
    @Length(max = 10)
    @JsonProperty(value = "origin_mark")
    private String originMark;

    /**
     * 订单来源编号（该字段可以显示在达达app订单详情页面，支持字母和数字，最大长度为30）
     */
    @Length(max = 30)
    @JsonProperty(value = "origin_mark_no")
    private String originMarkNo;

    /**
     * 是否使用保价费（0：不使用保价，1：使用保价； 同时，请确保填写了订单金额（cargo_price））
     * 商品保价费(当商品出现损坏，可获取一定金额的赔付)
     * 保费=配送物品实际价值*费率（5‰），配送物品价值及最高赔付不超过10000元， 最高保费为50元（物品价格最小单位为100元，不足100元部分按100元认定，保价费向上取整数， 如：物品声明价值为201元，保价费为300元*5‰=1.5元，取整数为2元。）
     * 若您选择不保价，若物品出现丢失或损毁，最高可获得平台30元优惠券。 （优惠券直接存入用户账户中）。
     */
    @JsonProperty(value = "is_use_insurance")
    private Integer isUseInsurance;

    /**
     * 收货码（0：不需要；1：需要。收货码的作用是：骑手必须输入收货码才能完成订单妥投）
     */
    @JsonProperty(value = "is_finish_code_needed")
    private Integer isFinishCodeNeeded;

    /**
     * 预约发单时间（预约时间unix时间戳(10位),精确到分;整10分钟为间隔，并且需要至少提前20分钟预约。）
     */
    @JsonProperty(value = "delay_publish_time")
    private Integer delayPublishTime;

    /**
     * 是否选择直拿直送（0：不需要；1：需要。选择直拿直送后，同一时间骑士只能配送此订单至完成，同时，也会相应的增加配送费用）
     */
    @JsonProperty(value = "is_direct_delivery")
    private Integer isDirectDelivery;

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Double getCargoPrice() {
        return cargoPrice;
    }

    public void setCargoPrice(Double cargoPrice) {
        this.cargoPrice = cargoPrice;
    }

    public Integer getIsPrepay() {
        return isPrepay;
    }

    public void setIsPrepay(Integer isPrepay) {
        this.isPrepay = isPrepay;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Double getReceiverLat() {
        return receiverLat;
    }

    public void setReceiverLat(Double receiverLat) {
        this.receiverLat = receiverLat;
    }

    public Double getReceiverLng() {
        return receiverLng;
    }

    public void setReceiverLng(Double receiverLng) {
        this.receiverLng = receiverLng;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public Double getTips() {
        return tips;
    }

    public void setTips(Double tips) {
        this.tips = tips;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCargoType() {
        return cargoType;
    }

    public void setCargoType(Integer cargoType) {
        this.cargoType = cargoType;
    }

    public Double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public Integer getCargoNum() {
        return cargoNum;
    }

    public void setCargoNum(Integer cargoNum) {
        this.cargoNum = cargoNum;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getOriginMark() {
        return originMark;
    }

    public void setOriginMark(String originMark) {
        this.originMark = originMark;
    }

    public String getOriginMarkNo() {
        return originMarkNo;
    }

    public void setOriginMarkNo(String originMarkNo) {
        this.originMarkNo = originMarkNo;
    }

    public Integer getIsUseInsurance() {
        return isUseInsurance;
    }

    public void setIsUseInsurance(Integer isUseInsurance) {
        this.isUseInsurance = isUseInsurance;
    }

    public Integer getIsFinishCodeNeeded() {
        return isFinishCodeNeeded;
    }

    public void setIsFinishCodeNeeded(Integer isFinishCodeNeeded) {
        this.isFinishCodeNeeded = isFinishCodeNeeded;
    }

    public Integer getDelayPublishTime() {
        return delayPublishTime;
    }

    public void setDelayPublishTime(Integer delayPublishTime) {
        this.delayPublishTime = delayPublishTime;
    }

    public Integer getIsDirectDelivery() {
        return isDirectDelivery;
    }

    public void setIsDirectDelivery(Integer isDirectDelivery) {
        this.isDirectDelivery = isDirectDelivery;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, ReAddOrderModel> {
        public Builder shopNo(String shopNo) {
            instance.setShopNo(shopNo);
            return this;
        }

        public Builder originId(String originId) {
            instance.setOriginId(originId);
            return this;
        }

        public Builder cityCode(String cityCode) {
            instance.setCityCode(cityCode);
            return this;
        }

        public Builder cargoPrice(Double cargoPrice) {
            instance.setCargoPrice(cargoPrice);
            return this;
        }

        public Builder isPrepay(Integer isPrepay) {
            instance.setIsPrepay(isPrepay);
            return this;
        }

        public Builder receiverName(String receiverName) {
            instance.setReceiverName(receiverName);
            return this;
        }

        public Builder receiverAddress(String receiverAddress) {
            instance.setReceiverAddress(receiverAddress);
            return this;
        }

        public Builder receiverLat(Double receiverLat) {
            instance.setReceiverLat(receiverLat);
            return this;
        }

        public Builder receiverLng(Double receiverLng) {
            instance.setReceiverLng(receiverLng);
            return this;
        }

        public Builder callback(String callback) {
            instance.setCallback(callback);
            return this;
        }

        public Builder topic(String topic) {
            instance.setTopic(topic);
            return this;
        }

        public Builder receiverPhone(String receiverPhone) {
            instance.setReceiverPhone(receiverPhone);
            return this;
        }

        public Builder receiverTel(String receiverTel) {
            instance.setReceiverTel(receiverTel);
            return this;
        }

        public Builder tips(Double tips) {
            instance.setTips(tips);
            return this;
        }

        public Builder info(String info) {
            instance.setInfo(info);
            return this;
        }

        public Builder cargoType(Integer cargoType) {
            instance.setCargoType(cargoType);
            return this;
        }

        public Builder cargoWeight(Double cargoWeight) {
            instance.setCargoWeight(cargoWeight);
            return this;
        }

        public Builder cargoNum(Integer cargoNum) {
            instance.setCargoNum(cargoNum);
            return this;
        }

        public Builder invoiceTitle(String invoiceTitle) {
            instance.setInvoiceTitle(invoiceTitle);
            return this;
        }

        public Builder originMark(String originMark) {
            instance.setOriginMark(originMark);
            return this;
        }

        public Builder originMarkNo(String originMarkNo) {
            instance.setOriginMarkNo(originMarkNo);
            return this;
        }

        public Builder isUseInsurance(Integer isUseInsurance) {
            instance.setIsUseInsurance(isUseInsurance);
            return this;
        }

        public Builder isFinishCodeNeeded(Integer isFinishCodeNeeded) {
            instance.setIsFinishCodeNeeded(isFinishCodeNeeded);
            return this;
        }

        public Builder delayPublishTime(Integer delayPublishTime) {
            instance.setDelayPublishTime(delayPublishTime);
            return this;
        }

        public Builder isDirectDelivery(Integer isDirectDelivery) {
            instance.setIsDirectDelivery(isDirectDelivery);
            return this;
        }

        @Override
        public ReAddOrderModel build() {
            ReAddOrderModel reAddOrderModel = super.build();
            reAddOrderModel.setShopNo(instance.getShopNo());
            reAddOrderModel.setOriginId(instance.getOriginId());
            reAddOrderModel.setCityCode(instance.getCityCode());
            reAddOrderModel.setCargoPrice(instance.getCargoPrice());
            reAddOrderModel.setIsPrepay(instance.getIsPrepay());
            reAddOrderModel.setReceiverName(instance.getReceiverName());
            reAddOrderModel.setReceiverAddress(instance.getReceiverAddress());
            reAddOrderModel.setReceiverLat(instance.getReceiverLat());
            reAddOrderModel.setReceiverLng(instance.getReceiverLng());
            reAddOrderModel.setCallback(instance.getCallback());
            reAddOrderModel.setTopic(instance.getTopic());
            reAddOrderModel.setReceiverPhone(instance.getReceiverPhone());
            reAddOrderModel.setReceiverTel(instance.getReceiverTel());
            reAddOrderModel.setTips(instance.getTips());
            reAddOrderModel.setInfo(instance.getInfo());
            reAddOrderModel.setCargoType(instance.getCargoType());
            reAddOrderModel.setCargoWeight(instance.getCargoWeight());
            reAddOrderModel.setCargoNum(instance.getCargoNum());
            reAddOrderModel.setInvoiceTitle(instance.getInvoiceTitle());
            reAddOrderModel.setOriginMark(instance.getOriginMark());
            reAddOrderModel.setOriginMarkNo(instance.getOriginMarkNo());
            reAddOrderModel.setIsUseInsurance(instance.getIsUseInsurance());
            reAddOrderModel.setIsFinishCodeNeeded(instance.getIsFinishCodeNeeded());
            reAddOrderModel.setDelayPublishTime(instance.getDelayPublishTime());
            reAddOrderModel.setIsDirectDelivery(instance.getIsDirectDelivery());
            return reAddOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
