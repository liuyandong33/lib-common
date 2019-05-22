package build.dream.common.constants;

import build.dream.common.exceptions.Error;
import build.dream.common.utils.ConfigurationUtils;

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
    public static final String UNAUTHORIZED = "unauthorized";
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
     * @see #ERROR_CODE_UNAUTHORIZED：未认证的
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
    public static final String ERROR_CODE_UNAUTHORIZED = "0015";

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
    public static final Error UNAUTHORIZED_ERROR = new Error(ERROR_CODE_INVALID_SIGNATURE, "Full authentication is required to access this resource！");
}
