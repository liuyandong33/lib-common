package build.dream.common.utils;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {
    public static void sleepSafe(long millis) {
        ApplicationHandler.callMethodSuppressThrow(() -> Thread.sleep(millis));
    }

    public static void sleepSafe(TimeUnit timeUnit, long timeout) {
        ApplicationHandler.callMethodSuppressThrow(() -> timeUnit.sleep(timeout));
    }
}
