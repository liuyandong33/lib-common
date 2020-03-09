package build.dream.common.domains.admin;

import build.dream.common.basic.BasicDomain;
import build.dream.common.domains.saas.Tenant;

public class Host extends BasicDomain {
    /**
     * 主机类型，1-物理机，2-虚拟机
     */
    private Integer type;
    /**
     * 宿主机ID
     */
    private Long parentId;
    /**
     * 主机名称
     */
    private String name;
    /**
     * ip 地址
     */
    private String ipAddress;
    /**
     * ssh 连接端口号
     */
    private Integer sshPort;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    /**
     * 硬盘大小，单位GB
     */
    private Integer diskSize;

    /**
     * CPU 核心数量
     */
    private Integer cpuCoreQuantity;

    /**
     * 内存大小，单位B
     */
    private Integer memorySize;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getSshPort() {
        return sshPort;
    }

    public void setSshPort(Integer sshPort) {
        this.sshPort = sshPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
    }

    public Integer getCpuCoreQuantity() {
        return cpuCoreQuantity;
    }

    public void setCpuCoreQuantity(Integer cpuCoreQuantity) {
        this.cpuCoreQuantity = cpuCoreQuantity;
    }

    public Integer getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(Integer memorySize) {
        this.memorySize = memorySize;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Host> {
        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder parentId(Long parentId) {
            instance.setParentId(parentId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder ipAddress(String ipAddress) {
            instance.setIpAddress(ipAddress);
            return this;
        }

        public Builder sshPort(Integer sshPort) {
            instance.setSshPort(sshPort);
            return this;
        }

        public Builder userName(String userName) {
            instance.setUserName(userName);
            return this;
        }

        public Builder password(String password) {
            instance.setPassword(password);
            return this;
        }

        public Builder diskSize(Integer diskSize) {
            instance.setDiskSize(diskSize);
            return this;
        }

        public Builder cpuCoreQuantity(Integer cpuCoreQuantity) {
            instance.setCpuCoreQuantity(cpuCoreQuantity);
            return this;
        }

        public Builder memorySize(Integer memorySize) {
            instance.setMemorySize(memorySize);
            return this;
        }

        @Override
        public Host build() {
            Host host = super.build();
            host.setType(instance.getType());
            host.setParentId(instance.getParentId());
            host.setName(instance.getName());
            host.setIpAddress(instance.getIpAddress());
            host.setUserName(instance.getUserName());
            host.setSshPort(instance.getSshPort());
            host.setPassword(instance.getPassword());
            host.setDiskSize(instance.getDiskSize());
            host.setCpuCoreQuantity(instance.getCpuCoreQuantity());
            host.setMemorySize(instance.getMemorySize());
            return host;
        }
    }

    public static Tenant.Builder builder() {
        return new Tenant.Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TYPE = "type";
        public static final String PARENT_ID = "parent_id";
        public static final String NAME = "name";
        public static final String IP_ADDRESS = "ip_address";
        public static final String SSH_PORT = "ssh_port";
        public static final String USER_NAME = "user_name";
        public static final String PASSWORD = "password";
        public static final String DISK_SIZE = "disk_size";
        public static final String CPU_CORE_QUANTITY = "cpu_core_quantity";
        public static final String MEMORY_SIZE = "memory_size";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TYPE = "type";
        public static final String PARENT_ID = "parentId";
        public static final String NAME = "name";
        public static final String IP_ADDRESS = "ipAddress";
        public static final String SSH_PORT = "sshPort";
        public static final String USER_NAME = "userName";
        public static final String PASSWORD = "password";
        public static final String DISK_SIZE = "diskSize";
        public static final String CPU_CORE_QUANTITY = "cpuCoreQuantity";
        public static final String MEMORY_SIZE = "memorySize";
    }
}
