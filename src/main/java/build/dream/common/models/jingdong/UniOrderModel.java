package build.dream.common.models.jingdong;

import build.dream.common.models.BasicModel;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class UniOrderModel extends BasicModel {
    private static final String[] ORDER_TYPES = {"0", "1"};
    private static final String[] TRADE_TYPES = {"GEN", "QR"};
    @NotNull
    @Length(max = 32)
    private String merchant;

    @Length(max = 32)
    private String payMerchant;

    @Length(max = 32)
    private String device;

    @NotNull
    @Length(max = 32)
    private String tradeNum;

    @NotNull
    @Length(max = 32)
    private String tradeName;

    @Length(max = 1024)
    private String tradeDesc;

    @NotNull
    @Length(min = 14, max = 14)
    private String tradeTime;

    @NotNull
    private Long amount;

    private String orderType;

    @Length(max = 32)
    private String industryCategoryCode;

    private String currency;

    @Length(max = 256)
    private String note;

    @Length(max = 256)
    private String callbackUrl;

    @NotNull
    @Length(max = 256)
    private String notifyUrl;

    @Length(max = 16)
    private String ip;

    @Length(max = 64)
    private String specCardNo;

    @Length(max = 64)
    private String specId;

    @Length(max = 64)
    private String specName;

    private String tradeType;

    @Length(max = 64)
    private String userId;

    private Integer expireTime;

    @Max(value = 999)
    private Integer orderGoodsNum;

    @Length(max = 20)
    private String vendorId;

    private List<GoodsInfo> goodsInfo;

    private ReceiverInfo receiverInfo;

    private TermInfo termInfo;

    private RiskInfo riskInfo;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getPayMerchant() {
        return payMerchant;
    }

    public void setPayMerchant(String payMerchant) {
        this.payMerchant = payMerchant;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(String tradeNum) {
        this.tradeNum = tradeNum;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeDesc() {
        return tradeDesc;
    }

    public void setTradeDesc(String tradeDesc) {
        this.tradeDesc = tradeDesc;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getIndustryCategoryCode() {
        return industryCategoryCode;
    }

    public void setIndustryCategoryCode(String industryCategoryCode) {
        this.industryCategoryCode = industryCategoryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSpecCardNo() {
        return specCardNo;
    }

    public void setSpecCardNo(String specCardNo) {
        this.specCardNo = specCardNo;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getOrderGoodsNum() {
        return orderGoodsNum;
    }

    public void setOrderGoodsNum(Integer orderGoodsNum) {
        this.orderGoodsNum = orderGoodsNum;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public List<GoodsInfo> getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(List<GoodsInfo> goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public ReceiverInfo getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(ReceiverInfo receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public TermInfo getTermInfo() {
        return termInfo;
    }

    public void setTermInfo(TermInfo termInfo) {
        this.termInfo = termInfo;
    }

    public RiskInfo getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(RiskInfo riskInfo) {
        this.riskInfo = riskInfo;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if (CollectionUtils.isNotEmpty(goodsInfo)) {
            for (GoodsInfo info : goodsInfo) {
                info.validateAndThrow();
            }
        }
        if (Objects.nonNull(receiverInfo)) {
            receiverInfo.validateAndThrow();
        }

        if (Objects.nonNull(termInfo)) {
            termInfo.validateAndThrow();
        }

        if (Objects.nonNull(riskInfo)) {
            riskInfo.validateAndThrow();
        }
    }
}
