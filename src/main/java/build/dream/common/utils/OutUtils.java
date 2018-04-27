package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.Validate;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OutUtils {
    public static String doGet(String url, Map<String, String> headers) throws IOException {
        Map<String, String> doGetRequestParameters = new HashMap<String, String>();
        doGetRequestParameters.put("url", url);
        if (MapUtils.isNotEmpty(headers)) {
            doGetRequestParameters.put("headers", GsonUtils.toJson(headers));
        }

        ApiRest doGetApiRest = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_OUT, "proxy", "doGets", doGetRequestParameters);
        Validate.isTrue(doGetApiRest.isSuccessful(), doGetApiRest.getError());
        return doGetApiRest.getData().toString();
    }

    public static String doPost(String url, String requestBody, Map<String, String> headers) throws IOException {
        Map<String, String> doPostRequestParameters = new HashMap<String, String>();
        doPostRequestParameters.put("url", url);
        doPostRequestParameters.put("requestBody", requestBody);
        if (MapUtils.isNotEmpty(headers)) {
            doPostRequestParameters.put("headers", GsonUtils.toJson(headers));
        }

        ApiRest doPostApiRest = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_OUT, "proxy", "doPost", doPostRequestParameters);
        Validate.isTrue(doPostApiRest.isSuccessful(), doPostApiRest.getError());
        return doPostApiRest.getData().toString();
    }

    public static String doPostMultipart(String url, Map<String, Object> requestParameters, Map<String, String> headers) throws IOException {
        Map<String, Object> doPostMultipartRequestParameters = new HashMap<String, Object>();
        doPostMultipartRequestParameters.put("url", url);
        doPostMultipartRequestParameters.putAll(requestParameters);
        if (MapUtils.isNotEmpty(headers)) {
            doPostMultipartRequestParameters.put("headers", GsonUtils.toJson(headers));
        }

        ApiRest doPostMultipartApiRest = ProxyUtils.doPostWithRequestParametersAndFiles(Constants.SERVICE_NAME_OUT, "proxy", "doPostMultipart", doPostMultipartRequestParameters);
        Validate.isTrue(doPostMultipartApiRest.isSuccessful(), doPostMultipartApiRest.getError());
        return doPostMultipartApiRest.getData().toString();
    }

    public static ResponseEntity<byte[]> doGetOriginal(String url, Map<String, String> headers) throws IOException {
        Map<String, String> doGetOriginalRequestParameters = new HashMap<String, String>();
        doGetOriginalRequestParameters.put("url", url);
        if (MapUtils.isNotEmpty(headers)) {
            doGetOriginalRequestParameters.put("headers", GsonUtils.toJson(headers));
        }
        return ProxyUtils.obtainRestTemplate().getForEntity(ProxyUtils.obtainUrl(null, Constants.SERVICE_NAME_O2O, "proxy", "doGetOriginal", doGetOriginalRequestParameters), byte[].class);
    }
}
