package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class Vip extends BasicDomain {
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
     * 会员类型ID
     */
    private BigInteger vipTypeId;
    /**
     * 会员编号
     */
    private String vipCode;
    /**
     * 会员姓名
     */
    private String vipName;
    /**
     * 会员生日
     */
    private Date birthday = Constants.DATETIME_DEFAULT_VALUE;
    /**
     * 会员电话号码
     */
    private String phoneNumber;
    /**
     * 微信open id
     */
    private String openId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 主账号open id
     */
    private String mainOpenId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 支付宝用户ID
     */
    private String alipayUserId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 微信会员卡id
     */
    private String cardId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 微信会员卡编号
     */
    private String userCardCode = Constants.VARCHAR_DEFAULT_VALUE;

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

    public BigInteger getVipTypeId() {
        return vipTypeId;
    }

    public void setVipTypeId(BigInteger vipTypeId) {
        this.vipTypeId = vipTypeId;
    }

    public String getVipCode() {
        return vipCode;
    }

    public void setVipCode(String vipCode) {
        this.vipCode = vipCode;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getMainOpenId() {
        return mainOpenId;
    }

    public void setMainOpenId(String mainOpenId) {
        this.mainOpenId = mainOpenId;
    }

    public String getAlipayUserId() {
        return alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserCardCode() {
        return userCardCode;
    }

    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }

    public static class Builder {
        private final Vip instance = new Vip();

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

        public Builder vipTypeId(BigInteger vipTypeId) {
            instance.setVipTypeId(vipTypeId);
            return this;
        }

        public Builder vipCode(String vipCode) {
            instance.setVipCode(vipCode);
            return this;
        }

        public Builder vipName(String vipName) {
            instance.setVipName(vipName);
            return this;
        }

        public Builder birthday(Date birthday) {
            instance.setBirthday(birthday);
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            instance.setPhoneNumber(phoneNumber);
            return this;
        }

        public Builder openId(String openId) {
            instance.setOpenId(openId);
            return this;
        }

        public Builder mainOpenId(String mainOpenId) {
            instance.setMainOpenId(mainOpenId);
            return this;
        }

        public Builder alipayUserId(String alipayUserId) {
            instance.setAlipayUserId(alipayUserId);
            return this;
        }

        public Builder cardId(String cardId) {
            instance.setCardId(cardId);
            return this;
        }

        public Builder userCardCode(String userCardCode) {
            instance.setUserCardCode(userCardCode);
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
