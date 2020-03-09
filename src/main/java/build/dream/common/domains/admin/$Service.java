package build.dream.common.domains.admin;

import build.dream.common.annotations.Table;
import build.dream.common.basic.BasicDomain;

@Table(name = "service")
public class $Service extends BasicDomain {
    private Long appId;
    /**
     * 名字
     */
    private String name;

    /**
     * 程序名称
     */
    private String programName;

    /**
     * 程序版本
     */
    private String programVersion;

    private String healthCheckPath;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramVersion() {
        return programVersion;
    }

    public void setProgramVersion(String programVersion) {
        this.programVersion = programVersion;
    }

    public String getHealthCheckPath() {
        return healthCheckPath;
    }

    public void setHealthCheckPath(String healthCheckPath) {
        this.healthCheckPath = healthCheckPath;
    }

    public static class Builder extends BasicDomain.Builder<Builder, $Service> {
        public Builder appId(Long appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder programName(String programName) {
            instance.setProgramName(programName);
            return this;
        }

        public Builder programVersion(String programVersion) {
            instance.setProgramVersion(programVersion);
            return this;
        }

        public Builder healthCheckPath(String healthCheckPath) {
            instance.setHealthCheckPath(healthCheckPath);
            return this;
        }

        public $Service build() {
            $Service service = super.build();
            service.setAppId(instance.getAppId());
            service.setName(instance.getName());
            service.setProgramName(instance.getProgramName());
            service.setProgramVersion(instance.getProgramVersion());
            service.setHealthCheckPath(instance.getHealthCheckPath());
            return service;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String APP_ID = "app_id";
        public static final String NAME = "name";
        public static final String PROGRAM_NAME = "program_name";
        public static final String PROGRAM_VERSION = "program_version";
        public static final String HEALTH_CHECK_PATH = "health_check_path";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String APP_ID = "appId";
        public static final String NAME = "name";
        public static final String PROGRAM_NAME = "programName";
        public static final String PROGRAM_VERSION = "programVersion";
        public static final String HEALTH_CHECK_PATH = "healthCheckPath";
    }
}
