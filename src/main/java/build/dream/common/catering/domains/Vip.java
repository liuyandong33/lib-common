package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class Vip extends BasicDomain {
    public static final String TABLE_NAME = "vip";
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

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public Vip build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String VIP_TYPE_ID = "vip_type_id";
        public static final String VIP_CODE = "vip_code";
        public static final String VIP_NAME = "vip_name";
        public static final String BIRTHDAY = "birthday";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String OPEN_ID = "open_id";
        public static final String MAIN_OPEN_ID = "main_open_id";
        public static final String ALIPAY_USER_ID = "alipay_user_id";
        public static final String CARD_ID = "card_id";
        public static final String USER_CARD_CODE = "user_card_code";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String VIP_TYPE_ID = "vipTypeId";
        public static final String VIP_CODE = "vipCode";
        public static final String VIP_NAME = "vipName";
        public static final String BIRTHDAY = "birthday";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String OPEN_ID = "openId";
        public static final String MAIN_OPEN_ID = "mainOpenId";
        public static final String ALIPAY_USER_ID = "alipayUserId";
        public static final String CARD_ID = "cardId";
        public static final String USER_CARD_CODE = "userCardCode";
    }
}
