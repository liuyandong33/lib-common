package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class Agent extends BasicDomain {
    public static final String TABLE_NAME = "agent";
    /**
     * 代理商编码
     */
    private String code;
    /**
     * 代理商名称
     */
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Agent> {
        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        @Override
        public Agent build() {
            Agent agent = super.build();
            agent.setCode(instance.getCode());
            agent.setName(instance.getName());
            return agent;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String CODE = "code";
        public static final String NAME = "name";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CODE = "code";
        public static final String NAME = "name";
    }
}
