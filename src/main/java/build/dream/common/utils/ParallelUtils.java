package build.dream.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class ParallelUtils {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static <T> Map<String, T> invokeAll(Map<String, Callable<T>> callableMap) throws InterruptedException, ExecutionException {
        List<Future<T>> futures = EXECUTOR_SERVICE.invokeAll(callableMap.values());
        Set<String> keySet = callableMap.keySet();

        int index = 0;
        Map<String, T> result = new HashMap<String, T>();
        for (String key : keySet) {
            result.put(key, futures.get(index).get());
            index++;
        }
        return result;
    }
}
