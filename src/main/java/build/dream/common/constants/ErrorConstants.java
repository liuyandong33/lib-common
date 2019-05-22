package build.dream.common.constants;

import build.dream.common.api.ApiRest;
import build.dream.common.exceptions.Error;
import build.dream.common.utils.ConfigurationUtils;
import build.dream.common.utils.GsonUtils;

public class ErrorConstants {
    private static final String PLATFORM_PRIVATE_KEY = ConfigurationUtils.getConfiguration(Constants.PLATFORM_PRIVATE_KEY);
    public static final String INVALID_REQUEST = "invalid_request";
    public static final String INVALID_CLIENT = "invalid_client";
    public static final String INVALID_GRANT = "invalid_grant";
    public static final String UNAUTHORIZED_CLIENT = "unauthorized_client";
    public static final String UNSUPPORTED_GRANT_TYPE = "unsupported_grant_type";
    public static final String INVALID_SCOPE = "invalid_scope";
    public static final String INSUFFICIENT_SCOPE = "insufficient_scope";
    public static final String INVALID_TOKEN = "invalid_token";
    public static final String REDIRECT_URI_MISMATCH = "redirect_uri_mismatch";
    public static final String UNSUPPORTED_RESPONSE_TYPE = "unsupported_response_type";
    public static final String ACCESS_DENIED = "access_denied";
    /**
     * 错误代码
     *
     * @see #ERROR_CODE_UNKNOWN_ERROR：未知错误
     * @see #ERROR_CODE_INVALID_PARAMETER：参数错误
     * @see #ERROR_CODE_HANDLING_ERROR：处理错误
     * @see #ERROR_CODE_INVALID_CLIENT：无效客户端
     * @see #ERROR_CODE_UNAUTHORIZED_CLIENT：未授权的客户端
     * @see #ERROR_CODE_INVALID_GRANT：grant无效
     * @see #ERROR_CODE_INVALID_SCOPE：scope无效
     * @see #ERROR_CODE_INVALID_TOKEN：token无效
     * @see #ERROR_CODE_INVALID_REQUEST：无效请求
     * @see #ERROR_CODE_REDIRECT_URI_MISMATCH：redirect_uri不匹配
     * @see #ERROR_CODE_UNSUPPORTED_GRANT_TYPE：grant_type错误
     * @see #ERROR_CODE_UNSUPPORTED_RESPONSE_TYPE：response_type错误
     * @see #ERROR_CODE_INSUFFICIENT_SCOPE：scope错误
     * @see #ERROR_CODE_ACCESS_DENIED：不允许访问
     * @see #ERROR_CODE_INVALID_SIGNATURE：签名错误
     */
    public static final String ERROR_CODE_UNKNOWN_ERROR = "0000";
    public static final String ERROR_CODE_INVALID_PARAMETER = "0001";
    public static final String ERROR_CODE_HANDLING_ERROR = "0002";
    public static final String ERROR_CODE_INVALID_CLIENT = "0003";
    public static final String ERROR_CODE_UNAUTHORIZED_CLIENT = "0004";
    public static final String ERROR_CODE_INVALID_GRANT = "0005";
    public static final String ERROR_CODE_INVALID_SCOPE = "0006";
    public static final String ERROR_CODE_INVALID_TOKEN = "0007";
    public static final String ERROR_CODE_INVALID_REQUEST = "0008";
    public static final String ERROR_CODE_REDIRECT_URI_MISMATCH = "0009";
    public static final String ERROR_CODE_UNSUPPORTED_GRANT_TYPE = "0010";
    public static final String ERROR_CODE_UNSUPPORTED_RESPONSE_TYPE = "0011";
    public static final String ERROR_CODE_INSUFFICIENT_SCOPE = "0012";
    public static final String ERROR_CODE_ACCESS_DENIED = "0013";
    public static final String ERROR_CODE_INVALID_SIGNATURE = "0014";

    public static final Error UNKNOWN_ERROR = new Error(ERROR_CODE_UNKNOWN_ERROR, "未知错误！");
    public static final Error INVALID_PARAMETER_ERROR = new Error(ERROR_CODE_INVALID_PARAMETER, "参数错误！");
    public static final Error HANDLING_ERROR = new Error(ERROR_CODE_HANDLING_ERROR, "处理错误！");
    public static final Error INVALID_CLIENT_ERROR = new Error(ERROR_CODE_INVALID_CLIENT, "无效客户端！");
    public static final Error UNAUTHORIZED_CLIENT_ERROR = new Error(ERROR_CODE_UNAUTHORIZED_CLIENT, "未授权的客户端！");
    public static final Error INVALID_GRANT_ERROR = new Error(ERROR_CODE_INVALID_GRANT, "grant无效！");
    public static final Error INVALID_SCOPE_ERROR = new Error(ERROR_CODE_INVALID_SCOPE, "scope无效！");
    public static final Error INVALID_TOKEN_ERROR = new Error(ERROR_CODE_INVALID_TOKEN, "token无效！");
    public static final Error INVALID_REQUEST_ERROR = new Error(ERROR_CODE_INVALID_REQUEST, "无效请求！");
    public static final Error REDIRECT_URI_MISMATCH_ERROR = new Error(ERROR_CODE_REDIRECT_URI_MISMATCH, "redirect_uri不匹配！");
    public static final Error UNSUPPORTED_GRANT_TYPE_ERROR = new Error(ERROR_CODE_UNSUPPORTED_GRANT_TYPE, "grant_type错误！");
    public static final Error UNSUPPORTED_RESPONSE_TYPE_ERROR = new Error(ERROR_CODE_UNSUPPORTED_RESPONSE_TYPE, "response_type错误！");
    public static final Error INSUFFICIENT_SCOPE_ERROR = new Error(ERROR_CODE_INSUFFICIENT_SCOPE, "scope错误！");
    public static final Error ACCESS_DENIED_ERROR = new Error(ERROR_CODE_ACCESS_DENIED, "不允许访问！");
    public static final Error INVALID_SIGNATURE_ERROR = new Error(ERROR_CODE_INVALID_SIGNATURE, "签名错误！");

