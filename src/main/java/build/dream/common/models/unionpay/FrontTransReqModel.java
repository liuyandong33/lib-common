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
            return frontTransReqModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}