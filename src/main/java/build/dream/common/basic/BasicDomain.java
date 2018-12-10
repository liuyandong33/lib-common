package build.dream.common.basic;

import build.dream.common.constants.Constants;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class BasicDomain implements Serializable {
    private BigInteger id;
    private Date createdTime;
    private BigInteger createdUserId;
    private Date updatedTime;
    private BigInteger updatedUserId;
    private String updatedRemark = Constants.VARCHAR_DEFAULT_VALUE;
    private Date deletedTime = Constants.DATETIME_DEFAULT_VALUE;
    private boolean deleted;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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

    protected static class ColumnName {
        public static final String ID = "id";
        public static final String CREATED_TIME = "created_time";
        public static final String CREATED_USER_ID = "created_user_id";
        public static final String UPDATED_TIME = "updated_time";
        public static final String UPDATED_USER_ID = "updated_user_id";
        public static final String UPDATED_REMARK = "updated_remark";
        public static final String DELETED_TIME = "deleted_time";
        public static final String DELETED = "deleted";
    }

    protected static class FieldName {
        public static final String ID = "id";
        public static final String CREATED_TIME = "createdTime";
        public static final String CREATED_USER_ID = "createdUserId";
        public static final String UPDATED_TIME = "updatedTime";
        public static final String UPDATED_USER_ID = "updatedUserId";
        public static final String UPDATED_REMARK = "updatedRemark";
        public static final String DELETED_TIME = "deletedTime";
        public static final String DELETED = "deleted";
    }
}
