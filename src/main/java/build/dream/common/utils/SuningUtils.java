package build.dream.common.utils;

import build.dream.common.models.suning.CommonParamsModel;

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
        headers.put("access_token", commonParamsModel.getAccessToken());
        headers.put("Content-Type", "application/json;charset=utf-8");
        return headers;
    }

    public static Map<String, Object> suningCustomLogisticsNewsQuery() {
        return null;
    }
}
