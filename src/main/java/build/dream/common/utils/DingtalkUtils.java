package build.dream.common.utils;

import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.constants.Constants;
import build.dream.common.constants.RedisKeys;
import build.dream.common.models.dingtalk.CreateChatModel;
import build.dream.common.models.dingtalk.ListDepartmentsModel;
import build.dream.common.models.dingtalk.ListUserByPageModel;
import build.dream.common.models.dingtalk.SendModel;
import net.sf.json.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DingtalkUtils {
    private static final String DINGTALK_SERVICE_URL = "https://oapi.dingtalk.com";

    private static String obtainAccessToken(String appKey) {
        String tokenJson = CommonRedisUtils.hget(RedisKeys.KEY_DINGTALK_TOKENS, appKey);
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

    private static String getToken(String appKey, String appSecret) {
        Map<String, String> obtainAccessTokenRequestParameters = new HashMap<String, String>();
        obtainAccessTokenRequestParameters.put("appkey", appKey);
        obtainAccessTokenRequestParameters.put("appsecret", appSecret);
        String url = DINGTALK_SERVICE_URL + "/gettoken";
        String result = OutUtils.doGet(url, obtainAccessTokenRequestParameters);
        JSONObject resultJsonObject = JSONObject.fromObject(result);
        int errcode = resultJsonObject.getInt("errcode");
        ValidateUtils.isTrue(errcode == 0, resultJsonObject.optString("errmsg"));

        Map<String, Object> tokenMap = new HashMap<String, Object>();
        String accessToken = resultJsonObject.getString("access_token");
        tokenMap.put("access_token", accessToken);
        tokenMap.put("expires_in", resultJsonObject.getLong("expires_in"));
        tokenMap.put("fetch_time", System.currentTimeMillis());
        CommonRedisUtils.hset(RedisKeys.KEY_DINGTALK_TOKENS, appKey, JacksonUtils.writeValueAsString(tokenMap));
        return accessToken;
    }

    public static String obtainAccessToken(String appKey, String appSecret) {
        String accessToken = obtainAccessToken(appKey);
        if (StringUtils.isBlank(accessToken)) {
            accessToken = getToken(appKey, appSecret);
        }
        return accessToken;
    }

    /**
     * 发送群消息
     *
     * @param sendModel
     * @return
     */
    public static Map<String, Object> send(SendModel sendModel) {
        sendModel.validateAndThrow();

        String appKey = sendModel.getAppKey();
        String appSecret = sendModel.getAppSecret();
        String chatId = sendModel.getChatId();
        Map<String, Object> msg = sendModel.getMsg();
        Map<String, Object> sendRequestBody = new HashMap<String, Object>();
        sendRequestBody.put("chatid", chatId);
        sendRequestBody.put("msg", msg);
        String url = DINGTALK_SERVICE_URL + "/chat/send?access_token=" + obtainAccessToken(appKey, appSecret);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(sendRequestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));

        return resultMap;
    }

    /**
     * 发送群消息
     *
     * @param chatId
     * @param content
     * @return
     */
    public static Map<String, Object> send(String chatId, String content) {
        String appKey = ConfigurationUtils.getConfiguration(ConfigurationKeys.DINGTALK_APP_KEY);
        String appSecret = ConfigurationUtils.getConfiguration(ConfigurationKeys.DINGTALK_APP_SECRET);

        Map<String, Object> text = new HashMap<String, Object>();
        text.put("content", content);

        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("msgtype", "text");
        msg.put("text", text);

        SendModel sendModel = SendModel.builder()
                .appKey(appKey)
                .appSecret(appSecret)
                .chatId(chatId)
                .msg(msg)
                .build();
        return send(sendModel);
    }

    /**
     * 创建会话
     *
     * @param createChatModel
     * @return
     */
    public static Map<String, Object> createChat(CreateChatModel createChatModel) {
        createChatModel.validateAndThrow();

        String appKey = createChatModel.getAppKey();
        String appSecret = createChatModel.getAppSecret();
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

        String url = DINGTALK_SERVICE_URL + "/chat/create?access_token=" + obtainAccessToken(appKey, appSecret);
        String result = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(createChatRequestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        listDepartmentsModel.validateAndThrow();

        String appKey = listDepartmentsModel.getAppKey();
        String appSecret = listDepartmentsModel.getAppSecret();
        String lang = listDepartmentsModel.getLang();
        Boolean fetchChild = listDepartmentsModel.getFetchChild();
        String id = listDepartmentsModel.getId();

        Map<String, String> listDepartmentsRequestParameters = new HashMap<String, String>();
        listDepartmentsRequestParameters.put("access_token", obtainAccessToken(appKey, appSecret));
        if (StringUtils.isNotBlank(lang)) {
            listDepartmentsRequestParameters.put("lang", lang);
        }

        if (Objects.nonNull(fetchChild)) {
            listDepartmentsRequestParameters.put("fetch_child", fetchChild.toString());
        }

        if (StringUtils.isNotBlank(id)) {
            listDepartmentsRequestParameters.put("id", id);
        }

        String url = DINGTALK_SERVICE_URL + "/department/list";
        String result = OutUtils.doGet(url, listDepartmentsRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));

        return resultMap;
    }

    /**
     * 获取部门用户详情
     *
     * @param listUserByPageModel
     * @return
     */
    public static Map<String, Object> listUserByPage(ListUserByPageModel listUserByPageModel) {
        listUserByPageModel.validateAndThrow();

        String appKey = listUserByPageModel.getAppKey();
        String appSecret = listUserByPageModel.getAppSecret();
        String lang = listUserByPageModel.getLang();
        String departmentId = listUserByPageModel.getDepartmentId();
        Integer offset = listUserByPageModel.getOffset();
        Integer size = listUserByPageModel.getSize();
        String order = listUserByPageModel.getOrder();

        Map<String, String> listUserByPageRequestParameters = new HashMap<String, String>();
        listUserByPageRequestParameters.put("access_token", obtainAccessToken(appKey, appSecret));
        if (StringUtils.isNotBlank(lang)) {
            listUserByPageRequestParameters.put("lang", lang);
        }
        listUserByPageRequestParameters.put("department_id", departmentId);
        listUserByPageRequestParameters.put("offset", offset.toString());
        listUserByPageRequestParameters.put("size", size.toString());
        if (StringUtils.isNotBlank(order)) {
            listUserByPageRequestParameters.put("order", order);
        }
        String url = DINGTALK_SERVICE_URL + "/user/listbypage";
        String result = OutUtils.doGet(url, listUserByPageRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));

        return resultMap;
    }
}
