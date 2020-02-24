package build.dream.common.utils;

import build.dream.common.beans.SuningOAuthToken;
import build.dream.common.constants.Constants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.models.suning.CommonParamsModel;
import build.dream.common.models.suning.SuningBasicModel;
import build.dream.common.models.suning.SuningCustomLogisticsNewsQueryModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SuningUtils {
    private static final String SU_NING_AUTHORIZE_URL = "https://open.suning.com/api/oauth/authorize";
    private static final String SU_NING_OAUTH_TOKEN_URL = "https://open.suning.com/api/oauth/token";
    private static final String SU_NING_API_URL = "https://openpre.cnsuning.com/api/http/sopRequest";

    /**
     * 构建请求头
     *
     * @param commonParamsModel
     * @return
     */
    public static Map<String, String> buildHeaders(CommonParamsModel commonParamsModel) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("appMethod", commonParamsModel.getAppMethod());
        headers.put("appRequestTime", commonParamsModel.getAppRequestTime());
        headers.put("format", commonParamsModel.getFormat());
        headers.put("appKey", commonParamsModel.getAppKey());
        headers.put("versionNo", commonParamsModel.getVersionNo());
        headers.put("signInfo", commonParamsModel.getSignInfo());
        headers.put("access_token", commonParamsModel.getAccessToken());
        return headers;
    }

    /**
     * 生成签名
     *
     * @param commonParamsModel
     * @param businessParameters
     */
    public static void generateSignInfo(CommonParamsModel commonParamsModel, String businessParameters) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(commonParamsModel.getAppSecret());
        stringBuilder.append(commonParamsModel.getAppMethod());
        stringBuilder.append(commonParamsModel.getAppRequestTime());
        stringBuilder.append(commonParamsModel.getAppKey());
        stringBuilder.append(commonParamsModel.getVersionNo());
        stringBuilder.append(commonParamsModel.getAccessToken());
        stringBuilder.append(Base64.encodeBase64String(businessParameters.getBytes(Constants.CHARSET_UTF_8)));
        commonParamsModel.setSignInfo(DigestUtils.md5Hex(stringBuilder.toString()));
    }

    /**
     * 获取access_token
     *
     * @param tenantId
     * @param branchId
     * @return
     */
    public static String obtainAccessToken(String tenantId, String branchId) {
        String tokenJson = CommonRedisUtils.hget(Constants.KEY_SU_NING_TOKENS, tenantId + "_" + branchId);
        if (StringUtils.isBlank(tokenJson)) {
            return null;
        }

        SuningOAuthToken suningOAuthToken = JacksonUtils.readValue(tokenJson, SuningOAuthToken.class);
        return suningOAuthToken.getAccessToken();
    }

    /**
     * 生成授权链接
     *
     * @param scope
     * @param redirectUri
     * @param state
     * @param itemcode
     * @return
     */
    public static String generateAuthorizeUrl(String scope, String redirectUri, String state, String itemcode) {
        StringBuilder authorizeUrl = new StringBuilder(SU_NING_AUTHORIZE_URL);
        authorizeUrl.append("?client_id=");
        authorizeUrl.append(ConfigurationUtils.getConfiguration(Constants.SU_NING_APP_KEY));
        authorizeUrl.append("&response_type=code");
        authorizeUrl.append("&redirect_uri=").append(redirectUri);
        if (StringUtils.isNotBlank(scope)) {
            authorizeUrl.append("&scope=").append(scope);
        }
        if (StringUtils.isNotBlank(state)) {
            authorizeUrl.append("&state=").append(state);
        }
        authorizeUrl.append("&itemcode=").append(itemcode);
        return authorizeUrl.toString();
    }

    /**
     * 获取token
     *
     * @param code
     * @param scope
     * @param redirectUri
     * @param state
     * @return
     */
    public static SuningOAuthToken obtainOAuthToken(String code, String scope, String redirectUri, String state) {
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("client_id", ConfigurationUtils.getConfiguration(Constants.SU_NING_APP_KEY));
        queryParams.put("client_secret", ConfigurationUtils.getConfiguration(Constants.SU_NING_APP_SECRET));
        queryParams.put("code", code);
        queryParams.put("grant_type", "authorization_code");
        queryParams.put("redirect_uri", redirectUri);
        if (StringUtils.isNotBlank(scope)) {
            queryParams.put("scope", scope);
        }

        if (StringUtils.isNotBlank(state)) {
            queryParams.put("state", state);
        }
        String result = OutUtils.doGet(SU_NING_OAUTH_TOKEN_URL, queryParams);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        SuningOAuthToken suningOAuthToken = new SuningOAuthToken();
        suningOAuthToken.setAccessToken(MapUtils.getString(resultMap, "access_token"));
        suningOAuthToken.setTokenType(MapUtils.getString(resultMap, "token_type"));
        suningOAuthToken.setRefreshToken(MapUtils.getString(resultMap, "refresh_token"));
        suningOAuthToken.setExpiresIn(MapUtils.getIntValue(resultMap, "expires_in"));
        suningOAuthToken.setReExpiresIn(MapUtils.getIntValue(resultMap, "re_expires_in"));
        suningOAuthToken.setSuningUserName(MapUtils.getString(resultMap, "suning_user_name"));
        suningOAuthToken.setCustnum(MapUtils.getString(resultMap, "custnum"));
        suningOAuthToken.setModule(MapUtils.getString(resultMap, "module"));
        suningOAuthToken.setVendorCode(MapUtils.getString(resultMap, "vendorCode"));
        return suningOAuthToken;
    }

    /**
     * 调用苏宁api
     *
     * @param suningBasicModel
     * @param appMethod
     * @param rootNodeName
     * @return
     */
    public static Map<String, Object> callSuningApi(SuningBasicModel suningBasicModel, String appMethod, String rootNodeName) {
        String tenantId = suningBasicModel.getTenantId();
        String branchId = suningBasicModel.getBranchId();
        Map<String, Object> snBody = new HashMap<String, Object>();
        snBody.put(rootNodeName, suningBasicModel);

        Map<String, Object> snRequest = new HashMap<String, Object>();
        snRequest.put("sn_body", snBody);

        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put("sn_request", snRequest);

        String body = JacksonUtils.writeValueAsString(bodyMap, JsonInclude.Include.NON_NULL);

        CommonParamsModel commonParamsModel = CommonParamsModel.builder()
                .appMethod(appMethod)
                .appRequestTime(new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date()))
                .format("json")
                .appKey(ConfigurationUtils.getConfiguration(Constants.SU_NING_APP_KEY))
                .appSecret(ConfigurationUtils.getConfiguration(Constants.SU_NING_APP_SECRET))
                .versionNo(Constants.SU_NING_VERSION_NO_V_1_2)
                .accessToken(obtainAccessToken(tenantId, branchId))
                .build();
        generateSignInfo(commonParamsModel, body);
        Map<String, String> headers = buildHeaders(commonParamsModel);
        String result = OutUtils.doPostWithRequestBody(SU_NING_API_URL + "/" + appMethod, body, Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8, headers);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        Map<String, Object> snResponseContent = MapUtils.getMap(resultMap, "sn_responseContent");
        Map<String, Object> snError = MapUtils.getMap(snResponseContent, "sn_error");
        if (MapUtils.isNotEmpty(snError)) {
            throw new CustomException(MapUtils.getString(snError, "error_msg"));
        }
        return resultMap;
    }

    /**
     * 物流动态查询
     *
     * @param suningCustomLogisticsNewsQueryModel
     * @return
     */
    public static Map<String, Object> suningCustomLogisticsNewsQuery(SuningCustomLogisticsNewsQueryModel suningCustomLogisticsNewsQueryModel) {
        return callSuningApi(suningCustomLogisticsNewsQueryModel, "suning.custom.logisticsnews.query", "logisticsnews");
    }
}