    public static final String UNKNOWN_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(UNKNOWN_ERROR).successful(false).build());
    public static final String INVALID_PARAMETER_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(INVALID_PARAMETER_ERROR).successful(false).build());
    public static final String HANDLING_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(HANDLING_ERROR).successful(false).build());
    public static final String INVALID_CLIENT_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(INVALID_CLIENT_ERROR).successful(false).build());
    public static final String UNAUTHORIZED_CLIENT_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(UNAUTHORIZED_CLIENT_ERROR).successful(false).build());
    public static final String INVALID_GRANT_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(INVALID_GRANT_ERROR).successful(false).build());
    public static final String INVALID_SCOPE_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(INVALID_SCOPE_ERROR).successful(false).build());
    public static final String INVALID_TOKEN_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(INVALID_TOKEN_ERROR).successful(false).build());
    public static final String INVALID_REQUEST_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(INVALID_REQUEST_ERROR).successful(false).build());
    public static final String REDIRECT_URI_MISMATCH_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(REDIRECT_URI_MISMATCH_ERROR).successful(false).build());
    public static final String UNSUPPORTED_GRANT_TYPE_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(UNSUPPORTED_GRANT_TYPE_ERROR).successful(false).build());
    public static final String UNSUPPORTED_RESPONSE_TYPE_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(UNSUPPORTED_RESPONSE_TYPE_ERROR).successful(false).build());
    public static final String INSUFFICIENT_SCOPE_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(INSUFFICIENT_SCOPE_ERROR).successful(false).build());
    public static final String ACCESS_DENIED_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(ACCESS_DENIED_ERROR).successful(false).build());
    public static final String INVALID_SIGNATURE_ERROR_API_REST = GsonUtils.toJson(ApiRest.builder().error(INVALID_SIGNATURE_ERROR).successful(false).build());

    private static String obtainSignedApiRest(Error error) {
        ApiRest apiRest = ApiRest.builder().error(error).successful(false).build();
        apiRest.sign(PLATFORM_PRIVATE_KEY);
        return GsonUtils.toJson(apiRest);
    }

    public static final String UNKNOWN_ERROR_SIGNED_API_REST = obtainSignedApiRest(UNKNOWN_ERROR);
    public static final String INVALID_PARAMETER_ERROR_SIGNED_API_REST = obtainSignedApiRest(INVALID_PARAMETER_ERROR);
    public static final String HANDLING_ERROR_SIGNED_API_REST = obtainSignedApiRest(HANDLING_ERROR);
    public static final String INVALID_CLIENT_ERROR_SIGNED_API_REST = obtainSignedApiRest(INVALID_CLIENT_ERROR);
    public static final String UNAUTHORIZED_CLIENT_ERROR_SIGNED_API_REST = obtainSignedApiRest(UNAUTHORIZED_CLIENT_ERROR);
    public static final String INVALID_GRANT_ERROR_SIGNED_API_REST = obtainSignedApiRest(INVALID_GRANT_ERROR);
    public static final String INVALID_SCOPE_ERROR_SIGNED_API_REST = obtainSignedApiRest(INVALID_SCOPE_ERROR);
    public static final String INVALID_TOKEN_ERROR_SIGNED_API_REST = obtainSignedApiRest(INVALID_TOKEN_ERROR);
    public static final String INVALID_REQUEST_ERROR_SIGNED_API_REST = obtainSignedApiRest(INVALID_REQUEST_ERROR);
    public static final String REDIRECT_URI_MISMATCH_SIGNED_ERROR_API_REST = obtainSignedApiRest(REDIRECT_URI_MISMATCH_ERROR);
    public static final String UNSUPPORTED_GRANT_TYPE_ERROR_SIGNED_API_REST = obtainSignedApiRest(UNSUPPORTED_GRANT_TYPE_ERROR);
    public static final String UNSUPPORTED_RESPONSE_TYPE_ERROR_SIGNED_API_REST = obtainSignedApiRest(UNSUPPORTED_RESPONSE_TYPE_ERROR);
    public static final String INSUFFICIENT_SCOPE_ERROR_SIGNED_API_REST = obtainSignedApiRest(INSUFFICIENT_SCOPE_ERROR);
    public static final String ACCESS_DENIED_ERROR_API_SIGNED_REST = obtainSignedApiRest(ACCESS_DENIED_ERROR);
    public static final String INVALID_SIGNATURE_ERROR_SIGNED_API_REST = obtainSignedApiRest(INVALID_SIGNATURE_ERROR);
}
