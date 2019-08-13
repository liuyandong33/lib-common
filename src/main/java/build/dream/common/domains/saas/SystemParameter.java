package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class SystemParameter extends BasicDomain {
    public static final String TABLE_NAME = "system_parameter";
    /**
     * 参数名称
     */
    private String parameterName;
    /**
     * 参数值
     */
    private String parameterValue;

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SystemParameter> {
        public Builder parameterName(String parameterName) {
            instance.setParameterName(parameterName);
            return this;
        }

        public Builder parameterValue(String parameterValue) {
            instance.setParameterValue(parameterValue);
            return this;
        }

        @Override
        public SystemParameter build() {
            SystemParameter systemParameter = super.build();
            systemParameter.setParameterName(instance.getParameterName());
            systemParameter.setParameterValue(instance.getParameterValue());
            return systemParameter;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String PARAMETER_NAME = "parameter_name";
        public static final String PARAMETER_VALUE = "parameter_value";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String PARAMETER_NAME = "parameterName";
        public static final String PARAMETER_VALUE = "parameterValue";
    }
}
