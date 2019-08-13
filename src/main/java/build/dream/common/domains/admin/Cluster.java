package build.dream.common.domains.admin;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class Cluster extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 集群名称
     */
    private String name;
    /**
     * 集群类型，1-zookeeper 集群
     */
    private Integer type;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static class Builder {
        private final Cluster instance = new Cluster();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
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

        public Cluster build() {
            Cluster cluster = new Cluster();
            cluster.setTenantId(instance.getTenantId());
            cluster.setName(instance.getName());
            cluster.setType(instance.getType());
            cluster.setId(instance.getId());
            cluster.setCreatedTime(instance.getCreatedTime());
            cluster.setCreatedUserId(instance.getCreatedUserId());
            cluster.setUpdatedTime(instance.getUpdatedTime());
            cluster.setUpdatedUserId(instance.getUpdatedUserId());
            cluster.setUpdatedRemark(instance.getUpdatedRemark());
            cluster.setDeletedTime(instance.getDeletedTime());
            cluster.setDeleted(instance.isDeleted());
            return cluster;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String NAME = "name";
        public static final String TYPE = "type";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String NAME = "name";
        public static final String TYPE = "type";
    }
}
