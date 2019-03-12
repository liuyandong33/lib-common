package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class BackgroundPrivilege extends BasicDomain {
    public static final String TABLE_NAME = "background_privilege";
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
    private String serviceName;
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
     * 是否在权限设置页面隐藏，1-隐藏，2-不隐藏
     */
    private boolean hidden;
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

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder {
        private final BackgroundPrivilege instance = new BackgroundPrivilege();

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

        public Builder hidden(boolean hidden) {
            instance.setHidden(hidden);
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

        public BackgroundPrivilege build() {
            BackgroundPrivilege backgroundPrivilege = new BackgroundPrivilege();
            backgroundPrivilege.setPrivilegeCode(instance.getPrivilegeCode());
            backgroundPrivilege.setPrivilegeName(instance.getPrivilegeName());
            backgroundPrivilege.setAccessMode(instance.getAccessMode());
            backgroundPrivilege.setServiceName(instance.getServiceName());
            backgroundPrivilege.setControllerName(instance.getControllerName());
            backgroundPrivilege.setActionName(instance.getActionName());
            backgroundPrivilege.setParentId(instance.getParentId());
            backgroundPrivilege.setHidden(instance.isHidden());
            backgroundPrivilege.setRemark(instance.getRemark());
            backgroundPrivilege.setId(instance.getId());
            backgroundPrivilege.setCreatedTime(instance.getCreatedTime());
            backgroundPrivilege.setCreatedUserId(instance.getCreatedUserId());
            backgroundPrivilege.setUpdatedTime(instance.getUpdatedTime());
            backgroundPrivilege.setUpdatedUserId(instance.getUpdatedUserId());
            backgroundPrivilege.setUpdatedRemark(instance.getUpdatedRemark());
            backgroundPrivilege.setDeletedTime(instance.getDeletedTime());
            backgroundPrivilege.setDeleted(instance.isDeleted());
            return backgroundPrivilege;
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
        public static final String HIDDEN = "hidden";
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
        public static final String HIDDEN = "hidden";
        public static final String REMARK = "remark";
    }
}
