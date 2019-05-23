package build.dream.common.exceptions;

import build.dream.common.constants.Constants;
import build.dream.common.constants.ErrorCodeConstants;

public class CustomException extends RuntimeException {
    private String code;

    public CustomException() {
        this("未知错误！");
    }

    public CustomException(String message) {
        super(message);
        this.code = Constants.ERROR_CODE_UNKNOWN_ERROR;
    }

    public CustomException(String message, String code) {
        super(message);
        this.code = code;
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCodeConstants.ERROR_CODE_UNKNOWN_ERROR;
    }

    public CustomException(Throwable cause) {
        super(cause);
        this.code = ErrorCodeConstants.ERROR_CODE_UNKNOWN_ERROR;
    }

    public CustomException(Error error) {
        super(error.getMessage());
        this.code = error.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
