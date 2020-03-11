package build.dream.common.domains.devops;

import build.dream.common.basic.BasicDomain;

public class App extends BasicDomain {
    public static final String TABLE_NAME = "app";
    /**
     * 应用名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder extends BasicDomain.Builder<Builder, App> {
        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public App build() {
            App app = super.build();
            app.setName(instance.getName());
            app.setDescription(instance.getDescription());
            return app;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
    }
}
