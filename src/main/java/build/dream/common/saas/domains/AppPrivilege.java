package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class AppPrivilege extends BasicDomain {
    public static final String TABLE_NAME = "app_privilege";
    /**
     * 权限编号
     */
    private String privilegeCode;
    /**
     * 权限名称
     */
    private String privilegeName;
    /**
     * 访问方式，1-GET，2-POST，3-签名GET，4-签名POST
     */
    private Integer accessMode;
    /**
     * 服务名称
     */
    private String serviceName = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * controller name
     */
    private String controllerName = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * action name
     */
    private String actionName = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 父级权限ID
     */
    private BigInteger parentId;
    /**
     * 备注
     */
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

    public Integer getAccessMode() {
        return accessMode;
    }

    public void setAccessMode(Integer accessMode) {
        this.accessMode = accessMode;
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
        private final AppPrivilege instance = new AppPrivilege();

        public Builder privilegeCode(String privilegeCode) {
            instance.setPrivilegeCode(privilegeCode);
            return this;
        }

        public Builder privilegeName(String privilegeName) {
            instance.setPrivilegeName(privilegeName);
            return this;
        }

        public Builder accessMode(Integer accessMode) {
            instance.setAccessMode(accessMode);
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

        public AppPrivilege build() {
            AppPrivilege appPrivilege = new AppPrivilege();
            appPrivilege.setPrivilegeCode(instance.getPrivilegeCode());
            appPrivilege.setPrivilegeName(instance.getPrivilegeName());
            appPrivilege.setAccessMode(instance.getAccessMode());
            appPrivilege.setServiceName(instance.getServiceName());
            appPrivilege.setControllerName(instance.getControllerName());
            appPrivilege.setActionName(instance.getActionName());
            appPrivilege.setParentId(instance.getParentId());
            appPrivilege.setRemark(instance.getRemark());
            appPrivilege.setId(instance.getId());
            appPrivilege.setCreatedTime(instance.getCreatedTime());
            appPrivilege.setCreatedUserId(instance.getCreatedUserId());
            appPrivilege.setUpdatedTime(instance.getUpdatedTime());
            appPrivilege.setUpdatedUserId(instance.getUpdatedUserId());
            appPrivilege.setUpdatedRemark(instance.getUpdatedRemark());
            appPrivilege.setDeletedTime(instance.getDeletedTime());
            appPrivilege.setDeleted(instance.isDeleted());
            return appPrivilege;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String PRIVILEGE_CODE = "privilege_code";
        public static final String PRIVILEGE_NAME = "privilege_name";
        public static final String ACCESS_MODE = "access_mode";
        public static final String SERVICE_NAME = "service_name";
        public static final String CONTROLLER_NAME = "controller_name";
        public static final String ACTION_NAME = "action_name";
        public static final String PARENT_ID = "parent_id";
        public static final String REMARK = "remark";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String PRIVILEGE_CODE = "privilegeCode";
        public static final String PRIVILEGE_NAME = "privilegeName";
        public static final String ACCESS_MODE = "accessMode";
        public static final String SERVICE_NAME = "serviceName";
        public static final String CONTROLLER_NAME = "controllerName";
        public static final String ACTION_NAME = "actionName";
        public static final String PARENT_ID = "parentId";
        public static final String REMARK = "remark";
    }
}
