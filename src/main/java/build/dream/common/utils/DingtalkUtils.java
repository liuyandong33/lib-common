package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.dingtalk.CreateChatModel;
import build.dream.common.models.dingtalk.ListDepartmentsModel;
import build.dream.common.models.dingtalk.SendModel;
import net.sf.json.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DingtalkUtils {
    private static final String DINGTALK_SERVICE_URL = "https://oapi.dingtalk.com";
    private static final Map<String, String> HEADERS = new HashMap<String, String>();

    static {
        HEADERS.put("Content-Type", "application/json;charset=UTF-8");
    }

    private static String obtainAccessToken(String corpId) {
        String tokenJson = CacheUtils.hget(Constants.KEY_DINGTALK_TOKENS, corpId);
        if (StringUtils.isBlank(tokenJson)) {
            return null;
        }
        JSONObject tokenJsonObject = JSONObject.fromObject(tokenJson);
        long fetchTime = tokenJsonObject.getLong("fetch_time");
        long expiresIn = tokenJsonObject.getLong("expires_in");
        if ((System.currentTimeMillis() - fetchTime) / 1000 < expiresIn) {
            return tokenJsonObject.getString("access_token");
        }
        return null;
    }

    private static String getToken(String corpId, String corpSecret) {
        Map<String, String> obtainAccessTokenRequestParameters = new HashMap<String, String>();
        obtainAccessTokenRequestParameters.put("corpid", corpId);
        obtainAccessTokenRequestParameters.put("corpsecret", corpSecret);
        String url = DINGTALK_SERVICE_URL + "/gettoken";
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, null, obtainAccessTokenRequestParameters);
        JSONObject resultJsonObject = JSONObject.fromObject(webResponse.getResult());
        int errcode = resultJsonObject.getInt("errcode");
        ValidateUtils.isTrue(errcode == 0, resultJsonObject.optString("errmsg"));

        Map<String, Object> tokenMap = new HashMap<String, Object>();
        String accessToken = resultJsonObject.getString("access_token");
        tokenMap.put("access_token", accessToken);
        tokenMap.put("expires_in", resultJsonObject.getLong("expires_in"));
        tokenMap.put("fetch_time", System.currentTimeMillis());
        CacheUtils.hset(Constants.KEY_DINGTALK_TOKENS, corpId, GsonUtils.toJson(tokenMap));
        return accessToken;
    }

    public static String obtainAccessToken(String corpId, String corpSecret) {
        String accessToken = obtainAccessToken(corpId);
        if (StringUtils.isBlank(accessToken)) {
            accessToken = getToken(corpId, corpSecret);
        }
        return accessToken;
    }

    /**
     * 发送群消息
     *
     * @param corpId
     * @param corpSecret
     * @param sendModel
     * @return
     */
    public static Map<String, Object> send(String corpId, String corpSecret, SendModel sendModel) {
        String sender = sendModel.getSender();
        String chatId = sendModel.getChatId();
        String content = sendModel.getContent();
        Map<String, Object> sendRequestBody = new HashMap<String, Object>();
        sendRequestBody.put("sender", sender);
        sendRequestBody.put("chatId", chatId);
        sendRequestBody.put("msgtype", "text");
        Map<String, Object> textMap = new HashMap<String, Object>();
        textMap.put("content", content);
        sendRequestBody.put("text", textMap);
        String url = DINGTALK_SERVICE_URL + "/chat/send?access_token=" + obtainAccessToken(corpId, corpSecret);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, HEADERS, GsonUtils.toJson(sendRequestBody));

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));

        return resultMap;
    }

    /**
     * 发送群消息
     *
     * @param sendModel
     * @return
     */
    public static Map<String, Object> send(SendModel sendModel) {
        String corpId = ConfigurationUtils.getConfiguration(Constants.DINGTALK_CORP_ID);
        String corpSecret = ConfigurationUtils.getConfiguration(Constants.DINGTALK_CORP_SECRET);
        return send(corpId, corpSecret, sendModel);
    }

    /**
     * 创建会话
     *
     * @param corpId
     * @param corpSecret
     * @param createChatModel
     * @return
     */
    public static Map<String, Object> createChat(String corpId, String corpSecret, CreateChatModel createChatModel) {
        String name = createChatModel.getName();
        String owner = createChatModel.getOwner();
        List<String> userIdList = createChatModel.getUserIdList();
        Integer showHistoryType = createChatModel.getShowHistoryType();
        Integer searchable = createChatModel.getSearchable();
        Integer validationType = createChatModel.getValidationType();
        Integer mentionAllAuthority = createChatModel.getMentionAllAuthority();
        Integer managementType = createChatModel.getManagementType();
        Map<String, Object> createChatRequestBody = new HashMap<String, Object>();
        createChatRequestBody.put("name", name);
        createChatRequestBody.put("owner", owner);
        createChatRequestBody.put("useridlist", userIdList);
        createChatRequestBody.put("showHistoryType", showHistoryType);
        createChatRequestBody.put("searchable", searchable);
        createChatRequestBody.put("validationType", validationType);
        createChatRequestBody.put("mentionAllAuthority", mentionAllAuthority);
        createChatRequestBody.put("managementType", managementType);

        String url = DINGTALK_SERVICE_URL + "/chat/create?access_token=" + obtainAccessToken(corpId, corpSecret);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, HEADERS, GsonUtils.toJson(createChatRequestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));

        return resultMap;
    }

    /**
     * 创建会话
     *
     * @param createChatModel
     * @return
     */
    public static Map<String, Object> createChat(CreateChatModel createChatModel) {
        String corpId = ConfigurationUtils.getConfiguration(Constants.DINGTALK_CORP_ID);
        String corpSecret = ConfigurationUtils.getConfiguration(Constants.DINGTALK_CORP_SECRET);
        return createChat(corpId, corpSecret, createChatModel);
    }

    /**
     * 获取部门列表
     *
     * @param corpId
     * @param corpSecret
     * @param listDepartmentsModel
     * @return
     */
    public static Map<String, Object> listDepartments(String corpId, String corpSecret, ListDepartmentsModel listDepartmentsModel) {
        String lang = listDepartmentsModel.getLang();
        Boolean fetchChild = listDepartmentsModel.getFetchChild();
        String id = listDepartmentsModel.getId();

        Map<String, String> listDepartmentsRequestParameters = new HashMap<String, String>();
        listDepartmentsRequestParameters.put("access_token", obtainAccessToken(corpId, corpSecret));
        if (StringUtils.isNotBlank(lang)) {
            listDepartmentsRequestParameters.put("lang", lang);
        }

        if (fetchChild != null) {
            listDepartmentsRequestParameters.put("fetch_child", fetchChild.toString());
        }

        if (StringUtils.isNotBlank(id)) {
            listDepartmentsRequestParameters.put("id", id);
        }

        String url = DINGTALK_SERVICE_URL + "/department/list?access_token=" + obtainAccessToken(corpId, corpSecret);
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, listDepartmentsRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));

        return resultMap;
    }

    /**
     * 获取部门列表
     *
     * @param listDepartmentsModel
     * @return
     */
    public static Map<String, Object> listDepartments(ListDepartmentsModel listDepartmentsModel) {
        String corpId = ConfigurationUtils.getConfiguration(Constants.DINGTALK_CORP_ID);
        String corpSecret = ConfigurationUtils.getConfiguration(Constants.DINGTALK_CORP_SECRET);
        return listDepartments(corpId, corpSecret, listDepartmentsModel);
    }
}
