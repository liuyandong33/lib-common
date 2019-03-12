package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

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

    public static class Builder {
        private final SystemParameter instance = new SystemParameter();

        public Builder parameterName(String parameterName) {
            instance.setParameterName(parameterName);
            return this;
        }

        public Builder parameterValue(String parameterValue) {
            instance.setParameterValue(parameterValue);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public SystemParameter build() {
            SystemParameter systemParameter = new SystemParameter();
            systemParameter.setParameterName(instance.getParameterName());
            systemParameter.setParameterValue(instance.getParameterValue());
            systemParameter.setId(instance.getId());
            systemParameter.setCreatedTime(instance.getCreatedTime());
            systemParameter.setCreatedUserId(instance.getCreatedUserId());
            systemParameter.setUpdatedTime(instance.getUpdatedTime());
            systemParameter.setUpdatedUserId(instance.getUpdatedUserId());
            systemParameter.setUpdatedRemark(instance.getUpdatedRemark());
            systemParameter.setDeletedTime(instance.getDeletedTime());
            systemParameter.setDeleted(instance.isDeleted());
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
