package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenPublicPersonalizedExtensionCreateModel extends AlipayBasicModel {
    @NotEmpty
    private List<Area> areas;

    @NotEmpty
    @JsonProperty(value = "label_rule")
    private List<LabelRule> labelRules;

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<LabelRule> getLabelRules() {
        return labelRules;
    }

    public void setLabelRules(List<LabelRule> labelRules) {
        this.labelRules = labelRules;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicPersonalizedExtensionCreateModel instance = new AlipayOpenPublicPersonalizedExtensionCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder areas(List<Area> areas) {
            instance.setAreas(areas);
            return this;
        }

        public Builder labelRules(List<LabelRule> labelRules) {
            instance.setLabelRules(labelRules);
            return this;
        }

        public AlipayOpenPublicPersonalizedExtensionCreateModel build() {
            AlipayOpenPublicPersonalizedExtensionCreateModel alipayOpenPublicPersonalizedExtensionCreateModel = new AlipayOpenPublicPersonalizedExtensionCreateModel();
            build(alipayOpenPublicPersonalizedExtensionCreateModel);
            alipayOpenPublicPersonalizedExtensionCreateModel.setAreas(instance.getAreas());
            alipayOpenPublicPersonalizedExtensionCreateModel.setLabelRules(instance.getLabelRules());
            return alipayOpenPublicPersonalizedExtensionCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Area extends BasicModel {
        @NotNull
        @Length(max = 12)
        private String name;

        @NotNull
        @InList(value = {"h5", "image"})
        private String type;

        @NotNull
        @Length(max = 1200)
        private String url;

        @Length(max = 1200)
        @JsonProperty(value = "goto_url")
        private String gotoUrl;

        @Min(value = 200)
        @Max(value = 500)
        private Integer height;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getGotoUrl() {
            return gotoUrl;
        }

        public void setGotoUrl(String gotoUrl) {
            this.gotoUrl = gotoUrl;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
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
