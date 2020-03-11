package build.dream.common.domains.devops;

import build.dream.common.basic.BasicDomain;

public class MySqlConfiguration extends BasicDomain {
    private String name;
    private String value;
    private String type;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder {
        private final MySqlConfiguration instance = new MySqlConfiguration();

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder value(String value) {
            instance.setValue(value);
            return this;
        }

        public Builder type(String type) {
            instance.setType(type);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        public MySqlConfiguration build() {
            MySqlConfiguration mySqlConfiguration = new MySqlConfiguration();
            mySqlConfiguration.setName(instance.getName());
            mySqlConfiguration.setValue(instance.getValue());
            mySqlConfiguration.setType(instance.getType());
            mySqlConfiguration.setRemark(instance.getRemark());
            mySqlConfiguration.setId(instance.getId());
            mySqlConfiguration.setCreatedTime(instance.getCreatedTime());
            mySqlConfiguration.setCreatedUserId(instance.getCreatedUserId());
            mySqlConfiguration.setUpdatedTime(instance.getUpdatedTime());
            mySqlConfiguration.setUpdatedUserId(instance.getUpdatedUserId());
            mySqlConfiguration.setUpdatedRemark(instance.getUpdatedRemark());
            mySqlConfiguration.setDeletedTime(instance.getDeletedTime());
            mySqlConfiguration.setDeleted(instance.isDeleted());
            return mySqlConfiguration;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String NAME = "name";
        public static final String VALUE = "value";
        public static final String TYPE = "type";
        public static final String REMARK = "remark";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String NAME = "name";
        public static final String VALUE = "value";
        public static final String TYPE = "type";
        public static final String REMARK = "remark";
    }
}
