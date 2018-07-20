package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class VipAccount extends BasicDomain {
    /**
     * 商户id
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店id
     */
    private BigInteger branchId;

    /**
     * 会员ID
     */
    private BigInteger vipId;
    /**
     * 会员积分
     */
    private BigDecimal point;
    /**
     * 累计积分
     */
    private BigDecimal accumulativePoint;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 累计充值金额
     */
    private BigDecimal accumulativeRecharge;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public BigInteger getVipId() {
        return vipId;
    }

    public void setVipId(BigInteger vipId) {
        this.vipId = vipId;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public BigDecimal getAccumulativePoint() {
        return accumulativePoint;
    }

    public void setAccumulativePoint(BigDecimal accumulativePoint) {
        this.accumulativePoint = accumulativePoint;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAccumulativeRecharge() {
        return accumulativeRecharge;
    }

    public void setAccumulativeRecharge(BigDecimal accumulativeRecharge) {
        this.accumulativeRecharge = accumulativeRecharge;
    }
}
