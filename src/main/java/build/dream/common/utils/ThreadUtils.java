package build.dream.common.utils;

public class ThreadUtils {
    public static void sleepSafe(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
