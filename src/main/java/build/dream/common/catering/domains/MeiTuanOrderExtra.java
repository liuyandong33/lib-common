package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MeiTuanOrderExtra extends BasicDomain {
    /**
     * mei_tuan_order id
     */
    private BigInteger meiTuanOrderId;
    /**
     * 该活动中美团承担的费用
     */
    private BigDecimal mtCharge;
    /**
     * 该活动中商家承担的费用
     */
    private BigDecimal poiCharge;
    /**
     * 活动优惠金额，是在原价基础上减免的金额。并非一定等于美团承担活动费用和商户承担费用的总和，如type=23，即买赠活动时，赠品的成本虽然由商家承担，但这部分不算在活动优惠金额内
     */
    private BigDecimal reduceFee;
    /**
     * 优惠说明
     */
    private String remark;
    /**
     * 优惠活动类型（1-新用户立减；2-满减；4-套餐赠送；5-满赠；9-使用红包；11-提前下单减；16-满免配送费(即将废弃)；17-折扣商品；18-美团专送再减(即将废弃)；19-点评券；20-第二份半价；21-会员免配送费；22-门店新客立减；23-买赠；24-平台新用户立减；25-满减配送费；100-满返商家代金券；101-使用商家代金券；103-进店领券）
     */
    private Integer type;

    public BigInteger getMeiTuanOrderId() {
        return meiTuanOrderId;
    }

    public void setMeiTuanOrderId(BigInteger meiTuanOrderId) {
        this.meiTuanOrderId = meiTuanOrderId;
    }

    public BigDecimal getMtCharge() {
        return mtCharge;
    }

    public void setMtCharge(BigDecimal mtCharge) {
        this.mtCharge = mtCharge;
    }

    public BigDecimal getPoiCharge() {
        return poiCharge;
    }

    public void setPoiCharge(BigDecimal poiCharge) {
        this.poiCharge = poiCharge;
    }

    public BigDecimal getReduceFee() {
        return reduceFee;
    }

    public void setReduceFee(BigDecimal reduceFee) {
        this.reduceFee = reduceFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
