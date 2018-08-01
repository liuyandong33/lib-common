package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

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

    public static class Builder {
        private final VipAccount instance = new VipAccount();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder vipId(BigInteger vipId) {
            instance.setVipId(vipId);
            return this;
        }

        public Builder point(BigDecimal point) {
            instance.setPoint(point);
            return this;
        }

        public Builder accumulativePoint(BigDecimal accumulativePoint) {
            instance.setAccumulativePoint(accumulativePoint);
            return this;
        }

        public Builder balance(BigDecimal balance) {
            instance.setBalance(balance);
            return this;
        }

        public Builder accumulativeRecharge(BigDecimal accumulativeRecharge) {
            instance.setAccumulativeRecharge(accumulativeRecharge);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
