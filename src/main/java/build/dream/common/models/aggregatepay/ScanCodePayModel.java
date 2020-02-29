package build.dream.common.models.aggregatepay;

import build.dream.common.beans.MqConfig;
import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class ScanCodePayModel extends BasicModel {
    @NotNull
    private String tenantId;

    @NotNull
    private String branchId;

    @NotNull
    private Integer channelType;

    @NotNull
    private String outTradeNo;

    @NotNull
    private String authCode;

    @NotNull
    private String subject;

    @NotNull
    private Integer totalAmount;

    @NotNull
    private MqConfig mqConfig;

    @NotNull
    private String ipAddress;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public MqConfig getMqConfig() {
        return mqConfig;
    }

    public void setMqConfig(MqConfig mqConfig) {
        this.mqConfig = mqConfig;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public static class Builder {
        private final ScanCodePayModel instance = new ScanCodePayModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder channelType(Integer channelType) {
            instance.setChannelType(channelType);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder authCode(String authCode) {
            instance.setAuthCode(authCode);
            return this;
        }

        public Builder subject(String subject) {
            instance.setSubject(subject);
            return this;
        }

        public Builder totalAmount(Integer totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder mqConfig(MqConfig mqConfig) {
            instance.setMqConfig(mqConfig);
            return this;
        }

        public Builder ipAddress(String ipAddress) {
            instance.setIpAddress(ipAddress);
            return this;
        }

        public ScanCodePayModel build() {
            ScanCodePayModel scanCodePayModel = new ScanCodePayModel();
            scanCodePayModel.setTenantId(instance.getTenantId());
            scanCodePayModel.setBranchId(instance.getBranchId());
            scanCodePayModel.setChannelType(instance.getChannelType());
            scanCodePayModel.setOutTradeNo(instance.getOutTradeNo());
            scanCodePayModel.setAuthCode(instance.getAuthCode());
            scanCodePayModel.setSubject(instance.getSubject());
            scanCodePayModel.setTotalAmount(instance.getTotalAmount());
            scanCodePayModel.setMqConfig(instance.getMqConfig());
            scanCodePayModel.setIpAddress(instance.getIpAddress());
            return scanCodePayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
