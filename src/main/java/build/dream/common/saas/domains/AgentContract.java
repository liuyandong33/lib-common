package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class AgentContract extends BasicDomain {
    public static final String TABLE_NAME = "agent_contract";
    /**
     * 合同编号
     */
    private String contractNumber;
    /**
     * 代理商ID
     */
    private BigInteger agentId;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 合同状态，1-未审核，2-未执行，3-执行中，4-已终止，5-已过期
     */
    private Integer status;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public BigInteger getAgentId() {
        return agentId;
    }

    public void setAgentId(BigInteger agentId) {
        this.agentId = agentId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static class Builder {
        private final AgentContract instance = new AgentContract();

        public Builder contractNumber(String contractNumber) {
            instance.setContractNumber(contractNumber);
            return this;
        }

        public Builder agentId(BigInteger agentId) {
            instance.setAgentId(agentId);
            return this;
        }

        public Builder startTime(Date startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(Date endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
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

        public AgentContract build() {
            AgentContract agentContract = new AgentContract();
            agentContract.setContractNumber(instance.getContractNumber());
            agentContract.setAgentId(instance.getAgentId());
            agentContract.setStartTime(instance.getStartTime());
            agentContract.setEndTime(instance.getEndTime());
            agentContract.setStatus(instance.getStatus());
            agentContract.setId(instance.getId());
            agentContract.setCreatedTime(instance.getCreatedTime());
            agentContract.setCreatedUserId(instance.getCreatedUserId());
            agentContract.setUpdatedTime(instance.getUpdatedTime());
            agentContract.setUpdatedUserId(instance.getUpdatedUserId());
            agentContract.setUpdatedRemark(instance.getUpdatedRemark());
            agentContract.setDeletedTime(instance.getDeletedTime());
            agentContract.setDeleted(instance.isDeleted());
            return agentContract;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String CONTRACT_NUMBER = "contract_number";
        public static final String AGENT_ID = "agent_id";
        public static final String START_TIME = "start_time";
        public static final String END_TIME = "end_time";
        public static final String STATUS = "status";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CONTRACT_NUMBER = "contractNumber";
        public static final String AGENT_ID = "agentId";
        public static final String START_TIME = "startTime";
        public static final String END_TIME = "endTime";
        public static final String STATUS = "status";
    }
}
