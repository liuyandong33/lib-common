package build.dream.common.models.unionpay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class FrontTransReqModel extends BasicModel {
    @NotNull
    private String version;

    @NotNull
    private String encoding;

    @NotNull
    private String bizType;

    @NotNull
    private String txnTime;

    @NotNull
    private String backUrl;

    @NotNull
    private String currencyCode;

    @NotNull
    private Integer txnAmt;

    @NotNull
    private String txnType;

    @NotNull
    @InList(value = {"01", "03"})
    private String txnSubType;

    @NotNull
    @InList(value = {"0", "1", "2"})
    private String accessType;

    @NotNull
    private String channelType;

    @NotNull
    private String merId;

    @NotNull
    private String orderId;

    private String orderDesc;

    private String subMerId;

    private String subMerAbbr;

    private String subMerName;

    private String issInsCode;

    private String instalTransInfo;

    private String encryptCertId;

    private String frontUrl;

    private String customerInfo;

    private String cardTransData;

    private String accountPayChannel;

    private String accNo;

    private String accType;

    private String certId;

    private String reserved;

    private String customerIp;

    private String orderTimeout;

    private String accSplitData;

    private String riskRateInfo;

    private String ctrlRule;

    private String defaultPayType;

    private String reqReserved;

    private String frontFailUrl;

    private String supPayType;

    private String payTimeout;

    private String termId;

    private String userMac;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(Integer txnAmt) {
        this.txnAmt = txnAmt;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnSubType() {
        return txnSubType;
    }

    public void setTxnSubType(String txnSubType) {
        this.txnSubType = txnSubType;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getSubMerId() {
        return subMerId;
    }

    public void setSubMerId(String subMerId) {
        this.subMerId = subMerId;
    }

    public String getSubMerAbbr() {
        return subMerAbbr;
    }

    public void setSubMerAbbr(String subMerAbbr) {
        this.subMerAbbr = subMerAbbr;
    }

    public String getSubMerName() {
        return subMerName;
    }

    public void setSubMerName(String subMerName) {
        this.subMerName = subMerName;
    }

    public String getIssInsCode() {
        return issInsCode;
    }

    public void setIssInsCode(String issInsCode) {
        this.issInsCode = issInsCode;
    }

    public String getInstalTransInfo() {
        return instalTransInfo;
    }

    public void setInstalTransInfo(String instalTransInfo) {
        this.instalTransInfo = instalTransInfo;
    }

    public String getEncryptCertId() {
        return encryptCertId;
    }

    public void setEncryptCertId(String encryptCertId) {
        this.encryptCertId = encryptCertId;
    }

    public String getFrontUrl() {
        return frontUrl;
    }

    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getCardTransData() {
        return cardTransData;
    }

    public void setCardTransData(String cardTransData) {
        this.cardTransData = cardTransData;
    }

    public String getAccountPayChannel() {
        return accountPayChannel;
    }

    public void setAccountPayChannel(String accountPayChannel) {
        this.accountPayChannel = accountPayChannel;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getOrderTimeout() {
        return orderTimeout;
    }

    public void setOrderTimeout(String orderTimeout) {
        this.orderTimeout = orderTimeout;
    }

    public String getAccSplitData() {
        return accSplitData;
    }

    public void setAccSplitData(String accSplitData) {
        this.accSplitData = accSplitData;
    }

    public String getRiskRateInfo() {
        return riskRateInfo;
    }

    public void setRiskRateInfo(String riskRateInfo) {
        this.riskRateInfo = riskRateInfo;
    }

    public String getCtrlRule() {
        return ctrlRule;
    }

    public void setCtrlRule(String ctrlRule) {
        this.ctrlRule = ctrlRule;
    }

    public String getDefaultPayType() {
        return defaultPayType;
    }

    public void setDefaultPayType(String defaultPayType) {
        this.defaultPayType = defaultPayType;
    }

    public String getReqReserved() {
        return reqReserved;
    }

    public void setReqReserved(String reqReserved) {
        this.reqReserved = reqReserved;
    }

    public String getFrontFailUrl() {
        return frontFailUrl;
    }

    public void setFrontFailUrl(String frontFailUrl) {
        this.frontFailUrl = frontFailUrl;
    }

    public String getSupPayType() {
        return supPayType;
    }

    public void setSupPayType(String supPayType) {
        this.supPayType = supPayType;
    }

    public String getPayTimeout() {
        return payTimeout;
    }

    public void setPayTimeout(String payTimeout) {
        this.payTimeout = payTimeout;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getUserMac() {
        return userMac;
    }

    public void setUserMac(String userMac) {
        this.userMac = userMac;
    }

    public static class Builder {
        private final FrontTransReqModel instance = new FrontTransReqModel();

        public Builder version(String version) {
            instance.setVersion(version);
            return this;
        }

        public Builder encoding(String encoding) {
            instance.setEncoding(encoding);
            return this;
        }

        public Builder bizType(String bizType) {
            instance.setBizType(bizType);
            return this;
        }

        public Builder txnTime(String txnTime) {
            instance.setTxnTime(txnTime);
            return this;
        }

        public Builder backUrl(String backUrl) {
            instance.setBackUrl(backUrl);
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            instance.setCurrencyCode(currencyCode);
            return this;
        }

        public Builder txnAmt(Integer txnAmt) {
            instance.setTxnAmt(txnAmt);
            return this;
        }

        public Builder txnType(String txnType) {
            instance.setTxnType(txnType);
            return this;
        }

        public Builder txnSubType(String txnSubType) {
            instance.setTxnSubType(txnSubType);
            return this;
        }

        public Builder accessType(String accessType) {
            instance.setAccessType(accessType);
            return this;
        }

        public Builder channelType(String channelType) {
            instance.setChannelType(channelType);
            return this;
        }

        public Builder merId(String merId) {
            instance.setMerId(merId);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder orderDesc(String orderDesc) {
            instance.setOrderDesc(orderDesc);
            return this;
        }

        public Builder subMerId(String subMerId) {
            instance.setSubMerId(subMerId);
            return this;
        }

        public Builder subMerAbbr(String subMerAbbr) {
            instance.setSubMerAbbr(subMerAbbr);
            return this;
        }

        public Builder subMerName(String subMerName) {
            instance.setSubMerName(subMerName);
            return this;
        }

        public Builder issInsCode(String issInsCode) {
            instance.setIssInsCode(issInsCode);
            return this;
        }

        public Builder instalTransInfo(String instalTransInfo) {
            instance.setInstalTransInfo(instalTransInfo);
            return this;
        }

        public Builder encryptCertId(String encryptCertId) {
            instance.setEncryptCertId(encryptCertId);
            return this;
        }

        public Builder frontUrl(String frontUrl) {
            instance.setFrontUrl(frontUrl);
            return this;
        }

        public Builder customerInfo(String customerInfo) {
            instance.setCustomerInfo(customerInfo);
            return this;
        }

        public Builder cardTransData(String cardTransData) {
            instance.setCardTransData(cardTransData);
            return this;
        }

        public Builder accountPayChannel(String accountPayChannel) {
            instance.setAccountPayChannel(accountPayChannel);
            return this;
        }

        public Builder accNo(String accNo) {
            instance.setAccNo(accNo);
            return this;
        }

        public Builder accType(String accType) {
            instance.setAccType(accType);
            return this;
        }

        public Builder certId(String certId) {
            instance.setCertId(certId);
            return this;
        }

        public Builder reserved(String reserved) {
            instance.setReserved(reserved);
            return this;
        }

        public Builder customerIp(String customerIp) {
            instance.setCustomerIp(customerIp);
            return this;
        }

        public Builder orderTimeout(String orderTimeout) {
            instance.setOrderTimeout(orderTimeout);
            return this;
        }

        public Builder accSplitData(String accSplitData) {
            instance.setAccSplitData(accSplitData);
            return this;
        }

        public Builder riskRateInfo(String riskRateInfo) {
            instance.setRiskRateInfo(riskRateInfo);
            return this;
        }

        public Builder ctrlRule(String ctrlRule) {
            instance.setCtrlRule(ctrlRule);
            return this;
        }

        public Builder defaultPayType(String defaultPayType) {
            instance.setDefaultPayType(defaultPayType);
            return this;
        }

        public Builder reqReserved(String reqReserved) {
            instance.setReqReserved(reqReserved);
            return this;
        }

        public Builder frontFailUrl(String frontFailUrl) {
            instance.setFrontFailUrl(frontFailUrl);
            return this;
        }

        public Builder supPayType(String supPayType) {
            instance.setSupPayType(supPayType);
            return this;
        }

        public Builder payTimeout(String payTimeout) {
            instance.setPayTimeout(payTimeout);
            return this;
        }

        public Builder termId(String termId) {
            instance.setTermId(termId);
            return this;
        }

        public Builder userMac(String userMac) {
            instance.setUserMac(userMac);
            return this;
        }

        public FrontTransReqModel build() {
            FrontTransReqModel frontTransReqModel = new FrontTransReqModel();
            frontTransReqModel.setVersion(instance.getVersion());
            frontTransReqModel.setEncoding(instance.getEncoding());
            frontTransReqModel.setBizType(instance.getBizType());
            frontTransReqModel.setTxnTime(instance.getTxnTime());
            frontTransReqModel.setBackUrl(instance.getBackUrl());
            frontTransReqModel.setCurrencyCode(instance.getCurrencyCode());
            frontTransReqModel.setTxnAmt(instance.getTxnAmt());
            frontTransReqModel.setTxnType(instance.getTxnType());
            frontTransReqModel.setTxnSubType(instance.getTxnSubType());
            frontTransReqModel.setAccessType(instance.getAccessType());
            frontTransReqModel.setChannelType(instance.getChannelType());
            frontTransReqModel.setMerId(instance.getMerId());
            frontTransReqModel.setOrderId(instance.getOrderId());
            frontTransReqModel.setOrderDesc(instance.getOrderDesc());
            frontTransReqModel.setSubMerId(instance.getSubMerId());
            frontTransReqModel.setSubMerAbbr(instance.getSubMerAbbr());
            frontTransReqModel.setSubMerName(instance.getSubMerName());
            frontTransReqModel.setIssInsCode(instance.getIssInsCode());
            frontTransReqModel.setInstalTransInfo(instance.getInstalTransInfo());
            frontTransReqModel.setEncryptCertId(instance.getEncryptCertId());
            frontTransReqModel.setFrontUrl(instance.getFrontUrl());
            frontTransReqModel.setCustomerInfo(instance.getCustomerInfo());
            frontTransReqModel.setCardTransData(instance.getCardTransData());
            frontTransReqModel.setAccountPayChannel(instance.getAccountPayChannel());
            frontTransReqModel.setAccNo(instance.getAccNo());
            frontTransReqModel.setAccType(instance.getAccType());
            frontTransReqModel.setCertId(instance.getCertId());
            frontTransReqModel.setReserved(instance.getReserved());
            frontTransReqModel.setCustomerIp(instance.getCustomerIp());
            frontTransReqModel.setOrderTimeout(instance.getOrderTimeout());
            frontTransReqModel.setAccSplitData(instance.getAccSplitData());
            frontTransReqModel.setRiskRateInfo(instance.getRiskRateInfo());
            frontTransReqModel.setCtrlRule(instance.getCtrlRule());
            frontTransReqModel.setDefaultPayType(instance.getDefaultPayType());
            frontTransReqModel.setReqReserved(instance.getReqReserved());
            frontTransReqModel.setFrontFailUrl(instance.getFrontFailUrl());
            frontTransReqModel.setSupPayType(instance.getSupPayType());
            frontTransReqModel.setPayTimeout(instance.getPayTimeout());
            frontTransReqModel.setTermId(instance.getTermId());
            frontTransReqModel.setUserMac(instance.getUserMac());
            return frontTransReqModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}