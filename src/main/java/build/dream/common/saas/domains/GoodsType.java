package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class GoodsType extends BasicDomain {
    /**
     * 产品类型名称
     */
    private String name;
    /**
     * 描述
     */
    private String description = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 该类型下是否只能有一个产品
     */
    private boolean single;
    /**
     * 续费时执行的sql
     */
    private String renewSql = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 过期时执行的sql
     */
    private String disableSql = Constants.VARCHAR_DEFAULT_VALUE;

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

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public String getRenewSql() {
        return renewSql;
    }

    public void setRenewSql(String renewSql) {
        this.renewSql = renewSql;
    }

    public String getDisableSql() {
        return disableSql;
    }

    public void setDisableSql(String disableSql) {
        this.disableSql = disableSql;
    }

    public static class Builder {
        private final GoodsType instance = new GoodsType();

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder single(boolean single) {
            instance.setSingle(single);
            return this;
        }

        public Builder renewSql(String renewSql) {
            instance.setRenewSql(renewSql);
            return this;
        }

        public Builder disableSql(String disableSql) {
            instance.setDisableSql(disableSql);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public GoodsType build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String SINGLE = "single";
        public static final String RENEW_SQL = "renew_sql";
        public static final String DISABLE_SQL = "disable_sql";
    }
}
