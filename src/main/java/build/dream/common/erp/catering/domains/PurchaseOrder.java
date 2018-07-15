package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class PurchaseOrder extends BasicDomain {
    private BigInteger tenantId;
    private String tenantCode;
    private BigInteger branchId;
    private String orderNumber;
    private BigInteger originatorUserId;
    private BigInteger reviewerUserId;
    private Date reviewTime;
    private String remark;

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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigInteger getOriginatorUserId() {
        return originatorUserId;
    }

    public void setOriginatorUserId(BigInteger originatorUserId) {
        this.originatorUserId = originatorUserId;
    }

    public BigInteger getReviewerUserId() {
        return reviewerUserId;
    }

    public void setReviewerUserId(BigInteger reviewerUserId) {
        this.reviewerUserId = reviewerUserId;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
