package build.dream.common.models.anubis;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
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
    private String partnerRemark;

    @NotNull
    @Length(max = 128)
    @SerializedName(value = "partner_order_code", alternate = "partnerOrderCode")
    private String partnerOrderCode;

    @NotNull
    @Length(max = 255)
    @SerializedName(value = "notify_url", alternate = "notifyUrl")
    private String notifyUrl;

    @NotNull
    @SerializedName(value = "order_type", alternate = "orderType")
    private Integer orderType;

    @SerializedName(value = "chain_store_code", alternate = "chainStoreCode")
    private String chainStoreCode;

    @NotNull
    @SerializedName(value = "transport_info", alternate = "transportInfo")
    private TransportInfo transportInfo;

    @SerializedName(value = "order_add_time", alternate = "orderAddTime")
    private Long orderAddTime;

    @NotNull
    @SerializedName(value = "order_total_amount", alternate = "orderTotalAmount")
    private BigDecimal orderTotalAmount;

    @NotNull
    @SerializedName(value = "order_actual_amount", alternate = "orderActualAmount")
    private BigDecimal orderActualAmount;

    @SerializedName(value = "order_weight", alternate = "orderWeight")
    private BigDecimal orderWeight;

    @Length(max = 255)
    @SerializedName(value = "order_remark", alternate = "orderRemark")
    private String orderRemark;

    @SerializedName(value = "is_invoiced", alternate = "isInvoiced")
    private Integer isInvoiced;

    @Length(max = 128)
    private String invoice;

    @SerializedName(value = "order_payment_status", alternate = "orderPaymentStatus")
    private Integer orderPaymentStatus;

    @SerializedName(value = "order_payment_method", alternate = "orderPaymentMethod")
    private Integer orderPaymentMethod;

    @SerializedName(value = "is_agent_payment", alternate = "isAgentPayment")
    private Integer isAgentPayment;

    @SerializedName(value = "require_payment_pay", alternate = "requirePaymentPay")
    private BigDecimal requirePaymentPay;

    @SerializedName(value = "require_receive_time", alternate = "requireReceiveTime")
    private Long requireReceiveTime;

    @NotNull
    @SerializedName(value = "goods_count", alternate = "goodsCount")
    private Integer goodsCount;

    @NotNull
    @SerializedName(value = "receiver_info", alternate = "receiverInfo")
    private ReceiverInfo receiverInfo;

    @NotEmpty
    @SerializedName(value = "items_json", alternate = "items")
    private List<Item> items;

    @Length(max = 6)
    @SerializedName(value = "serial_number", alternate = "serialNumber")
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
}
