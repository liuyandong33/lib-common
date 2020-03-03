package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.util.Date;

@ShardingColumn(fieldName = Vip.FieldName.TENANT_ID, columnName = Vip.ColumnName.TENANT_ID)
public class Vip extends BasicDomain {
    public static final String TABLE_NAME = "vip";
    /**
     * 商户id
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店id
     */
    private Long branchId;
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

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
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

    public static class Builder extends BasicDomain.Builder<Builder, Vip> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
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

        @Override
        public Vip build() {
            Vip vip = super.build();
            vip.setTenantId(instance.getTenantId());
            vip.setTenantCode(instance.getTenantCode());
            vip.setBranchId(instance.getBranchId());
            vip.setVipCode(instance.getVipCode());
            vip.setVipName(instance.getVipName());
            vip.setBirthday(instance.getBirthday());
            vip.setPhoneNumber(instance.getPhoneNumber());
            vip.setOpenId(instance.getOpenId());
            vip.setMainOpenId(instance.getMainOpenId());
            vip.setAlipayUserId(instance.getAlipayUserId());
            vip.setCardId(instance.getCardId());
            vip.setUserCardCode(instance.getUserCardCode());
            return vip;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
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
