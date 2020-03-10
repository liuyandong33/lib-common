package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.AgentUserDetails;
import build.dream.common.utils.WebSecurityUtils;

public class AgentBasicModel extends OAuthBasicModel {
    @InstantiateObjectIgnore
    private Long $userId;

    @InstantiateObjectIgnore
    private Long $agentId;

    @InstantiateObjectIgnore
    private String $agentCode;

    public AgentBasicModel() {
        AgentUserDetails agentUserDetails = WebSecurityUtils.obtainAgentUserDetails();
        this.$userId = agentUserDetails.getUserId();
        this.$agentId = agentUserDetails.getAgentId();
        this.$agentCode = agentUserDetails.getAgentCode();
    }

    public Long obtainUserId() {
        return $userId;
    }

    public Long obtainAgentId() {
        return $agentId;
    }

    public String obtainAgentCode() {
        return $agentCode;
    }
}
