package build.dream.common.models.jingdong;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class FkmPayModel extends BasicModel {
    @NotNull
    @Length(max = 32)
    private String token;

    @NotNull
    @Length(max = 10)
    private String version = Constants.JING_DONG_PAY_VERSION;

    @NotNull
    @Length(max = 32)
    private String merchant;

    @NotNull
    @Length(max = 32)
    private String device;

    @NotNull
    @Length(max = 32)
    private String tradeNum;

    @NotNull
    @Length(max = 50)
    private String tradeName;

    @Length(max = 256)
    private String tradeDesc;

    @NotNull
    @Length(min = 14, max = 14)
    private String tradeTime;

    @NotNull
    private Long amount;

    @Length(max = 32)
    private String industryCategory;

    @NotNull
    @Length(max = 8)
    private String currency = Constants.CNY;

    @Length(max = 256)
    private String note;

    @Length(max = 256)
    private String topic;

    @Length(max = 3)
    private String orderGoodsNum;

    @Length(max = 20)
    private String vendorId;

    private List<GoodsInfo> goodsInfoList;

    private ReceiverInfo receiverInfo;

    private TermInfo termInfo;

    @Length(max = 32)
    private String payMerchant;

    private RiskInfo riskInfo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
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

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOrderGoodsNum() {
        return orderGoodsNum;
    }

    public void setOrderGoodsNum(String orderGoodsNum) {
        this.orderGoodsNum = orderGoodsNum;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
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

    public String getPayMerchant() {
        return payMerchant;
    }

    public void setPayMerchant(String payMerchant) {
        this.payMerchant = payMerchant;
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
        if (CollectionUtils.isNotEmpty(goodsInfoList)) {
            for (GoodsInfo goodsInfo : goodsInfoList) {
                goodsInfo.validateAndThrow();
            }
        }
        if (receiverInfo != null) {
            receiverInfo.validateAndThrow();
        }

        if (termInfo != null) {
            termInfo.validateAndThrow();
        }

        if (riskInfo != null) {
            riskInfo.validateAndThrow();
        }
    }
}
