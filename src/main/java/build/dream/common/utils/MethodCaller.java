package build.dream.common.utils;

import build.dream.common.api.ApiRest;

public interface MethodCaller {
    ApiRest call() throws Exception;
}
