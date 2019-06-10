package build.dream.common.beans;

public class WeiXinBillSummary {
    /**
     * 总交易单数
     */
    private Integer totalTrade;

    /**
     * 应结订单总金额
     */
    private Double settlementTotalAmount;

    /**
     * 退款总金额
     */
    private Double refundAmount;

    /**
     * 充值券退款总金额
     */
    private Double cashRefundAmount;

    /**
     * 手续费总金额
     */
    private Double totalServiceFee;

    /**
     * 订单总金额
     */
    private Double totalAmount;

    /**
     * 申请退款总金额
     */
    private Double totalRefundFee;

    public Integer getTotalTrade() {
        return totalTrade;
    }

    public void setTotalTrade(Integer totalTrade) {
        this.totalTrade = totalTrade;
    }

    public Double getSettlementTotalAmount() {
        return settlementTotalAmount;
    }

    public void setSettlementTotalAmount(Double settlementTotalAmount) {
        this.settlementTotalAmount = settlementTotalAmount;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Double getCashRefundAmount() {
        return cashRefundAmount;
    }

    public void setCashRefundAmount(Double cashRefundAmount) {
        this.cashRefundAmount = cashRefundAmount;
    }

    public Double getTotalServiceFee() {
        return totalServiceFee;
    }

    public void setTotalServiceFee(Double totalServiceFee) {
        this.totalServiceFee = totalServiceFee;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalRefundFee() {
        return totalRefundFee;
    }

    public void setTotalRefundFee(Double totalRefundFee) {
        this.totalRefundFee = totalRefundFee;
    }

    public static class Builder {
        private final WeiXinBillSummary instance = new WeiXinBillSummary();

        public Builder totalTrade(Integer totalTrade) {
            instance.setTotalTrade(totalTrade);
            return this;
        }

        public Builder settlementTotalAmount(Double settlementTotalAmount) {
            instance.setSettlementTotalAmount(settlementTotalAmount);
            return this;
        }

        public Builder refundAmount(Double refundAmount) {
            instance.setRefundAmount(refundAmount);
            return this;
        }

        public Builder cashRefundAmount(Double cashRefundAmount) {
            instance.setCashRefundAmount(cashRefundAmount);
            return this;
        }

        public Builder totalServiceFee(Double totalServiceFee) {
            instance.setTotalServiceFee(totalServiceFee);
            return this;
        }

        public Builder totalAmount(Double totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder totalRefundFee(Double totalRefundFee) {
            instance.setTotalRefundFee(totalRefundFee);
            return this;
        }

        public WeiXinBillSummary build() {
            WeiXinBillSummary weiXinBillSummary = new WeiXinBillSummary();
            weiXinBillSummary.setTotalTrade(instance.getTotalTrade());
            weiXinBillSummary.setSettlementTotalAmount(instance.getSettlementTotalAmount());
            weiXinBillSummary.setRefundAmount(instance.getRefundAmount());
            weiXinBillSummary.setCashRefundAmount(instance.getCashRefundAmount());
            weiXinBillSummary.setTotalServiceFee(instance.getTotalServiceFee());
            weiXinBillSummary.setTotalAmount(instance.getTotalAmount());
            weiXinBillSummary.setTotalRefundFee(instance.getTotalRefundFee());
            return weiXinBillSummary;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}