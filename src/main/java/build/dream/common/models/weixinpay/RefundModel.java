package build.dream.common.models.weixinpay;

import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RefundModel extends WeiXinPayBasicModel {
    private static final String[] REFUNDS_ACCOUNTS = {"REFUND_SOURCE_UNSETTLED_FUNDS", "REFUND_SOURCE_RECHARGE_FUNDS"};
    private static final String[] REFUND_FEE_TYPES = {"CNY"};

    @Length(max = 32)
    private String transactionId;

    @Length(max = 32)
    private String outTradeNo;

    @NotNull
    @Length(max = 64)
    private String outRefundNo;

    @NotNull
    private Integer totalFee;

    @NotNull
    private Integer refundFee;

    private String refundFeeType;

    @Length(max = 80)
    private String refundDesc;

    private String refundAccount;

    private String topic;

    /**
     * 操作证书
     */
    @NotNull
    private String operationCertificate;
    /**
     * 操作证书密码
     */
    @NotNull
    private String operationCertificatePassword;

    /**
     * api_v3秘钥
     */
    private String apiV3Key;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOperationCertificate() {
        return operationCertificate;
    }

    public void setOperationCertificate(String operationCertificate) {
        this.operationCertificate = operationCertificate;
    }

    public String getOperationCertificatePassword() {
        return operationCertificatePassword;
    }

    public void setOperationCertificatePassword(String operationCertificatePassword) {
        this.operationCertificatePassword = operationCertificatePassword;
    }

    public String getApiV3Key() {
        return apiV3Key;
    }

    public void setApiV3Key(String apiV3Key) {
        this.apiV3Key = apiV3Key;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(transactionId) || StringUtils.isNotBlank(outTradeNo), "参数transactionId，outTradeNo不能同时为空！");
        if (StringUtils.isNotBlank(refundFeeType)) {
            ApplicationHandler.inArray(REFUND_FEE_TYPES, refundFeeType, "refundFeeType");
        }
        if (StringUtils.isNotBlank(refundAccount)) {
            ApplicationHandler.inArray(REFUNDS_ACCOUNTS, refundAccount, "refundAccount");
        }
    }

    public static class Builder extends WeiXinPayBasicModel.Builder<Builder, RefundModel> {
        public Builder transactionId(String transactionId) {
            instance.setTransactionId(transactionId);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder outRefundNo(String outRefundNo) {
            instance.setOutRefundNo(outRefundNo);
            return this;
        }

        public Builder totalFee(Integer totalFee) {
            instance.setTotalFee(totalFee);
            return this;
        }

        public Builder refundFee(Integer refundFee) {
            instance.setRefundFee(refundFee);
            return this;
        }

        public Builder refundFeeType(String refundFeeType) {
            instance.setRefundFeeType(refundFeeType);
            return this;
        }

        public Builder refundDesc(String refundDesc) {
            instance.setRefundDesc(refundDesc);
            return this;
        }

        public Builder refundAccount(String refundAccount) {
            instance.setRefundAccount(refundAccount);
            return this;
        }

        public Builder topic(String topic) {
            instance.setTopic(topic);
            return this;
        }

        public Builder operationCertificate(String operationCertificate) {
            instance.setOperationCertificate(operationCertificate);
            return this;
        }

        public Builder operationCertificatePassword(String operationCertificatePassword) {
            instance.setOperationCertificatePassword(operationCertificatePassword);
            return this;
        }

        public Builder apiV3Key(String apiV3Key) {
            instance.setApiV3Key(apiV3Key);
            return this;
        }

        @Override
        public RefundModel build() {
            RefundModel refundModel = super.build();
            refundModel.setTransactionId(instance.getTransactionId());
            refundModel.setOutTradeNo(instance.getOutTradeNo());
            refundModel.setOutRefundNo(instance.getOutRefundNo());
            refundModel.setTotalFee(instance.getTotalFee());
            refundModel.setRefundFee(instance.getRefundFee());
            refundModel.setRefundFeeType(instance.getRefundFeeType());
            refundModel.setRefundDesc(instance.getRefundDesc());
            refundModel.setRefundAccount(instance.getRefundAccount());
            refundModel.setTopic(instance.getTopic());
            refundModel.setOperationCertificate(instance.getOperationCertificate());
            refundModel.setOperationCertificatePassword(instance.getOperationCertificatePassword());
            refundModel.setApiV3Key(instance.getApiV3Key());
            return refundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}