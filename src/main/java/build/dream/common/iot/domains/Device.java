package build.dream.common.iot.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.saas.domains.Tenant;

public class Device extends BasicDomain {
    public static class Builder extends BasicDomain.Builder<Builder, Device> {
        @Override
        public Device build() {
            Device device = super.build();
            return device;
        }
    }

    public static Tenant.Builder builder() {
        return new Tenant.Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
    }

    public static final class FieldName extends BasicDomain.FieldName {
    }
}
