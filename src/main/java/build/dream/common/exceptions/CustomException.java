package build.dream.common.exceptions;

import build.dream.common.constants.Constants;

public class CustomException extends RuntimeException {
    private String code;

    public CustomException() {
        this.code = Constants.ERROR_CODE_UNKNOWN_ERROR;
    }

    public CustomException(String message) {
        super(message);
        this.code = Constants.ERROR_CODE_UNKNOWN_ERROR;
    }

    public CustomException(String message, String code) {
        super(message);
        this.code = code;
    }

    public CustomException(Error error) {
        super(error.getMessage());
        this.code = error.getCode();
    }
}
