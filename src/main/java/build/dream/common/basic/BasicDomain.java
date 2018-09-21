package build.dream.common.basic;

import build.dream.common.constants.Constants;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class BasicDomain implements Serializable {
    private BigInteger id;
    private Date createTime;
    private BigInteger createUserId;
    private Date lastUpdateTime;
    private BigInteger lastUpdateUserId;
    private String lastUpdateRemark = Constants.VARCHAR_DEFAULT_VALUE;
    private Date deleteTime = Constants.DATETIME_DEFAULT_VALUE;
    private boolean deleted;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigInteger getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(BigInteger createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public BigInteger getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(BigInteger lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getLastUpdateRemark() {
        return lastUpdateRemark;
    }

    public void setLastUpdateRemark(String lastUpdateRemark) {
        this.lastUpdateRemark = lastUpdateRemark;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    protected static class ColumnName {
        public static final String ID = "id";
        public static final String CREATE_TIME = "create_time";
        public static final String CREATE_USER_ID = "create_user_id";
        public static final String LAST_UPDATE_TIME = "last_update_time";
        public static final String LAST_UPDATE_USER_ID = "last_update_user_id";
        public static final String LAST_UPDATE_REMARK = "last_update_remark";
        public static final String DELETE_TIME = "delete_time";
        public static final String DELETED = "deleted";
    }

    protected static class FieldName {
        public static final String ID = "id";
        public static final String CREATE_TIME = "createTime";
        public static final String CREATE_USER_ID = "createUserId";
        public static final String LAST_UPDATE_TIME = "lastUpdateTime";
        public static final String LAST_UPDATE_USER_ID = "lastUpdateUserId";
        public static final String LAST_UPDATE_REMARK = "lastUpdateRemark";
        public static final String DELETE_TIME = "deleteTime";
        public static final String DELETED = "deleted";
    }
}
