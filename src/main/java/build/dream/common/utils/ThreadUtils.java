package build.dream.common.utils;

public class ThreadUtils {
    public static void sleepSafe(long millis) {
        ApplicationHandler.callMethodSuppressThrow(() -> Thread.sleep(millis));
    }
}
