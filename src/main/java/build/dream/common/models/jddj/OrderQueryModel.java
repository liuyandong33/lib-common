package build.dream.common.models.jddj;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OrderQueryModel extends JDDJBasicModel {
    /**
     * 当前页数,默认：1
     */
    @Min(value = 1)
    private Long pageNo;

    /**
     * 每页条数,默认：20，最大值100
     */
    @Min(value = 1)
    @Max(100)
    private Integer pageSize;

    /**
     * 订单号
     */
    private Long orderId;

    /**
     * 客户名
     */
    private String buyerFullName;

    /**
     * 客户名（模糊查询）
     */
    @JsonProperty(value = "buyerFullName_like")
    private String buyerFullNameLike;

    /**
     * 手机号
     */
    private String buyerMobile;

    /**
     * 订单支付类型（1：货到付款，4：在线支付）
     */
    private Integer orderPayType;

    /**
     * 买家账号
     */
    private String buyerPin;

    /**
     * 订单开始时间(开始)
     */
    @JsonProperty(value = "orderStartTime_begin")
    private Date orderStartTimeBegin;

    /**
     * 订单开始时间(结束)
     */
    @JsonProperty(value = "orderStartTime_end")
    private Date orderStartTimeEnd;

    /**
     * 购买成交时间-支付(开始)
     */
    @JsonProperty(value = "orderPurchaseTime_begin")
    private Date orderPurchaseTimeBegin;

    /**
     * 购买成交时间-支付(结束)
     */
    @JsonProperty(value = "orderPurchaseTime_end")
    private Date orderPurchaseTimeEnd;

    /**
     * 妥投时间(开始)
     */
    @JsonProperty(value = "deliveryConfirmTime_begin")
    private Date deliveryConfirmTimeBegin;

    /**
     * 妥投时间(结束)
     */
    @JsonProperty(value = "deliveryConfirmTime_end")
    private Date deliveryConfirmTimeEnd;

    /**
     * 订单关闭时间(开始)
     */
    @JsonProperty(value = "orderCloseTime_begin")
    private Date orderCloseTimeBegin;

    /**
     * 订单关闭时间(结束)
     */
    @JsonProperty(value = "orderCloseTime_end")
    private Date orderCloseTimeEnd;

    /**
     * 订单取消时间(开始)
     */
    @JsonProperty(value = "orderCancelTime_begin")
    private Date orderCancelTimeBegin;

    /**
     * 订单取消时间(结束)
     */
    @JsonProperty(value = "orderCancelTime_end")
    private Date orderCancelTimeEnd;

    /**
     * 订单状态（20010:锁定，20020:订单取消，20030:订单取消申请，20040:超时未支付系统取消，0050:暂停，
     * 31000:等待付款，31020:已付款，41000:待处理，32000:等待出库，33040:配送中，33060:已妥投，90000:订单完成）
     */
    private Integer orderStatus;

    /**
     * 订单状态复选条件
     */
    @JsonProperty(value = "orderStatus_list")
    private Set<Integer> orderStatusList;

    /**
     * 城市复选条件
     */
    @JsonProperty(value = "buyerCity_list")
    private Set<String> buyerCityList;

    /**
     * 承运单号，通常情况下和订单号一致
     */
    private String deliveryBillNo;

    /**
     * 业务类型（1:京东到家商超,2:京东到家美食,3:京东到家精品有约,4:京东到家开放仓,5:哥伦布店内订单,
     * 6:货柜项目订单,7:智能货柜项目订单,8:轻松购订单,9:自助收银订单,10:超级会员码），当多个业务类型时，是以逗号分隔的数值串。
     */
    @JsonProperty(value = "businessType_list")
    private List<Integer> businessTypeList;

    /**
     * 订单类型 10000:从门店出的订单
     */
    private String orderType;

    /**
     * 订单自提码，当该字段有值时，要求到家配送门店编码必填。
     */
    private String orderTakeSelfCode;

    /**
     * 到家门店编码
     */
    private String deliveryStationNo;

    /**
     * 商家门店编码
     */
    private String deliveryStationNoIsv;

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getBuyerFullName() {
        return buyerFullName;
    }

    public void setBuyerFullName(String buyerFullName) {
        this.buyerFullName = buyerFullName;
    }

    public String getBuyerFullNameLike() {
        return buyerFullNameLike;
    }

    public void setBuyerFullNameLike(String buyerFullNameLike) {
        this.buyerFullNameLike = buyerFullNameLike;
    }

    public String getBuyerMobile() {
        return buyerMobile;
    }

    public void setBuyerMobile(String buyerMobile) {
        this.buyerMobile = buyerMobile;
    }

    public Integer getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(Integer orderPayType) {
        this.orderPayType = orderPayType;
    }

    public String getBuyerPin() {
        return buyerPin;
    }

    public void setBuyerPin(String buyerPin) {
        this.buyerPin = buyerPin;
    }

    public Date getOrderStartTimeBegin() {
        return orderStartTimeBegin;
    }

    public void setOrderStartTimeBegin(Date orderStartTimeBegin) {
        this.orderStartTimeBegin = orderStartTimeBegin;
    }

    public Date getOrderStartTimeEnd() {
        return orderStartTimeEnd;
    }

    public void setOrderStartTimeEnd(Date orderStartTimeEnd) {
        this.orderStartTimeEnd = orderStartTimeEnd;
    }

    public Date getOrderPurchaseTimeBegin() {
        return orderPurchaseTimeBegin;
    }

    public void setOrderPurchaseTimeBegin(Date orderPurchaseTimeBegin) {
        this.orderPurchaseTimeBegin = orderPurchaseTimeBegin;
    }

    public Date getOrderPurchaseTimeEnd() {
        return orderPurchaseTimeEnd;
    }

    public void setOrderPurchaseTimeEnd(Date orderPurchaseTimeEnd) {
        this.orderPurchaseTimeEnd = orderPurchaseTimeEnd;
    }

    public Date getDeliveryConfirmTimeBegin() {
        return deliveryConfirmTimeBegin;
    }

    public void setDeliveryConfirmTimeBegin(Date deliveryConfirmTimeBegin) {
        this.deliveryConfirmTimeBegin = deliveryConfirmTimeBegin;
    }

    public Date getDeliveryConfirmTimeEnd() {
        return deliveryConfirmTimeEnd;
    }

    public void setDeliveryConfirmTimeEnd(Date deliveryConfirmTimeEnd) {
        this.deliveryConfirmTimeEnd = deliveryConfirmTimeEnd;
    }

    public Date getOrderCloseTimeBegin() {
        return orderCloseTimeBegin;
    }

    public void setOrderCloseTimeBegin(Date orderCloseTimeBegin) {
        this.orderCloseTimeBegin = orderCloseTimeBegin;
    }

    public Date getOrderCloseTimeEnd() {
        return orderCloseTimeEnd;
    }

    public void setOrderCloseTimeEnd(Date orderCloseTimeEnd) {
        this.orderCloseTimeEnd = orderCloseTimeEnd;
    }

    public Date getOrderCancelTimeBegin() {
        return orderCancelTimeBegin;
    }

    public void setOrderCancelTimeBegin(Date orderCancelTimeBegin) {
        this.orderCancelTimeBegin = orderCancelTimeBegin;
    }

    public Date getOrderCancelTimeEnd() {
        return orderCancelTimeEnd;
    }

    public void setOrderCancelTimeEnd(Date orderCancelTimeEnd) {
        this.orderCancelTimeEnd = orderCancelTimeEnd;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<Integer> getOrderStatusList() {
        return orderStatusList;
    }

    public void setOrderStatusList(Set<Integer> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }

    public Set<String> getBuyerCityList() {
        return buyerCityList;
    }

    public void setBuyerCityList(Set<String> buyerCityList) {
        this.buyerCityList = buyerCityList;
    }

    public String getDeliveryBillNo() {
        return deliveryBillNo;
    }

    public void setDeliveryBillNo(String deliveryBillNo) {
        this.deliveryBillNo = deliveryBillNo;
    }

    public List<Integer> getBusinessTypeList() {
        return businessTypeList;
    }

    public void setBusinessTypeList(List<Integer> businessTypeList) {
        this.businessTypeList = businessTypeList;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderTakeSelfCode() {
        return orderTakeSelfCode;
    }

    public void setOrderTakeSelfCode(String orderTakeSelfCode) {
        this.orderTakeSelfCode = orderTakeSelfCode;
    }

    public String getDeliveryStationNo() {
        return deliveryStationNo;
    }

    public void setDeliveryStationNo(String deliveryStationNo) {
        this.deliveryStationNo = deliveryStationNo;
    }

    public String getDeliveryStationNoIsv() {
        return deliveryStationNoIsv;
    }

    public void setDeliveryStationNoIsv(String deliveryStationNoIsv) {
        this.deliveryStationNoIsv = deliveryStationNoIsv;
    }
}
