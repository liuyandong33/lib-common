package build.dream.common.saas.domains;

import build.dream.common.annotations.Table;
import build.dream.common.basic.BasicDomain;

@Table(name = "jddj_code")
public class JDDJCode extends BasicDomain {
    public static final String TABLE_NAME = "jddj_code";
    /**
     * code
     */
    private String code;

    /**
     * 商家ID
     */
    private String venderId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public static class Builder extends BasicDomain.Builder<Builder, JDDJCode> {
        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder venderId(String venderId) {
            instance.setVenderId(venderId);
            return this;
        }

        @Override
        public JDDJCode build() {
            JDDJCode jddjCode = super.build();
            jddjCode.setCode(instance.getCode());
            jddjCode.setVenderId(instance.getVenderId());
            return jddjCode;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String CODE = "code";
        public static final String VENDER_ID = "vender_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CODE = "code";
        public static final String VENDER_ID = "venderId";
    }
}
