package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MeiTuanOrderPoiReceiveDetail extends BasicDomain {
    /**
     * mei_tuan_order id
     */
    private BigInteger meiTuanOrderId;
    /**
     * 菜品分成
     */
    private BigDecimal foodShareFeeChargeByPoi;
    /**
     * 配送费
     */
    private BigDecimal logisticsFee;
    /**
     * 在线支付款
     */
    private BigDecimal onlinePayment;
    /**
     * 商家应收款
     */
    private BigDecimal wmPoiReceiveCent;

    public BigInteger getMeiTuanOrderId() {
        return meiTuanOrderId;
    }

    public void setMeiTuanOrderId(BigInteger meiTuanOrderId) {
        this.meiTuanOrderId = meiTuanOrderId;
    }

    public BigDecimal getFoodShareFeeChargeByPoi() {
        return foodShareFeeChargeByPoi;
    }

    public void setFoodShareFeeChargeByPoi(BigDecimal foodShareFeeChargeByPoi) {
        this.foodShareFeeChargeByPoi = foodShareFeeChargeByPoi;
    }

    public BigDecimal getLogisticsFee() {
        return logisticsFee;
    }

    public void setLogisticsFee(BigDecimal logisticsFee) {
        this.logisticsFee = logisticsFee;
    }

    public BigDecimal getOnlinePayment() {
        return onlinePayment;
    }

    public void setOnlinePayment(BigDecimal onlinePayment) {
        this.onlinePayment = onlinePayment;
    }

    public BigDecimal getWmPoiReceiveCent() {
        return wmPoiReceiveCent;
    }

    public void setWmPoiReceiveCent(BigDecimal wmPoiReceiveCent) {
        this.wmPoiReceiveCent = wmPoiReceiveCent;
    }
}
