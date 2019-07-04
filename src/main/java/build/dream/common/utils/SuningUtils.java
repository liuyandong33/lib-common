package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.models.suning.CommonParamsModel;
import build.dream.common.models.suning.SuningBasicModel;
import build.dream.common.models.suning.SuningCustomLogisticsNewsQueryModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SuningUtils {
    public static Map<String, String> buildHeaders(CommonParamsModel commonParamsModel) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("appMethod", commonParamsModel.getAppMethod());
        headers.put("appRequestTime", commonParamsModel.getAppRequestTime());
        headers.put("format", commonParamsModel.getFormat());
        headers.put("appKey", commonParamsModel.getAppKey());
        headers.put("versionNo", commonParamsModel.getVersionNo());
        headers.put("signInfo", commonParamsModel.getSignInfo());
        headers.put("access_token", commonParamsModel.getAccessToken());
        headers.put("Content-Type", "application/json;charset=utf-8");
        return headers;
    }

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

    public static String obtainAccessToken() {
        return null;
    }

    public static Map<String, Object> callSuningApi(SuningBasicModel suningBasicModel, String appMethod, String rootNodeName) {
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
                .versionNo(Constants.SU_NING_VERSION_NO)
                .accessToken(obtainAccessToken())
                .build();
        generateSignInfo(commonParamsModel, body);
        Map<String, String> headers = buildHeaders(commonParamsModel);
        WebResponse webResponse = OutUtils.doPostWithRequestBody("", headers, body);
        String result = webResponse.getResult();
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
