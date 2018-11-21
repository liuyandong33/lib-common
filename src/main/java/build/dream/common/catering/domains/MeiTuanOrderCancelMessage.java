package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;

public class MeiTuanOrderCancelMessage extends BasicDomain {
    private BigInteger dietOrderId;
    private BigInteger developerId;
    private String ePoiId;
    private String sign;
    private BigInteger orderId;
    private String reasonCode = Constants.VARCHAR_DEFAULT_VALUE;
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
