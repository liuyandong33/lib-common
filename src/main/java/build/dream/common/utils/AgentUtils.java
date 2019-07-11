package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.Agent;
import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;

public class AgentUtils {
    public static Agent obtainAgentInfo(BigInteger agentId) {
        String agentInfoJson = CommonRedisUtils.hget(Constants.KEY_AGENT_INFOS, "_id_" + agentId);
        if (StringUtils.isBlank(agentInfoJson)) {
            return null;
        }
        return JacksonUtils.readValue(agentInfoJson, Agent.class);
    }

    public static Agent obtainAgentInfo(String agentCode) {
        String agentInfoJson = CommonRedisUtils.hget(Constants.KEY_AGENT_INFOS, "_code_" + agentCode);
        if (StringUtils.isBlank(agentInfoJson)) {
            return null;
        }
        return JacksonUtils.readValue(agentInfoJson, Agent.class);
    }
}
