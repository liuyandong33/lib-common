package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

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
    private Date birthday;
    /**
     * 会员电话号码
     */
    private String phoneNumber;
    /**
     * 微信open id
     */
    private String openId;
    /**
     * 主账号open id
     */
    private String mainOpenId;
    /**
     * 支付宝用户ID
     */
    private String alipayUserId;
    /**
     * 微信会员卡id
     */
    private String cardId;
    /**
     * 微信会员卡编号
     */
    private String userCardCode;
    /**
     * 会员积分
     */
    private Integer bonus;

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

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
