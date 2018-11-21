package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;

public class MeiTuanOrderRefundMessage extends BasicDomain {
    /**
     * diet_order.id
     */
    private BigInteger dietOrderId;
    /**
     * ERP厂商入驻新美大餐饮平台得到的唯一身份表示
     */
    private BigInteger developerId;
    /**
     * ERP方门店id 最大长度100
     */
    private String ePoiId;
    /**
     * 数字签名
     */
    private String sign;
    /**
     * 美团订单号
     */
    private BigInteger orderId;
    /**
     * 退款消息类型
     */
    private String notifyType = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 退款理由
     */
    private String reason = Constants.VARCHAR_DEFAULT_VALUE;

    public BigInteger getDietOrderId() {
        return dietOrderId;
    }

    public void setDietOrderId(BigInteger dietOrderId) {
        this.dietOrderId = dietOrderId;
    }

    public BigInteger getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(BigInteger developerId) {
        this.developerId = developerId;
    }

    public String getePoiId() {
        return ePoiId;
    }

    public void setePoiId(String ePoiId) {
        this.ePoiId = ePoiId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
