package build.dream.common.domains.admin;

import build.dream.common.basic.BasicDomain;

public class ServiceNode extends BasicDomain {
    /**
     * 服务ID
     */
    private Long serviceId;

    /**
     * 主机ID
     */
    private Long hostId;

    /**
     * 服务端口
     */
    private Integer port;

    /**
     * 服务状态，1-运行中，2-已停止
     */
    private Integer status;

    /**
     * 进程ID
     */
    private String pid;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public static class Builder extends BasicDomain.Builder<Builder, ServiceNode> {
        public Builder serviceId(Long serviceId) {
            instance.setServiceId(serviceId);
            return this;
        }

        public Builder hostId(Long hostId) {
            instance.setHostId(hostId);
            return this;
        }

        public Builder port(Integer port) {
            instance.setPort(port);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        public Builder pid(String pid) {
            instance.setPid(pid);
            return this;
        }

        public ServiceNode build() {
            ServiceNode serviceNode = super.build();
            serviceNode.setServiceId(instance.getServiceId());
            serviceNode.setHostId(instance.getHostId());
            serviceNode.setPort(instance.getPort());
            serviceNode.setStatus(instance.getStatus());
            serviceNode.setPid(instance.getPid());
            return serviceNode;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String SERVICE_ID = "service_id";
        public static final String HOST_ID = "host_id";
        public static final String PORT = "port";
        public static final String STATUS = "status";
        public static final String PID = "pid";

    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String SERVICE_ID = "serviceId";
        public static final String HOST_ID = "hostId";
        public static final String PORT = "port";
        public static final String STATUS = "status";
        public static final String PID = "pid";
    }
}
