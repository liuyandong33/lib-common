package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ActOrderChargeByPoi extends BasicDomain {
    /**
     * mei_tuan_order_poi_receive_detail id
     */
    private BigInteger meiTuanOrderPoiReceiveDetailId;
    /**
     * 备注
     */
    private String comment;
    /**
     * 明细费用类型描述
     */
    private String feeTypeDesc;
    /**
     * 明细费用类型Id
     */
    private BigInteger feeTypeId;
    /**
     * 明细金额
     */
    private BigDecimal moneyCent;

    public BigInteger getMeiTuanOrderPoiReceiveDetailId() {
        return meiTuanOrderPoiReceiveDetailId;
    }

    public void setMeiTuanOrderPoiReceiveDetailId(BigInteger meiTuanOrderPoiReceiveDetailId) {
        this.meiTuanOrderPoiReceiveDetailId = meiTuanOrderPoiReceiveDetailId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFeeTypeDesc() {
        return feeTypeDesc;
    }

    public void setFeeTypeDesc(String feeTypeDesc) {
        this.feeTypeDesc = feeTypeDesc;
    }

    public BigInteger getFeeTypeId() {
        return feeTypeId;
    }

    public void setFeeTypeId(BigInteger feeTypeId) {
        this.feeTypeId = feeTypeId;
    }

    public BigDecimal getMoneyCent() {
        return moneyCent;
    }

    public void setMoneyCent(BigDecimal moneyCent) {
        this.moneyCent = moneyCent;
    }
}
