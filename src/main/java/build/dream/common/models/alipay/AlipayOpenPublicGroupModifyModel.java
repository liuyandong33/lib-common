package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenPublicGroupModifyModel extends AlipayBasicModel {
    @Length(max = 10)
    @JsonProperty(value = "group_id")
    private String groupId;

    @Length(max = 30)
    private String name;

    @NotEmpty
    private List<LabelRule> labelRules;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LabelRule> getLabelRules() {
        return labelRules;
    }

    public void setLabelRules(List<LabelRule> labelRules) {
        this.labelRules = labelRules;
    }

    public static class Builder {
        private final AlipayOpenPublicGroupModifyModel instance = new AlipayOpenPublicGroupModifyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder groupId(String groupId) {
            instance.setGroupId(groupId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder labelRules(List<LabelRule> labelRules) {
            instance.setLabelRules(labelRules);
            return this;
        }

        public AlipayOpenPublicGroupModifyModel build() {
            AlipayOpenPublicGroupModifyModel alipayOpenPublicGroupModifyModel = new AlipayOpenPublicGroupModifyModel();
            alipayOpenPublicGroupModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicGroupModifyModel.setBranchId(instance.getBranchId());
            alipayOpenPublicGroupModifyModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicGroupModifyModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicGroupModifyModel.setAuthToken(instance.getAuthToken());
            alipayOpenPublicGroupModifyModel.setGroupId(instance.getGroupId());
            alipayOpenPublicGroupModifyModel.setName(instance.getName());
            alipayOpenPublicGroupModifyModel.setLabelRules(instance.getLabelRules());
            return alipayOpenPublicGroupModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class LabelRule extends BasicModel {
        @NotNull
        @Length(max = 32)
        @JsonProperty(value = "label_id")
        private String labelId;

        @NotNull
        @InList(value = {"EQ", "NEQ", "LT", "GT", "LTEQ", "GTEQ", "LIKE", "BETWEEN", "IN", "NOTIN"})
        private String operator;

        @NotNull
        @Length(max = 120)
        @JsonProperty(value = "label_value")
        private String labelValue;

        public String getLabelId() {
            return labelId;
        }

        public void setLabelId(String labelId) {
            this.labelId = labelId;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public String getLabelValue() {
            return labelValue;
        }

        public void setLabelValue(String labelValue) {
            this.labelValue = labelValue;
        }
    }
}
