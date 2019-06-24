package build.dream.common.models.anubis;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.NotifyUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class OrderModel extends AnubisBasicModel {
    private static final Integer[] BOOLEAN_ITEMS = {0, 1};
    private static final Integer[] ORDER_TYPES = {1};
    private static final Integer[] ORDER_PAYMENT_STATUSES = {0, 1};
    private static final Integer[] ORDER_PAYMENT_METHODS = {1};
    @Length(max = 255)
    @SerializedName(value = "partner_remark", alternate = "partnerRemark")
    @JsonProperty(value = "partner_remark")
    private String partnerRemark;

    @NotNull
    @Length(max = 128)
    @SerializedName(value = "partner_order_code", alternate = "partnerOrderCode")
    @JsonProperty(value = "partner_order_code")
    private String partnerOrderCode;

    @NotNull
    @Length(max = 255)
    @SerializedName(value = "notify_url", alternate = "notifyUrl")
    @JsonProperty(value = "notify_url")
    private String notifyUrl = NotifyUtils.obtainNotifyUrl(Constants.NOTIFY_TYPE_ANUBIS_ORDER_CALLBACK, "partner_order_code");

    @NotNull
    @JsonIgnore
    private String topic;

    @NotNull
    @SerializedName(value = "order_type", alternate = "orderType")
    @JsonProperty(value = "order_type")
    private Integer orderType;

    @SerializedName(value = "chain_store_code", alternate = "chainStoreCode")
    @JsonProperty(value = "chain_store_code")
    private String chainStoreCode;

    @NotNull
    @SerializedName(value = "transport_info", alternate = "transportInfo")
    @JsonProperty(value = "transport_info")
    private TransportInfo transportInfo;

    @SerializedName(value = "order_add_time", alternate = "orderAddTime")
    @JsonProperty(value = "order_add_time")
    private Long orderAddTime;

    @NotNull
    @SerializedName(value = "order_total_amount", alternate = "orderTotalAmount")
    @JsonProperty(value = "order_total_amount")
    private BigDecimal orderTotalAmount;

    @NotNull
    @SerializedName(value = "order_actual_amount", alternate = "orderActualAmount")
    @JsonProperty(value = "order_actual_amount")
    private BigDecimal orderActualAmount;

    @SerializedName(value = "order_weight", alternate = "orderWeight")
    @JsonProperty(value = "order_weight")
    private BigDecimal orderWeight;

    @Length(max = 255)
    @SerializedName(value = "order_remark", alternate = "orderRemark")
    @JsonProperty(value = "order_remark")
    private String orderRemark;

    @SerializedName(value = "is_invoiced", alternate = "isInvoiced")
    @JsonProperty(value = "is_invoiced")
    private Integer isInvoiced;

    @Length(max = 128)
    private String invoice;

    @SerializedName(value = "order_payment_status", alternate = "orderPaymentStatus")
    @JsonProperty(value = "order_payment_status")
    private Integer orderPaymentStatus;

    @SerializedName(value = "order_payment_method", alternate = "orderPaymentMethod")
    @JsonProperty(value = "order_payment_method")
    private Integer orderPaymentMethod;

    @SerializedName(value = "is_agent_payment", alternate = "isAgentPayment")
    @JsonProperty(value = "is_agent_payment")
    private Integer isAgentPayment;

    @SerializedName(value = "require_payment_pay", alternate = "requirePaymentPay")
    @JsonProperty(value = "require_payment_pay")
    private BigDecimal requirePaymentPay;

    @SerializedName(value = "require_receive_time", alternate = "requireReceiveTime")
    @JsonProperty(value = "require_receive_time")
    private Long requireReceiveTime;

    @NotNull
    @SerializedName(value = "goods_count", alternate = "goodsCount")
    @JsonProperty(value = "goods_count")
    private Integer goodsCount;

    @NotNull
    @SerializedName(value = "receiver_info", alternate = "receiverInfo")
    @JsonProperty(value = "receiver_info")
    private ReceiverInfo receiverInfo;

    @NotEmpty
    @SerializedName(value = "items_json", alternate = "items")
    @JsonProperty(value = "items_json")
    private List<Item> items;

    @Length(max = 6)
    @SerializedName(value = "serial_number", alternate = "serialNumber")
    @JsonProperty(value = "serial_number")
    private String serialNumber;

    public String getPartnerRemark() {
        return partnerRemark;
    }

    public void setPartnerRemark(String partnerRemark) {
        this.partnerRemark = partnerRemark;
    }

    public String getPartnerOrderCode() {
        return partnerOrderCode;
    }

    public void setPartnerOrderCode(String partnerOrderCode) {
        this.partnerOrderCode = partnerOrderCode;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getChainStoreCode() {
        return chainStoreCode;
    }

    public void setChainStoreCode(String chainStoreCode) {
        this.chainStoreCode = chainStoreCode;
    }

    public TransportInfo getTransportInfo() {
        return transportInfo;
    }

    public void setTransportInfo(TransportInfo transportInfo) {
        this.transportInfo = transportInfo;
    }

    public Long getOrderAddTime() {
        return orderAddTime;
    }

    public void setOrderAddTime(Long orderAddTime) {
        this.orderAddTime = orderAddTime;
    }

    public BigDecimal getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public BigDecimal getOrderActualAmount() {
        return orderActualAmount;
    }

    public void setOrderActualAmount(BigDecimal orderActualAmount) {
        this.orderActualAmount = orderActualAmount;
    }

    public BigDecimal getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(BigDecimal orderWeight) {
        this.orderWeight = orderWeight;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Integer getIsInvoiced() {
        return isInvoiced;
    }

    public void setIsInvoiced(Integer isInvoiced) {
        this.isInvoiced = isInvoiced;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Integer getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(Integer orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public Integer getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public void setOrderPaymentMethod(Integer orderPaymentMethod) {
        this.orderPaymentMethod = orderPaymentMethod;
    }

    public Integer getIsAgentPayment() {
        return isAgentPayment;
    }

    public void setIsAgentPayment(Integer isAgentPayment) {
        this.isAgentPayment = isAgentPayment;
    }

    public BigDecimal getRequirePaymentPay() {
        return requirePaymentPay;
    }

    public void setRequirePaymentPay(BigDecimal requirePaymentPay) {
        this.requirePaymentPay = requirePaymentPay;
    }

    public Long getRequireReceiveTime() {
        return requireReceiveTime;
    }

    public void setRequireReceiveTime(Long requireReceiveTime) {
        this.requireReceiveTime = requireReceiveTime;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public ReceiverInfo getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(ReceiverInfo receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean validate() {
        boolean isOK = super.validate()
                && ArrayUtils.contains(ORDER_TYPES, orderType)
                && transportInfo.validate()
                && ArrayUtils.contains(ORDER_PAYMENT_STATUSES, orderPaymentStatus)
                && ArrayUtils.contains(ORDER_PAYMENT_METHODS, orderPaymentMethod)
                && ArrayUtils.contains(BOOLEAN_ITEMS, isInvoiced)
                && receiverInfo.validate();
        if (!isOK) {
            return false;
        }
        isOK = isInvoiced == 1 ? StringUtils.isNotBlank(invoice) : true;
        if (!isOK) {
            return false;
        }
        for (Item item : items) {
            if (!item.validate()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ApplicationHandler.inArray(ORDER_TYPES, orderType, "orderType");
        ApplicationHandler.isTrue(transportInfo.validate(), "transportInfo");
        ApplicationHandler.inArray(ORDER_PAYMENT_STATUSES, orderPaymentStatus, "orderPaymentStatus");
        ApplicationHandler.inArray(ORDER_PAYMENT_METHODS, orderPaymentMethod, "orderPaymentMethod");
        ApplicationHandler.inArray(BOOLEAN_ITEMS, isInvoiced, "isInvoiced");
        ApplicationHandler.isTrue(receiverInfo.validate(), "receiverInfo");
        if (isInvoiced == 1) {
            ApplicationHandler.notBlank(invoice, "invoice");
        }
        for (Item item : items) {
            ApplicationHandler.isTrue(item.validate(), "items");
        }
    }

    public static class TransportInfo extends BasicModel {
        private static final Integer[] POSITION_SOURCES = {1, 2, 3};
        @Length(max = 32)
        @SerializedName(value = "transport_id", alternate = "transportId")
        private String transportId;

        @NotNull
        @Length(max = 32)
        @SerializedName(value = "transport_name", alternate = "transportName")
        private String transportName;

        @NotNull
        @Length(max = 255)
        @SerializedName(value = "transport_address", alternate = "transportAddress")
        private String transportAddress;

        @NotNull
        @SerializedName(value = "transport_longitude", alternate = "transportLongitude")
        private Double transportLongitude;

        @NotNull
        @SerializedName(value = "transport_latitude", alternate = "transportLatitude")
        private Double transportLatitude;

        @NotNull
        @SerializedName(value = "position_source", alternate = "positionSource")
        private Integer positionSource;

        @NotNull
        @Length(max = 16)
        @SerializedName(value = "transport_tel", alternate = "transportTel")
        private String transportTel;

        @Length(max = 255)
        @SerializedName(value = "transport_remark", alternate = "transportRemark")
        private String transportRemark;

        public String getTransportId() {
            return transportId;
        }

        public void setTransportId(String transportId) {
            this.transportId = transportId;
        }


        public String getTransportName() {
            return transportName;
        }

        public void setTransportName(String transportName) {
            this.transportName = transportName;
        }


        public String getTransportAddress() {
            return transportAddress;
        }

        public void setTransportAddress(String transportAddress) {
            this.transportAddress = transportAddress;
        }


        public Double getTransportLongitude() {
            return transportLongitude;
        }

        public void setTransportLongitude(Double transportLongitude) {
            this.transportLongitude = transportLongitude;
        }


        public Double getTransportLatitude() {
            return transportLatitude;
        }

        public void setTransportLatitude(Double transportLatitude) {
            this.transportLatitude = transportLatitude;
        }


        public Integer getPositionSource() {
            return positionSource;
        }

        public void setPositionSource(Integer positionSource) {
            this.positionSource = positionSource;
        }


        public String getTransportTel() {
            return transportTel;
        }

        public void setTransportTel(String transportTel) {
            this.transportTel = transportTel;
        }

        public String getTransportRemark() {
            return transportRemark;
        }

        public void setTransportRemark(String transportRemark) {
            this.transportRemark = transportRemark;
        }

        @Override
        public boolean validate() {
            return super.validate() && ArrayUtils.contains(POSITION_SOURCES, positionSource);
        }

        @Override
        public void validateAndThrow() {
            super.validateAndThrow();
            Validate.isTrue(ArrayUtils.contains(POSITION_SOURCES, positionSource));
        }
    }

    public static class ReceiverInfo extends BasicModel {
        private static final Integer[] POSITION_SOURCES = {1, 2, 3};
        @NotNull
        @Length(max = 30)
        @SerializedName(value = "receiver_name", alternate = "receiverName")
        private String receiverName;

        @NotNull
        @Length(max = 64)
        @SerializedName(value = "receiver_primary_phone", alternate = "receiverPrimaryPhone")
        private String receiverPrimaryPhone;

        @Length(max = 64)
        @SerializedName(value = "receiver_second_phone", alternate = "receiverSecondPhone")
        private String receiverSecondPhone;

        @NotNull
        @Length(max = 255)
        @SerializedName(value = "receiver_address", alternate = "receiverAddress")
        private String receiverAddress;

        @NotNull
        @SerializedName(value = "receiver_longitude", alternate = "receiverLongitude")
        private Double receiverLongitude;

        @NotNull
        @SerializedName(value = "receiver_latitude", alternate = "receiverLatitude")
        private Double receiverLatitude;

        @NotNull
        @SerializedName(value = "position_source", alternate = "positionSource")
        private Integer positionSource;

        public String getReceiverName() {
            return receiverName;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public String getReceiverPrimaryPhone() {
            return receiverPrimaryPhone;
        }

        public void setReceiverPrimaryPhone(String receiverPrimaryPhone) {
            this.receiverPrimaryPhone = receiverPrimaryPhone;
        }

        public String getReceiverSecondPhone() {
            return receiverSecondPhone;
        }

        public void setReceiverSecondPhone(String receiverSecondPhone) {
            this.receiverSecondPhone = receiverSecondPhone;
        }

        public String getReceiverAddress() {
            return receiverAddress;
        }

        public void setReceiverAddress(String receiverAddress) {
            this.receiverAddress = receiverAddress;
        }

        public Double getReceiverLongitude() {
            return receiverLongitude;
        }

        public void setReceiverLongitude(Double receiverLongitude) {
            this.receiverLongitude = receiverLongitude;
        }

        public Double getReceiverLatitude() {
            return receiverLatitude;
        }

        public void setReceiverLatitude(Double receiverLatitude) {
            this.receiverLatitude = receiverLatitude;
        }

        public Integer getPositionSource() {
            return positionSource;
        }

        public void setPositionSource(Integer positionSource) {
            this.positionSource = positionSource;
        }

        @Override
        public boolean validate() {
            return super.validate() && ArrayUtils.contains(POSITION_SOURCES, positionSource);
        }

        @Override
        public void validateAndThrow() {
            super.validateAndThrow();
            Validate.isTrue(ArrayUtils.contains(POSITION_SOURCES, positionSource));
        }
    }

    public static class Item extends BasicModel {
        @SerializedName(value = "item_id", alternate = "itemId")
        private String itemId;

        @NotNull
        @Length(max = 128)
        @SerializedName(value = "item_name", alternate = "itemName")
        private String itemName;

        @NotNull
        @SerializedName(value = "item_quantity", alternate = "itemQuantity")
        private Integer itemQuantity;

        @NotNull
        @SerializedName(value = "item_price", alternate = "itemPrice")
        private BigDecimal itemPrice;

        @NotNull
        @SerializedName(value = "item_actual_price", alternate = "itemActualPrice")
        private BigDecimal itemActualPrice;

        @SerializedName(value = "item_size", alternate = "itemSize")
        private Integer itemSize;

        @Length(max = 255)
        @SerializedName(value = "item_remark", alternate = "itemRemark")
        private String itemRemark;

        @NotNull
        @SerializedName(value = "is_need_package", alternate = "isNeedPackage")
        private Integer isNeedPackage;

        @NotNull
        @SerializedName(value = "is_agent_purchase", alternate = "isAgentPurchase")
        private Integer isAgentPurchase;

        @SerializedName(value = "agent_purchase_price", alternate = "agentPurchasePrice")
        private BigDecimal agentPurchasePrice;

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public Integer getItemQuantity() {
            return itemQuantity;
        }

        public void setItemQuantity(Integer itemQuantity) {
            this.itemQuantity = itemQuantity;
        }

        public BigDecimal getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(BigDecimal itemPrice) {
            this.itemPrice = itemPrice;
        }

        public BigDecimal getItemActualPrice() {
            return itemActualPrice;
        }

        public void setItemActualPrice(BigDecimal itemActualPrice) {
            this.itemActualPrice = itemActualPrice;
        }

        public Integer getItemSize() {
            return itemSize;
        }

        public void setItemSize(Integer itemSize) {
            this.itemSize = itemSize;
        }

        public String getItemRemark() {
            return itemRemark;
        }

        public void setItemRemark(String itemRemark) {
            this.itemRemark = itemRemark;
        }

        public Integer getIsNeedPackage() {
            return isNeedPackage;
        }

        public void setIsNeedPackage(Integer isNeedPackage) {
            this.isNeedPackage = isNeedPackage;
        }

        public Integer getIsAgentPurchase() {
            return isAgentPurchase;
        }

        public void setIsAgentPurchase(Integer isAgentPurchase) {
            this.isAgentPurchase = isAgentPurchase;
        }

        public BigDecimal getAgentPurchasePrice() {
            return agentPurchasePrice;
        }

        public void setAgentPurchasePrice(BigDecimal agentPurchasePrice) {
            this.agentPurchasePrice = agentPurchasePrice;
        }

        @Override
        public boolean validate() {
            return super.validate() && ArrayUtils.contains(BOOLEAN_ITEMS, isNeedPackage) && ArrayUtils.contains(BOOLEAN_ITEMS, isAgentPurchase) && (isAgentPurchase == 1 ? agentPurchasePrice != null : true);
        }

        @Override
        public void validateAndThrow() {
            super.validateAndThrow();
            Validate.isTrue(ArrayUtils.contains(BOOLEAN_ITEMS, isNeedPackage));
            Validate.isTrue(ArrayUtils.contains(BOOLEAN_ITEMS, isAgentPurchase));
            if (isAgentPurchase == 1) {
                Validate.notNull(agentPurchasePrice);
            }
        }
    }

    public static class Builder extends AnubisBasicModel.Builder<Builder, OrderModel> {
        public Builder partnerRemark(String partnerRemark) {
            instance.setPartnerRemark(partnerRemark);
            return this;
        }

        public Builder partnerOrderCode(String partnerOrderCode) {
            instance.setPartnerOrderCode(partnerOrderCode);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder topic(String topic) {
            instance.setTopic(topic);
            return this;
        }

        public Builder orderType(Integer orderType) {
            instance.setOrderType(orderType);
            return this;
        }

        public Builder chainStoreCode(String chainStoreCode) {
            instance.setChainStoreCode(chainStoreCode);
            return this;
        }

        public Builder transportInfo(TransportInfo transportInfo) {
            instance.setTransportInfo(transportInfo);
            return this;
        }

        public Builder orderAddTime(Long orderAddTime) {
            instance.setOrderAddTime(orderAddTime);
            return this;
        }

        public Builder orderTotalAmount(BigDecimal orderTotalAmount) {
            instance.setOrderTotalAmount(orderTotalAmount);
            return this;
        }

        public Builder orderActualAmount(BigDecimal orderActualAmount) {
            instance.setOrderActualAmount(orderActualAmount);
            return this;
        }

        public Builder orderWeight(BigDecimal orderWeight) {
            instance.setOrderWeight(orderWeight);
            return this;
        }

        public Builder orderRemark(String orderRemark) {
            instance.setOrderRemark(orderRemark);
            return this;
        }

        public Builder isInvoiced(Integer isInvoiced) {
            instance.setIsInvoiced(isInvoiced);
            return this;
        }

        public Builder invoice(String invoice) {
            instance.setInvoice(invoice);
            return this;
        }

        public Builder orderPaymentStatus(Integer orderPaymentStatus) {
            instance.setOrderPaymentStatus(orderPaymentStatus);
            return this;
        }

        public Builder orderPaymentMethod(Integer orderPaymentMethod) {
            instance.setOrderPaymentMethod(orderPaymentMethod);
            return this;
        }

        public Builder isAgentPayment(Integer isAgentPayment) {
            instance.setIsAgentPayment(isAgentPayment);
            return this;
        }

        public Builder requirePaymentPay(BigDecimal requirePaymentPay) {
            instance.setRequirePaymentPay(requirePaymentPay);
            return this;
        }

        public Builder requireReceiveTime(Long requireReceiveTime) {
            instance.setRequireReceiveTime(requireReceiveTime);
            return this;
        }

        public Builder goodsCount(Integer goodsCount) {
            instance.setGoodsCount(goodsCount);
            return this;
        }

        public Builder receiverInfo(ReceiverInfo receiverInfo) {
            instance.setReceiverInfo(receiverInfo);
            return this;
        }

        public Builder items(List<Item> items) {
            instance.setItems(items);
            return this;
        }

        public Builder serialNumber(String serialNumber) {
            instance.setSerialNumber(serialNumber);
            return this;
        }

        @Override
        public OrderModel build() {
            OrderModel orderModel = super.build();
            orderModel.setPartnerRemark(instance.getPartnerRemark());
            orderModel.setPartnerOrderCode(instance.getPartnerOrderCode());
            orderModel.setNotifyUrl(instance.getNotifyUrl());
            orderModel.setTopic(instance.getTopic());
            orderModel.setOrderType(instance.getOrderType());
            orderModel.setChainStoreCode(instance.getChainStoreCode());
            orderModel.setTransportInfo(instance.getTransportInfo());
            orderModel.setOrderAddTime(instance.getOrderAddTime());
            orderModel.setOrderTotalAmount(instance.getOrderTotalAmount());
            orderModel.setOrderActualAmount(instance.getOrderActualAmount());
            orderModel.setOrderWeight(instance.getOrderWeight());
            orderModel.setOrderRemark(instance.getOrderRemark());
            orderModel.setIsInvoiced(instance.getIsInvoiced());
            orderModel.setInvoice(instance.getInvoice());
            orderModel.setOrderPaymentStatus(instance.getOrderPaymentStatus());
            orderModel.setOrderPaymentMethod(instance.getOrderPaymentMethod());
            orderModel.setIsAgentPayment(instance.getIsAgentPayment());
            orderModel.setRequirePaymentPay(instance.getRequirePaymentPay());
            orderModel.setRequireReceiveTime(instance.getRequireReceiveTime());
            orderModel.setGoodsCount(instance.getGoodsCount());
            orderModel.setReceiverInfo(instance.getReceiverInfo());
            orderModel.setItems(instance.getItems());
            orderModel.setSerialNumber(instance.getSerialNumber());
            return orderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
