package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class MeiTuanOrderCancelMessage extends BasicDomain {
    private BigInteger meiOrderId;
    private BigInteger developerId;
    private String ePoiId;
    private String sign;
    private BigInteger orderId;
    private String reasonCode;
    private String reason;

    public BigInteger getMeiOrderId() {
        return meiOrderId;
    }

    public void setMeiOrderId(BigInteger meiOrderId) {
        this.meiOrderId = meiOrderId;
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

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
