package build.dream.common.basic;

import build.dream.common.annotations.GenerationStrategy;
import build.dream.common.annotations.Id;
import build.dream.common.annotations.InsertIgnore;
import build.dream.common.annotations.UpdateIgnore;
import build.dream.common.constants.Constants;
import build.dream.common.utils.ObjectUtils;

import java.math.BigInteger;
import java.util.Date;

public class BasicDomain implements IdDomain<BigInteger> {
    @Id(strategy = GenerationStrategy.AUTO_INCREMENT)
    @UpdateIgnore
    private BigInteger id;

    @InsertIgnore
    @UpdateIgnore
    private Date createdTime;
    private BigInteger createdUserId;

    @InsertIgnore
    @UpdateIgnore
    private Date updatedTime;
    private BigInteger updatedUserId;
    private String updatedRemark = Constants.VARCHAR_DEFAULT_VALUE;

    @InsertIgnore
    private Date deletedTime = Constants.DATETIME_DEFAULT_VALUE;

    @InsertIgnore
    private boolean deleted;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public BigInteger getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(BigInteger createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public BigInteger getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(BigInteger updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public String getUpdatedRemark() {
        return updatedRemark;
    }

    public void setUpdatedRemark(String updatedRemark) {
        this.updatedRemark = updatedRemark;
    }

    public Date getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    public static class ColumnName {
        public static final String ID = "id";
        public static final String CREATED_TIME = "created_time";
        public static final String CREATED_USER_ID = "created_user_id";
        public static final String UPDATED_TIME = "updated_time";
        public static final String UPDATED_USER_ID = "updated_user_id";
        public static final String UPDATED_REMARK = "updated_remark";
        public static final String DELETED_TIME = "deleted_time";
        public static final String DELETED = "deleted";
    }

    public static class FieldName {
        public static final String ID = "id";
        public static final String CREATED_TIME = "createdTime";
        public static final String CREATED_USER_ID = "createdUserId";
        public static final String UPDATED_TIME = "updatedTime";
        public static final String UPDATED_USER_ID = "updatedUserId";
        public static final String UPDATED_REMARK = "updatedRemark";
        public static final String DELETED_TIME = "deletedTime";
        public static final String DELETED = "deleted";
    }

    protected abstract static class Builder<BT extends Builder<BT, IT>, IT extends BasicDomain> {
        private IT instance;

        protected abstract IT getInstance();

        public Builder() {
            super();
            instance = getInstance();
        }

        public BT id(BigInteger id) {
            instance.setId(id);
            return (BT) this;
        }

        public BT createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return (BT) this;
        }

        public BT createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return (BT) this;
        }

        public BT updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return (BT) this;
        }

        public BT updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return (BT) this;
        }

        public BT updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return (BT) this;
        }

        public BT deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return (BT) this;
        }

        public BT deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return (BT) this;
        }

        protected IT build() {
            IT object = (IT) ObjectUtils.newInstance(instance.getClass());
            object.setId(instance.getId());
            object.setCreatedTime(instance.getCreatedTime());
            object.setCreatedUserId(instance.getCreatedUserId());
            object.setUpdatedTime(instance.getUpdatedTime());
            object.setUpdatedUserId(instance.getUpdatedUserId());
            object.setUpdatedRemark(instance.getUpdatedRemark());
            object.setDeletedTime(instance.getDeletedTime());
            object.setDeleted(instance.isDeleted());
            return object;
        }
    }
}
