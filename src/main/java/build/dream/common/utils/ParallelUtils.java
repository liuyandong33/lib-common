package build.dream.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class ParallelUtils {
    public static <T> Map<String, T> execute(Map<String, Callable<T>> callableMap) throws InterruptedException, ExecutionException {
        ExecutorService executeService = Executors.newCachedThreadPool();
        List<Future<T>> futures = executeService.invokeAll(callableMap.values());
        Set<String> keySet = callableMap.keySet();

        int index = 0;
        Map<String, T> result = new HashMap<String, T>();
        for (String key : keySet) {
            result.put(key, futures.get(index).get());
            index++;
        }
        executeService.shutdown();
        return result;
    }
}
