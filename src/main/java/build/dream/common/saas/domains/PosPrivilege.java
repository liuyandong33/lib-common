package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class PosPrivilege extends BasicDomain {
    private String privilegeCode;
    private String privilegeName;
    private String serviceName = Constants.VARCHAR_DEFAULT_VALUE;
    private String controllerName = Constants.VARCHAR_DEFAULT_VALUE;
    private String actionName = Constants.VARCHAR_DEFAULT_VALUE;
    private BigInteger parentId;
    private String remark = Constants.VARCHAR_DEFAULT_VALUE;

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder {
        private final PosPrivilege instance = new PosPrivilege();

        public Builder privilegeCode(String privilegeCode) {
            instance.setPrivilegeCode(privilegeCode);
            return this;
        }

        public Builder privilegeName(String privilegeName) {
            instance.setPrivilegeName(privilegeName);
            return this;
        }

        public Builder serviceName(String serviceName) {
            instance.setServiceName(serviceName);
            return this;
        }

        public Builder controllerName(String controllerName) {
            instance.setControllerName(controllerName);
            return this;
        }

        public Builder actionName(String actionName) {
            instance.setActionName(actionName);
            return this;
        }

        public Builder parentId(BigInteger parentId) {
            instance.setParentId(parentId);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
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

        public PosPrivilege build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String PRIVILEGE_CODE = "privilege_code";
        public static final String PRIVILEGE_NAME = "privilege_name";
        public static final String SERVICE_NAME = "service_name";
        public static final String CONTROLLER_NAME = "controller_name";
        public static final String ACTION_NAME = "action_name";
        public static final String PARENT_ID = "parent_id";
        public static final String REMARK = "remark";
    }
}
