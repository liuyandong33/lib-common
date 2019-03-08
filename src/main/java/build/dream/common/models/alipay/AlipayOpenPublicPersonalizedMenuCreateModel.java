package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenPublicPersonalizedMenuCreateModel extends AlipayBasicModel {
    @JsonProperty(value = "button")
    private List<ButtonObject> buttonObjects;

    @NotEmpty
    @JsonProperty(value = "label_rule")
    private List<LabelRule> labelRules;

    @InList(value = {"icon", "text"})
    private String type;

    public List<ButtonObject> getButtonObjects() {
        return buttonObjects;
    }

    public void setButtonObjects(List<ButtonObject> buttonObjects) {
        this.buttonObjects = buttonObjects;
    }

    public List<LabelRule> getLabelRules() {
        return labelRules;
    }

    public void setLabelRules(List<LabelRule> labelRules) {
        this.labelRules = labelRules;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Builder {
        private final AlipayOpenPublicPersonalizedMenuCreateModel instance = new AlipayOpenPublicPersonalizedMenuCreateModel();

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

        public Builder buttonObjects(List<ButtonObject> buttonObjects) {
            instance.setButtonObjects(buttonObjects);
            return this;
        }

        public Builder labelRules(List<LabelRule> labelRules) {
            instance.setLabelRules(labelRules);
            return this;
        }

        public Builder type(String type) {
            instance.setType(type);
            return this;
        }

        public AlipayOpenPublicPersonalizedMenuCreateModel build() {
            AlipayOpenPublicPersonalizedMenuCreateModel alipayOpenPublicPersonalizedMenuCreateModel = new AlipayOpenPublicPersonalizedMenuCreateModel();
            alipayOpenPublicPersonalizedMenuCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicPersonalizedMenuCreateModel.setBranchId(instance.getBranchId());
            alipayOpenPublicPersonalizedMenuCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicPersonalizedMenuCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicPersonalizedMenuCreateModel.setAuthToken(instance.getAuthToken());
            alipayOpenPublicPersonalizedMenuCreateModel.setButtonObjects(instance.getButtonObjects());
            alipayOpenPublicPersonalizedMenuCreateModel.setLabelRules(instance.getLabelRules());
            alipayOpenPublicPersonalizedMenuCreateModel.setType(instance.getType());
            return alipayOpenPublicPersonalizedMenuCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class SubButton extends BasicModel {
        @NotNull
        @Length(max = 12)
        private String name;

        @NotNull
        @InList(value = {"out", "link", "tel", "map", "consumption"})
        @JsonProperty(value = "action_type")
        private String actionType;

        @NotNull
        @Length(max = 256)
        @JsonProperty(value = "action_param")
        private String actionParam;

        @Length(max = 64)
        private String icon;

        @JsonProperty(value = "sub_button")
        private List<SubButton> subButtons;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getActionType() {
            return actionType;
        }

        public void setActionType(String actionType) {
            this.actionType = actionType;
        }

        public String getActionParam() {
            return actionParam;
        }

        public void setActionParam(String actionParam) {
            this.actionParam = actionParam;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<SubButton> getSubButtons() {
            return subButtons;
        }

        public void setSubButtons(List<SubButton> subButtons) {
            this.subButtons = subButtons;
        }
    }

    public static class ButtonObject extends BasicModel {
        @NotNull
        @Length(max = 12)
        private String name;

        @InList(value = {"out", "link", "tel", "map", "consumption"})
        @JsonProperty(value = "action_type")
        private String actionType;

        @Length(max = 256)
        @JsonProperty(value = "action_param")
        private String actionParam;

        @Length(max = 64)
        private String icon;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getActionType() {
            return actionType;
        }

        public void setActionType(String actionType) {
            this.actionType = actionType;
        }

        public String getActionParam() {
            return actionParam;
        }

        public void setActionParam(String actionParam) {
            this.actionParam = actionParam;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class LabelRule extends BasicModel {
        @NotNull
        @Length(max = 32)
        @JsonProperty(value = "label_id")
        private String labelId;

        @NotNull
        @InList(value = {"EQ", "BETWEEN", "IN"})
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
