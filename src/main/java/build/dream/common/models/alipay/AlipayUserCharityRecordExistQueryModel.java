package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayUserCharityRecordExistQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "partner_id")
    private String partnerId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "user_id")
    private String userId;

    @Length(max = 2)
    @JsonProperty(value = "biz_type")
    private String bizType;

    @Length(min = 20, max = 20)
    @JsonProperty(value = "start_time")
    private String startTime;

    @Length(min = 20, max = 20)
    @JsonProperty(value = "end_time")
    private String endTime;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public static class Builder {
        private final AlipayUserCharityRecordExistQueryModel instance = new AlipayUserCharityRecordExistQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder partnerId(String partnerId) {
            instance.setPartnerId(partnerId);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder bizType(String bizType) {
            instance.setBizType(bizType);
            return this;
        }

        public Builder startTime(String startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(String endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public AlipayUserCharityRecordExistQueryModel build() {
            AlipayUserCharityRecordExistQueryModel alipayUserCharityRecordExistQueryModel = new AlipayUserCharityRecordExistQueryModel();
            alipayUserCharityRecordExistQueryModel.setTenantId(instance.getTenantId());
            alipayUserCharityRecordExistQueryModel.setBranchId(instance.getBranchId());
            alipayUserCharityRecordExistQueryModel.setPartnerId(instance.getPartnerId());
            alipayUserCharityRecordExistQueryModel.setUserId(instance.getUserId());
            alipayUserCharityRecordExistQueryModel.setBizType(instance.getBizType());
            alipayUserCharityRecordExistQueryModel.setStartTime(instance.getStartTime());
            alipayUserCharityRecordExistQueryModel.setEndTime(instance.getEndTime());
            return alipayUserCharityRecordExistQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
