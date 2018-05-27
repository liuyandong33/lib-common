package build.dream.common.models.jingdongpay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.GsonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    public static class GoodsInfo extends BasicModel {
        private static final String[] TYPES = {"GT01", "GT02"};
        @Length(max = 30)
        private String id;

        @Length(max = 10)
        private String cat1;

        @Length(max = 10)
        private String cat2;

        @Length(max = 10)
        private String cat3;

        private String type;

        private Long price;

        private Integer num;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat1() {
            return cat1;
        }

        public void setCat1(String cat1) {
            this.cat1 = cat1;
        }

        public String getCat2() {
            return cat2;
        }

        public void setCat2(String cat2) {
            this.cat2 = cat2;
        }

        public String getCat3() {
            return cat3;
        }

        public void setCat3(String cat3) {
            this.cat3 = cat3;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        @Override
        public boolean validate() {
            boolean isValidate = super.validate();
            if (!isValidate) {
                return false;
            }
            if (StringUtils.isNotBlank(type) && !ArrayUtils.contains(TYPES, type)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return GsonUtils.toJson(this, false);
        }
    }

    public static class ReceiverInfo extends BasicModel {
        @Length(max = 100)
        private String name;

        @Length(max = 500)
        private String address;

        @Length(max = 30)
        private String mobile;

        @Length(max = 20)
        private String phone;

        @Length(max = 100)
        private String email;

        @Length(max = 30)
        private String province;

        @Length(max = 30)
        private String city;

        @Length(max = 30)
        private String country;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return GsonUtils.toJson(this, false);
        }
    }

    public static class TermInfo extends BasicModel {
        private static final String[] OS_VERSIONS = {"OS01", "OS02", "OS03", "OS04", "OS05"};
        @Length(max = 50)
        private String type;

        @Length(max = 30)
        private String ip;

        @Length(max = 50)
        private String mac;

        @Length(max = 50)
        private String imei;

        @Length(max = 50)
        private String idfv;

        @Length(max = 50)
        private String adid;

        @Length(max = 10)
        private String os;

        private String osVersion;

        @Length(max = 30)
        private String termInfoId;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getIdfv() {
            return idfv;
        }

        public void setIdfv(String idfv) {
            this.idfv = idfv;
        }

        public String getAdid() {
            return adid;
        }

        public void setAdid(String adid) {
            this.adid = adid;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public void setOsVersion(String osVersion) {
            this.osVersion = osVersion;
        }

        public String getTermInfoId() {
            return termInfoId;
        }

        public void setTermInfoId(String termInfoId) {
            this.termInfoId = termInfoId;
        }

        @Override
        public boolean validate() {
            boolean isValidate = super.validate();
            if (!isValidate) {
                return false;
            }
            if (StringUtils.isNotBlank(osVersion) && !ArrayUtils.contains(OS_VERSIONS, osVersion)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return GsonUtils.toJson(this, false);
        }
    }

    public static class RiskInfo extends BasicModel {
        @Length(max = 64)
        private String omId;

        @Length(max = 200)
        private String omName;

        @Length(max = 30)
        private String omRt;

        @Length(max = 20)
        private String omType;

        @Length(max = 200)
        private String omAdd;

        @Length(max = 64)
        private String agentId;

        @Length(max = 200)
        private String agentName;

        @NotNull
        @Length(max = 64)
        private String enterpriseId;

        public String getOmId() {
            return omId;
        }

        public void setOmId(String omId) {
            this.omId = omId;
        }

        public String getOmName() {
            return omName;
        }

        public void setOmName(String omName) {
            this.omName = omName;
        }

        public String getOmRt() {
            return omRt;
        }

        public void setOmRt(String omRt) {
            this.omRt = omRt;
        }

        public String getOmType() {
            return omType;
        }

        public void setOmType(String omType) {
            this.omType = omType;
        }

        public String getOmAdd() {
            return omAdd;
        }

        public void setOmAdd(String omAdd) {
            this.omAdd = omAdd;
        }

        public String getAgentId() {
            return agentId;
        }

        public void setAgentId(String agentId) {
            this.agentId = agentId;
        }

        public String getAgentName() {
            return agentName;
        }

        public void setAgentName(String agentName) {
            this.agentName = agentName;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        @Override
        public String toString() {
            return GsonUtils.toJson(this, false);
        }
    }
}
