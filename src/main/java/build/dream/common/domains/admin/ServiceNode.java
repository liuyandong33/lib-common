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

    public static class Builder extends BasicDomain.Builder<Builder, ServiceNode> {
        public Builder serviceId(Long serviceId) {
            instance.setServiceId(serviceId);
            return this;
        }

        public Builder hostId(Long hostId) {
            instance.setHostId(hostId);
            return this;
        }

        public ServiceNode build() {
            ServiceNode serviceNode = super.build();
            serviceNode.setServiceId(instance.getServiceId());
            serviceNode.setHostId(instance.getHostId());
            return serviceNode;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String SERVICE_ID = "service_id";
        public static final String HOST_ID = "host_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String SERVICE_ID = "serviceId";
        public static final String HOST_ID = "hostId";
    }
}
