package build.dream.common.utils;

import build.dream.common.constants.RedisKeys;
import build.dream.common.domains.saas.Agent;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentUtils {
    private AgentUtils() {
        throw new AssertionError("No build.dream.common.utils.AgentUtils instances for you!");
    }

    public static Agent obtainAgentInfo(Long agentId) {
        String agentInfoJson = CommonRedisUtils.hget(RedisKeys.KEY_AGENT_INFOS, "_id_" + agentId);
        if (StringUtils.isBlank(agentInfoJson)) {
            return null;
        }
        return JacksonUtils.readValue(agentInfoJson, Agent.class);
    }

    public static Agent obtainAgentInfo(String agentCode) {
        String agentInfoJson = CommonRedisUtils.hget(RedisKeys.KEY_AGENT_INFOS, "_code_" + agentCode);
        if (StringUtils.isBlank(agentInfoJson)) {
            return null;
        }
        return JacksonUtils.readValue(agentInfoJson, Agent.class);
    }

    public static void cacheAgentInfo(Agent agent) {
        String agentInfo = JacksonUtils.writeValueAsString(agent);
        CommonRedisUtils.hset(RedisKeys.KEY_AGENT_INFOS, "_id_" + agent.getId(), agentInfo);
        CommonRedisUtils.hset(RedisKeys.KEY_AGENT_INFOS, "_code_" + agent.getCode(), agentInfo);
    }

    public static void rejoinCacheAgentInfos(List<Agent> agents) {
        Map<String, String> agentInfos = new HashMap<String, String>();
        for (Agent agent : agents) {
            String agentInfo = JacksonUtils.writeValueAsString(agent);
            agentInfos.put("_id_" + agent.getId(), agentInfo);
            agentInfos.put("_code_" + agent.getCode(), agentInfo);
        }

        CommonRedisUtils.del(RedisKeys.KEY_AGENT_INFOS);
        if (MapUtils.isNotEmpty(agentInfos)) {
            CommonRedisUtils.hmset(RedisKeys.KEY_AGENT_INFOS, agentInfos);
        }
    }
}
