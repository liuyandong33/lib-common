package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenPublicMenuModifyModel extends AlipayBasicModel {
    @JsonProperty(value = "button")
    private List<ButtonObject> buttonObjects;

    @InList(value = {"icon", "text"})
    private String type;

    public List<ButtonObject> getButtonObjects() {
        return buttonObjects;
    }

    public void setButtonObjects(List<ButtonObject> buttonObjects) {
        this.buttonObjects = buttonObjects;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicMenuModifyModel instance = new AlipayOpenPublicMenuModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder buttonObjects(List<ButtonObject> buttonObjects) {
            instance.setButtonObjects(buttonObjects);
            return this;
        }

        public Builder type(String type) {
            instance.setType(type);
            return this;
        }

        public AlipayOpenPublicMenuModifyModel build() {
            AlipayOpenPublicMenuModifyModel alipayOpenPublicMenuModifyModel = new AlipayOpenPublicMenuModifyModel();
            build(alipayOpenPublicMenuModifyModel);
            alipayOpenPublicMenuModifyModel.setButtonObjects(instance.getButtonObjects());
            alipayOpenPublicMenuModifyModel.setType(instance.getType());
            return alipayOpenPublicMenuModifyModel;
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
}
